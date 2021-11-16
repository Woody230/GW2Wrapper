package com.bselzer.library.gw2.v2.model.serialization

import com.bselzer.library.gw2.v2.model.account.token.ApiKeyInfo
import com.bselzer.library.gw2.v2.model.account.token.SubTokenInfo
import com.bselzer.library.gw2.v2.model.account.token.TokenInfo
import com.bselzer.library.gw2.v2.model.achievement.bit.*
import com.bselzer.library.gw2.v2.model.achievement.reward.*
import com.bselzer.library.gw2.v2.model.guild.log.*
import com.bselzer.library.gw2.v2.model.guild.upgrade.*
import com.bselzer.library.gw2.v2.model.guild.upgrade.cost.*
import com.bselzer.library.gw2.v2.model.item.*
import com.bselzer.library.gw2.v2.model.profession.track.SkillTrack
import com.bselzer.library.gw2.v2.model.profession.track.TrainingTrack
import com.bselzer.library.gw2.v2.model.profession.track.TraitTrack
import com.bselzer.library.gw2.v2.model.pvp.standing.BestStanding
import com.bselzer.library.gw2.v2.model.pvp.standing.CurrentStanding
import com.bselzer.library.gw2.v2.model.pvp.standing.PvpStanding
import com.bselzer.library.gw2.v2.model.skill.fact.*
import com.bselzer.library.gw2.v2.model.skin.*
import com.bselzer.library.gw2.v2.model.trait.fact.*
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.plus
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.serializer

object Modules
{
    /**
     * The [TokenInfo] serializers module.
     */
    val TOKEN_INFO = SerializersModule {
        polymorphic(TokenInfo::class) {
            subclass(ApiKeyInfo::class, serializer())
            subclass(SubTokenInfo::class, serializer())
        }
    }

    /**
     * The [AchievementReward] serializers module.
     */
    val ACHIEVEMENT_REWARD = SerializersModule {
        polymorphic(AchievementReward::class) {
            subclass(CoinReward::class, serializer())
            subclass(ItemReward::class, serializer())
            subclass(MasteryReward::class, serializer())
            subclass(TitleReward::class, serializer())
        }
    }

    /**
     * The [AchievementBit] serializers module.
     */
    val ACHIEVEMENT_BIT = SerializersModule {
        polymorphic(AchievementBit::class) {
            subclass(ItemBit::class, serializer())
            subclass(MiniBit::class, serializer())
            subclass(SkinBit::class, serializer())
            subclass(TextBit::class, serializer())
        }
    }

    /**
     * The [GuildLog] serializers module.
     */
    val GUILD_LOG = SerializersModule {
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

    /**
     * The [GuildUpgrade] serializers module.
     */
    val GUILD_UPGRADE = SerializersModule {
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
        }
    }

    /**
     * The [GuildUpgradeCost] serializers module.
     */
    val GUILD_UPGRADE_COST = SerializersModule {
        polymorphic(GuildUpgradeCost::class) {
            subclass(CoinUpgradeCost::class, serializer())
            subclass(CollectibleUpgradeCost::class, serializer())
            subclass(CurrencyUpgradeCost::class, serializer())
            subclass(ItemUpgradeCost::class, serializer())
        }
    }

    /**
     * The [Item] serializers module.
     */
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
        }
    }

    /**
     * The [PvpStanding] serializers module.
     */
    val PVP_STANDING = SerializersModule {
        polymorphic(PvpStanding::class) {
            subclass(BestStanding::class, serializer())
            subclass(CurrentStanding::class, serializer())
        }
    }

    /**
     * The [TrainingTrack] serializers module.
     */
    val TRAINING_TRACK = SerializersModule {
        polymorphic(TrainingTrack::class) {
            subclass(SkillTrack::class, serializer())
            subclass(TraitTrack::class, serializer())
        }
    }

    /**
     * The [SkillFact] serializers module.
     */
    val SKILL_FACT = SerializersModule {
        polymorphic(SkillFact::class) {
            subclass(SkillAttributeAdjustFact::class, serializer())
            subclass(SkillBuffFact::class, serializer())
            subclass(SkillComboFieldFact::class, serializer())
            subclass(SkillComboFinisherFact::class, serializer())
            subclass(SkillDamageFact::class, serializer())
            subclass(SkillDistanceFact::class, serializer())
            subclass(SkillDurationFact::class, serializer())
            subclass(SkillHealFact::class, serializer())
            subclass(SkillHealingAdjustFact::class, serializer())
            subclass(SkillNoDataFact::class, serializer())
            subclass(SkillNumberFact::class, serializer())
            subclass(SkillPercentFact::class, serializer())
            subclass(SkillPrefixedBuffFact::class, serializer())
            subclass(SkillRadiusFact::class, serializer())
            subclass(SkillRangeFact::class, serializer())
            subclass(SkillRechargeFact::class, serializer())
            subclass(SkillTimeFact::class, serializer())
            subclass(SkillUnblockableFact::class, serializer())
        }
    }

    /**
     * The [Skin] serializers module.
     */
    val SKIN = SerializersModule {
        polymorphic(Skin::class) {
            subclass(ArmorSkin::class, serializer())
            subclass(BackSkin::class, serializer())
            subclass(GatheringToolSkin::class, serializer())
            subclass(WeaponSkin::class, serializer())
        }
    }

    /**
     * The [TraitFact] serializers module.
     */
    val TRAIT_FACT = SerializersModule {
        polymorphic(TraitFact::class) {
            subclass(TraitAttributeAdjustFact::class, serializer())
            subclass(TraitBuffFact::class, serializer())
            subclass(TraitBuffConversionFact::class, serializer())
            subclass(TraitComboFieldFact::class, serializer())
            subclass(TraitComboFinisherFact::class, serializer())
            subclass(TraitDamageFact::class, serializer())
            subclass(TraitDistanceFact::class, serializer())
            subclass(TraitNoDataFact::class, serializer())
            subclass(TraitNumberFact::class, serializer())
            subclass(TraitPercentFact::class, serializer())
            subclass(TraitPrefixedBuffFact::class, serializer())
            subclass(TraitRadiusFact::class, serializer())
            subclass(TraitRangeFact::class, serializer())
            subclass(TraitRechargeFact::class, serializer())
            subclass(TraitTimeFact::class, serializer())
            subclass(TraitUnblockableFact::class, serializer())
        }
    }

    /**
     * All of the serializer modules.
     */
    val ALL: SerializersModule =
        TOKEN_INFO + ACHIEVEMENT_REWARD + ACHIEVEMENT_BIT + GUILD_LOG + GUILD_UPGRADE + GUILD_UPGRADE_COST + ITEM + PVP_STANDING + TRAINING_TRACK + SKILL_FACT + SKIN + TRAIT_FACT
}