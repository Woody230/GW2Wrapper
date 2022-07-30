package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.id.GetByAllIds
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.util.reflect.*

/**
 * A resource that supports getting all [Model]s using all [Id]s.
 */
class GetByAllIdsResource<Model, Id, Value>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: TypeInfo,
) : GetResource<List<Model>>(typeInfo<List<Model>>()), Gw2ResourceOptions by options,
    GetByAllIds<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> {
    private val context: () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} with all ids." }
    private val parameters: HttpRequestBuilder.() -> Unit = { parameter("ids", "all") }

    override suspend fun byAllIds(options: Gw2HttpOptions): List<Model> = options.get(context, parameters)
    override suspend fun byAllIdsOrEmpty(options: Gw2HttpOptions): List<Model> = options.getOrNull(context, customizations) ?: emptyList()
}