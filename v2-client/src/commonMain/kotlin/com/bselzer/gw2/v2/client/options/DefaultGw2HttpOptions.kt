package com.bselzer.gw2.v2.client.options

import com.bselzer.gw2.v2.client.constant.Endpoints
import com.bselzer.gw2.v2.client.validation.SuccessfulResult
import com.bselzer.gw2.v2.client.validation.UnsuccessfulResult
import com.bselzer.gw2.v2.client.validation.ValidationResult
import io.ktor.client.statement.*
import io.ktor.http.*

/**
 * The default [Gw2HttpOptions] to apply to requests.
 */
interface DefaultGw2HttpOptions : Gw2HttpOptions {
    val baseUrl: String

    companion object : DefaultGw2HttpOptions, Gw2HttpOptions by Gw2HttpOptions {
        override val baseUrl: String = Endpoints.BASE_URL
        override val schemaVersion: String = Endpoints.SCHEMA_VERSION
        override val pageSize: Int = Endpoints.MAXIMUM_PAGE_SIZE
        override val validate: HttpResponse.() -> ValidationResult = {
            // In the case where we are getting a 404, an empty default may be deserialized.
            // Consequently, we should fail validation in order to properly construct a default instead.
            when (status.isSuccess()) {
                true -> SuccessfulResult
                false -> UnsuccessfulResult("Unsuccessful status code of $status.")
            }
        }
    }
}