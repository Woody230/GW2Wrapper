package com.bselzer.gw2.v2.model.account.equipment

import com.bselzer.gw2.v2.model.extension.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EquipmentTemplateTab(
    /**
     * The id and index of the tab.
     */
    @SerialName("tab")
    override val id: Int = 0,

    /**
     * The name of the tab given by the player.
     */
    @SerialName("name")
    val name: String = "",

    /**
     * Whether this tab is the currently selected tab.
     */
    @SerialName("is_active")
    val isActive: Boolean = false,

    /**
     * The pieces of equipment.
     */
    @SerialName("equipment")
    val equipment: List<EquipmentTemplateItem> = emptyList(),

    /**
     * The pieces of equipment for player vs. player.
     */
    @SerialName("equipment_pvp")
    val pvpEquipment: EquipmentTemplatePvp = EquipmentTemplatePvp()
) : Identifiable<Int>