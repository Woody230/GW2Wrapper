package com.bselzer.gw2.v2.client.instance

import com.bselzer.gw2.v2.client.constant.Endpoints
import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.client.model.Token

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
    val schemaVersion: String? = "2022-03-24T00:00:00Z", // https://api.guildwars2.com/v2.json?v=latest

    /**
     * The access token.
     *
     * If null, then no access token will be added.
     * Note that many endpoints do not need authorization.
     */
    val token: Token? = null,

    /**
     * The language to retrieve data for.
     *
     * If null, then no language will be specified.
     */
    val language: Language? = null,

    /**
     * The page size.
     */
    val pageSize: Int = Endpoints.MAXIMUM_PAGE_SIZE,

    /**
     * How to recover when an exception occurs.
     */
    val exceptionRecoveryMode: ExceptionRecoveryMode = ExceptionRecoveryMode.NONE

    /* TODO scope validation
    /**
     * Whether to validate that the required scopes to access the endpoints exist.
     */
    val validateScopes: Boolean = true,

    /**
     * Whether to validate that the optional scopes to access information returned from endpoints exist.
     */
    val validateOptionalScopes: Boolean = false
     */
)

/**
 * How to recover when an exception occurs.
 */
enum class ExceptionRecoveryMode {
    /**
     * Do not recover. The exception will be thrown.
     */
    NONE,

    /**
     * Create a default object where appropriate.
     */
    DEFAULT,
}