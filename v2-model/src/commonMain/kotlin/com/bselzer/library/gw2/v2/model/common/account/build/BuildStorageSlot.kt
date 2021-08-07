package com.bselzer.library.gw2.v2.model.common.account.build

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuildStorageSlot(
    /**
     * The name of the template given by the player.
     */
    @SerialName("name")
    val name: String = "",

    /**
     * The profession the build template is for.
     */
    @SerialName("profession")
    val profession: String = "",

    /**
     * The selected specializations and traits.
     */
    @SerialName("specializations")
    val specializations: List<StorageSpecialization> = emptyList(),

    /**
     * The selected skills on land.
     */
    @SerialName("skills")
    val terrestrialSkills: List<StorageSkill> = emptyList(),

    /**
     * The selected skills underwater.
     */
    @SerialName("aquatic_skills")
    val aquaticSkills: List<StorageSkill> = emptyList(),

    /**
     * The selected legends on land. For Revenants only.
     */
    @SerialName("legends")
    val terrestrialLegends: List<String> = emptyList(),

    /**
     * The selected legends underwater. For Revenants only.
     */
    @SerialName("aquatic_legends")
    val aquaticLegends: List<String> = emptyList()
)