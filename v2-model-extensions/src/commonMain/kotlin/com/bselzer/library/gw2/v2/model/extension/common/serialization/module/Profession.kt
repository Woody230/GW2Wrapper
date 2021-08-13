package com.bselzer.library.gw2.v2.model.extension.common.serialization.module

import com.bselzer.library.gw2.v2.model.common.profession.skill.ElementalistSkill
import com.bselzer.library.gw2.v2.model.common.profession.skill.ProfessionSkill
import com.bselzer.library.gw2.v2.model.common.profession.skill.ThiefSkill
import com.bselzer.library.gw2.v2.model.common.profession.track.SkillTrack
import com.bselzer.library.gw2.v2.model.common.profession.track.TrainingTrack
import com.bselzer.library.gw2.v2.model.common.profession.track.TraitTrack
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer

object Profession
{
    val TRACK = SerializersModule {
        polymorphic(TrainingTrack::class) {
            subclass(SkillTrack::class, serializer())
            subclass(TraitTrack::class, serializer())
            default { serializer() }
        }
    }

    val SKILL = SerializersModule {
        polymorphic(ProfessionSkill::class) {
            subclass(ElementalistSkill::class, serializer())
            subclass(ThiefSkill::class, serializer())
            default { serializer() }
        }
    }
}