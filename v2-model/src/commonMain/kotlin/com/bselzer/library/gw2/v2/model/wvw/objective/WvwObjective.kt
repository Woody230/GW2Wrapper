package com.bselzer.library.gw2.v2.model.wvw.objective

import com.bselzer.library.gw2.v2.model.extension.base.Identifiable
import com.bselzer.library.gw2.v2.model.extension.dimension.Point2D
import com.bselzer.library.gw2.v2.model.extension.dimension.Point3D
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WvwObjective(
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

    @SerialName("coord")
    val coordinates: Point3D = Point3D(),

    @SerialName("label_coord")
    val labelCoordinates: Point2D = Point2D(),

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