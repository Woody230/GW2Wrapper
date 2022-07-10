package com.bselzer.gw2.v2.client.request.options

import com.bselzer.gw2.v2.client.model.Language
import com.bselzer.gw2.v2.client.model.Token
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
    val token: Token?

    /**
     * The language to retrieve data for.
     *
     * If null, then no language will be specified.
     */
    val language: Language?

    /**
     * The page size.
     */
    val pageSize: Int?

    /**
     * The customizations to apply to the request.
     */
    val customizations: HttpRequestBuilder.() -> Unit

    companion object : Gw2RequestOptions {
        override val schemaVersion: String? = null
        override val token: Token? = null
        override val language: Language? = null
        override val pageSize: Int? = null
        override val customizations: HttpRequestBuilder.() -> Unit = {}
    }
}