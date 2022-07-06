package com.bselzer.gw2.v2.db.operation

import com.bselzer.gw2.v2.model.continent.Continent
import com.bselzer.gw2.v2.model.continent.floor.Floor
import com.bselzer.gw2.v2.model.continent.map.ContinentMap
import com.bselzer.gw2.v2.model.continent.region.Region
import com.bselzer.gw2.v2.model.guild.Guild
import com.bselzer.gw2.v2.model.guild.emblem.GuildEmblem
import com.bselzer.gw2.v2.model.guild.log.GuildLog
import com.bselzer.gw2.v2.model.guild.member.GuildMember
import com.bselzer.gw2.v2.model.guild.permission.GuildPermission
import com.bselzer.gw2.v2.model.guild.rank.GuildRank
import com.bselzer.gw2.v2.model.guild.stash.GuildStash
import com.bselzer.gw2.v2.model.guild.storage.GuildStorageSlot
import com.bselzer.gw2.v2.model.guild.team.GuildTeam
import com.bselzer.gw2.v2.model.guild.treasury.GuildTreasurySlot
import com.bselzer.gw2.v2.model.guild.upgrade.ClaimableUpgrade
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgrade
import com.bselzer.gw2.v2.model.guild.upgrade.cost.GuildUpgradeCost
import com.bselzer.gw2.v2.model.map.Map
import com.bselzer.gw2.v2.model.world.World
import com.bselzer.gw2.v2.model.wvw.match.WvwMatch
import com.bselzer.gw2.v2.model.wvw.objective.WvwObjective
import com.bselzer.gw2.v2.model.wvw.upgrade.WvwUpgrade
import com.bselzer.ktx.db.operation.clear
import com.bselzer.ktx.db.transaction.Transaction
import org.kodein.db.deleteFrom
import org.kodein.db.find
import org.kodein.db.useModels

/**
 * Clears the [Continent], [Floor], [Region], [ContinentMap], and [Map] models.
 */
fun Transaction.clearContinent() {
    clear<Continent>()
    clear<Floor>()
    clear<Map>()

    // These models come from ContinentFloor and thus shouldn't be in the cache, but they are related so they should be deleted.
    clear<Region>()
    clear<ContinentMap>()
}

/**
 * Clears the [Guild], [GuildLog], [GuildMember], [GuildRank], [GuildStash], [GuildStorageSlot], [GuildEmblem], [GuildTeam], [GuildPermission], [GuildTreasurySlot],
 * [GuildUpgrade], and [GuildUpgradeCost] models.
 */
fun Transaction.clearGuild() {
    clear<Guild>()
    clear<GuildLog>()
    clear<GuildMember>()
    clear<GuildRank>()
    clear<GuildStash>()
    clear<GuildStorageSlot>()
    clear<GuildEmblem>()
    clear<GuildTeam>()
    clear<GuildPermission>()
    clear<GuildTreasurySlot>()
    clear<GuildUpgrade>()
    clear<GuildUpgradeCost>()
}

/**
 * Clears the [World], [WvwMatch], [WvwObjective], and [WvwUpgrade], and [ClaimableUpgrade] guild upgrade models.
 */
fun Transaction.clearWvw() {
    clear<World>()
    clear<WvwMatch>()
    clear<WvwObjective>()
    clear<WvwUpgrade>()

    // Since guild upgrades are not completely WvW specific, need to delete the specific upgrades.
    // Ids are only dynamically found through the match so using it wouldn't be comprehensive.
    // Therefore, the only resolution is to delete any ClaimableUpgrade, which should only be tactics.
    find<GuildUpgrade>().all().useModels { models ->
        models.filter { guildUpgrade -> guildUpgrade is ClaimableUpgrade }.forEach { tactic -> deleteFrom(tactic) }
    }
}