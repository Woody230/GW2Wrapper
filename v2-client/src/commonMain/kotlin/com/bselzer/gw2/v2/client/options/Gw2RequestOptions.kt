package com.bselzer.gw2.v2.client.options

import com.bselzer.gw2.v2.model.account.token.Token
import com.bselzer.ktx.client.options.UrlOptions
import io.ktor.client.request.*

data class Gw2RequestOptions(
    /**
     * The schema version.
     *
     * An ISO 8601 datetime to specify a particular schema, or "latest" to use the latest schema.
     * If null, then no schema version will be added.
     *
     * @see <a href="https://api.guildwars2.com/v2.json?v=latest">schemas</a>
     */
    val schemaVersion: String? = null,

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
    val language: String? = null,

    /**
     * The page size.
     */
    val pageSize: Int? = null,

    /**
     * Builds the url using path and query parameters.
     */
    val url: UrlOptions = UrlOptions.Default,

    /**
     * The customizations to apply to the request.
     */
    val customizations: HttpRequestBuilder.() -> Unit = {}
) {
    companion object {
        val Default = Gw2RequestOptions()
    }

    /**
     * Takes the [schemaVersion], [token], [language], and [pageSize] from the [other] [Gw2Options], defaulting to these options.
     * These [customizations] are applied first, and then the [other] [customizations].
     */
    fun merge(
        other: Gw2RequestOptions
    ): Gw2RequestOptions = Gw2RequestOptions(
        schemaVersion = other.schemaVersion ?: schemaVersion,
        token = other.token ?: token,
        language = other.language ?: language,
        pageSize = other.pageSize ?: pageSize,
        customizations = {
            apply(customizations)
            apply(other.customizations)
        }
    )
}