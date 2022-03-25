package com.bselzer.gw2.v2.chatlink.build.specialization

import com.bselzer.gw2.v2.chatlink.build.LinkComponent
import com.bselzer.gw2.v2.model.specialization.SpecializationId
import com.bselzer.ktx.function.collection.fill
import com.bselzer.ktx.function.objects.toBits
import com.bselzer.ktx.function.objects.toByte
import kotlinx.serialization.Serializable

@Serializable
data class LinkSpecialization(
    /**
     * The id of the specialization.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    var specializationId: SpecializationId = SpecializationId(),

    /**
     * The major trait choice 1.
     *
     * 0 for no selection, 1 for top, 2 for middle, 3 for bottom
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    var trait1: TraitChoice = TraitChoice(),

    /**
     * The major trait choice 2.
     *
     * 0 for no selection, 1 for top, 2 for middle, 3 for bottom
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    var trait2: TraitChoice = TraitChoice(),

    /**
     * The major trait choice 3.
     *
     * 0 for no selection, 1 for top, 2 for middle, 3 for bottom
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    var trait3: TraitChoice = TraitChoice(),
) : LinkComponent() {
    override val size: Int = 2

    override fun getData(): ByteArray {
        // First 2 bits are unused since there are only 3 major trait selections.
        val flags = listOf(false, false) + trait3.value.toBits().takeLast(2) + trait2.value.toBits().takeLast(2) + trait1.value.toBits().takeLast(2)
        return byteArrayOf(specializationId.value, flags.toByte())
    }

    override fun decode(bytes: ArrayDeque<Byte>) {
        // Ensure bytes size.
        super.decode(bytes)

        specializationId = SpecializationId(bytes.removeFirst())

        val flags = bytes.removeFirst().toBits()
        trait3 = flags.decodeTrait(2, 4)
        trait2 = flags.decodeTrait(4, 6)
        trait1 = flags.decodeTrait(6, 8)
    }

    /**
     * Converts the bit flags into a full byte.
     * @return the decoded trait
     */
    private fun List<Boolean>.decodeTrait(fromIndex: Int, toIndex: Int): TraitChoice {
        val flags = listOf<Boolean>().fill(6) { false } + subList(fromIndex, toIndex)
        return TraitChoice(flags.toByte())
    }
}