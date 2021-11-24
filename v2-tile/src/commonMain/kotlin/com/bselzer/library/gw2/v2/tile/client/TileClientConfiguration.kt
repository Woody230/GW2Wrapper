package com.bselzer.library.gw2.v2.tile.client

import com.bselzer.library.gw2.v2.tile.constant.Endpoints

/**
 * The configuration for the [TileClient]
 */
data class TileClientConfiguration(
    /**
     * The base url aliases for the tile service.
     */
    val baseUrls: Collection<String> = Endpoints.ALIAS_URLS.plus(Endpoints.BASE_URL)
)