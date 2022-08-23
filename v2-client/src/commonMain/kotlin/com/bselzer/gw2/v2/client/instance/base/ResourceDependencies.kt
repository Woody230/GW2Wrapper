package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.options.DefaultGw2HttpOptions
import com.bselzer.gw2.v2.scope.core.Scope
import com.bselzer.gw2.v2.scope.guild.GuildScope
import io.ktor.client.*
import io.ktor.client.request.*

data class ResourceDependencies(
    val httpClient: HttpClient,
    val defaultOptions: DefaultGw2HttpOptions = DefaultGw2HttpOptions
) {
    internal fun resourceOptions(
        path: String,
        scopes: Collection<Scope> = emptyList(),
        guildScopes: Collection<GuildScope> = emptyList(),
        customizations: HttpRequestBuilder.() -> Unit = {}
    ): Gw2ResourceOptions = ResourceOptions(defaultOptions, path, scopes, guildScopes, customizations)
}