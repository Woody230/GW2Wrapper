package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.constant.Endpoints
import com.bselzer.gw2.v2.client.constant.Headers
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.options.Gw2RequestOptions
import com.bselzer.gw2.v2.scope.core.Scope
import com.bselzer.gw2.v2.scope.guild.GuildScope
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.*

interface Gw2ResourceOptions {
    /**
     * The path relative to the base url.
     */
    val path: String

    // TODO pre-validation: ability to check permissions of a TokenInfo
    // TODO post-validation: forbidden vs unauthorized
    /**
     * The permissions required to access the resource.
     */
    val scopes: Collection<Scope>
        get() = emptyList()

    /**
     * The guild rankings required to access the resource.
     */
    val guildScopes: Collection<GuildScope>
        get() = emptyList()

    /**
     * The options to use by default if they are not provided with the request.
     */
    val defaultOptions: Gw2Options

    /**
     * Creates the [HttpRequestBuilder] block in the following order:
     *
     * The [Gw2RequestOptions.url] as the url.
     *
     * The [Gw2RequestOptions.schemaVersion] as a header if it exists.
     *
     * The [Gw2RequestOptions.language] as a header if it exists.
     *
     * The [Gw2RequestOptions.token] as a header if it exists.
     *
     * Customizations are applied in the following order:
     *
     * [Gw2RequestOptions.customizations]
     *
     * The given [customizations].
     */
    fun Gw2RequestOptions.configure(customizations: HttpRequestBuilder.() -> Unit): HttpRequestBuilder.() -> Unit = {
        val merged = defaultOptions.request.merge(this@configure)
        url(merged.url.url)

        apply(merged.customizations)
        apply(customizations)

        appendIfNameAbsent(Headers.SCHEMA_VERSION, merged.schemaVersion)
        appendIfNameAbsent(HttpHeaders.AcceptLanguage, merged.language)
        merged.token?.let { token ->
            appendIfNameAbsent(HttpHeaders.Authorization, "${Headers.BEARER} $token")
        }
    }

    /**
     * Sets the [header] to [value] if it is not null and does not exist already.
     */
    fun HttpMessageBuilder.appendIfNameAbsent(header: String, value: String?) = value?.let {
        headers.appendIfNameAbsent(header, value)
    }

    /**
     * Coerces the [Gw2RequestOptions.pageSize] between a range of 1 to 200 inclusive.
     */
    fun Gw2RequestOptions.coercedPageSize(): Int {
        val default = Endpoints.MAXIMUM_PAGE_SIZE
        val pageSize = defaultOptions.request.merge(this).pageSize ?: default
        return pageSize.coerceAtLeast(1).coerceAtMost(default)
    }
}

data class ResourceOptions(
    override val defaultOptions: Gw2Options,
    override val path: String,
    override val scopes: Collection<Scope> = emptyList(),
    override val guildScopes: Collection<GuildScope> = emptyList(),
) : Gw2ResourceOptions