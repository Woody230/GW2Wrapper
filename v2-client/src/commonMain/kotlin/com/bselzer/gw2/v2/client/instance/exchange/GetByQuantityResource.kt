package com.bselzer.gw2.v2.client.instance.exchange

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.instance.base.ResourceDependencies
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.exchange.GetByQuantity
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.ktx.client.GenericTypeInfo
import com.bselzer.ktx.client.genericTypeInfo
import io.ktor.client.*
import io.ktor.client.request.*

class GetByQuantityResource<Model, Quantity> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
    private val quantityTypeInfo: GenericTypeInfo<Quantity>
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetByQuantity<Model, Quantity> {
    private fun Quantity.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} in an exchange of $this ${quantityTypeInfo.toDisplayableString()}." }
    private fun Quantity.parameters(): HttpRequestBuilder.() -> Unit = { parameter("quantity", this@parameters) }

    override suspend fun byQuantity(quantity: Quantity, options: Gw2HttpOptions): GetResult<Model> = options.get(quantity.context(), quantity.parameters())
    override suspend fun byQuantityOrThrow(quantity: Quantity, options: Gw2HttpOptions): Model = byQuantity(quantity, options).getOrThrow()
    override suspend fun byQuantityOrNull(quantity: Quantity, options: Gw2HttpOptions): Model? = byQuantity(quantity, options).getOrNull()
}

inline fun <reified Model, reified Quantity> ResourceDependencies.getByQuantityResource(
    options: Gw2ResourceOptions
): GetByQuantityResource<Model, Quantity> = GetByQuantityResource(
    httpClient,
    options,
    genericTypeInfo(),
    genericTypeInfo()
)