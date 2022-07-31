package com.bselzer.gw2.v2.client.instance.world

import com.bselzer.gw2.v2.client.GenericTypeInfo
import com.bselzer.gw2.v2.client.genericTypeInfo
import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2HttpOptions
import com.bselzer.gw2.v2.client.request.world.GetByWorld
import com.bselzer.gw2.v2.model.world.WorldId
import io.ktor.client.*
import io.ktor.client.request.*

class GetByWorldResource<Model> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetByWorld<Model> {
    private fun WorldId.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} associated with the world with id $this." }
    private fun WorldId.parameters(): HttpRequestBuilder.() -> Unit = { parameter("world", value) }

    override suspend fun byWorld(worldId: WorldId, options: Gw2HttpOptions): Model = options.getOrThrow(worldId.context(), worldId.parameters())
    override suspend fun byWorldOrNull(worldId: WorldId, options: Gw2HttpOptions): Model? = options.getOrNull(worldId.context(), worldId.parameters())
}

inline fun <reified Model> getByWorldResource(
    httpClient: HttpClient,
    options: Gw2ResourceOptions
): GetByWorldResource<Model> = GetByWorldResource(httpClient, options, genericTypeInfo())