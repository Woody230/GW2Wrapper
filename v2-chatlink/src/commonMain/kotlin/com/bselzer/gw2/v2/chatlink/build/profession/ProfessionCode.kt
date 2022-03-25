package com.bselzer.gw2.v2.chatlink.build.profession

import com.bselzer.gw2.v2.model.enumeration.ProfessionName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
value class ProfessionCode(val value: Byte = 0) {
    val name: ProfessionName?
        get() = when (value) {
            1.toByte() -> ProfessionName.GUARDIAN
            2.toByte() -> ProfessionName.WARRIOR
            3.toByte() -> ProfessionName.ENGINEER
            4.toByte() -> ProfessionName.RANGER
            5.toByte() -> ProfessionName.THIEF
            6.toByte() -> ProfessionName.ELEMENTALIST
            7.toByte() -> ProfessionName.MESMER
            8.toByte() -> ProfessionName.NECROMANCER
            9.toByte() -> ProfessionName.REVENANT
            else -> null
        }

    override fun toString(): String = value.toString()
}