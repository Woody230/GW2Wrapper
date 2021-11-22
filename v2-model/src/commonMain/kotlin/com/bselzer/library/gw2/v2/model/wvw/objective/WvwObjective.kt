package com.bselzer.library.gw2.v2.model.wvw.objective

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwObjective(
    /**
     * The map identifier and objective identifier split by a dash (-).
     */
    @SerialName("id")
    override val id: String = "",

    @SerialName("name")
    val name: String = "",

    @SerialName("type")
    val type: String = "",

    @SerialName("sector_id")
    val mapSectorId: Int = 0,

    @SerialName("map_id")
    val mapId: Int = 0,

    @SerialName("map_type")
    val mapType: String = "",

    /**
     * The three-dimensional position of the objective within the texture.
     */
    @SerialName("coord")
    val coordinates: List<Double> = emptyList(),

    /**
     * The two-dimensional position of the label within the texture.
     */
    @SerialName("label_coord")
    val labelCoordinates: List<Double> = emptyList(),

    @SerialName("marker")
    val iconLink: String = "",

    @SerialName("chatLink")
    val chatLink: String = "",

    /**
     * The id of the upgrade.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">the wiki</a>
     */
    @SerialName("upgrade_id")
    val upgradeId: Int = 0
) : Identifiable<String>