package com.bselzer.library.gw2.v2.model.common.specialization

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Specialization(
    @SerialName("id")
    val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    /**
     * The name of the profession this specialization belongs to.
     */
    @SerialName("profession")
    val profession: String = "",

    /**
     * Whether this specialization is an elite specialization.
     */
    @SerialName("elite")
    val isElite: Boolean = false,

    @SerialName("icon")
    val iconLink: String = "",

    @SerialName("background")
    val backgroundLink: String = "",

    /**
     * The ids of the minor traits.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("minor_traits")
    val minorTraitIds: List<Int> = emptyList(),

    /**
     * The ids of the major traits.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("major_traits")
    val majorTraitIds: List<Int> = emptyList(),

    /**
     * The id of the trait enabling the weapon associated with an elite specialization.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("weapon_trait")
    val weaponTraitId: Int = 0,

    /**
     * The link to an icon for the elite specialization.
     */
    @SerialName("profession_icon")
    val eliteIconLink: String = "",

    /**
     * The link to an icon for the elite specialization.
     */
    @SerialName("profession_icon_big")
    val eliteIconLinkBig: String = ""
)