package com.bselzer.gw2.v2.client.options

import io.ktor.client.statement.*

interface Gw2ResponseOptions {
    /**
     * The block for performing validation on the response.
     */
    val validate: (HttpResponse) -> Result<HttpResponse>

    /**
     * This validation is performed first, then the given [validate] block, then the [other] validation.
     */
    fun merge(other: Gw2ResponseOptions, validate: (HttpResponse) -> Result<HttpResponse> = { response -> Result.success(response) }): Gw2ResponseOptions = ResponseOptions(
        validate = { response ->
            listOf(this@Gw2ResponseOptions.validate, validate, other.validate).fold(Result.success(response)) { result, block ->
                result.fold(
                    onSuccess = { newResponse -> block(newResponse) },
                    onFailure = { exception -> Result.failure(exception) }
                )
            }
        }
    )

    companion object : Gw2ResponseOptions by ResponseOptions()
}

data class ResponseOptions(
    override val validate: (HttpResponse) -> Result<HttpResponse> = { response -> Result.success(response) }
) : Gw2ResponseOptions