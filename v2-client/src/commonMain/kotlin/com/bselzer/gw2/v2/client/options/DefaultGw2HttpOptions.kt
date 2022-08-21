package com.bselzer.gw2.v2.client.options

import com.bselzer.gw2.v2.client.constant.Endpoints
import com.bselzer.gw2.v2.client.result.Gw2Result

/**
 * The default [Gw2HttpOptions] to apply to requests.
 */
interface DefaultGw2HttpOptions : Gw2HttpOptions {
    val baseUrl: String

    companion object : DefaultGw2HttpOptions, Gw2HttpOptions by Gw2HttpOptions {
        override val baseUrl: String = Endpoints.BASE_URL
        override val schemaVersion: String = Endpoints.SCHEMA_VERSION
        override val pageSize: Int = Endpoints.MAXIMUM_PAGE_SIZE
        override val onSuccess: (Gw2Result.Success) -> Unit = {}
        override val onFailure: (Gw2Result.Failure) -> Unit = {}
    }
}