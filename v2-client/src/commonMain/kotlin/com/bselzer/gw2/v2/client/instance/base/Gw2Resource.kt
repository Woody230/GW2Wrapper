package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.result.Gw2Result
import com.bselzer.gw2.v2.client.result.HttpError.Companion.error
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

interface Gw2Resource : Gw2ResourceOptions

abstract class Resource : Gw2Resource {
    protected abstract val httpClient: HttpClient

    internal fun (() -> String).message(message: String) = "${this()} $message".trimStart()

    /**
     * [configure]s the [HttpClient] customizations and executes the request.
     * If an exception occurs during this process, then the result fails with a [Gw2Result.Failure.Request] and [Gw2HttpOptions.onFailure] is applied.
     * Otherwise the result succeeds with a [Gw2Result.Success] and [Gw2HttpOptions.onSuccess] is applied.
     *
     * @param context The type of request being made, which should include any important information being used in the request.
     * @param customizations The [HttpClient] customizations specific to this implementation of the request.
     * @return The [HttpResponse] on [Gw2Result.Success], otherwise [Gw2Result.Failure].
     * @see [configure]
     */
    protected suspend fun Gw2HttpOptions.response(context: () -> String, customizations: HttpRequestBuilder.() -> Unit): Gw2Result {
        val configured = try {
            configure(customizations)
        } catch (ex: Exception) {
            val message = context.message("Failed to configure the HttpClient customizations.")
            return Gw2Result.Failure.Request(message, ex).apply(onFailure)
        }

        val response = try {
            httpClient.request(configured)
        } catch (ex: Exception) {
            val message = context.message("Failed to make the request to ${url}.")
            return Gw2Result.Failure.Request(message, ex).apply(onFailure)
        }

        return when {
            response.status.isSuccess() -> Gw2Result.Success(response).apply(onSuccess)
            else -> Gw2Result.Failure.Http(context(), response.error()).apply(onFailure)
        }
    }
}