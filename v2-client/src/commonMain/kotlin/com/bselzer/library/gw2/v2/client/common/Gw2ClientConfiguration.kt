package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.client.common.constant.Endpoints

/**
 * The configuration for the [Gw2Client]
 */
data class Gw2ClientConfiguration(
    /**
     * The schema version.
     *
     * An ISO 8601 datetime to specify a particular schema, or "latest" to use the latest schema.
     * If null, then no schema version will be added.
     */
    val schemaVersion: String? = null,

    /**
     * The access token.
     *
     * If null, then no access token will be added.
     * Note that many endpoints do not need authorization.
     */
    val token: String? = null,

    /**
     * The language to retrieve data for.
     *
     * If null, then no language will be specified.
     */
    val language: String? = null,

    /**
     * The page size.
     */
    val pageSize: Int = Endpoints.MAXIMUM_PAGE_SIZE,
)