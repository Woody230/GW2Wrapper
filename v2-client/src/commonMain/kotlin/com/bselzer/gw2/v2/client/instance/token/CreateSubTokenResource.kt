package com.bselzer.gw2.v2.client.instance.token

import com.bselzer.gw2.v2.client.exception.RequestException
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.options.Gw2RequestOptions
import com.bselzer.gw2.v2.client.request.token.CreateSubToken
import com.bselzer.gw2.v2.client.request.token.Token
import com.bselzer.gw2.v2.scope.core.Permission
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*
import kotlinx.datetime.Instant
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

class CreateSubTokenResource(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions
) : GetResource<JsonObject>(typeInfo<JsonObject>()), Gw2ResourceOptions by options, CreateSubToken {
    private fun Gw2HttpOptions.validate() {
        defaultOptions.merge(this as Gw2RequestOptions).token ?: throw RequestException("A token is required in order to create a sub-token.")
    }

    private fun context(expiration: Instant, permissions: List<Permission>, urls: List<String>): () -> String = {
        "Request for a sub-token expiring at $expiration with ${permissions.count()} permissions and ${urls.count()} urls."
    }

    private fun parameters(
        expiration: Instant,
        permissions: List<Permission>,
        urls: List<String>
    ): HttpRequestBuilder.() -> Unit = {
        parameter("expire", expiration)
        parameter("permissions", permissions.joinToString(separator = ",") { permission -> Json.encodeToString(permission) })
        parameter("urls", urls.joinToString(","))
    }

    private fun JsonObject?.extractToken(): Token? = this?.get("subtoken")?.toString()?.let { Token(it) }

    override suspend fun create(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2HttpOptions): Token {
        val context = context(expiration, permissions, urls)
        val parameters = parameters(expiration, permissions, urls)

        options.validate()
        return options.get(context, parameters).extractToken() ?: throw RequestException("${context()} subtoken key missing from the JsonObject")
    }

    override suspend fun createOrNull(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2HttpOptions): Token? {
        val context = context(expiration, permissions, urls)
        val parameters = parameters(expiration, permissions, urls)
        return options.get(context, parameters).extractToken()
    }
}