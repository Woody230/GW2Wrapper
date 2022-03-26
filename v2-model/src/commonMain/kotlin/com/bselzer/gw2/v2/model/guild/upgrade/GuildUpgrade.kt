package com.bselzer.gw2.v2.model.guild.upgrade

import com.bselzer.gw2.v2.model.guild.GuildLevel
import com.bselzer.gw2.v2.model.guild.upgrade.cost.GuildUpgradeCost
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.datetime.serialization.SecondDurationSerializer
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
abstract class GuildUpgrade(
    @SerialName("id")
    override val id: GuildUpgradeId = GuildUpgradeId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = "",

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    /**
     * The build time in seconds.
     */
    @Serializable(with = SecondDurationSerializer::class)
    @SerialName("build_time")
    val buildTime: Duration = Duration.ZERO,

    /**
     * The guild level required to build the upgrade.
     */
    @SerialName("required_level")
    val requiredLevel: GuildLevel = GuildLevel(),

    /**
     * The amount of guild experience that will be awarded upon building the upgrade.
     */
    @SerialName("experience")
    val experience: Int = 0,

    /**
     * The ids of the upgrades that must be completed before this upgrade.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/guild/upgrades">the wiki</a>
     */
    @SerialName("prerequisites")
    val prerequisites: List<GuildUpgradeId> = emptyList(),

    @SerialName("costs")
    val costs: List<GuildUpgradeCost> = emptyList()
) : Identifiable<Int> {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as GuildUpgrade

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (iconLink != other.iconLink) return false
        if (buildTime != other.buildTime) return false
        if (requiredLevel != other.requiredLevel) return false
        if (experience != other.experience) return false
        if (prerequisites != other.prerequisites) return false
        if (costs != other.costs) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + iconLink.hashCode()
        result = 31 * result + buildTime.hashCode()
        result = 31 * result + requiredLevel.hashCode()
        result = 31 * result + experience.hashCode()
        result = 31 * result + prerequisites.hashCode()
        result = 31 * result + costs.hashCode()
        return result
    }
}