package com.bselzer.library.gw2.v2.model.extension.common.serialization.module

import com.bselzer.library.gw2.v2.model.common.pvp.standing.BestStanding
import com.bselzer.library.gw2.v2.model.common.pvp.standing.CurrentStanding
import com.bselzer.library.gw2.v2.model.common.pvp.standing.PvpStanding
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer

@OptIn(InternalSerializationApi::class)
object PlayerVsPlayer
{
    val STANDING = SerializersModule {
        polymorphic(PvpStanding::class) {
            subclass(BestStanding::class, BestStanding::class.serializer())
            subclass(CurrentStanding::class, CurrentStanding::class.serializer())
        }
    }
}