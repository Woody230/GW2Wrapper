package com.bselzer.library.gw2.v2.model.extension.common.serialization.module

import com.bselzer.library.gw2.v2.model.common.achievement.bit.*
import com.bselzer.library.gw2.v2.model.common.achievement.reward.*
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer

object Achievement
{
    val REWARD = SerializersModule {
        polymorphic(AchievementReward::class) {
            subclass(CoinReward::class, serializer())
            subclass(ItemReward::class, serializer())
            subclass(MasteryReward::class, serializer())
            subclass(TitleReward::class, serializer())
            default { serializer() }
        }
    }

    val BIT = SerializersModule {
        polymorphic(AchievementBit::class) {
            subclass(ItemBit::class, serializer())
            subclass(MiniBit::class, serializer())
            subclass(SkinBit::class, serializer())
            subclass(TextBit::class, serializer())
            default { serializer() }
        }
    }
}