package com.bselzer.gw2.v2.client.instance.base

import com.bselzer.gw2.v2.client.options.Gw2Options
import com.bselzer.gw2.v2.scope.core.Scope
import com.bselzer.gw2.v2.scope.guild.GuildScope
import io.ktor.client.*

data class Gw2ResourceContext(
    val httpClient: HttpClient,
    val defaultOptions: Gw2Options = Gw2Options.Base
) {
    internal fun resourceOptions(
        path: String,
        scopes: Collection<Scope> = emptyList(),
        guildScopes: Collection<GuildScope> = emptyList(),
    ): Gw2ResourceOptions = ResourceOptions(defaultOptions, path, scopes, guildScopes)
}