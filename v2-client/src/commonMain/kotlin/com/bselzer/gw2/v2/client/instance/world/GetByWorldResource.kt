package com.bselzer.gw2.v2.client.instance.world

import com.bselzer.gw2.v2.client.instance.base.GetResource
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceContext
import com.bselzer.gw2.v2.client.instance.base.Gw2ResourceOptions
import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.client.request.world.GetByWorld
import com.bselzer.gw2.v2.client.result.GetResult
import com.bselzer.gw2.v2.model.world.WorldId
import com.bselzer.ktx.client.GenericTypeInfo
import com.bselzer.ktx.client.genericTypeInfo
import io.ktor.client.*
import io.ktor.client.request.*

class GetByWorldResource<Model> @PublishedApi internal constructor(
    override val httpClient: HttpClient,
    options: Gw2ResourceOptions,
    private val modelTypeInfo: GenericTypeInfo<Model>,
) : GetResource<Model>(modelTypeInfo), Gw2ResourceOptions by options, GetByWorld<Model> {
    private fun WorldId.context(): () -> String = { "Request for ${modelTypeInfo.toDisplayableString()} associated with the world with id $this." }
    private fun WorldId.parameters(): HttpRequestBuilder.() -> Unit = { parameter("world", value) }

    override suspend fun byWorld(worldId: WorldId, options: Gw2Options): GetResult<Model> = options.get(worldId.context(), worldId.parameters())
    override suspend fun byWorldOrThrow(worldId: WorldId, options: Gw2Options): Model = byWorld(worldId, options).getOrThrow()
    override suspend fun byWorldOrNull(worldId: WorldId, options: Gw2Options): Model? = byWorld(worldId, options).getOrNull()
}

inline fun <reified Model> Gw2ResourceContext.getByWorldResource(
    options: Gw2ResourceOptions
): GetByWorldResource<Model> = GetByWorldResource(
    httpClient,
    options,
    genericTypeInfo()
)