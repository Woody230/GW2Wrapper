package com.bselzer.gw2.v2.client.instance.token

import com.bselzer.gw2.v2.client.instance.base.ConvertibleGetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceContext
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.request.token.CreateSubToken
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.gw2.v2.client.result.Gw2Result
import com.bselzer.gw2.v2.model.account.token.CreatedSubToken
import com.bselzer.gw2.v2.model.account.token.SubToken
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.ktx.client.genericTypeInfo
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.datetime.Instant
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CreateSubTokenResource @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions
) : ConvertibleGetResource<CreatedSubToken, SubToken>(genericTypeInfo(), genericTypeInfo()), Gw2ResourceOptions by options, CreateSubToken {
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

    override suspend fun create(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2Options): GetResult<SubToken> {
        // Validate that the token exists.
        if (options.request.token == null) {
            val failure = Gw2Result.Failure.Request("A token is required in order to create a sub-token.").apply(options.response.onFailure)
            return GetResult.Failure.Gw2(failure)
        }

        val context = context(expiration, permissions, urls)
        val parameters = parameters(expiration, permissions, urls)
        return options.get(context, parameters) { result -> GetResult.Success(result.response, result.body.subtoken) }
    }

    override suspend fun createOrThrow(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2Options): SubToken {
        return create(expiration, permissions, urls, options).getOrThrow()
    }

    override suspend fun createOrNull(expiration: Instant, permissions: List<Permission>, urls: List<String>, options: Gw2Options): SubToken? {
        return create(expiration, permissions, urls, options).getOrNull()
    }
}

fun Gw2ResourceContext.createSubTokenResource(
    options: Gw2ResourceOptions
): CreateSubTokenResource = CreateSubTokenResource(httpClient, options)