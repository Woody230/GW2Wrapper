package com.bselzer.library.gw2.v2.model.common.skill.fact

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("NoData")
class NoDataFact : SkillFact()
{
    override fun equals(other: Any?): Boolean
    {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        return true
    }

    override fun hashCode(): Int
    {
        return this::class.hashCode()
    }
}