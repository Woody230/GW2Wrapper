package com.bselzer.library.gw2.v2.client.common.client

import com.bselzer.library.gw2.v2.annotation.common.scope.Permission
import com.bselzer.library.gw2.v2.annotation.common.scope.Requirement
import com.bselzer.library.gw2.v2.annotation.common.scope.Scope
import com.bselzer.library.gw2.v2.client.common.extension.ensureBearer
import com.bselzer.library.gw2.v2.model.common.account.*
import com.bselzer.library.gw2.v2.model.common.account.build.BuildTemplate
import com.bselzer.library.gw2.v2.model.common.account.mastery.AccountMastery
import com.bselzer.library.gw2.v2.model.common.account.mastery.AccountMasteryPoints
import io.ktor.client.*
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
    private companion object
    {
        const val ACCOUNT = "account"
        const val ACHIEVEMENTS = "achievements"
        const val BANK = "bank"
        const val BUILD_STORAGE = "buildstorage"
        const val DAILY_CRAFTING = "dailycrafting"
        const val DUNGEONS = "dungeons"
        const val DYES = "dyes"
        const val EMOTES = "emotes"
        const val FINISHERS = "finishers"
        const val GLIDERS = "gliders"
        const val HOME = "home"
        const val CATS = "cats"
        const val NODES = "nodes"
        const val INVENTORY = "inventory"
        const val LEGENDARY_ARMORY = "legendaryarmory"
        const val LUCK = "luck"
        const val MAIL_CARRIERS = "mailcarriers"
        const val MAP_CHESTS = "mapchests"
        const val MASTERIES = "masteries"
        const val MASTERY = "mastery"
        const val POINTS = "points"
        const val MATERIALS = "materials"
        const val MINIS = "minis"
        const val MOUNTS = "mounts"
        const val SKINS = "skins"
        const val TYPES = "types"
        const val NOVELTIES = "novelties"
        const val OUTFITS = "outfits"
        const val PVP = "pvp"
        const val HEROES = "heroes"
        const val RAIDS = "raids"
        const val RECIPES = "recipes"
        const val TITLES = "titles"
        const val WALLET = "wallet"
        const val WORLD_BOSSES = "worldbosses"
    }

    /**
     * @return the account information
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT)
    @Scope(Requirement.OPTIONAL, Permission.GUILDS, Permission.PROGRESSION)
    suspend fun account(token: String? = null): Account = get(path = ACCOUNT) {
        ensureBearer(token)
    }

    /**
     * @return the account's achievements
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/achievements">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun achievements(token: String? = null): List<AccountAchievement> =
        get(path = "$ACCOUNT/$ACHIEVEMENTS") {
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
        get(path = "$ACCOUNT/$BANK") {
            ensureBearer(token)
        }

    /**
     * @return the build templates stored on the account
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/buildstorage">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT)
    suspend fun storedBuildTemplates(token: String? = null): List<BuildTemplate> = get(path = "$ACCOUNT/$BUILD_STORAGE") {
        ensureBearer(token)
    }

    /**
     * @return the time-gated recipes that have been crafted since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/dailycrafting">the wiki</a>
     */
    // TODO enum for the items and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dailyCrafting(token: String? = null): List<String> =
        get(path = "$ACCOUNT/$DAILY_CRAFTING") {
            ensureBearer(token)
        }

    /**
     * @return the ids of the dungeon paths completed since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/dungeons">the wiki</a>
     */
    // TODO enum for the paths and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dailyDungeons(token: String? = null): List<String> =
        get(path = "$ACCOUNT/$DUNGEONS") {
            ensureBearer(token)
        }

    /**
     * @return the ids of the unlocked dyes on the account
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/dyes">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun dyes(token: String? = null): List<Int> = get(path = "$ACCOUNT/$DYES") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked emotes on the account
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/emotes">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT)
    suspend fun emotes(token: String? = null): List<String> = get(path = "$ACCOUNT/$EMOTES") {
        ensureBearer(token)
    }

    /**
     * @return the account's unlocked finishers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/finishers">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun finishers(token: String? = null): List<AccountFinisher> = get(path = "$ACCOUNT/$FINISHERS") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked gliders
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/gliders">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun gliders(token: String? = null): List<Int> = get(path = "$ACCOUNT/$GLIDERS") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked home instance cats
     * @since 2019-03-22T00:00:00Z or later
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/home/cats">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION, Permission.UNLOCKS)
    suspend fun cats(token: String? = null): List<Int> = get(path = "$ACCOUNT/$HOME/$CATS") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked home instance nodes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/home/nodes">the wiki</a>
     */
    // TODO enum for the ids and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION, Permission.UNLOCKS)
    suspend fun nodes(token: String? = null): List<String> = get(path = "$ACCOUNT/$HOME/$NODES") {
        ensureBearer(token)
    }

    /**
     * Gets the shared slots associated with an account.
     * A null [SharedSlot] indicates that the slot does not contain an item.
     * @return the account's shared slots
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/inventory">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.INVENTORIES)
    suspend fun sharedSlots(token: String? = null): List<SharedSlot> = get(path = "$ACCOUNT/$INVENTORY") {
        ensureBearer(token)
    }

    /**
     * @return the account's legendary armory items
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/legendaryarmory">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.INVENTORIES, Permission.UNLOCKS)
    suspend fun legendaryArmory(token: String? = null): List<ArmoryItem> = get(path = "$ACCOUNT/$LEGENDARY_ARMORY") {
        ensureBearer(token)
    }

    /**
     * @return the amount of luck consumed or null if the account has no luck
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/luck">the wiki</a>
     */
    // Response is a collection of AccountLuck objects, but there will only be 1 at most with an irrelevant id.
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION, Permission.UNLOCKS)
    suspend fun luck(token: String? = null): Int? = get<List<AccountLuck>>(path = "$ACCOUNT/$LUCK") {
        ensureBearer(token)
    }.firstOrNull()?.value

    /**
     * @return the ids of the unlocked mail carriers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mailcarriers">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun mailCarriers(token: String? = null): List<Int> = get(path = "$ACCOUNT/$MAIL_CARRIERS") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the map chests unlocked since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mapchests">the wiki</a>
     */
    // TODO enum for the ids and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dailyMapChests(token: String? = null): List<String> = get(path = "$ACCOUNT/$MAP_CHESTS") {
        ensureBearer(token)
    }

    /**
     * @return the account's unlocked masteries
     * @See <a href="https://wiki.guildwars2.com/wiki/API:2/account/masteries">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun masteries(token: String? = null): List<AccountMastery> = get(path = "$ACCOUNT/$MASTERIES") {
        ensureBearer(token)
    }

    /**
     * @return the account's unlocked mastery point counts
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mastery/points">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun masteryPoints(token: String? = null): AccountMasteryPoints = get(path = "$ACCOUNT/$MASTERY/$POINTS") {
        ensureBearer(token)
    }

    /**
     * @return the account's materials
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/materials">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.INVENTORIES)
    suspend fun materials(token: String? = null): List<AccountMaterial> = get(path = "$ACCOUNT/$MATERIALS") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked minis
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/minis">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun minis(token: String? = null): List<Int> = get(path = "$ACCOUNT/$MINIS") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked mount skins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mounts/skins">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun mountSkins(token: String? = null): List<Int> = get(path = "$ACCOUNT/$MOUNTS/$SKINS") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked mount types
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mounts/types">the wiki</a>
     */
    // TODO enums and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun mountTypes(token: String? = null): List<String> = get(path = "$ACCOUNT/$MOUNTS/$TYPES") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked novelties
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/novelties">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun novelties(token: String? = null): List<Int> = get(path = "$ACCOUNT/$NOVELTIES") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked outfits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/outfits">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun outfits(token: String? = null): List<Int> = get(path = "$ACCOUNT/$OUTFITS") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked PvP heroes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/pvp/heroes">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun pvpHeroes(token: String? = null): List<Int> = get(path = "$ACCOUNT/$PVP/$HEROES") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the raids completed since the weekly reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/raids">the wiki</a>
     */
    // TODO enums and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun weeklyRaids(token: String? = null): List<String> = get(path = "$ACCOUNT/$RAIDS") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked recipes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/recipes">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun recipes(token: String? = null): List<Int> = get(path = "$ACCOUNT/$RECIPES") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked skins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/skins">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun skins(token: String? = null): List<Int> = get(path = "$ACCOUNT/$SKINS") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the unlocked titles
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/titles">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun titles(token: String? = null): List<Int> = get(path = "$ACCOUNT/$TITLES") {
        ensureBearer(token)
    }

    /**
     * @return the account's currencies
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/wallet">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.WALLET)
    suspend fun currencies(token: String? = null): List<Int> = get(path = "$ACCOUNT/$WALLET") {
        ensureBearer(token)
    }

    /**
     * @return the ids of the world bosses completed since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/worldbosses">the wiki</a>
     */
    // TODO enums and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dailyWorldBosses(token: String? = null): List<String> = get(path = "$ACCOUNT/$WORLD_BOSSES") {
        ensureBearer(token)
    }
}