package com.bselzer.gw2.v2.cache.type

import com.bselzer.gw2.v2.model.account.token.ApiKeyInfo
import com.bselzer.gw2.v2.model.account.token.SubTokenInfo
import com.bselzer.gw2.v2.model.account.token.TokenInfo
import com.bselzer.gw2.v2.model.achievement.bit.*
import com.bselzer.gw2.v2.model.achievement.reward.*
import com.bselzer.gw2.v2.model.guild.log.*
import com.bselzer.gw2.v2.model.guild.upgrade.*
import com.bselzer.gw2.v2.model.guild.upgrade.cost.*
import com.bselzer.gw2.v2.model.item.*
import com.bselzer.gw2.v2.model.profession.track.SkillTrack
import com.bselzer.gw2.v2.model.profession.track.TrainingTrack
import com.bselzer.gw2.v2.model.profession.track.TraitTrack
import com.bselzer.gw2.v2.model.pvp.standing.BestStanding
import com.bselzer.gw2.v2.model.pvp.standing.CurrentStanding
import com.bselzer.gw2.v2.model.pvp.standing.PvpStanding
import com.bselzer.gw2.v2.model.skill.fact.*
import com.bselzer.gw2.v2.model.skin.*
import com.bselzer.gw2.v2.model.trait.fact.*
import org.kodein.db.TypeTable

/**
 * Injects the [TokenInfo] types.
 */
fun TypeTable.Builder.tokenInfo(): Unit = root<TokenInfo>().run {
    sub<ApiKeyInfo>()
    sub<SubTokenInfo>()
}

/**
 * Injects the [AchievementReward] types.
 */
fun TypeTable.Builder.achievementReward(): Unit = root<AchievementReward>().run {
    sub<CoinReward>()
    sub<ItemReward>()
    sub<MasteryReward>()
    sub<TitleReward>()
}

/**
 * Injects the [AchievementBit] types.
 */
fun TypeTable.Builder.achievementBit(): Unit = root<AchievementBit>().run {
    sub<ItemBit>()
    sub<MiniBit>()
    sub<SkinBit>()
    sub<TextBit>()
}

/**
 * Injects the [GuildLog] types.
 */
fun TypeTable.Builder.guildLog(): Unit = root<GuildLog>().run {
    sub<InfluenceLog>()
    sub<InviteDeclinedLog>()
    sub<InvitedLog>()
    sub<JoinedLog>()
    sub<KickLog>()
    sub<MessageOfTheDayLog>()
    sub<RankChangeLog>()
    sub<StashLog>()
    sub<TreasuryLog>()
    sub<UpgradeLog>()
}

/**
 * Injects the [GuildUpgrade] types.
 */
fun TypeTable.Builder.guildUpgrade(): Unit = root<GuildUpgrade>().run {
    sub<AccumulatingCurrencyUpgrade>()
    sub<BankTabUpgrade>()
    sub<BoostUpgrade>()
    sub<ClaimableUpgrade>()
    sub<ConsumableUpgrade>()
    sub<DecorationUpgrade>()
    sub<DefaultUpgrade>()
    sub<GuildHallExpeditionUpgrade>()
    sub<GuildHallUpgrade>()
    sub<HubUpgrade>()
    sub<QueueUpgrade>()
    sub<UnlockUpgrade>()
}

/**
 * Injects the [GuildUpgradeCost] types.
 */
fun TypeTable.Builder.guildUpgradeCost(): Unit = root<GuildUpgradeCost>().run {
    sub<CoinUpgradeCost>()
    sub<CollectibleUpgradeCost>()
    sub<CurrencyUpgradeCost>()
    sub<ItemUpgradeCost>()
}

/**
 * Injects the [Item] types.
 */
fun TypeTable.Builder.item(): Unit = root<Item>().run {
    sub<ArmorItem>()
    sub<BackItem>()
    sub<BagItem>()
    sub<ConsumableItem>()
    sub<ContainerItem>()
    sub<CraftingMaterialItem>()
    sub<DefaultItem>()
    sub<GatheringToolItem>()
    sub<GizmoItem>()
    sub<KeyItem>()
    sub<MiniItem>()
    sub<SalvageKitItem>()
    sub<TraitGuideItem>()
    sub<TrophyItem>()
    sub<UpgradeComponentItem>()
    sub<WeaponItem>()
}

/**
 * Injects the [PvpStanding] types.
 */
fun TypeTable.Builder.pvpStanding(): Unit = root<PvpStanding>().run {
    sub<BestStanding>()
    sub<CurrentStanding>()
}

/**
 * Injects the [TrainingTrack] types.
 */
fun TypeTable.Builder.trainingTrack(): Unit = root<TrainingTrack>().run {
    sub<SkillTrack>()
    sub<TraitTrack>()
}

/**
 * Injects the [SkillFact] types.
 */
fun TypeTable.Builder.skillFact(): Unit = root<SkillFact>().run {
    sub<SkillAttributeAdjustFact>()
    sub<SkillBuffFact>()
    sub<SkillComboFieldFact>()
    sub<SkillComboFinisherFact>()
    sub<SkillDamageFact>()
    sub<SkillDistanceFact>()
    sub<SkillDurationFact>()
    sub<SkillHealFact>()
    sub<SkillHealingAdjustFact>()
    sub<SkillNoDataFact>()
    sub<SkillNumberFact>()
    sub<SkillPercentFact>()
    sub<SkillRadiusFact>()
    sub<SkillRechargeFact>()
    sub<SkillStunBreakFact>()
    sub<SkillTimeFact>()
    sub<SkillUnblockableFact>()
}

/**
 * Injects the [Skin] types.
 */
fun TypeTable.Builder.skin(): Unit = root<Skin>().run {
    sub<ArmorSkin>()
    sub<BackSkin>()
    sub<DefaultSkin>()
    sub<GatheringToolSkin>()
    sub<WeaponSkin>()
}

/**
 * Injects the [TraitFact] types.
 */
fun TypeTable.Builder.traitFact(): Unit = root<TraitFact>().run {
    sub<TraitAttributeAdjustFact>()
    sub<TraitBuffFact>()
    sub<TraitBuffConversionFact>()
    sub<TraitComboFieldFact>()
    sub<TraitComboFinisherFact>()
    sub<TraitDamageFact>()
    sub<TraitDistanceFact>()
    sub<TraitNoDataFact>()
    sub<TraitNumberFact>()
    sub<TraitPercentFact>()
    sub<TraitPrefixedBuffFact>()
    sub<TraitRadiusFact>()
    sub<TraitRangeFact>()
    sub<TraitRechargeFact>()
    sub<TraitTimeFact>()
    sub<TraitUnblockableFact>()
}

/**
 * Injects all of the GW2 types.
 */
fun TypeTable.Builder.gw2() {
    tokenInfo()
    achievementReward()
    achievementBit()
    guildLog()
    guildUpgrade()
    guildUpgradeCost()
    item()
    pvpStanding()
    trainingTrack()
    skillFact()
    skin()
    traitFact()
}