package com.bselzer.gw2.v2.client.generator

import com.bselzer.gw2.v2.client.generator.instance.Client
import com.bselzer.gw2.v2.client.generator.query.Ids
import com.bselzer.gw2.v2.model.wvw.ability.WvwAbility
import com.bselzer.gw2.v2.model.wvw.ability.WvwAbilityId
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import com.bselzer.gw2.v2.scope.guild.GuildRanking
import com.bselzer.gw2.v2.scope.guild.GuildScope
import kotlin.io.path.Path

fun main() {
    val scopes = listOf(Scope(Requirement.REQUIRED, Permission.ACCOUNT), Scope(Requirement.OPTIONAL, Permission.GUILDS))
    val guildScope = listOf(GuildScope(Requirement.REQUIRED, GuildRanking.LEADER), GuildScope(Requirement.OPTIONAL, GuildRanking.MEMBER))
    val links = listOf("https://wiki.guildwars2.com/wiki/API:2/guild/:id/upgrades")
    val query = Ids(WvwAbilityId::class, WvwAbility::class, scopes, guildScope, links)
    val file = Client(WvwAbility::class, "wvw/abilities", query).file
    file.writeTo(Path(BuildKonfig.OUTPUT_DIRECTORY))
}