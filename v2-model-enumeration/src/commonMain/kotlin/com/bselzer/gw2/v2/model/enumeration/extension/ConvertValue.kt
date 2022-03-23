package com.bselzer.gw2.v2.model.enumeration.extension

import com.bselzer.ktx.serialization.function.enumValueOrNull

// Wrappers are used instead of the enums directly since while enums can help for pinpointing a specific type...
// There may be a missing or inconsistent enum sent by the API which will be no problem for deserialization because it will exist in its original form in the wrapper.

fun com.bselzer.gw2.v2.model.enumeration.wrapper.AchievementFlag.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.AchievementFlag>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.AchievementType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.AchievementType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.AccountAccess.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.AccountAccess>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.ArmorDetailType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.ArmorDetailType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.ArmorWeight.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.ArmorWeight>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.AttributeName.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.AttributeName>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.AttunementName.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.AttunementName>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.Binding.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.Binding>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.CharacterFlag.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.CharacterFlag>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.ColorCategory.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.ColorCategory>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.ComboFieldType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.ComboFieldType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.ComboFinisherType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.ComboFinisherType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.CraftingDiscipline.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.CraftingDiscipline>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.ConsumableDetailType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.ConsumableDetailType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.ConsumableUnlockType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.ConsumableUnlockType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.ContainerDetailType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.ContainerDetailType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.DungeonPathType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.DungeonPathType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.EffectName.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.EffectName>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.EquipmentLocation.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.EquipmentLocation>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.EquipmentSlot.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.EquipmentSlot>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.GatheringToolDetailType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.GatheringToolDetailType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.Gender.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.Gender>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.GizmoDetailType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.GizmoDetailType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.GuildEmblemFlag.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.GuildEmblemFlag>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.InfluenceActivity.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.InfluenceActivity>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.InfusionUpgradeFlag.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.InfusionUpgradeFlag>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.ItemFlag.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.ItemFlag>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.ItemGameType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.ItemGameType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.ItemRarity.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.ItemRarity>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.ItemRestriction.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.ItemRestriction>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.MapType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.MapType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.MaterialType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.MaterialType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.MountName.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.MountName>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.NoveltySlot.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.NoveltySlot>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.PointOfInterestType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.PointOfInterestType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.Product.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.Product>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.ProfessionFlag.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.ProfessionFlag>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.PvpDivisionFlag.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.PvpDivisionFlag>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.PvpHeroName.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.PvpHeroName>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.PvpHeroType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.PvpHeroType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.PvpLadderType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.PvpLadderType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.PvpRatingType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.PvpRatingType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.PvpResult.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.PvpResult>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.PvpTeam.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.PvpTeam>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.RaceGender.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.RaceGender>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.RaidEventType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.RaidEventType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.RecipeFlag.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.RecipeFlag>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.RecipeType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.RecipeType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.RegionType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.RegionType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.SabUnlockName.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.SabUnlockName>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.SalvageKitDetailType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.SalvageKitDetailType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.SkillCategory.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.SkillCategory>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.SkillFlag.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.SkillFlag>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.SkillSlot.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.SkillSlot>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.SkillType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.SkillType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.SkinFlag.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.SkinFlag>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.SpecializationName.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.SpecializationName>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.StashOperation.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.StashOperation>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.TeamMemberRole.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.TeamMemberRole>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.TrainingCategory.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.TrainingCategory>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.TrainingTrackType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.TrainingTrackType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.TraitSlot.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.TraitSlot>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.TraitTier.enumValueOrNull() = value.toString().enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.TraitTier>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.TrinketDetailType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.TrinketDetailType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.UpgradeAction.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.UpgradeAction>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.UpgradeComponentDetailType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.UpgradeComponentDetailType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.UpgradeComponentFlag.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.UpgradeComponentFlag>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.WeaponDamageType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.WeaponDamageType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.WeaponDetailType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.WeaponDetailType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.WeaponFlag.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.WeaponFlag>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.WeaponType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.WeaponType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.WorldName.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.WorldName>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.WorldPopulationLevel.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.WorldPopulationLevel>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.WvwMapBonusType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.WvwMapBonusType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.WvwMapType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.WvwMapType>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.WvwObjectiveOwner.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner>()
fun com.bselzer.gw2.v2.model.enumeration.wrapper.WvwObjectiveType.enumValueOrNull() = value.enumValueOrNull<com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType>()