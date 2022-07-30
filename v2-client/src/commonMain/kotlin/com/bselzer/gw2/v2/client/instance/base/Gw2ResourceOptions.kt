package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.constant.Headers
import com.bselzer.gw2.v2.client.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.client.options.Gw2RequestOptions
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.*

interface Gw2ResourceOptions {
    /**
     * The path relative to the base url.
     */
    val path: String

    /**
     * The customizations specific to the endpoint.
     */
    val customizations: HttpRequestBuilder.() -> Unit
        get() = {}

    /**
     * The options to use by default if they are not provided with the request.
     */
    val defaultOptions: DefaultGw2HttpOptions

    /**
     * The [DefaultGw2HttpOptions.baseUrl] and the [path].
     */
    val url: Url
        get() = URLBuilder().apply {
            takeFrom(defaultOptions.baseUrl)
            appendPathSegments(path)
        }.build()

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
     * The [Gw2ResourceOptions.customizations].
     *
     * The given [customizations].
     *
     * The [Gw2RequestOptions.customizations].
     */
    fun Gw2RequestOptions.configure(customizations: HttpRequestBuilder.() -> Unit): HttpRequestBuilder.() -> Unit = {
        url(this@Gw2ResourceOptions.url)

        val merged = defaultOptions.merge(this@configure) {
            apply(this@Gw2ResourceOptions.customizations)
            apply(customizations)
        }

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
     * Coerces the [Gw2RequestOptions.pageSize] between a range of 1 to [DefaultGw2HttpOptions.Companion.pageSize] inclusive.
     */
    fun Gw2RequestOptions.coercedPageSize(): Int {
        val pageSize = defaultOptions.merge(this).pageSize ?: DefaultGw2HttpOptions.pageSize
        return pageSize.coerceAtLeast(1).coerceAtMost(DefaultGw2HttpOptions.pageSize)
    }
}