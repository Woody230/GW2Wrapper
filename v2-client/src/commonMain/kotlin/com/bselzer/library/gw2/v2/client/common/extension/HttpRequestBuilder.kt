package com.bselzer.library.gw2.v2.client.common.extension

import com.bselzer.library.gw2.v2.client.common.constant.Headers
import io.ktor.client.request.*
import io.ktor.http.*

/**
 * Sets the bearer authorization.
 */
fun HttpRequestBuilder.bearer(token: String)
{
    headers[HttpHeaders.Authorization] = "${Headers.BEARER} $token"
}

/**
 * Sets the bearer if the [token] is provided, otherwise ensures that the bearer has already been set.
 */
fun HttpRequestBuilder.ensureBearer(token: String?)
{
    if (token != null)
    {
        // Override the configuration API key with the given API key.
        bearer(token)
    } else if (!headers.contains(HttpHeaders.Authorization))
    {
        throw IllegalArgumentException("A bearer is required. The token must be defined in the configuration or as a method parameter.")
    }
}

/**
 * Sets the accepted language if it is provided.
 */
fun HttpRequestBuilder.language(language: String?)
{
    // Don't override the configuration API key if the language is not provided.
    language ?: return
    headers[HttpHeaders.AcceptLanguage] = language
}

/**
 * Sets the schema version if it is provided.
 */
fun HttpRequestBuilder.schemaVersion(version: String?)
{
    // Don't override the configuration API key if the version is not provided.
    version ?: return
    headers[Headers.SCHEMA_VERSION] = version
}