package com.bselzer.gw2.v2.client.client

import com.bselzer.gw2.v2.client.extension.bearer
import com.bselzer.gw2.v2.client.model.Token
import com.bselzer.gw2.v2.model.account.Account
import com.bselzer.gw2.v2.model.account.achievement.AccountAchievement
import com.bselzer.gw2.v2.model.account.finisher.AccountFinisher
import com.bselzer.gw2.v2.model.account.luck.AccountLuck
import com.bselzer.gw2.v2.model.account.mastery.AccountMastery
import com.bselzer.gw2.v2.model.account.mastery.AccountMasteryPoints
import com.bselzer.gw2.v2.model.account.slot.AccountMaterial
import com.bselzer.gw2.v2.model.account.slot.ArmoryItem
import com.bselzer.gw2.v2.model.account.slot.BankSlot
import com.bselzer.gw2.v2.model.account.slot.SharedSlot
import com.bselzer.gw2.v2.model.color.DyeColorId
import com.bselzer.gw2.v2.model.currency.CurrencyId
import com.bselzer.gw2.v2.model.daily.DailyCraftingId
import com.bselzer.gw2.v2.model.dungeon.path.DungeonPathId
import com.bselzer.gw2.v2.model.emote.EmoteId
import com.bselzer.gw2.v2.model.glider.GliderId
import com.bselzer.gw2.v2.model.home.cat.CatId
import com.bselzer.gw2.v2.model.home.node.NodeId
import com.bselzer.gw2.v2.model.mailcarrier.MailCarrierId
import com.bselzer.gw2.v2.model.mapchest.MapChestId
import com.bselzer.gw2.v2.model.mini.MiniId
import com.bselzer.gw2.v2.model.mount.skin.MountSkinId
import com.bselzer.gw2.v2.model.mount.type.MountTypeId
import com.bselzer.gw2.v2.model.novelty.NoveltyId
import com.bselzer.gw2.v2.model.outfit.OutfitId
import com.bselzer.gw2.v2.model.pvp.hero.PvpHeroId
import com.bselzer.gw2.v2.model.raid.event.RaidEventId
import com.bselzer.gw2.v2.model.recipe.RecipeId
import com.bselzer.gw2.v2.model.skin.SkinId
import com.bselzer.gw2.v2.model.template.build.BuildTemplate
import com.bselzer.gw2.v2.model.title.TitleId
import com.bselzer.gw2.v2.model.worldboss.WorldBossId
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import io.ktor.client.*

/**
 * The account client.
 *
 * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account">the wiki</a>
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT)
@Scope(Requirement.OPTIONAL, Permission.GUILDS, Permission.PROGRESSION)
class AccountClient(httpClient: HttpClient, configuration: Gw2ClientConfiguration) : BaseClient(httpClient, configuration) {
    private companion object {
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
    suspend fun account(token: Token? = null): Account = getSingle(path = ACCOUNT, instance = { Account() }) {
        bearer(token)
    }

    /**
     * @return the account's achievements
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/achievements">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun achievements(token: Token? = null): List<AccountAchievement> =
        getIdentifiableList(path = "$ACCOUNT/$ACHIEVEMENTS") {
            bearer(token)
        }

    /**
     * Gets the bank slots associated with an account.
     * A null [BankSlot] indicates that the slot does not contain an item.
     *
     * @return the account's bank slots
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/bank">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.INVENTORIES)
    suspend fun bankSlots(token: Token? = null): List<BankSlot> =
        getIdentifiableList(path = "$ACCOUNT/$BANK") {
            bearer(token)
        }

    /**
     * @return the build templates stored on the account
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/buildstorage">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT)
    suspend fun storedBuildTemplates(token: Token? = null): List<BuildTemplate> = getList(path = "$ACCOUNT/$BUILD_STORAGE") {
        bearer(token)
    }

    /**
     * @return the time-gated recipes that have been crafted since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/dailycrafting">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dailyCrafting(token: Token? = null): List<DailyCraftingId> =
        getIds(path = "$ACCOUNT/$DAILY_CRAFTING") {
            bearer(token)
        }

    /**
     * @return the ids of the dungeon paths completed since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/dungeons">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dailyDungeons(token: Token? = null): List<DungeonPathId> =
        getIds(path = "$ACCOUNT/$DUNGEONS") {
            bearer(token)
        }

    /**
     * @return the ids of the unlocked dyes on the account
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/dyes">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun dyes(token: Token? = null): List<DyeColorId> = getIds(path = "$ACCOUNT/$DYES") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked emotes on the account
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/emotes">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT)
    suspend fun emotes(token: Token? = null): List<EmoteId> = getIds(path = "$ACCOUNT/$EMOTES") {
        bearer(token)
    }

    /**
     * @return the account's unlocked finishers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/finishers">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun finishers(token: Token? = null): List<AccountFinisher> = getIdentifiableList(path = "$ACCOUNT/$FINISHERS") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked gliders
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/gliders">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun gliders(token: Token? = null): List<GliderId> = getIds(path = "$ACCOUNT/$GLIDERS") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked home instance cats
     * @since 2019-03-22T00:00:00Z or later
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/home/cats">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION, Permission.UNLOCKS)
    suspend fun cats(token: Token? = null): List<CatId> = getIds(path = "$ACCOUNT/$HOME/$CATS") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked home instance nodes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/home/nodes">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION, Permission.UNLOCKS)
    suspend fun nodes(token: Token? = null): List<NodeId> = getIds(path = "$ACCOUNT/$HOME/$NODES") {
        bearer(token)
    }

    /**
     * Gets the shared slots associated with an account.
     * A null [SharedSlot] indicates that the slot does not contain an item.
     * @return the account's shared slots
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/inventory">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.INVENTORIES)
    suspend fun sharedSlots(token: Token? = null): List<SharedSlot> = getIdentifiableList(path = "$ACCOUNT/$INVENTORY") {
        bearer(token)
    }

    /**
     * @return the account's legendary armory items
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/legendaryarmory">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.INVENTORIES, Permission.UNLOCKS)
    suspend fun legendaryArmory(token: Token? = null): List<ArmoryItem> = getIdentifiableList(path = "$ACCOUNT/$LEGENDARY_ARMORY") {
        bearer(token)
    }

    /**
     * @return the amount of luck consumed or null if the account has no luck
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/luck">the wiki</a>
     */
    // Response is a collection of AccountLuck objects, but there will only be 1 at most with an irrelevant id.
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION, Permission.UNLOCKS)
    suspend fun luck(token: Token? = null): Int? = getList<AccountLuck>(path = "$ACCOUNT/$LUCK") {
        bearer(token)
    }.firstOrNull()?.value

    /**
     * @return the ids of the unlocked mail carriers
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mailcarriers">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun mailCarriers(token: Token? = null): List<MailCarrierId> = getIds(path = "$ACCOUNT/$MAIL_CARRIERS") {
        bearer(token)
    }

    /**
     * @return the ids of the map chests unlocked since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mapchests">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dailyMapChests(token: Token? = null): List<MapChestId> = getIds(path = "$ACCOUNT/$MAP_CHESTS") {
        bearer(token)
    }

    /**
     * @return the account's unlocked masteries
     * @See <a href="https://wiki.guildwars2.com/wiki/API:2/account/masteries">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun masteries(token: Token? = null): List<AccountMastery> = getList(path = "$ACCOUNT/$MASTERIES") {
        bearer(token)
    }

    /**
     * @return the account's unlocked mastery point counts
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mastery/points">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun masteryPoints(token: Token? = null): AccountMasteryPoints = getSingle(path = "$ACCOUNT/$MASTERY/$POINTS", instance = { AccountMasteryPoints() }) {
        bearer(token)
    }

    /**
     * @return the account's materials
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/materials">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.INVENTORIES)
    suspend fun materials(token: Token? = null): List<AccountMaterial> = getIdentifiableList(path = "$ACCOUNT/$MATERIALS") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked minis
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/minis">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun minis(token: Token? = null): List<MiniId> = getIds(path = "$ACCOUNT/$MINIS") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked mount skins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mounts/skins">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun mountSkins(token: Token? = null): List<MountSkinId> = getIds(path = "$ACCOUNT/$MOUNTS/$SKINS") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked mount types
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/mounts/types">the wiki</a>
     */
    // TODO enums and extension method
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun mountTypes(token: Token? = null): List<MountTypeId> = getIds(path = "$ACCOUNT/$MOUNTS/$TYPES") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked novelties
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/novelties">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun novelties(token: Token? = null): List<NoveltyId> = getIds(path = "$ACCOUNT/$NOVELTIES") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked outfits
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/outfits">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun outfits(token: Token? = null): List<OutfitId> = getIds(path = "$ACCOUNT/$OUTFITS") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked PvP heroes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/pvp/heroes">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun pvpHeroes(token: Token? = null): List<PvpHeroId> = getIds(path = "$ACCOUNT/$PVP/$HEROES") {
        bearer(token)
    }

    /**
     * @return the ids of the raid encounters completed since the weekly reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/raids">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun weeklyRaids(token: Token? = null): List<RaidEventId> = getIds(path = "$ACCOUNT/$RAIDS") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked recipes
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/recipes">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun recipes(token: Token? = null): List<RecipeId> = getIds(path = "$ACCOUNT/$RECIPES") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked skins
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/skins">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun skins(token: Token? = null): List<SkinId> = getIds(path = "$ACCOUNT/$SKINS") {
        bearer(token)
    }

    /**
     * @return the ids of the unlocked titles
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/titles">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.UNLOCKS)
    suspend fun titles(token: Token? = null): List<TitleId> = getIds(path = "$ACCOUNT/$TITLES") {
        bearer(token)
    }

    /**
     * @return the account's currencies
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/wallet">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.WALLET)
    suspend fun currencies(token: Token? = null): List<CurrencyId> = getIds(path = "$ACCOUNT/$WALLET") {
        bearer(token)
    }

    /**
     * @return the ids of the world bosses completed since the daily reset
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/account/worldbosses">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.ACCOUNT, Permission.PROGRESSION)
    suspend fun dailyWorldBosses(token: Token? = null): List<WorldBossId> = getIds(path = "$ACCOUNT/$WORLD_BOSSES") {
        bearer(token)
    }
}