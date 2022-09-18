package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceContext
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.request.id.GetIds
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.client.GenericTypeInfo
import com.bselzer.ktx.client.genericTypeInfo
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * A resource that supports getting all [Id]s.
 */
class GetIdsResource<Id> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val idTypeInfo: GenericTypeInfo<Id>,
) : GetResource<List<Id>>(genericTypeInfo()), Gw2ResourceOptions by options, GetIds<Id> where Id : Identifier<*> {
    private val context: () -> String = { "Request for ${idTypeInfo.toDisplayableString()}s." }
    private val parameters: HttpRequestBuilder.() -> Unit = {}

    override suspend fun ids(options: Gw2Options): GetResult<List<Id>> = options.get(context, parameters)
    override suspend fun idsOrThrow(options: Gw2Options): List<Id> = ids(options).getOrThrow()
    override suspend fun idsOrEmpty(options: Gw2Options): List<Id> = ids(options).getOrNull() ?: emptyList()
}

inline fun <reified Id> Gw2ResourceContext.getIdsResource(
    options: Gw2ResourceOptions
): GetIdsResource<Id> where Id : Identifier<*> = GetIdsResource(
    httpClient,
    options,
    genericTypeInfo()
)