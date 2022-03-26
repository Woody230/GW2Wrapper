package com.bselzer.gw2.v2.model.wvw.objective

import com.bselzer.gw2.v2.model.continent.map.sector.SectorId
import com.bselzer.gw2.v2.model.enumeration.wrapper.WvwMapType
import com.bselzer.gw2.v2.model.enumeration.wrapper.WvwObjectiveType
import com.bselzer.gw2.v2.model.map.MapId
import com.bselzer.gw2.v2.model.wrapper.ChatLink
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.gw2.v2.model.wvw.upgrade.WvwUpgradeId
import com.bselzer.ktx.geometry.dimension.bi.position.Point2D
import com.bselzer.ktx.geometry.dimension.tri.position.Point3D
import com.bselzer.ktx.value.identifier.Identifiable
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
    val type: WvwObjectiveType = WvwObjectiveType(),

    @SerialName("sector_id")
    val mapSectorId: SectorId = SectorId(),

    @SerialName("map_id")
    val mapId: MapId = MapId(),

    @SerialName("map_type")
    val mapType: WvwMapType = WvwMapType(),

    /**
     * The three-dimensional position of the objective within the texture.
     */
    @SerialName("coord")
    val coordinates: Point3D = Point3D(),

    /**
     * The two-dimensional position of the label within the texture.
     */
    @SerialName("label_coord")
    val labelCoordinates: Point2D = Point2D(),

    @SerialName("marker")
    val iconLink: ImageLink = ImageLink(),

    @SerialName("chatLink")
    val chatLink: ChatLink = ChatLink(),

    /**
     * The id of the upgrade.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/wvw/upgrades">the wiki</a>
     */
    @SerialName("upgrade_id")
    val upgradeId: WvwUpgradeId = WvwUpgradeId()
) : Identifiable<String>