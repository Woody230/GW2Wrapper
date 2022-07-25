package com.bselzer.gw2.v2.client

import com.bselzer.gw2.v2.client.constant.Headers
import com.bselzer.gw2.v2.client.request.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.client.request.options.Gw2RequestOptions
import io.ktor.client.request.*
import io.ktor.http.*

interface Gw2Client {
    val path: String
    val customizations: HttpRequestBuilder.() -> Unit
        get() = {}

    val defaultOptions: DefaultGw2HttpOptions

    /**
     * Creates the [HttpRequestBuilder] block in the following order:
     *
     * The [path] applied to the url.
     *
     * [Gw2RequestOptions.schemaVersion] as a header if it exists.
     *
     * [Gw2RequestOptions.language] as a header if it exists.
     *
     * [Gw2RequestOptions.token] as a header if it exists.
     *
     * The given [customizations].
     *
     * The [Gw2Client.customizations].
     *
     * The given [Gw2RequestOptions.customizations].
     *
     * The [Gw2Client.defaultOptions] customizations.
     */
    fun Gw2RequestOptions.configure(customizations: HttpRequestBuilder.() -> Unit = {}): HttpRequestBuilder.() -> Unit = {
        url(path)
        setHeader(Headers.SCHEMA_VERSION, schemaVersion)
        setHeader(HttpHeaders.AcceptLanguage, language)
        token?.let { token ->
            setHeader(HttpHeaders.Authorization, "${Headers.BEARER} $token")
        }

        apply(customizations)
        apply(this@Gw2Client.customizations)
        apply(this@configure.customizations)
        apply(this@Gw2Client.defaultOptions.customizations)
    }

    /**
     * Sets the [header] to [value] if it is not null.
     */
    fun HttpMessageBuilder.setHeader(header: String, value: String?) = value?.let {
        headers[header] = value
    }

    /**
     * Coerces the [Gw2RequestOptions.pageSize] between a range of 1 to [DefaultGw2HttpOptions.Companion.pageSize] inclusive.
     */
    fun Gw2RequestOptions.coercedPageSize(): Int {
        val pageSize = pageSize ?: DefaultGw2HttpOptions.pageSize
        return pageSize.coerceAtLeast(1).coerceAtMost(DefaultGw2HttpOptions.pageSize)
    }
}