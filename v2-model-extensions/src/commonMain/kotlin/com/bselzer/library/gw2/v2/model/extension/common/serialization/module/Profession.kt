package com.bselzer.library.gw2.v2.model.extension.common.serialization.module

import com.bselzer.library.gw2.v2.model.common.profession.track.SkillTrack
import com.bselzer.library.gw2.v2.model.common.profession.track.TrainingTrack
import com.bselzer.library.gw2.v2.model.common.profession.track.TraitTrack
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer

@OptIn(InternalSerializationApi::class)
object Profession
{
    val TRACK = SerializersModule {
        polymorphic(TrainingTrack::class) {
            subclass(SkillTrack::class, SkillTrack::class.serializer())
            subclass(TraitTrack::class, TraitTrack::class.serializer())
        }
    }
}