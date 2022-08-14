package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.exception.RequestException
import com.bselzer.gw2.v2.client.exception.ValidationException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

interface Gw2Resource : Gw2ResourceOptions

abstract class Resource : Gw2Resource {
    protected abstract val httpClient: HttpClient

    internal fun (() -> String).message(message: String) = "${this()} $message".trimStart()
    internal fun <T> Throwable.failureResult(): Result<T> = Result.failure(this)
    internal fun <T> T.successResult(): Result<T> = Result.success(this)

    /**
     * [configure]s the [HttpClient] customizations and executes the request.
     * If an exception occurs during this process, then the result fails with a [RequestException].
     *
     * If the response is able to be obtained, then it is validated according to the given [Gw2HttpOptions].
     * If an exception occurs during this process, then the result fails with a [ValidationException].
     *
     * If validation is successful, then the result succeeds with the [HttpResponse].
     *
     * @param context The type of request being made, which should include any important information being used in the request.
     * @param customizations The [HttpClient] customizations specific to this implementation of the request.
     * @return The result of the request. On success, the [HttpResponse]. On failure, a [RequestException] or [ValidationException].
     * @see [configure]
     */
    protected suspend fun Gw2HttpOptions.response(context: () -> String, customizations: HttpRequestBuilder.() -> Unit): Result<HttpResponse> {
        val configured = try {
            configure(customizations)
        } catch (ex: Exception) {
            val message = context.message("Failed to configure the HttpClient customizations.")
            return RequestException(message, ex).failureResult()
        }

        val response = try {
            httpClient.request(configured)
        } catch (ex: Exception) {
            val message = context.message("Failed to make the request to ${url}.")
            return RequestException(message, ex).failureResult()
        }

        return try {
            val result = validate(response)
            val cause = result.exceptionOrNull()
            return when {
                result.isSuccess -> result
                cause is ValidationException -> cause.failureResult()
                else -> ValidationException(cause).failureResult()
            }
        } catch (ex: Exception) {
            val message = context.message("Failed to validate the response and create a result.")
            ValidationException(message).failureResult()
        }
    }
}