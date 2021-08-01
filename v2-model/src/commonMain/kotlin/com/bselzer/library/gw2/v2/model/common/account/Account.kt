package com.bselzer.library.gw2.v2.model.common.account

import com.bselzer.library.gw2.v2.model.common.serialization.SecondDurationSerializer
import com.bselzer.library.kotlin.extension.datetime.common.function.minValue
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

/**
 * The account information.
 *
 * Scopes: account
 *
 * Optional scopes: guilds, progression
 */
@ExperimentalTime
@Serializable
data class Account(
    /**
     * The identifier in the form of a UUID.
     */
    @SerialName("id")
    val id: String = "",

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
    val name: String = "",

    /**
     * The id of the world (server).
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/worlds">the wiki</a>
     */
    @SerialName("world")
    val world: Int = 0,

    /**
     * The guild ids in the form of UUIDs.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id">the wiki</a>
     */
    @SerialName("guilds")
    val guilds: List<String> = emptyList(),

    /**
     * The guilds ids that the account is a leader of, in the form of UUIDs.
     *
     * Scopes: guilds
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/:id">the wiki</a>
     */
    @SerialName("guild_leader")
    val leaderGuilds: List<String> = emptyList(),

    /**
     * The date and time of account creation.
     */
    @SerialName("created")
    val createdAt: LocalDateTime = LocalDateTime.minValue(),

    /**
     * The types of access, indicating no access, free to play access, or base/expansion content access.
     */
    @SerialName("access")
    val access: List<String> = emptyList(),

    /**
     * Whether the account has bought a commander tag.
     */
    @SerialName("commander")
    val hasCommanderTag: Boolean = false,

    /**
     * The personal fractal reward level.
     *
     * Scopes: progression
     */
    @SerialName("fractal_level")
    val fractalLevel: Int = 0,

    /**
     * The number of daily achievement points earned.
     *
     * Scopes: progression
     */
    @SerialName("daily_ap")
    val dailyAp: Int = 0,

    /**
     * The number of monthly achievement points earned.
     *
     * Scopes: progression
     */
    @SerialName("monthly_ap")
    val monthlyAp: Int = 0,

    /**
     * The personal WvW rank.
     *
     * Scopes: progression
     */
    @SerialName("wvw_rank")
    val wvwRank: Int = 0,

    /**
     * The date and time of when the account information last changed.
     *
     * @since 2019-02-21T00:00:00Z or later
     */
    @SerialName("last_modified")
    val lastModifiedAt: LocalDateTime = LocalDateTime.minValue(),

    /**
     * The number of build storage slots.
     *
     * @since 2019-12-19T00:00:00Z or later
     * @see <a href="https://wiki.guildwars2.com/wiki/Template#Build_Storage">the wiki</a>
     */
    @SerialName("build_storage_slots")
    val buildStorageSlots: Int = 0
)