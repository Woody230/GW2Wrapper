package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.request.id.*
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*

/**
 * A resource that supports getting a single [Model] by a single [Id], multiple [Model]s by multiple [Id]s, and all [Model]s using all [Id]s.
 */
class AllIdsResource<Model, Id, Value> @PublishedApi internal constructor(
    httpClient: HttpClient,
    options: Gw2ResourceOptions,
    modelTypeInfo: GenericTypeInfo<Model>,
    idTypeInfo: GenericTypeInfo<Id>,
    defaultById: (Id) -> Model
) : AllIds<Model, Id, Value>,
    GetByAllIds<Model, Id, Value> by GetByAllIdsResource(httpClient, options, modelTypeInfo),
    GetById<Model, Id, Value> by GetByIdResource(httpClient, options, modelTypeInfo, defaultById),
    GetByIds<Model, Id, Value> by GetByIdsResource(httpClient, options, modelTypeInfo, defaultById),
    GetIds<Id> by GetIdsResource(httpClient, options, idTypeInfo)
        where Id : Identifier<Value>, Model : Identifiable<Id, Value>

inline fun <reified Model, reified Id, Value> ResourceDependencies.allIdsResource(
    options: Gw2ResourceOptions,
    noinline defaultById: (Id) -> Model,
): AllIdsResource<Model, Id, Value> where Id : Identifier<Value>, Model : Identifiable<Id, Value> =
    AllIdsResource(
        httpClient,
        options,
        genericTypeInfo(),
        genericTypeInfo(),
        defaultById
    )