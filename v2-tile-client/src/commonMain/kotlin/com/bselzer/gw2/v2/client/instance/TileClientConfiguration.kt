package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.constant.Endpoints

/**
 * The configuration for the [TileClient]
 */
data class TileClientConfiguration(
    /**
     * The base url aliases for the tile service.
     */
    val baseUrls: Collection<String> = Endpoints.ALIAS_URLS.plus(Endpoints.BASE_URL)
)