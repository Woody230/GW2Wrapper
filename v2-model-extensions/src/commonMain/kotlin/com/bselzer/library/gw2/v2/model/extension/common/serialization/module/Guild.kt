package com.bselzer.library.gw2.v2.model.extension.common.serialization.module

import com.bselzer.library.gw2.v2.model.common.guild.log.*
import com.bselzer.library.gw2.v2.model.common.guild.upgrade.*
import com.bselzer.library.gw2.v2.model.common.guild.upgrade.cost.*
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer

object Guild
{
    val LOG = SerializersModule {
        polymorphic(GuildLog::class) {
            subclass(InfluenceLog::class, serializer())
            subclass(InviteDeclinedLog::class, serializer())
            subclass(InvitedLog::class, serializer())
            subclass(JoinedLog::class, serializer())
            subclass(KickLog::class, serializer())
            subclass(MessageOfTheDayLog::class, serializer())
            subclass(RankChangeLog::class, serializer())
            subclass(StashLog::class, serializer())
            subclass(TreasuryLog::class, serializer())
            subclass(UpgradeLog::class, serializer())
            default { serializer() }
        }
    }

    val UPGRADE = SerializersModule {
        polymorphic(GuildUpgrade::class) {
            subclass(AccumulatingCurrencyUpgrade::class, serializer())
            subclass(BankTabUpgrade::class, serializer())
            subclass(BoostUpgrade::class, serializer())
            subclass(ClaimableUpgrade::class, serializer())
            subclass(DecorationUpgrade::class, serializer())
            subclass(GuildHallExpeditionUpgrade::class, serializer())
            subclass(GuildHallUpgrade::class, serializer())
            subclass(HubUpgrade::class, serializer())
            subclass(QueueUpgrade::class, serializer())
            subclass(UnlockUpgrade::class, serializer())
            default { serializer() }
        }
    }

    val UPGRADE_COST = SerializersModule {
        polymorphic(GuildUpgradeCost::class) {
            subclass(CoinUpgradeCost::class, serializer())
            subclass(CollectibleUpgradeCost::class, serializer())
            subclass(CurrencyUpgradeCost::class, serializer())
            subclass(GuildUpgradeCost::class, serializer())
            subclass(ItemUpgradeCost::class, serializer())
            default { serializer() }
        }
    }
}