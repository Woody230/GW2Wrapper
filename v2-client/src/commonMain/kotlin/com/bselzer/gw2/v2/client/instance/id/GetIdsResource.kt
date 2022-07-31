package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.id.GetIds
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * A resource that supports getting all [Id]s.
 */
class GetIdsResource<Id>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val idTypeInfo: GenericTypeInfo<Id>,
) : GetResource<List<Id>>(genericTypeInfo()), Gw2ResourceOptions by options, GetIds<Id> where Id : Identifier<*> {
    private val context: () -> String = { "Request for ${idTypeInfo.toDisplayableString()}s." }
    private val parameters: HttpRequestBuilder.() -> Unit = {}

    override suspend fun ids(options: Gw2HttpOptions): List<Id> = options.getOrThrow(context, parameters)
    override suspend fun idsOrEmpty(options: Gw2HttpOptions): List<Id> = options.getOrNull(context, parameters) ?: emptyList()
}