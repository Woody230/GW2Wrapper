package com.bselzer.gw2.v2.client.instance.token

import com.bselzer.gw2.v2.client.exception.RequestException
import com.bselzer.gw2.v2.client.instance.base.GetClient
import com.bselzer.gw2.v2.client.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.options.Gw2RequestOptions
import com.bselzer.gw2.v2.client.request.token.CreateSubToken
import com.bselzer.gw2.v2.client.request.token.Token
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.ktx.logging.Logger
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.datetime.Instant
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

interface CreateSubTokenClient : GetClient, CreateSubToken {
    /**
     * Creates a sub-token that expires at [expiration], that is able to access the endpoints associated with the [permissions] or defined by the [urls].
     *
     * The token must either be defined in the [Gw2HttpOptions] or [DefaultGw2HttpOptions].
     *
     * @return the sub-token id
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
     */
    suspend fun HttpClient.create(
        expiration: Instant,
        permissions: List<Permission>,
        urls: List<String>,
        options: Gw2HttpOptions
    ): Token {
        defaultOptions.merge(options as Gw2RequestOptions).token ?: throw RequestException("A token is required in order to create a sub-token.")

        val subToken = get(options) {
            parameter("expire", expiration)
            parameter("permissions", permissions.joinToString(separator = ",") { permission -> Json.encodeToString(permission) })
            parameter("urls", urls.joinToString(","))
        }.body<JsonObject>()["subtoken"]?.toString()

        return subToken?.let { Token(it) } ?: throw RequestException("subtoken key missing from the JsonObject")
    }

    /**
     * Creates a sub-token that expires at [expiration], that is able to access the endpoints associated with the [permissions] or defined by the [urls].
     *
     * The token must either be defined in the [Gw2HttpOptions] or [DefaultGw2HttpOptions].
     *
     * @return the sub-token id, or null if unable to fulfill the request
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">createsubtoken on the wiki</a>
     */
    suspend fun HttpClient.createOrNull(
        expiration: Instant,
        permissions: List<Permission>,
        urls: List<String>,
        options: Gw2HttpOptions
    ): Token? = try {
        create(expiration, permissions, urls, options)
    } catch (ex: Exception) {
        Logger.e(ex) { "Failed to create a sub-token. " }
        null
    }
}