package com.bselzer.gw2.v2.model.specialization

import com.bselzer.gw2.v2.model.enumeration.wrapper.SpecializationName
import com.bselzer.gw2.v2.model.profession.ProfessionId
import com.bselzer.gw2.v2.model.trait.TraitId
import com.bselzer.gw2.v2.model.wrapper.ImageLink
import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Specialization(
    @SerialName("id")
    override val id: SpecializationId = SpecializationId(),

    @SerialName("name")
    val name: SpecializationName = SpecializationName(),

    /**
     * The name of the profession this specialization belongs to.
     */
    @SerialName("profession")
    val profession: ProfessionId = ProfessionId(),

    /**
     * Whether this specialization is an elite specialization.
     */
    @SerialName("elite")
    val isElite: Boolean = false,

    @SerialName("icon")
    val iconLink: ImageLink = ImageLink(),

    @SerialName("background")
    val backgroundLink: ImageLink = ImageLink(),

    /**
     * The ids of the minor traits.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("minor_traits")
    val minorTraitIds: List<TraitId> = emptyList(),

    /**
     * The ids of the major traits.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("major_traits")
    val majorTraitIds: List<TraitId> = emptyList(),

    /**
     * The id of the trait enabling the weapon associated with an elite specialization.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    @SerialName("weapon_trait")
    val weaponTraitId: TraitId = TraitId(),

    /**
     * The link to an icon for the elite specialization.
     */
    @SerialName("profession_icon")
    val eliteIconLink: ImageLink = ImageLink(),

    /**
     * The link to an icon for the elite specialization.
     */
    @SerialName("profession_icon_big")
    val eliteIconLinkBig: ImageLink = ImageLink()
) : Identifiable<SpecializationId, Byte>