package com.bselzer.library.gw2.v2.model.extension.common.serialization.module

import com.bselzer.library.gw2.v2.model.common.achievement.bit.*
import com.bselzer.library.gw2.v2.model.common.achievement.reward.*
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer

@OptIn(InternalSerializationApi::class)
object Achievement
{
    val REWARD = SerializersModule {
        polymorphic(AchievementReward::class) {
            subclass(CoinReward::class, CoinReward::class.serializer())
            subclass(ItemReward::class, ItemReward::class.serializer())
            subclass(MasteryReward::class, MasteryReward::class.serializer())
            subclass(TitleReward::class, TitleReward::class.serializer())
        }
    }

    val BIT = SerializersModule {
        polymorphic(AchievementBit::class) {
            subclass(ItemBit::class, ItemBit::class.serializer())
            subclass(MiniBit::class, MiniBit::class.serializer())
            subclass(SkinBit::class, SkinBit::class.serializer())
            subclass(TextBit::class, TextBit::class.serializer())
        }
    }
}