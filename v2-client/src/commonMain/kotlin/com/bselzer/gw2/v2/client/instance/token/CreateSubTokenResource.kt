package com.bselzer.gw2.v2.client.instance.token

import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.options.Gw2RequestOptions
import com.bselzer.gw2.v2.client.request.token.CreateSubToken
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.gw2.v2.client.result.Gw2Result
import com.bselzer.gw2.v2.model.account.token.SubToken
import com.bselzer.gw2.v2.scope.core.Permission
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.datetime.Instant
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CreateSubTokenResource @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions
) : GetResource<com.bselzer.gw2.v2.model.account.token.CreateSubToken>(genericTypeInfo()), Gw2ResourceOptions by options, CreateSubToken {
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

    override suspend fun create(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2HttpOptions): GetResult<SubToken> {
        // Validate that the token exists.
        if (defaultOptions.merge(options as Gw2RequestOptions).token == null) {
            val failure = Gw2Result.Failure.Request("A token is required in order to create a sub-token.").apply(options.onFailure)
            return GetResult.Failure.Gw2(failure)
        }

        val context = context(expiration, permissions, urls)
        val parameters = parameters(expiration, permissions, urls)
        return when (val result = options.get(context, parameters)) {
            is GetResult.Success<com.bselzer.gw2.v2.model.account.token.CreateSubToken> -> GetResult.Success(result.response, result.body.subtoken)
            is GetResult.Failure<com.bselzer.gw2.v2.model.account.token.CreateSubToken> -> result.persistFailure()
        }
    }

    override suspend fun createOrThrow(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2HttpOptions): SubToken {
        return create(expiration, permissions, urls, options).getOrThrow()
    }

    override suspend fun createOrNull(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2HttpOptions): SubToken? {
        return create(expiration, permissions, urls, options).getOrNull()
    }
}

fun ResourceDependencies.createSubTokenResource(
    options: Gw2ResourceOptions
): CreateSubTokenResource = CreateSubTokenResource(httpClient, options)