package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.constant.TileEndpoints

/**
 * The configuration for the [TileClient]
 */
data class TileClientConfiguration(
    /**
     * The base url aliases for the tile service.
     */
    val baseUrls: Collection<String> = TileEndpoints.ALIAS_URLS.plus(TileEndpoints.BASE_URL)
)