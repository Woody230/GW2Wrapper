package com.bselzer.gw2.v2.model.wvw.objective

import com.bselzer.gw2.v2.model.continent.map.sector.SectorId
import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.map.MapId
import com.bselzer.gw2.v2.model.wvw.upgrade.WvwUpgradeId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwObjective(
    /**
     * The map identifier and objective identifier split by a dash (-).
     */
    @SerialName("id")
    override val id: WvwMapObjectiveId = WvwMapObjectiveId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("type")
    val type: com.bselzer.gw2.v2.model.wrapper.WvwObjectiveType = com.bselzer.gw2.v2.model.wrapper.WvwObjectiveType(),

    @SerialName("sector_id")
    val mapSectorId: SectorId = SectorId(),

    @SerialName("map_id")
    val mapId: MapId = MapId(),

    @SerialName("map_type")
    val mapType: com.bselzer.gw2.v2.model.wrapper.WvwMapType = com.bselzer.gw2.v2.model.wrapper.WvwMapType(),

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
    val upgradeId: WvwUpgradeId = WvwUpgradeId()
) : Identifiable<String>