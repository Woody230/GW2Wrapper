package com.bselzer.gw2.v2.client.instance.id

import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.request.id.*
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*
import io.ktor.util.reflect.*

/**
 * A resource that supports getting a single [Model] by a single [Id], multiple [Model]s by multiple [Id]s, and all [Model]s using all [Id]s.
 */
class AllIdsResource<Model, Id, Value>(
    httpClient: HttpClient,
    options: Gw2ResourceOptions,
    modelTypeInfo: TypeInfo,
    idTypeInfo: TypeInfo,
    defaultById: (Id) -> Model
) : AllIds<Model, Id, Value>,
    GetByAllIds<Model, Id, Value> by GetByAllIdsResource(httpClient, options, modelTypeInfo),
    GetById<Model, Id, Value> by GetByIdResource(httpClient, options, modelTypeInfo, defaultById),
    GetByIds<Model, Id, Value> by GetByIdsResource(httpClient, options, modelTypeInfo, defaultById),
    GetIds<Id> by GetIdsResource(httpClient, options, idTypeInfo)
        where Id : Identifier<Value>, Model : Identifiable<Id, Value>