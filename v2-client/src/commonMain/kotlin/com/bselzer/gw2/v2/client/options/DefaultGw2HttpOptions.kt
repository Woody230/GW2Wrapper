package com.bselzer.gw2.v2.client.options

import com.bselzer.gw2.v2.client.constant.Endpoints

/**
 * The default [Gw2HttpOptions] to apply to requests.
 */
interface DefaultGw2HttpOptions : Gw2HttpOptions {
    val baseUrl: String

    companion object : DefaultGw2HttpOptions, Gw2HttpOptions by Gw2HttpOptions {
        override val baseUrl: String = Endpoints.BASE_URL
        override val schemaVersion: String = Endpoints.SCHEMA_VERSION
        override val pageSize: Int = Endpoints.MAXIMUM_PAGE_SIZE
    }
}

data class DefaultHttpOptions(
    val request: Gw2RequestOptions = DefaultGw2HttpOptions,
    val response: Gw2ResponseOptions = DefaultGw2HttpOptions,
    override val baseUrl: String = DefaultGw2HttpOptions.baseUrl
) : DefaultGw2HttpOptions, Gw2RequestOptions by request, Gw2ResponseOptions by response