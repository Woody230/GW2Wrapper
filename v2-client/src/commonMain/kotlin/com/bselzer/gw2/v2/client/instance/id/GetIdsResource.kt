package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.id.GetIds
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

class GetIdsResource<Id>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val idTypeInfo: TypeInfo,
) : GetResource<List<Id>>(typeInfo<List<Id>>()), Gw2ResourceOptions by options, GetIds<Id> where Id : Identifier<*> {
    private val context: () -> String = { "Request for ${idTypeInfo.type.simpleName}s." }
    private val parameters: HttpRequestBuilder.() -> Unit = {}

    override suspend fun ids(options: Gw2HttpOptions): List<Id> = options.get(context, parameters)
    override suspend fun idsOrEmpty(options: Gw2HttpOptions): List<Id> = options.getOrNull(context, parameters) ?: emptyList()
}