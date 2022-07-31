package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.exception.RequestException
import com.bselzer.gw2.v2.client.exception.ValidationException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.reflect.*

abstract class Gw2Resource : Gw2ResourceOptions {
    protected abstract val httpClient: HttpClient

    internal fun TypeInfo.toDisplayableString() = kotlinType ?: type.simpleName

    internal fun <T> Throwable.failureResult(): Result<T> = Result.failure(this)
    internal fun <T> T.successResult(): Result<T> = Result.success(this)

    protected suspend fun Gw2HttpOptions.response(context: () -> String, customizations: HttpRequestBuilder.() -> Unit): Result<HttpResponse> {
        val response = try {
            httpClient.request(configure(customizations))
        } catch (ex: Exception) {
            return RequestException("${context()} Failed to make the request to ${url}.".trimStart(), ex).failureResult()
        }

        return try {
            val result = validate(response)
            return when {
                result.isSuccess -> result
                else -> ValidationException("${context()} ${result.exceptionOrNull()?.message}".trimStart()).failureResult()
            }
        } catch (ex: Exception) {
            ValidationException("${context()} Failed to validate the response and create a result.".trimStart()).failureResult()
        }
    }
}