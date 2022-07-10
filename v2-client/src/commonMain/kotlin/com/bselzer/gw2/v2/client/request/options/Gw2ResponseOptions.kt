package com.bselzer.gw2.v2.client.request.options

import com.bselzer.gw2.v2.client.request.options.validation.SuccessfulResult
import com.bselzer.gw2.v2.client.request.options.validation.ValidationResult
import io.ktor.client.statement.*

interface Gw2ResponseOptions {
    /**
     * The block for performing validation on the response.
     */
    val validate: HttpResponse.() -> ValidationResult

    companion object : Gw2ResponseOptions {
        override val validate: HttpResponse.() -> ValidationResult = { SuccessfulResult }
    }
}