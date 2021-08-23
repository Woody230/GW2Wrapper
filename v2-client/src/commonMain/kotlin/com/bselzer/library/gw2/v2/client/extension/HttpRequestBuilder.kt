package com.bselzer.library.gw2.v2.client.extension

import com.bselzer.library.gw2.v2.client.constant.Headers
import io.ktor.client.request.*
import io.ktor.http.*

/**
 * Sets the bearer authorization if the [token] exists and has not been set.
 */
internal fun HttpRequestBuilder.bearer(token: String?)
{
    if (token != null && !headers.contains(HttpHeaders.Authorization))
    {
        headers[HttpHeaders.Authorization] = "${Headers.BEARER} $token"
    }
}

/**
 * Sets the accepted language if the [language] exists and has not been set.
 */
internal fun HttpRequestBuilder.language(language: String?)
{
    if (language != null && !headers.contains(HttpHeaders.AcceptLanguage))
    {
        headers[HttpHeaders.AcceptLanguage] = language
    }
}

/**
 * Sets the schema version if the [version] exists and has not been set.
 */
internal fun HttpRequestBuilder.schemaVersion(version: String?)
{
    if (version != null && !headers.contains(Headers.SCHEMA_VERSION))
    {
        headers[Headers.SCHEMA_VERSION] = version
    }
}