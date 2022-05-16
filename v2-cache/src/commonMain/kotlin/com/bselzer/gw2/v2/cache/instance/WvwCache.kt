package com.bselzer.gw2.v2.cache.instance

import com.bselzer.gw2.v2.cache.operation.findByReferenceId
import com.bselzer.gw2.v2.cache.operation.findByReferenceIds
import com.bselzer.gw2.v2.client.client.Gw2Client
import com.bselzer.gw2.v2.model.extension.wvw.allWorlds
import com.bselzer.gw2.v2.model.guild.upgrade.ClaimableUpgrade
import com.bselzer.gw2.v2.model.guild.upgrade.DefaultUpgrade
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgrade
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgradeId
import com.bselzer.gw2.v2.model.world.WorldId
import com.bselzer.gw2.v2.model.wvw.map.WvwMapObjective
import com.bselzer.gw2.v2.model.wvw.match.WvwMatch
import com.bselzer.gw2.v2.model.wvw.objective.WvwObjective
import com.bselzer.gw2.v2.model.wvw.upgrade.WvwUpgrade
import com.bselzer.gw2.v2.model.wvw.upgrade.WvwUpgradeId
import com.bselzer.ktx.kodein.db.cache.Cache
import com.bselzer.ktx.kodein.db.operation.clear
import com.bselzer.ktx.kodein.db.operation.putMissingById
import com.bselzer.ktx.kodein.db.transaction.Transaction
import org.kodein.db.*
import kotlin.jvm.JvmName

/**
 * Represents a cache for World vs. World models.
 */
class WvwCache(private val client: Gw2Client) : Cache {
    /**
     * Finds the match in the database that the world with the given [worldId] is associated with.
     *
     * If there is no match, then it is resolved with a call to the api.
     *
     * @param worldId the id of the world
     * @return the match
     */
    suspend fun Transaction.findMatch(worldId: WorldId): WvwMatch {
        var stored = reader.find<WvwMatch>().all().useModels { it.firstOrNull { match -> match.allWorlds().contains(worldId) } }
        if (stored == null) {
            stored = client.wvw.match(worldId = worldId)
            writer.put(stored)
        }

        return stored
    }

    /**
     * Finds the objectives in the database associated with the [match].
     *
     * If there are missing objectives, then they are not resolved with a call to the api.
     * A call to [putMatch] should be made first.
     *
     * @param match the match
     * @return the objectives
     */
    fun Transaction.findObjectives(match: WvwMatch): Collection<WvwObjective> = findByReferenceIds(listOf(match)) {
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
    fun Transaction.getUpgrade(objective: WvwObjective): WvwUpgrade? {
        return reader.getById(objective.upgradeId)
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
    fun Transaction.findUpgrades(objectives: Collection<WvwObjective>): Collection<WvwUpgrade> = findByReferenceId(objectives) { upgradeId }

    /**
     * Finds the guild upgrades associated with the match [objectives].
     *
     * If there are missing upgrades, then they are not resolved with a call to the api.
     * A call to [putMatch] should be made first.
     *
     * @param objectives the objectives
     * @return the guild upgrades
     */
    @JvmName("findGuildUpgradesByObjective")
    fun Transaction.findGuildUpgrades(objectives: Collection<WvwMapObjective>): Collection<GuildUpgrade> = findByReferenceIds(objectives) { guildUpgradeIds }

    /**
     * Finds the guild upgrades associated with all the [ids] if provided, or all the ids returned from the api by default.
     *
     * If there are missing upgrades, then they are resolved with a call to the api.
     *
     * @param ids the ids of the guild upgrades to find
     * @return the guild upgrades
     */
    @JvmName("findGuildUpgradesById")
    suspend fun Transaction.findGuildUpgrades(ids: Collection<GuildUpgradeId>? = null): Collection<GuildUpgrade> {
        val guildUpgradeIds = ids ?: client.guild.upgradeIds()
        putGuildUpgrades(guildUpgradeIds)
        return findByReferenceId(guildUpgradeIds) { this }
    }

    /**
     * Puts the match and associated objectives.
     *
     * @param match the match
     */
    suspend fun Transaction.putMatch(match: WvwMatch): Unit {
        writer.put(match)
        putObjectives(match)
    }

    /**
     * Puts the missing objectives from the match and their associated upgrades and guild upgrades.
     *
     * @param match the match
     */
    private suspend fun Transaction.putObjectives(match: WvwMatch) {
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
     * Puts the missing upgrades associated with the given [ids].
     *
     * @param ids the ids of the upgrades
     */
    @JvmName("putUpgradesById")
    private suspend fun Transaction.putUpgrades(ids: Collection<WvwUpgradeId>) {
        putMissingById(
            requestIds = { ids },
            requestById = { requested -> client.wvw.upgrades(requested) },
            getId = { upgrade -> upgrade.id },

            // Need to default since some ids may not exist and this will prevent repeated API calls.
            default = { WvwUpgrade() }
        )
    }

    /**
     * Puts the missing upgrades from the objectives.
     *
     * @param objectives the objectives
     */
    @JvmName("putUpgradesByObjective")
    private suspend fun Transaction.putUpgrades(objectives: Collection<WvwObjective>): Unit = putUpgrades(ids = objectives.map { objective -> objective.upgradeId })

    /**
     * Puts the missing guild upgrades associated with the given [ids].
     *
     * @param ids the ids of the guild upgrades
     */
    private suspend fun Transaction.putGuildUpgrades(ids: Collection<GuildUpgradeId>) {
        putMissingById(
            requestIds = { ids },
            requestById = { requested -> client.guild.upgrades(requested) },
            getId = { upgrade -> upgrade.id },

            // Need to default since some ids may not exist and this will prevent repeated API calls.
            default = { DefaultUpgrade() }
        )
    }

    /**
     * Puts the missing guild upgrades from the objectives within the match.
     *
     * @param match the match
     */
    private suspend fun Transaction.putGuildUpgrades(match: WvwMatch): Unit = putGuildUpgrades(
        ids = match.maps.flatMap { map -> map.objectives.flatMap { objective -> objective.guildUpgradeIds } }
    )

    /**
     * Clears the [WvwMatch], [WvwObjective], and [WvwUpgrade], and [ClaimableUpgrade] guild upgrade models.
     */
    override fun Transaction.clear() {
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