package com.bselzer.library.gw2.v2.client

import io.ktor.http.*

/**
 * The [ContentType] as a [Headers]
 */
fun ContentType.asHeader(): Headers = headersOf(HttpHeaders.ContentType, listOf(this.toString()))