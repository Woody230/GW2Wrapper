package com.bselzer.gw2.v2.model.enumeration.achievement

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AchievementFlag {
    /**
     * An achievement for the PvP or WvW game modes.
     */
    @SerialName("Pvp")
    PVP,

    /**
     * A meta achievement.
     */
    @SerialName("CategoryDisplay")
    CATEGORY_DISPLAY,

    /**
     * An achievement that affects in-game UI collation.
     */
    @SerialName("MoveToTop")
    MOVE_TO_TOP,

    /**
     * An achievement that does not appear in the nearly complete UI.
     */
    @SerialName("IgnoreNearlyComplete")
    IGNORE_NEARLY_COMPLETE,

    /**
     * An achievement that can be done multiple times.
     */
    @SerialName("Repeatable")
    REPEATABLE,

    /**
     * An achievement that cannot be tracked before it is unlocked.
     *
     * @see <a href="https://wiki.guildwars2.com/wiki/List_of_hidden_achievements">the wiki<a/>
     */
    @SerialName("Hidden")
    HIDDEN,

    /**
     * An achievement that can be tracked before it is unlocked.
     */
    @SerialName("RequiresUnlock")
    REQUIRES_UNLOCK,

    @SerialName("RepairOnLogin")
    REPAIR_ON_LOGIN,

    /**
     * An achievement that resets daily.
     */
    @SerialName("Daily")
    DAILY,

    /**
     * An achievement that resets weekly.
     */
    @SerialName("Weekly")
    WEEKLY,

    /**
     * An achievement that resets monthly.
     */
    @SerialName("Monthly")
    MONTHLY,

    /**
     * An achievement that does not reset.
     */
    @SerialName("Permanent")
    PERMANENT,
}