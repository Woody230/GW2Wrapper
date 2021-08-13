package com.bselzer.library.gw2.v2.model.extension.common.serialization.module

import com.bselzer.library.gw2.v2.model.common.guild.log.*
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
        }
    }
}