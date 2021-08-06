package com.bselzer.library.gw2.v2.client.common

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import com.bselzer.library.gw2.v2.client.common.constant.endpoint.Accounts
import com.bselzer.library.gw2.v2.client.common.extension.ensureBearer
import com.bselzer.library.gw2.v2.model.common.account.*
import com.bselzer.library.gw2.v2.model.common.account.mastery.AccountMastery
import com.bselzer.library.gw2.v2.model.common.account.mastery.AccountMasteryPoints
import io.ktor.client.*
import io.ktor.client.request.*
import kotlin.time.ExperimentalTime

/**
 * The account client.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account">the wiki</a>
 */
@OptIn(ExperimentalTime::class)
@Scope(Requirement.REQUIRED, Permission.ACCOUNT)
@Scope(Requirement.OPTIONAL, Permission.GUILDS, Permission.PROGRESSION)
class AccountClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration)
{
    /**
     * @return the account information
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT)
    @Scope(Requirement.OPTIONAL, Permission.GUILDS, Permission.PROGRESSION)
    suspend fun account(token: String? = null): Account = httpClient.get(path = Accounts.ACCOUNT) {
        ensureBearer(token)
    }

    /**
     * @return the account's achievements
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/achievements">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun achievements(token: String? = null): List<AccountAchievement> =
        httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.ACHIEVEMENTS}") {
            ensureBearer(token)
        }

    /**
     * Gets the bank slots associated with an account.
     * A null [BankSlot] indicates that the slot does not contain an item.
     *
     * @return the account's bank slots
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/bank">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.INVENTORIES)
    suspend fun bankSlots(token: String? = null): List<BankSlot> =
        httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.BANK}") {
            ensureBearer(token)
        }

    /**
     * @return the time-gated recipes that have been crafted since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/dailycrafting">the wiki</a>
     */
    // TODO enum for the items and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dailyCrafting(token: String? = null): List<String> =
        httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.DAILY_CRAFTING}") {
            ensureBearer(token)
        }

    /**
     * @return the ids of the dungeon paths completed since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/dungeons">the wiki</a>
     */
    // TODO enum for the paths and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dailyDungeons(token: String? = null): List<String> =
        httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.DUNGEONS}") {
            ensureBearer(token)
        }

    /**
     * @return the ids of the unlocked dyes on the account
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/dyes">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun dyes(token: String? = null): List<Int> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.DYES}") {
        ensureBearer(token)
    }

    /**
     * @return the account's unlocked finishers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/finishers">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun finishers(token: String? = null): List<AccountFinisher> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.FINISHERS}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked gliders
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/gliders">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun gliders(token: String? = null): List<Int> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.GLIDERS}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked home instance cats
     * @since 2019-03-22T00:00:00Z or later
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/home/cats">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION, Permission.UNLOCKS)
    suspend fun cats(token: String? = null): List<Int> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.HOME}/${Accounts.CATS}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked home instance nodes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/home/nodes">the wiki</a>
     */
    // TODO enum for the ids and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION, Permission.UNLOCKS)
    suspend fun nodes(token: String? = null): List<String> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.HOME}/${Accounts.NODES}") {
        ensureBearer(token)
    }

    /**
     * Gets the shared slots associated with an account.
     * A null [SharedSlot] indicates that the slot does not contain an item.
     * @return the account's shared slots
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/inventory">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.INVENTORIES)
    suspend fun inventories(token: String? = null): List<SharedSlot> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.INVENTORY}") {
        ensureBearer(token)
    }

    /**
     * @return the amount of luck consumed or null if the account has no luck
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/luck">the wiki</a>
     */
    // Response is a collection of AccountLuck objects, but there will only be 1 at most with an irrelevant id.
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION, Permission.UNLOCKS)
    suspend fun luck(token: String? = null): Int? = httpClient.get<List<AccountLuck>>(path = "${Accounts.ACCOUNT}/${Accounts.LUCK}") {
        ensureBearer(token)
    }.firstOrNull()?.value

    /**
     * @return the ids of the unlocked mail carriers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mailcarriers">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun mailCarriers(token: String? = null): List<Int> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.MAIL_CARRIERS}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the map chests unlocked since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mapchests">the wiki</a>
     */
    // TODO enum for the ids and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dailyMapChests(token: String? = null): List<String> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.MAP_CHESTS}") {
        ensureBearer(token)
    }

    /**
     * @return the account's unlocked masteries
     * @See <a href="https://wiki.guildwars2.com/wiki/API:2/account/masteries">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun masteries(token: String? = null): List<AccountMastery> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.MASTERIES}") {
        ensureBearer(token)
    }

    /**
     * @return the account's unlocked mastery point counts
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mastery/points">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun masteryPoints(token: String? = null): AccountMasteryPoints = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.MASTERY}/${Accounts.POINTS}") {
        ensureBearer(token)
    }

    /**
     * @return the account's materials
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/materials">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.INVENTORIES)
    suspend fun materials(token: String? = null): List<AccountMaterial> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.MATERIALS}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked minis
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/minis">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun minis(token: String? = null): List<Int> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.MINIS}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked mount skins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mounts/skins">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun mountSkins(token: String? = null): List<Int> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.MOUNTS}/${Accounts.SKINS}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked mount types
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mounts/types">the wiki</a>
     */
    // TODO enums and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun mountTypes(token: String? = null): List<String> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.MOUNTS}/${Accounts.TYPES}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked novelties
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/novelties">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun novelties(token: String? = null): List<Int> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.NOVELTIES}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked outfits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/outfits">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun outfits(token: String? = null): List<Int> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.OUTFITS}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked PvP heroes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/pvp/heroes">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun pvpHeroes(token: String? = null): List<Int> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.PVP}/${Accounts.HEROES}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the raids completed since the weekly reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/raids">the wiki</a>
     */
    // TODO enums and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun weeklyRaids(token: String? = null): List<String> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.RAIDS}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked recipes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/recipes">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun recipes(token: String? = null): List<Int> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.RECIPES}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked skins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/skins">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun skins(token: String? = null): List<Int> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.SKINS}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked titles
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/titles">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun titles(token: String? = null): List<Int> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.TITLES}") {
        ensureBearer(token)
    }

    /**
     * @return the account's currencies
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/wallet">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.WALLET)
    suspend fun currencies(token: String? = null): List<Int> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.WALLET}") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the world bosses completed since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/worldbosses">the wiki</a>
     */
    // TODO enums and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dailyWorldBosses(token: String? = null): List<String> = httpClient.get(path = "${Accounts.ACCOUNT}/${Accounts.WORLD_BOSSES}") {
        ensureBearer(token)
    }
}