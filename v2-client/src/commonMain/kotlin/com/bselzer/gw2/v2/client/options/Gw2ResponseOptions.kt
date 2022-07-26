package com.bselzer.gw2.v2.client.options

import com.bselzer.gw2.v2.client.validation.SuccessfulResult
import com.bselzer.gw2.v2.client.validation.UnsuccessfulResult
import com.bselzer.gw2.v2.client.validation.ValidationResult
import io.ktor.client.statement.*

interface Gw2ResponseOptions {
    /**
     * The block for performing validation on the response.
     */
    val validate: HttpResponse.() -> ValidationResult

    /**
     * [validate] is a [SuccessfulResult] if this [validate] and the [other] [validate] produce a [SuccessfulResult], otherwise the result is [UnsuccessfulResult]
     */
    fun merge(other: Gw2ResponseOptions): Gw2ResponseOptions = ResponseOptions(
        validate = {
            val failed = listOf(validate(this), other.validate(this)).filterIsInstance<UnsuccessfulResult>()
            if (failed.any()) {
                UnsuccessfulResult(failed.joinToString("\n") { result -> result.message })
            } else {
                SuccessfulResult
            }
        }
    )

    companion object : Gw2ResponseOptions by ResponseOptions()
}

data class ResponseOptions(
    override val validate: HttpResponse.() -> ValidationResult = { SuccessfulResult }
) : Gw2ResponseOptions