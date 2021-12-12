package com.bselzer.gw2.v2.emblem.client

import com.bselzer.gw2.v2.emblem.constant.Endpoints

/**
 * The configuration for the [EmblemClient].
 */
data class EmblemClientConfiguration(
    /**
     * The base url.
     */
    val baseUrl: String = Endpoints.BASE_URL
)