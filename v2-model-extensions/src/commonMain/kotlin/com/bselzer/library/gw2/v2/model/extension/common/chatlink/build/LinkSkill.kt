package com.bselzer.library.gw2.v2.model.extension.common.chatlink.build

import com.bselzer.library.kotlin.extension.function.common.collection.removeFirst
import com.bselzer.library.kotlin.extension.function.common.collection.toByteArray
import com.bselzer.library.kotlin.extension.function.common.collection.toShort
import kotlinx.serialization.Serializable

@Serializable
data class LinkSkill(
    /**
     * The palette id of the land skill.
     *
     * A skill id to palette id mapping exists on the profession.
     */
    var terrestrialId: Short = 0,

    /**
     * The palette id of the water skill.
     *
     * A skill id to palette id mapping exists on the profession.
     */
    var aquaticId: Short = 0
) : LinkComponent()
{
    override val size: Int = 4

    override fun getData(): ByteArray = terrestrialId.toByteArray() + aquaticId.toByteArray()

    override fun decode(bytes: ArrayDeque<Byte>)
    {
        // Ensure bytes size.
        super.decode(bytes)

        terrestrialId = bytes.removeFirst(take = 2).toShort()
        aquaticId = bytes.removeFirst(take = 2).toShort()
    }
}