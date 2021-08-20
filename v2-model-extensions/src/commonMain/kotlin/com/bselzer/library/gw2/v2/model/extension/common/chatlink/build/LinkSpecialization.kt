package com.bselzer.library.gw2.v2.model.extension.common.chatlink.build

import com.bselzer.library.kotlin.extension.function.common.collection.fill
import com.bselzer.library.kotlin.extension.function.common.objects.toBits
import com.bselzer.library.kotlin.extension.function.common.objects.toByte
import kotlinx.serialization.Serializable

@Serializable
data class LinkSpecialization(
    /**
     * The id of the specialization.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/specializations">the wiki</a>
     */
    var specializationId: Byte = 0,

    /**
     * The major trait choice 1.
     *
     * 0 for no selection, 1 for top, 2 for middle, 3 for bottom
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    var trait1: Byte = 0,

    /**
     * The major trait choice 2.
     *
     * 0 for no selection, 1 for top, 2 for middle, 3 for bottom
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    var trait2: Byte = 0,

    /**
     * The major trait choice 3.
     *
     * 0 for no selection, 1 for top, 2 for middle, 3 for bottom
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/traits">the wiki</a>
     */
    var trait3: Byte = 0,
) : LinkComponent()
{
    override val size: Int = 2

    override fun getData(): ByteArray
    {
        // First 2 bits are unused since there are only 3 major trait selections.
        val flags = listOf(false, false) + trait3.toBits().takeLast(2) + trait2.toBits().takeLast(2) + trait1.toBits().takeLast(2)
        return byteArrayOf(specializationId, flags.toByte())
    }

    override fun decode(bytes: ArrayDeque<Byte>)
    {
        // Ensure bytes size.
        super.decode(bytes)

        specializationId = bytes.removeFirst()

        val flags = bytes.removeFirst().toBits()
        trait3 = flags.decodeTrait(2, 4)
        trait2 = flags.decodeTrait(4, 6)
        trait1 = flags.decodeTrait(6, 8)
    }

    /**
     * Converts the
     * @return the decoded trait
     */
    private fun List<Boolean>.decodeTrait(fromIndex: Int, toIndex: Int): Byte
    {
        val flags = listOf<Boolean>().fill(6) { false } + subList(fromIndex, toIndex)
        return flags.toByte()
    }
}