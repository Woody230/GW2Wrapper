package com.bselzer.library.gw2.v2.client.common.serialization

import com.bselzer.library.gw2.v2.model.common.account.token.ApiKeyInfo
import com.bselzer.library.gw2.v2.model.common.account.token.SubTokenInfo
import com.bselzer.library.gw2.v2.model.common.account.token.TokenInfo
import com.bselzer.library.gw2.v2.model.common.achievement.bit.*
import com.bselzer.library.gw2.v2.model.common.achievement.reward.*
import com.bselzer.library.gw2.v2.model.common.guild.log.*
import com.bselzer.library.gw2.v2.model.common.guild.upgrade.*
import com.bselzer.library.gw2.v2.model.common.guild.upgrade.cost.*
import com.bselzer.library.gw2.v2.model.common.item.*
import com.bselzer.library.gw2.v2.model.common.profession.skill.ElementalistSkill
import com.bselzer.library.gw2.v2.model.common.profession.skill.ProfessionSkill
import com.bselzer.library.gw2.v2.model.common.profession.skill.ThiefSkill
import com.bselzer.library.gw2.v2.model.common.profession.track.SkillTrack
import com.bselzer.library.gw2.v2.model.common.profession.track.TrainingTrack
import com.bselzer.library.gw2.v2.model.common.profession.track.TraitTrack
import com.bselzer.library.gw2.v2.model.common.pvp.standing.BestStanding
import com.bselzer.library.gw2.v2.model.common.pvp.standing.CurrentStanding
import com.bselzer.library.gw2.v2.model.common.pvp.standing.PvpStanding
import com.bselzer.library.gw2.v2.model.common.skill.fact.*
import com.bselzer.library.gw2.v2.model.common.skin.*
import com.bselzer.library.gw2.v2.model.common.trait.fact.BuffConversionFact
import com.bselzer.library.gw2.v2.model.common.trait.fact.TraitFact
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
            default { serializer() }
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
            default { serializer() }
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
            default { serializer() }
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
            default { serializer() }
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
            default { serializer() }
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
            subclass(GuildUpgradeCost::class, serializer())
            subclass(ItemUpgradeCost::class, serializer())
            default { serializer() }
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
            default { serializer() }
        }
    }

    /**
     * The [PvpStanding] serializers module.
     */
    val PVP_STANDING = SerializersModule {
        polymorphic(PvpStanding::class) {
            subclass(BestStanding::class, serializer())
            subclass(CurrentStanding::class, serializer())
            default { serializer() }
        }
    }

    /**
     * The [TrainingTrack] serializers module.
     */
    val TRAINING_TRACK = SerializersModule {
        polymorphic(TrainingTrack::class) {
            subclass(SkillTrack::class, serializer())
            subclass(TraitTrack::class, serializer())
            default { serializer() }
        }
    }

    /**
     * The [ProfessionSkill] serializers module.
     */
    val PROFESSION_SKILL = SerializersModule {
        polymorphic(ProfessionSkill::class) {
            subclass(ElementalistSkill::class, serializer())
            subclass(ThiefSkill::class, serializer())
            default { serializer() }
        }
    }

    /**
     * The [SkillFact] serializers module.
     */
    val SKILL_FACT = SerializersModule {
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

    /**
     * The [Skin] serializers module.
     */
    val SKIN = SerializersModule {
        polymorphic(Skin::class) {
            subclass(ArmorSkin::class, serializer())
            subclass(BackSkin::class, serializer())
            subclass(GatheringToolSkin::class, serializer())
            subclass(WeaponSkin::class, serializer())
            default { serializer() }
        }
    }

    /**
     * The [TraitFact] serializers module.
     */
    val TRAIT_FACT = SerializersModule {
        polymorphic(TraitFact::class) {
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.AttributeAdjustFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.BuffFact::class, serializer())
            subclass(BuffConversionFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.ComboFieldFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.ComboFinisherFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.DamageFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.DistanceFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.NoDataFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.NumberFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.PercentFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.PrefixedBuffFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.RadiusFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.RangeFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.RechargeFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.TimeFact::class, serializer())
            subclass(com.bselzer.library.gw2.v2.model.common.trait.fact.UnblockableFact::class, serializer())
            default { serializer() }
        }
    }

    /**
     * All of the serializer modules.
     */
    val ALL: SerializersModule =
        TOKEN_INFO + ACHIEVEMENT_REWARD + ACHIEVEMENT_BIT + GUILD_LOG + GUILD_UPGRADE + GUILD_UPGRADE_COST + ITEM + PVP_STANDING + TRAINING_TRACK + PROFESSION_SKILL + SKILL_FACT + SKIN + TRAIT_FACT
}