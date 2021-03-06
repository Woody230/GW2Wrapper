package com.bselzer.gw2.v2.model.template.build

import com.bselzer.gw2.v2.model.legend.LegendId
import com.bselzer.gw2.v2.model.profession.ProfessionId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuildTemplate(
    /**
     * The name of the template given by the player.
     */
    @SerialName("name")
    val name: String = "",

    /**
     * The profession the build template is for.
     */
    @SerialName("profession")
    val profession: ProfessionId = ProfessionId(),

    /**
     * The selected specializations and traits.
     */
    @SerialName("specializations")
    val specializations: List<BuildSpecialization> = emptyList(),

    /**
     * The selected skills on land.
     */
    @SerialName("skills")
    val terrestrialSkills: List<BuildSkill> = emptyList(),

    /**
     * The selected skills underwater.
     */
    @SerialName("aquatic_skills")
    val aquaticSkills: List<BuildSkill> = emptyList(),

    /**
     * The selected pets. For Rangers only.
     */
    @SerialName("pets")
    val pets: BuildPets = BuildPets(),

    /**
     * The selected legends on land. For Revenants only. A null indicates no selection.
     */
    @SerialName("legends")
    val terrestrialLegends: List<LegendId?> = emptyList(),

    /**
     * The selected legends underwater. For Revenants only. A null indicates no selection.
     */
    @SerialName("aquatic_legends")
    val aquaticLegends: List<LegendId?> = emptyList()
)