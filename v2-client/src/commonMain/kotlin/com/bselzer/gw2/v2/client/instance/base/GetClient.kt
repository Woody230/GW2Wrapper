package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.exception.RequestException
import com.bselzer.gw2.v2.client.exception.ValidationException
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.validation.SuccessfulResult
import com.bselzer.gw2.v2.client.validation.UnsuccessfulResult
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

interface GetClient : Gw2Client {
    /**
     * Gets the [HttpResponse] using the [configure]d [options] and validates the response.
     */
    suspend fun HttpClient.get(
        options: Gw2HttpOptions,
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): HttpResponse {
        val response = try {
            get(configure(options, customizations))
        } catch (ex: Exception) {
            throw RequestException("Failed to make the request to $url", ex)
        }

        try {
            when (val result = options.validate(response)) {
                is SuccessfulResult -> {}
                is UnsuccessfulResult -> throw ValidationException(result.message, result.cause)
            }
        } catch (ex: Exception) {
            throw ValidationException("Failed to validate the response and create a result.", ex)
        }

        return response
    }
}