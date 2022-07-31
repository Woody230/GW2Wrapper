package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.exception.RequestException
import com.bselzer.gw2.v2.client.exception.ValidationException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

abstract class Gw2Resource : Gw2ResourceOptions {
    protected abstract val httpClient: HttpClient

    internal fun (() -> String).message(message: String) = "${this()} $message".trimStart()
    internal fun <T> Throwable.failureResult(): Result<T> = Result.failure(this)
    internal fun <T> T.successResult(): Result<T> = Result.success(this)

    protected suspend fun Gw2HttpOptions.response(context: () -> String, customizations: HttpRequestBuilder.() -> Unit): Result<HttpResponse> {
        val configured = try {
            configure(customizations)
        } catch (ex: Exception) {
            val message = context.message("Failed to configure the customizations.")
            return RequestException(message, ex).failureResult()
        }

        val response = try {
            HttpRequestBuilder().apply(configured).build()
            httpClient.request(configured)
        } catch (ex: Exception) {
            val message = context.message("Failed to make the request to ${url}.")
            return RequestException(message, ex).failureResult()
        }

        return try {
            val result = validate(response)
            return when {
                result.isSuccess -> result
                else -> {
                    val message = context.message("${result.exceptionOrNull()?.message}")
                    ValidationException(message).failureResult()
                }
            }
        } catch (ex: Exception) {
            val message = context.message("Failed to validate the response and create a result.")
            ValidationException(message).failureResult()
        }
    }
}