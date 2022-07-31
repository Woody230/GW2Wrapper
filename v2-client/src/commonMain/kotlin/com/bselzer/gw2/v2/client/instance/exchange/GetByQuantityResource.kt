package com.bselzer.gw2.v2.client.instance.exchange

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.exchange.GetByQuantity
import io.ktor.client.*
import io.ktor.client.request.*

class GetByQuantityResource<Model, Quantity>(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
    private val quantityTypeInfo: GenericTypeInfo<Quantity>
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetByQuantity<Model, Quantity> {
    private fun Quantity.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} in an exchange of $this ${quantityTypeInfo.toDisplayableString()}." }
    private fun Quantity.parameters(): HttpRequestBuilder.() -> Unit = { parameter("quantity", this@parameters) }

    override suspend fun byQuantity(quantity: Quantity, options: Gw2HttpOptions): Model = options.getOrThrow(quantity.context(), quantity.parameters())
    override suspend fun byQuantityOrNull(quantity: Quantity, options: Gw2HttpOptions): Model? = options.getOrNull(quantity.context(), quantity.parameters())
}