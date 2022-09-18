package com.bselzer.gw2.v2.client.options

import com.bselzer.gw2.v2.client.constant.Endpoints
import com.bselzer.ktx.client.options.UrlOptions
import io.ktor.http.*

data class Gw2Options(
    val request: Gw2RequestOptions = Gw2RequestOptions.Default,
    val response: Gw2ResponseOptions = Gw2ResponseOptions.Default
) {
    companion object {
        val Default = Gw2Options()

        private val BaseUrl = UrlOptions(
            protocol = URLProtocol.HTTPS,
            host = Endpoints.HOST,
            pathSegments = listOf("v2")
        )

        internal val Base = Gw2Options(
            request = Gw2RequestOptions(
                schemaVersion = Endpoints.SCHEMA_VERSION,
                pageSize = Endpoints.MAXIMUM_PAGE_SIZE,
                url = BaseUrl
            )
        )
    }
}