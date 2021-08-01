package com.bselzer.library.gw2.v2.client.common.extension

import com.bselzer.library.gw2.v2.client.common.constant.Headers
import io.ktor.client.request.*
import io.ktor.http.*

/**
 * Adds the bearer authorization.
 */
fun HttpRequestBuilder.bearer(apiKey: String)
{
    headers[HttpHeaders.Authorization] = "${Headers.BEARER} $apiKey"
}