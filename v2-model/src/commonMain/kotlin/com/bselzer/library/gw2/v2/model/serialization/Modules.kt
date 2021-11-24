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
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.plus
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

object Modules
{
    /**
     * The [TokenInfo] serializers module.
     */
    val TOKEN_INFO = SerializersModule {
        polymorphic(TokenInfo::class) {
            subclass(ApiKeyInfo::class)
            subclass(SubTokenInfo::class)
        }
    }

    /**
     * The [AchievementReward] serializers module.
     */
    val ACHIEVEMENT_REWARD = SerializersModule {
        polymorphic(AchievementReward::class) {
            subclass(CoinReward::class)
            subclass(ItemReward::class)
            subclass(MasteryReward::class)
            subclass(TitleReward::class)
        }
    }

    /**
     * The [AchievementBit] serializers module.
     */
    val ACHIEVEMENT_BIT = SerializersModule {
        polymorphic(AchievementBit::class) {
            subclass(ItemBit::class)
            subclass(MiniBit::class)
            subclass(SkinBit::class)
            subclass(TextBit::class)
        }
    }

    /**
     * The [GuildLog] serializers module.
     */
    val GUILD_LOG = SerializersModule {
        polymorphic(GuildLog::class) {
            subclass(InfluenceLog::class)
            subclass(InviteDeclinedLog::class)
            subclass(InvitedLog::class)
            subclass(JoinedLog::class)
            subclass(KickLog::class)
            subclass(MessageOfTheDayLog::class)
            subclass(RankChangeLog::class)
            subclass(StashLog::class)
            subclass(TreasuryLog::class)
            subclass(UpgradeLog::class)
        }
    }

    /**
     * The [GuildUpgrade] serializers module.
     */
    val GUILD_UPGRADE = SerializersModule {
        polymorphic(GuildUpgrade::class) {
            subclass(AccumulatingCurrencyUpgrade::class)
            subclass(BankTabUpgrade::class)
            subclass(BoostUpgrade::class)
            subclass(ClaimableUpgrade::class)
            subclass(ConsumableUpgrade::class)
            subclass(DecorationUpgrade::class)
            subclass(GuildHallExpeditionUpgrade::class)
            subclass(GuildHallUpgrade::class)
            subclass(HubUpgrade::class)
            subclass(QueueUpgrade::class)
            subclass(UnlockUpgrade::class)
        }
    }

    /**
     * The [GuildUpgradeCost] serializers module.
     */
    val GUILD_UPGRADE_COST = SerializersModule {
        polymorphic(GuildUpgradeCost::class) {
            subclass(CoinUpgradeCost::class)
            subclass(CollectibleUpgradeCost::class)
            subclass(CurrencyUpgradeCost::class)
            subclass(ItemUpgradeCost::class)
        }
    }

    /**
     * The [Item] serializers module.
     */
    val ITEM = SerializersModule {
        polymorphic(Item::class) {
            subclass(ArmorItem::class)
            subclass(BackItem::class)
            subclass(BagItem::class)
            subclass(ConsumableItem::class)
            subclass(ContainerItem::class)
            subclass(CraftingMaterialItem::class)
            subclass(GatheringToolItem::class)
            subclass(GizmoItem::class)
            subclass(KeyItem::class)
            subclass(MiniItem::class)
            subclass(SalvageKitItem::class)
            subclass(TraitGuideItem::class)
            subclass(TrophyItem::class)
            subclass(UpgradeComponentItem::class)
            subclass(WeaponItem::class)
        }
    }

    /**
     * The [PvpStanding] serializers module.
     */
    val PVP_STANDING = SerializersModule {
        polymorphic(PvpStanding::class) {
            subclass(BestStanding::class)
            subclass(CurrentStanding::class)
        }
    }

    /**
     * The [TrainingTrack] serializers module.
     */
    val TRAINING_TRACK = SerializersModule {
        polymorphic(TrainingTrack::class) {
            subclass(SkillTrack::class)
            subclass(TraitTrack::class)
        }
    }

    /**
     * The [SkillFact] serializers module.
     */
    val SKILL_FACT = SerializersModule {
        polymorphic(SkillFact::class) {
            subclass(SkillAttributeAdjustFact::class)
            subclass(SkillBuffFact::class)
            subclass(SkillComboFieldFact::class)
            subclass(SkillComboFinisherFact::class)
            subclass(SkillDamageFact::class)
            subclass(SkillDistanceFact::class)
            subclass(SkillDurationFact::class)
            subclass(SkillHealFact::class)
            subclass(SkillHealingAdjustFact::class)
            subclass(SkillNoDataFact::class)
            subclass(SkillNumberFact::class)
            subclass(SkillPercentFact::class)
            subclass(SkillPrefixedBuffFact::class)
            subclass(SkillRadiusFact::class)
            subclass(SkillRangeFact::class)
            subclass(SkillRechargeFact::class)
            subclass(SkillTimeFact::class)
            subclass(SkillUnblockableFact::class)
        }
    }

    /**
     * The [Skin] serializers module.
     */
    val SKIN = SerializersModule {
        polymorphic(Skin::class) {
            subclass(ArmorSkin::class)
            subclass(BackSkin::class)
            subclass(GatheringToolSkin::class)
            subclass(WeaponSkin::class)
        }
    }

    /**
     * The [TraitFact] serializers module.
     */
    val TRAIT_FACT = SerializersModule {
        polymorphic(TraitFact::class) {
            subclass(TraitAttributeAdjustFact::class)
            subclass(TraitBuffFact::class)
            subclass(TraitBuffConversionFact::class)
            subclass(TraitComboFieldFact::class)
            subclass(TraitComboFinisherFact::class)
            subclass(TraitDamageFact::class)
            subclass(TraitDistanceFact::class)
            subclass(TraitNoDataFact::class)
            subclass(TraitNumberFact::class)
            subclass(TraitPercentFact::class)
            subclass(TraitPrefixedBuffFact::class)
            subclass(TraitRadiusFact::class)
            subclass(TraitRangeFact::class)
            subclass(TraitRechargeFact::class)
            subclass(TraitTimeFact::class)
            subclass(TraitUnblockableFact::class)
        }
    }

    /**
     * All of the serializer modules.
     */
    val ALL: SerializersModule =
        TOKEN_INFO + ACHIEVEMENT_REWARD + ACHIEVEMENT_BIT + GUILD_LOG + GUILD_UPGRADE + GUILD_UPGRADE_COST + ITEM + PVP_STANDING + TRAINING_TRACK + SKILL_FACT + SKIN + TRAIT_FACT

    /**
     * The model [Json] instance.
     *
     * It is designed to be lenient in order to avoid errors.
     */
    val JSON = Json {
        isLenient = true
        ignoreUnknownKeys = true
        coerceInputValues = true
        encodeDefaults = true
        classDiscriminator = "type"
        serializersModule = ALL
    }
}