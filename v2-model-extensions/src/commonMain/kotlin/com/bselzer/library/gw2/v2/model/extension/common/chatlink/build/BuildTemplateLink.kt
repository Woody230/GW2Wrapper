package com.bselzer.library.gw2.v2.model.extension.common.chatlink.build

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.ChatLink
import com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.profession.LinkProfessionData
import com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.profession.LinkRangerData
import com.bselzer.library.gw2.v2.model.extension.common.chatlink.build.profession.LinkRevenantData

class BuildTemplateLink(
    /**
     * The id of the profession code.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/professions">the wiki</a>
     */
    var profession: Byte = 0,

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

    ) : ChatLink()
{
    override val header: Byte = 13

    /**
     * The number of bytes required in the data.
     */
    private val size: Int = 43

    override fun getData(): ByteArray
    {
        val specs = specialization1.getData() + specialization2.getData() + specialization3.getData()
        val skills = healSkill.getData() + utilitySkill1.getData() + utilitySkill2.getData() + utilitySkill3.getData() + eliteSkill.getData()
        return byteArrayOf(profession) + specs + skills + professionData.getData()
    }

    override fun decode(bytes: ByteArray)
    {
        if (bytes.size != size)
        {
            throw IllegalArgumentException("Unable to decode build template link: exactly $size data bytes are required")
        }

        profession = bytes[0]

        // TODO arraydeque
        var start = 1
        var end = start + specialization1.size
        specialization1.decode(bytes.copyOfRange(start, end))

        start = end
        end += specialization2.size
        specialization2.decode(bytes.copyOfRange(start, end))

        start = end
        end += specialization3.size
        specialization3.decode(bytes.copyOfRange(start, end))

        start = end
        end += healSkill.size
        healSkill.decode(bytes.copyOfRange(start, end))

        start = end
        end += utilitySkill1.size
        utilitySkill1.decode(bytes.copyOfRange(start, end))

        start = end
        end += utilitySkill2.size
        utilitySkill2.decode(bytes.copyOfRange(start, end))

        start = end
        end += utilitySkill3.size
        utilitySkill3.decode(bytes.copyOfRange(start, end))

        start = end
        end += eliteSkill.size
        eliteSkill.decode(bytes.copyOfRange(start, end))

        professionData = when (profession)
        {
            LinkRangerData.CODE -> LinkRangerData()
            LinkRevenantData.CODE -> LinkRevenantData()
            else -> LinkProfessionData()
        }

        start = end
        end += professionData.size
        professionData.decode(bytes.copyOfRange(start, end))
    }
}