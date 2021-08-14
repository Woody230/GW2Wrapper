package com.bselzer.library.gw2.v2.model.extension.common.serialization.module

import com.bselzer.library.gw2.v2.model.common.item.*
import com.bselzer.library.gw2.v2.model.common.item.Item
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer

object Item
{
    val ITEM = SerializersModule {
        polymorphic(Item::class) {
            subclass(ArmorItem::class, serializer())
            subclass(BackItem::class, serializer())
            subclass(BagItem::class, serializer())
            subclass(ConsumableItem::class, serializer())
            subclass(ContainerItem::class, serializer())
            subclass(CraftingMaterialItem::class, serializer())
            subclass(GatheringToolItem::class, serializer())
            subclass(GizmoItem::class, serializer())
            subclass(KeyItem::class, serializer())
            subclass(MiniItem::class, serializer())
            subclass(SalvageKitItem::class, serializer())
            subclass(TraitGuideItem::class, serializer())
            subclass(TrophyItem::class, serializer())
            subclass(UpgradeComponentItem::class, serializer())
            subclass(WeaponItem::class, serializer())
            default { serializer() }
        }
    }
}