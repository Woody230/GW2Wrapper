package com.bselzer.gw2.v2.client.instance.base

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
    ): HttpResponse = get(configure(options, customizations)).also { response ->
        when (val result = options.validate(response)) {
            is SuccessfulResult -> {}
            is UnsuccessfulResult -> {
                throw ValidationException(message = result.message)
            }
        }
    }
}