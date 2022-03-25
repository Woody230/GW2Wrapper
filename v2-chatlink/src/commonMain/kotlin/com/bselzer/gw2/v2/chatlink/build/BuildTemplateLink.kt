package com.bselzer.gw2.v2.chatlink.build

import com.bselzer.gw2.v2.chatlink.ChatLink
import com.bselzer.gw2.v2.chatlink.build.profession.LinkProfessionData
import com.bselzer.gw2.v2.chatlink.build.profession.LinkRangerData
import com.bselzer.gw2.v2.chatlink.build.profession.LinkRevenantData
import com.bselzer.gw2.v2.chatlink.build.profession.ProfessionCode
import com.bselzer.gw2.v2.model.enumeration.ProfessionName

/**
 * @see <a href="https://wiki.guildwars2.com/wiki/Chat_link_format#Build_template_link">the wiki</a>
 */
class BuildTemplateLink(
    /**
     * The id of the profession code.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    var profession: ProfessionCode = ProfessionCode(),

    /**
     * The additional data about the profession.
     */
    var professionData: LinkProfessionData = LinkProfessionData(),

    /**
     * The specialization and traits ids.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki for specializations</a>
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    var specialization1: LinkSpecialization = LinkSpecialization(),

    /**
     * The specialization and traits ids.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki for specializations</a>
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    var specialization2: LinkSpecialization = LinkSpecialization(),

    /**
     * The specialization and traits ids.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki for specializations</a>
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    var specialization3: LinkSpecialization = LinkSpecialization(),

    /**
     * The heal skill ids.
     */
    var healSkill: LinkSkill = LinkSkill(),

    /**
     * The utility skill 1 ids.
     */
    var utilitySkill1: LinkSkill = LinkSkill(),

    /**
     * The utility skill 2 ids.
     */
    var utilitySkill2: LinkSkill = LinkSkill(),

    /**
     * The utility skill 3 ids.
     */
    var utilitySkill3: LinkSkill = LinkSkill(),

    /**
     * The elite skill ids.
     */
    var eliteSkill: LinkSkill = LinkSkill(),
) : ChatLink() {
    override val header: Byte = 13

    /**
     * The number of bytes required in the data.
     */
    private val size: Int = 43

    override fun getData(): ByteArray {
        val specs = specialization1.getData() + specialization2.getData() + specialization3.getData()
        val skills = healSkill.getData() + utilitySkill1.getData() + utilitySkill2.getData() + utilitySkill3.getData() + eliteSkill.getData()
        return byteArrayOf(profession.value) + specs + skills + professionData.getData()
    }

    override fun decode(bytes: ArrayDeque<Byte>) {
        if (bytes.size != size) {
            throw IllegalArgumentException("Unable to decode build template link: exactly $size data bytes are required")
        }

        profession = ProfessionCode(bytes.removeFirst())
        specialization1.decode(bytes)
        specialization2.decode(bytes)
        specialization3.decode(bytes)
        healSkill.decode(bytes)
        utilitySkill1.decode(bytes)
        utilitySkill2.decode(bytes)
        utilitySkill3.decode(bytes)
        eliteSkill.decode(bytes)

        professionData = when (profession.name) {
            ProfessionName.RANGER -> LinkRangerData()
            ProfessionName.REVENANT -> LinkRevenantData()
            else -> LinkProfessionData()
        }
        professionData.decode(bytes)
    }
}