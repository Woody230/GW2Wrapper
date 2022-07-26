package com.bselzer.gw2.v2.client.options

import io.ktor.client.request.*

interface Gw2RequestOptions {
    /**
     * The schema version.
     *
     * An ISO 8601 datetime to specify a particular schema, or "latest" to use the latest schema.
     * If null, then no schema version will be added.
     *
     * @see <a href="https://api.guildwars2.com/v2.json?v=latest">schemas</a>
     */
    val schemaVersion: String?

    /**
     * The access token.
     *
     * If null, then no access token will be added.
     * Note that many endpoints do not need authorization.
     */
    val token: String?

    /**
     * The language to retrieve data for.
     *
     * If null, then no language will be specified.
     */
    val language: String?

    /**
     * The page size.
     */
    val pageSize: Int?

    /**
     * The customizations to apply to the request.
     */
    val customizations: HttpRequestBuilder.() -> Unit

    /**
     * Takes the [schemaVersion], [token], [language], and [pageSize] from the [other] [Gw2HttpOptions], defaulting to these options.
     * These [customizations] are applied first and then the [other] [customizations] are applied.
     */
    fun merge(other: Gw2RequestOptions): Gw2RequestOptions = RequestOptions(
        schemaVersion = other.schemaVersion ?: schemaVersion,
        token = other.token ?: token,
        language = other.language ?: language,
        pageSize = other.pageSize ?: pageSize,
        customizations = {
            apply(customizations)
            apply(other.customizations)
        }
    )

    companion object : Gw2RequestOptions by RequestOptions()
}

data class RequestOptions(
    override val schemaVersion: String? = null,
    override val token: String? = null,
    override val language: String? = null,
    override val pageSize: Int? = null,
    override val customizations: HttpRequestBuilder.() -> Unit = {}
) : Gw2RequestOptions