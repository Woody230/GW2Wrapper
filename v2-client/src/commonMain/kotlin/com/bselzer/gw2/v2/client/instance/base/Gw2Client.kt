package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.constant.Headers
import com.bselzer.gw2.v2.client.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.client.options.DefaultGw2HttpOptions.Companion.baseUrl
import com.bselzer.gw2.v2.client.options.Gw2RequestOptions
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.*

interface Gw2Client {
    val path: String
    val customizations: HttpRequestBuilder.() -> Unit
        get() = {}

    val defaultOptions: DefaultGw2HttpOptions

    /**
     * Creates the [HttpRequestBuilder] block in the following order:
     *
     * The [DefaultGw2HttpOptions.baseUrl] and [path] as the url.
     *
     * The [Gw2RequestOptions.schemaVersion] or [DefaultGw2HttpOptions.schemaVersion] as a header if it exists.
     *
     * The [Gw2RequestOptions.language] or [DefaultGw2HttpOptions.language] as a header if it exists.
     *
     * The [Gw2RequestOptions.token] or [DefaultGw2HttpOptions.token] as a header if it exists.
     *
     * Customizations are applied in the following order:
     *
     * [DefaultGw2HttpOptions.customizations]
     *
     * The [Gw2Client.customizations].
     *
     * The given [customizations].
     *
     * The [Gw2RequestOptions.customizations].
     */
    fun configure(options: Gw2RequestOptions, customizations: HttpRequestBuilder.() -> Unit): HttpRequestBuilder.() -> Unit = {
        url {
            takeFrom(baseUrl)
            appendPathSegments(path)
        }

        val merged = defaultOptions.merge(options)
        appendIfNameAbsent(Headers.SCHEMA_VERSION, merged.schemaVersion)
        appendIfNameAbsent(HttpHeaders.AcceptLanguage, merged.language)
        merged.token?.let { token ->
            appendIfNameAbsent(HttpHeaders.Authorization, "${Headers.BEARER} $token")
        }

        apply(defaultOptions.customizations)
        apply(this@Gw2Client.customizations)
        apply(customizations)
        apply(options.customizations)
    }

    /**
     * Sets the [header] to [value] if it is not null and does not exist already.
     */
    fun HttpMessageBuilder.appendIfNameAbsent(header: String, value: String?) = value?.let {
        headers.appendIfNameAbsent(header, value)
    }

    /**
     * Coerces the [Gw2RequestOptions.pageSize] between a range of 1 to [DefaultGw2HttpOptions.Companion.pageSize] inclusive.
     */
    fun Gw2RequestOptions.coercedPageSize(): Int {
        val pageSize = defaultOptions.merge(this).pageSize ?: DefaultGw2HttpOptions.pageSize
        return pageSize.coerceAtLeast(1).coerceAtMost(DefaultGw2HttpOptions.pageSize)
    }
}