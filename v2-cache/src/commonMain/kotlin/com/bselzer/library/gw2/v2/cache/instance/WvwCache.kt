package com.bselzer.library.gw2.v2.cache.instance

import com.bselzer.library.gw2.v2.client.client.Gw2Client
import com.bselzer.library.gw2.v2.model.guild.upgrade.ClaimableUpgrade
import com.bselzer.library.gw2.v2.model.guild.upgrade.GuildUpgrade
import com.bselzer.library.gw2.v2.model.wvw.match.WvwMapObjective
import com.bselzer.library.gw2.v2.model.wvw.match.WvwMatch
import com.bselzer.library.gw2.v2.model.wvw.objective.WvwObjective
import com.bselzer.library.gw2.v2.model.wvw.upgrade.WvwUpgrade
import com.bselzer.library.kotlin.extension.kodein.db.operation.clear
import com.bselzer.library.kotlin.extension.kodein.db.operation.putMissingById
import com.bselzer.library.kotlin.extension.kodein.db.transaction.TransactionManager
import org.kodein.db.asModelSequence
import org.kodein.db.deleteFrom
import org.kodein.db.find
import org.kodein.db.getById

/**
 * Represents a cache for World vs. World models.
 */
class WvwCache(transactionManager: TransactionManager, client: Gw2Client) : Gw2Cache(transactionManager, client) {

    /**
     * Finds the objectives in the database associated with the [match].
     *
     * If there are missing objectives, then they are not resolved with a call to the api.
     * A call to [putMatch] should be made first.
     *
     * @param match the match
     * @return the objectives
     */
    suspend fun findObjectives(match: WvwMatch): Collection<WvwObjective> = findByReferenceIds(listOf(match)) {
        maps.flatMap { map -> map.objectives.map { objective -> objective.id } }
    }

    /**
     * Gets the upgrade associated with the [objective].
     *
     * If there is no upgrade, then it is not resolved with a call to the api.
     * A call to [putMatch] should be made first.
     *
     * @param objective the objective
     * @return the upgrade
     */
    suspend fun getUpgrade(objective: WvwObjective): WvwUpgrade? = transaction { db ->
        db.reader.getById(objective.upgradeId)
    }

    /**
     * Finds the upgrades associated with the [objectives].
     *
     * If there are missing upgrades, then they are not resolved with a call to the api.
     * A call to [putMatch] should be made first.
     *
     * @param objectives the objectives
     * @return the upgrades
     */
    suspend fun findUpgrades(objectives: Collection<WvwObjective>): Collection<WvwUpgrade> = findByReferenceId(objectives) { upgradeId }

    /**
     * Finds the guild upgrades associated with the match [objectives].
     *
     * If there are missing upgrades, then they are not resolved with a call to the api.
     * A call to [putMatch] should be made first.
     */
    suspend fun findGuildUpgrades(objectives: Collection<WvwMapObjective>): Collection<GuildUpgrade> = findByReferenceIds(objectives) { guildUpgradeIds }

    /**
     * Puts the match and associated objectives.
     *
     * @param match the match
     */
    suspend fun putMatch(match: WvwMatch): Unit = transaction {
        putObjectives(match)
    }

    /**
     * Puts the missing objectives from the match and their associated upgrades and guild upgrades.
     *
     * @param match the match
     */
    private suspend fun putObjectives(match: WvwMatch): Unit = transaction { db ->
        val objectiveIds = match.maps.flatMap { map -> map.objectives.map { objective -> objective.id } }
        putMissingById(
            requestIds = { objectiveIds },
            requestById = { ids -> client.wvw.objectives(ids) }
        )

        val objectives = objectiveIds.mapNotNull { id -> db.reader.getById<WvwObjective>(id) }
        putUpgrades(objectives)
        putGuildUpgrades(match)
    }

    /**
     * Puts the missing upgrades from the objectives.
     *
     * @param objectives the objectives
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
     *
     * @param match the match
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
    override suspend fun clear(): Unit = transaction { db ->
        clear<WvwMatch>()
        clear<WvwObjective>()
        clear<WvwUpgrade>()

        // Since guild upgrades are not completely WvW specific, need to delete the specific upgrades.
        // Ids are only dynamically found through the match so using it wouldn't be comprehensive.
        // Therefore, the only resolution is to delete any ClaimableUpgrade, which should only be tactics.
        val tactics = db.reader.find<GuildUpgrade>().all().asModelSequence().filter { guildUpgrade -> guildUpgrade is ClaimableUpgrade }
        tactics.forEach { tactic -> db.writer.deleteFrom(tactic) }
    }
}