package com.bselzer.gw2.asset.cdn.client

/**
 * The configuration for the [AssetCdnClient].
 */
data class AssetCdnClientConfiguration(
    /**
     * The type of site to use.
     */
    val type: AssetCdnType = AssetCdnType.CORE
)