package com.bselzer.library.gw2.v2.client.common.extension

import com.bselzer.library.gw2.v2.client.common.constant.Headers
import io.ktor.client.request.*
import io.ktor.http.*

/**
 * Adds the bearer authorization.
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