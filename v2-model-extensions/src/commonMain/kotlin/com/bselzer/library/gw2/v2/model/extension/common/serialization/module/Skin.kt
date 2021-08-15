package com.bselzer.library.gw2.v2.model.extension.common.serialization.module

import com.bselzer.library.gw2.v2.model.common.skin.*
import com.bselzer.library.gw2.v2.model.common.skin.Skin
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer

object Skin
{
    val SKIN = SerializersModule {
        polymorphic(Skin::class) {
            subclass(ArmorSkin::class, serializer())
            subclass(BackSkin::class, serializer())
            subclass(GatheringToolSkin::class, serializer())
            subclass(WeaponSkin::class, serializer())
            default { serializer() }
        }
    }
}