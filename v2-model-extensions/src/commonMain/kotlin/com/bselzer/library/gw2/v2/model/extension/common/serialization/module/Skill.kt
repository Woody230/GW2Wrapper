package com.bselzer.library.gw2.v2.model.extension.common.serialization.module

import com.bselzer.library.gw2.v2.model.common.skill.fact.*
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer

@OptIn(InternalSerializationApi::class)
object Skill
{
    val FACT = SerializersModule {
        polymorphic(SkillFact::class) {
            subclass(AttributeAdjustFact::class, serializer())
            subclass(BuffFact::class, serializer())
            subclass(ComboFieldFact::class, serializer())
            subclass(ComboFinisherFact::class, serializer())
            subclass(DamageFact::class, serializer())
            subclass(DistanceFact::class, serializer())
            subclass(DurationFact::class, serializer())
            subclass(HealFact::class, serializer())
            subclass(HealingAdjustFact::class, serializer())
            subclass(NoDataFact::class, serializer())
            subclass(NumberFact::class, serializer())
            subclass(PercentFact::class, serializer())
            subclass(PrefixedBuffFact::class, serializer())
            subclass(RadiusFact::class, serializer())
            subclass(RangeFact::class, serializer())
            subclass(RechargeFact::class, serializer())
            subclass(TimeFact::class, serializer())
            subclass(UnblockableFact::class, serializer())
            default { serializer() }
        }
    }
}