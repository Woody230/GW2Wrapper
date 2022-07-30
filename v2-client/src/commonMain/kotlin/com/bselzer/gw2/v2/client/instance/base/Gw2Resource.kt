package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.exception.RequestException
import com.bselzer.gw2.v2.client.exception.ResponseException
import com.bselzer.gw2.v2.client.exception.ValidationException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.validation.SuccessfulResult
import com.bselzer.gw2.v2.client.validation.UnsuccessfulResult
import com.bselzer.gw2.v2.client.validation.ValidationResult
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.reflect.*

abstract class Gw2Resource : Gw2ResourceOptions {
    abstract val httpClient: HttpClient

    internal fun TypeInfo.toDisplayableString() = kotlinType ?: type.simpleName

    private suspend fun Gw2HttpOptions.request(context: () -> String, customizations: HttpRequestBuilder.() -> Unit): Pair<HttpResponse?, ValidationResult> {
        val response = try {
            httpClient.request(configure(customizations))
        } catch (ex: Exception) {
            val cause = if (ex is RequestException) ex else RequestException(ex)
            return null to UnsuccessfulResult(cause) { "${context()} Failed to make the request to ${url}.".trimStart() }.also { it.log() }
        }

        return try {
            return when (val result = validate(response)) {
                is SuccessfulResult -> response to result
                is UnsuccessfulResult -> {
                    val cause = if (result.cause is ValidationException) result.cause else ValidationException(result.cause)
                    response to UnsuccessfulResult(cause) { "${context()} ${result.message}".trimStart() }.also { it.log() }
                }
            }
        } catch (ex: Exception) {
            val cause = if (ex is ValidationException) ex else ValidationException(ex)
            null to UnsuccessfulResult(cause) { "${context()} Failed to validate the response and create a result.".trimStart() }.also { it.log() }
        }
    }

    protected suspend fun Gw2HttpOptions.responseOrNull(context: () -> String, customizations: HttpRequestBuilder.() -> Unit): HttpResponse? {
        val (response, _) = request(context, customizations)
        return response
    }

    protected suspend fun Gw2HttpOptions.response(context: () -> String, customizations: HttpRequestBuilder.() -> Unit): HttpResponse {
        val (response, validation) = request(context, customizations)
        return when (validation) {
            is UnsuccessfulResult -> throw validation.cause ?: ResponseException(validation.message())
            is SuccessfulResult -> response ?: throw ResponseException("Validation is successful, but the response does not exist.")
        }
    }
}