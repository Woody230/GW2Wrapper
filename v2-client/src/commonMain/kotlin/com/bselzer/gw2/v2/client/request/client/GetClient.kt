package com.bselzer.gw2.v2.client.request.client

import com.bselzer.gw2.v2.client.request.exception.ValidationException
import com.bselzer.gw2.v2.client.request.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.options.validation.SuccessfulResult
import com.bselzer.gw2.v2.client.request.options.validation.UnsuccessfulResult
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
    ): HttpResponse = get(options.configure(customizations)).apply {
        when (val result = options.validate(this)) {
            is SuccessfulResult -> {}
            is UnsuccessfulResult -> {
                throw ValidationException(message = result.message)
            }
        }
    }
}