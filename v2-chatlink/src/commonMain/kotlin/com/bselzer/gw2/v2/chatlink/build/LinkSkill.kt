package com.bselzer.gw2.v2.chatlink.build

import com.bselzer.gw2.v2.model.skill.SkillCode
import com.bselzer.ktx.function.collection.removeFirst
import com.bselzer.ktx.function.collection.toByteArray
import com.bselzer.ktx.function.collection.toShort
import kotlinx.serialization.Serializable

@Serializable
data class LinkSkill(
    /**
     * The palette id of the land skill.
     *
     * A skill id to palette id mapping exists on the profession.
     */
    var terrestrialId: SkillCode = SkillCode(),

    /**
     * The palette id of the water skill.
     *
     * A skill id to palette id mapping exists on the profession.
     */
    var aquaticId: SkillCode = SkillCode()
) : LinkComponent() {
    override val size: Int = 4

    override fun getData(): ByteArray = terrestrialId.value.toByteArray() + aquaticId.value.toByteArray()

    override fun decode(bytes: ArrayDeque<Byte>) {
        // Ensure bytes size.
        super.decode(bytes)

        terrestrialId = SkillCode(bytes.removeFirst(take = 2).toShort())
        aquaticId = SkillCode(bytes.removeFirst(take = 2).toShort())
    }
}