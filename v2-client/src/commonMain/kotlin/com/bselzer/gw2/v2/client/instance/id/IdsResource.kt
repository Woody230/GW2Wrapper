package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.request.id.GetById
import com.bselzer.gw2.v2.client.request.id.GetByIds
import com.bselzer.gw2.v2.client.request.id.GetIds
import com.bselzer.gw2.v2.client.request.id.Ids
import com.bselzer.ktx.client.GenericTypeInfo
import com.bselzer.ktx.client.genericTypeInfo
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*

/**
 * A resource that supports getting a single [Model] by a single [Id] and multiple [Model]s by multiple [Id]s.
 */
class IdsResource<Model, Id, Value> @PublishedApi internal constructor(
    httpClient: HttpClient,
    options: Gw2ResourceOptions,
    modelTypeInfo: GenericTypeInfo<Model>,
    idTypeInfo: GenericTypeInfo<Id>,
    defaultById: (Id) -> Model
) : Ids<Model, Id, Value>,
    GetById<Model, Id, Value> by GetByIdResource(httpClient, options, modelTypeInfo, defaultById),
    GetByIds<Model, Id, Value> by GetByIdsResource(httpClient, options, modelTypeInfo, defaultById),
    GetIds<Id> by GetIdsResource(httpClient, options, idTypeInfo)
        where Id : Identifier<Value>, Model : Identifiable<Id, Value>

inline fun <reified Model, reified Id, Value> ResourceDependencies.idsResource(
    options: Gw2ResourceOptions,
    noinline defaultById: (Id) -> Model,
): IdsResource<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> =
    IdsResource(
        httpClient,
        options,
        genericTypeInfo(),
        genericTypeInfo(),
        defaultById
    )