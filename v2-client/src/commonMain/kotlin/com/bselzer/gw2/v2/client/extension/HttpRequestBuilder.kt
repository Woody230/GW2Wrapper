package com.bselzer.gw2.v2.client.extension

import com.bselzer.gw2.v2.client.constant.Headers
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.client.model.Token
import io.ktor.client.request.*
import io.ktor.http.*

/**
 * Sets the bearer authorization if the [token] is not null.
 */
internal fun HttpRequestBuilder.bearer(token: Token?) {
    // Only populate if the token exists since the associated endpoint may become completely invalid due to a 401 instead of returning partial data.
    // An example of this includes the guild endpoint.
    token?.value?.let {
        setHeader(HttpHeaders.Authorization, "${Headers.BEARER} $it")
    }
}

/**
 * Sets the accepted language if the [language] is not null.
 */
internal fun HttpRequestBuilder.language(language: Language?) = setHeader(HttpHeaders.AcceptLanguage, language?.value)

/**
 * Sets the schema version if the [version] is not null.
 */
internal fun HttpRequestBuilder.schemaVersion(version: String?) = setHeader(Headers.SCHEMA_VERSION, version)

/**
 * Sets the [header] to [value] if it is not null.
 */
internal fun HttpRequestBuilder.setHeader(header: String, value: String?) = value?.let {
    headers[header] = value
}