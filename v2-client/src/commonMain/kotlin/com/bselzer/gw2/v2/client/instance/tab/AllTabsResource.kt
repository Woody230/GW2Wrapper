package com.bselzer.gw2.v2.client.instance.tab

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.request.tab.*
import com.bselzer.ktx.value.identifier.Identifiable
import com.bselzer.ktx.value.identifier.Identifier
import io.ktor.client.*

/**
 * A resource that supports getting a single [Model] by a single [Tab], multiple [Model]s by multiple [Tab]s, and all [Model]s using all [Tab]s.
 */
class AllTabsResource<Model, Tab, Value> @PublishedApi internal constructor(
    httpClient: HttpClient,
    options: Gw2ResourceOptions,
    modelTypeInfo: GenericTypeInfo<Model>,
    tabTypeInfo: GenericTypeInfo<Tab>,
    defaultByTab: (Tab) -> Model
) : AllTabs<Model, Tab, Value>,
    GetByAllTabs<Model, Tab, Value> by GetByAllTabsResource(httpClient, options, modelTypeInfo),
    GetByTab<Model, Tab, Value> by GetByTabResource(httpClient, options, modelTypeInfo, defaultByTab),
    GetByTabs<Model, Tab, Value> by GetByTabsResource(httpClient, options, modelTypeInfo, defaultByTab),
    GetTabs<Tab> by GetTabsResource(httpClient, options, tabTypeInfo)
        where Tab : Identifier<Value>, Model : Identifiable<Tab, Value>

inline fun <reified Model, reified Tab, Value> allTabsResource(
    httpClient: HttpClient,
    options: Gw2ResourceOptions,
    noinline defaultByTab: (Tab) -> Model,
): AllTabsResource<Model, Tab, Value> where Tab : Identifier<Value>, Model : Identifiable<Tab, Value> =
    AllTabsResource(httpClient, options, genericTypeInfo(), genericTypeInfo(), defaultByTab)