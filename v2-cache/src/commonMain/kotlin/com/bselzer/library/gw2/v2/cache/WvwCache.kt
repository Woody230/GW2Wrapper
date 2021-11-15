package com.bselzer.library.gw2.v2.cache

import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.gw2.v2.model.guild.upgrade.ClaimableUpgrade
import com.bselzer.library.gw2.v2.model.guild.upgrade.GuildUpgrade
import com.bselzer.library.gw2.v2.model.wvw.match.WvwMatch
import com.bselzer.library.gw2.v2.model.wvw.objective.WvwObjective
import com.bselzer.library.gw2.v2.model.wvw.upgrade.WvwUpgrade
import com.bselzer.library.kotlin.extension.kodein.db.operation.clear
import com.bselzer.library.kotlin.extension.kodein.db.operation.putMissingById
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionStarter
import org.kodein.db.asModelSequence
import org.kodein.db.deleteFrom
import org.kodein.db.find
import org.kodein.db.getById

/**
 * Represents a cache for World vs. World models.
 */
class WvwCache(transactionStarter: TransactionStarter, client: Gw2Client) : BaseCache(transactionStarter, client) {
    /**
     * Puts the match and associated objectives.
     */
    suspend fun putMatch(match: WvwMatch): Unit = transaction {
        writer.put(match)
        putObjectives(match)
    }

    /**
     * Puts the missing objectives from the match and their associated upgrades and guild upgrades.
     */
    private suspend fun putObjectives(match: WvwMatch): Unit = transaction {
        val objectiveIds = match.maps.flatMap { map -> map.objectives.map { objective -> objective.id } }
        putMissingById(
            requestIds = { objectiveIds },
            requestById = { ids -> client.wvw.objectives(ids) }
        )

        val objectives = objectiveIds.mapNotNull { id -> reader.getById<WvwObjective>(id) }
        putUpgrades(objectives)
        putGuildUpgrades(match)
    }

    /**
     * Puts the missing upgrades from the objectives.
     */
    private suspend fun putUpgrades(objectives: Collection<WvwObjective>): Unit = transaction {
        putMissingById(
            requestIds = { objectives.map { objective -> objective.upgradeId } },
            requestById = { ids -> client.wvw.upgrades(ids) },
            getId = { upgrade -> upgrade.id },

            // Need to default since some ids may not exist and this will prevent repeated API calls.
            default = { WvwUpgrade() }
        )
    }

    /**
     * Puts the missing guild upgrades from the objectives within the match.
     */
    private suspend fun putGuildUpgrades(match: WvwMatch): Unit = transaction {
        putMissingById(
            requestIds = { match.maps.flatMap { map -> map.objectives.flatMap { objective -> objective.guildUpgradeIds } } },
            requestById = { ids -> client.guild.upgrades(ids) },
            getId = { upgrade -> upgrade.id },

            // Need to default since some ids may not exist and this will prevent repeated API calls.
            default = { ClaimableUpgrade() }
        )
    }

    /**
     * Clears the [WvwMatch], [WvwObjective], and [WvwUpgrade], and [ClaimableUpgrade] guild upgrade models.
     */
    override suspend fun clear() = transaction {
        clear<WvwMatch>()
        clear<WvwObjective>()
        clear<WvwUpgrade>()

        // Since guild upgrades are not completely WvW specific, need to delete the specific upgrades.
        // Ids are only dynamically found through the match so using it wouldn't be comprehensive.
        // Therefore, the only resolution is to delete any ClaimableUpgrade, which should only be tactics.
        val tactics = reader.find<GuildUpgrade>().all().asModelSequence().filter { guildUpgrade -> guildUpgrade is ClaimableUpgrade }
        tactics.forEach { tactic -> writer.deleteFrom(tactic) }
    }
}