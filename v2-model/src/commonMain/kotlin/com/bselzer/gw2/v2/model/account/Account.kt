package com.bselzer.gw2.v2.model.account

import com.bselzer.gw2.v2.model.achievement.AchievementPoints
import com.bselzer.gw2.v2.model.enumeration.wrapper.AccountAccess
import com.bselzer.gw2.v2.model.guild.GuildId
import com.bselzer.gw2.v2.model.world.WorldId
import com.bselzer.gw2.v2.model.wvw.rank.WvwLevel
import com.bselzer.gw2.v2.scope.core.Permission
import com.bselzer.gw2.v2.scope.core.Requirement
import com.bselzer.gw2.v2.scope.core.Scope
import com.bselzer.ktx.datetime.serialization.SecondDurationSerializer
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration

/**
 * The account information.
 */
@Scope(Requirement.REQUIRED, Permission.ACCOUNT)
@Scope(Requirement.OPTIONAL, Permission.GUILDS, Permission.PROGRESSION)
@Serializable
data class Account(
    /**
     * The id in the form of a UUID.
     */
    @SerialName("id")
    override val id: AccountId = AccountId(),

    /**
     * The age in the form of seconds.
     */
    @Serializable(with = SecondDurationSerializer::class)
    @SerialName("age")
    val age: Duration = Duration.ZERO,

    /**
     * The name in the form of "DisplayName.####" where # are numbers.
     */
    @SerialName("name")
    val name: AccountName = AccountName(),

    /**
     * The id of the world (server).
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    @SerialName("world")
    val world: WorldId = WorldId(),

    /**
     * The guild ids in the form of UUIDs.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id">the wiki</a>
     */
    @SerialName("guilds")
    val guilds: List<GuildId> = emptyList(),

    /**
     * The guilds ids that the account is a leader of, in the form of UUIDs.
     *
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id">the wiki</a>
     */
    @Scope(Requirement.REQUIRED, Permission.GUILDS)
    @SerialName("guild_leader")
    val leaderGuilds: List<GuildId> = emptyList(),

    /**
     * The date and time of account creation.
     */
    @SerialName("created")
    val createdAt: Instant = Instant.DISTANT_PAST,

    /**
     * The types of access, indicating no access, free to play access, or base/expansion content access.
     */
    @SerialName("access")
    val access: List<AccountAccess> = emptyList(),

    /**
     * Whether the account has bought a commander tag.
     */
    @SerialName("commander")
    val hasCommanderTag: Boolean = false,

    /**
     * The personal fractal reward level.
     */
    @Scope(Requirement.REQUIRED, Permission.PROGRESSION)
    @SerialName("fractal_level")
    val fractalLevel: Int = 0,

    /**
     * The number of daily achievement points earned.
     */
    @Scope(Requirement.REQUIRED, Permission.PROGRESSION)
    @SerialName("daily_ap")
    val dailyAp: AchievementPoints = AchievementPoints(),

    /**
     * The number of monthly achievement points earned.
     */
    @Scope(Requirement.REQUIRED, Permission.PROGRESSION)
    @SerialName("monthly_ap")
    val monthlyAp: AchievementPoints = AchievementPoints(),

    /**
     * The personal WvW rank.
     */
    @Scope(Requirement.REQUIRED, Permission.PROGRESSION)
    @SerialName("wvw_rank")
    val wvwRank: WvwLevel = WvwLevel(),

    /**
     * The date and time of when the account information last changed.
     *
     * @since 2019-02-21T00:00:00.000Z
     */
    @SerialName("last_modified")
    val lastModifiedAt: Instant = Instant.DISTANT_PAST,

    /**
     * The number of build storage slots.
     *
     * @since 2019-12-19T00:00:00.000Z
     * @see <a href="https://wiki.guildwars2.com/wiki/Template#Build_Storage">the wiki</a>
     */
    @SerialName("build_storage_slots")
    val buildStorageSlots: Int = 0
) : Identifiable<String>