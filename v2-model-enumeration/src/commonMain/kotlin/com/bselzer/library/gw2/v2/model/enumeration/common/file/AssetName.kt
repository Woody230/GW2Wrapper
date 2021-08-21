package com.bselzer.library.gw2.v2.model.enumeration.common.file

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AssetName
{
    @SerialName("map_complete")
    MAP_COMPLETE,

    @SerialName("map_dungeon")
    MAP_DUNGEON,

    @SerialName("map_heart_empty")
    MAP_HEART_EMPTY,

    @SerialName("map_heart_full")
    MAP_HEART_FULL,

    @SerialName("map_node_harvesting")
    MAP_NODE_HARVESTING,

    @SerialName("map_node_logging")
    MAP_NODE_LOGGING,

    @SerialName("map_node_mining")
    MAP_NODE_MINING,

    @SerialName("map_poi")
    MAP_POINT_OF_INTEREST,

    @SerialName("map_special_event")
    MAP_SPECIAL_EVENT,

    @SerialName("map_story")
    MAP_STORY,

    @SerialName("map_waypoint")
    MAP_WAYPOINT,

    @SerialName("map_waypoint_contested")
    MAP_WAYPOINT_CONTESTED,

    @SerialName("map_waypoint_hover")
    MAP_WAYPOINT_HOVER,

    @SerialName("map_vista")
    MAP_VISTA,

    @SerialName("map_heropoint")
    MAP_HEROPOINT,

    @SerialName("wvw_battles_hollow_blue")
    WVW_BATTLES_HOLLOW_BLUE,

    @SerialName("wvw_battles_hollow_green")
    WVW_BATTLES_HOLLOW_GREEN,

    @SerialName("wvw_battles_hollow_red")
    WVW_BATTLES_HOLLOW_RED,

    @SerialName("wvw_battles_hollow_white")
    WVW_BATTLES_HOLLOW_WHITE,

    @SerialName("wvw_bauers_estate_blue")
    WVW_BAUERS_ESTATE_BLUE,

    @SerialName("wvw_bauers_estate_green")
    WVW_BAUERS_ESTATE_GREEN,

    @SerialName("wvw_bauers_estate_red")
    WVW_BAUERS_ESTATE_RED,

    @SerialName("wvw_bauers_estate_white")
    WVW_BAUERS_ESTATE_WHITE,

    @SerialName("wvw_carvers_ascent_blue")
    WVW_CARVERS_ASCENT_BLUE,

    @SerialName("wvw_carvers_ascent_green")
    WVW_CARVERS_ASCENT_GREEN,

    @SerialName("wvw_carvers_ascent_red")
    WVW_CARVERS_ASCENT_RED,

    @SerialName("wvw_carvers_ascent_white")
    WVW_CARVERS_ASCENT_WHITE,

    @SerialName("wvw_orchard_overlook_blue")
    WVW_ORCHARD_OVERLOOK_BLUE,

    @SerialName("wvw_orchard_overlook_green")
    WVW_ORCHARD_OVERLOOK_GREEN,

    @SerialName("wvw_orchard_overlook_red")
    WVW_ORCHARD_OVERLOOK_RED,

    @SerialName("wvw_orchard_overlook_white")
    WVW_ORCHARD_OVERLOOK_WHITE,

    @SerialName("wvw_temple_of_lost_prayers_blue")
    WVW_TEMPLE_OF_LOST_PRAYERS_BLUE,

    @SerialName("wvw_temple_of_lost_prayers_green")
    WVW_TEMPLE_OF_LOST_PRAYERS_GREEN,

    @SerialName("wvw_temple_of_lost_prayers_red")
    WVW_TEMPLE_OF_LOST_PRAYERS_RED,

    @SerialName("wvw_temple_of_lost_prayers_white")
    WVW_TEMPLE_OF_LOST_PRAYERS_WHITE,

    @SerialName("wvw_camp")
    WVW_CAMP,

    @SerialName("wvw_tower")
    WVW_TOWER,

    @SerialName("wvw_keep")
    WVW_KEEP,

    @SerialName("wvw_castle")
    WVW_CASTLE,

    @SerialName("ui_upgrade_slot_open")
    UI_UPGRADE_SLOT_OPEN,

    @SerialName("ui_infusion_slot_agony")
    UI_INFUSION_SLOT_AGONY,

    @SerialName("ui_infusion_slot_defensive")
    UI_INFUSION_SLOT_DEFENSIVE,

    @SerialName("ui_infusion_slot_offensive")
    UI_INFUSION_SLOT_OFFENSIVE,

    @SerialName("ui_infusion_slot_utility")
    UI_INFUSION_SLOT_UTILITY,

    @SerialName("ui_coin_gold")
    UI_COIN_GOLD,

    @SerialName("ui_coin_silver")
    UI_COIN_SILVER,

    @SerialName("ui_coin_copper")
    UI_COIN_COPPER,

    @SerialName("ui_gem")
    UI_GEM,

    @SerialName("ui_supply")
    UI_SUPPLY,

    @SerialName("ui_minor_trait_mask")
    UI_MINOR_TRAIT_MASK,

    @SerialName("ui_major_trait_mask")
    UI_MAJOR_TRAIT_MASK,

    @SerialName("icon_guardian")
    GUARDIAN_ICON,

    @SerialName("icon_warrior")
    WARRIOR_ICON,

    @SerialName("icon_revenant")
    REVENANT_ICON,

    @SerialName("icon_necromancer")
    NECROMANCER_ICON,

    @SerialName("icon_mesmer")
    MESMER_ICON,

    @SerialName("icon_elementalist")
    ELEMENTALIST_ICON,

    @SerialName("icon_thief")
    THIEF_ICON,

    @SerialName("icon_ranger")
    RANGER_ICON,

    @SerialName("icon_engineer")
    ENGINEER_ICON,

    @SerialName("icon_guardian_big")
    GUARDIAN_ICON_BIG,

    @SerialName("icon_warrior_big")
    WARRIOR_ICON_BIG,

    @SerialName("icon_revenant_big")
    REVENANT_ICON_BIG,

    @SerialName("icon_necromancer_big")
    NECROMANCER_ICON_BIG,

    @SerialName("icon_mesmer_big")
    MESMER_ICON_BIG,

    @SerialName("icon_elementalist_big")
    ELEMENTALIST_ICON_BIG,

    @SerialName("icon_thief_big")
    THIEF_ICON_BIG,

    @SerialName("icon_ranger_big")
    RANGER_ICON_BIG,

    @SerialName("icon_engineer_big")
    ENGINEER_ICON_BIG,

    @SerialName("map_crafting_scribe")
    MAP_CRAFTING_SCRIBE,

    @SerialName("map_bank")
    MAP_BANK,

    @SerialName("map_guild_bank")
    MAP_GUILD_BANK,

    @SerialName("map_trading_post")
    MAP_TRADING_POST,

    @SerialName("map_crafting_armorsmith")
    MAP_CRAFTING_ARMORSMITH,

    @SerialName("map_crafting_artificer")
    MAP_CRAFTING_ARTIFICER,

    @SerialName("map_crafting_cook")
    MAP_CRAFTING_COOK,

    @SerialName("map_crafting_huntsman")
    MAP_CRAFTING_HUNTSMAN,

    @SerialName("map_crafting_jeweler")
    MAP_CRAFTING_JEWELER,

    @SerialName("map_crafting_leatherworker")
    MAP_CRAFTING_LEATHERWORKER,

    @SerialName("map_crafting_tailor")
    MAP_CRAFTING_TAILOR,

    @SerialName("map_crafting_weaponsmith")
    MAP_CRAFTING_WEAPONSMITH,

    @SerialName("map_guild_registrar")
    MAP_GUILD_REGISTRAR,

    @SerialName("map_profession_trainer")
    MAP_PROFESSION_TRAINER,

    @SerialName("map_repair")
    MAP_REPAIR,

    @SerialName("map_vendor")
    MAP_VENDOR,

    @SerialName("map_vendor_armor")
    MAP_VENDOR_ARMOR,

    @SerialName("map_vendor_weapons")
    MAP_VENDOR_WEAPONS,

    @SerialName("map_vendor_mystic_forge")
    MAP_VENDOR_MYSTIC_FORGE,

    @SerialName("map_vendor_laurel")
    MAP_VENDOR_LAUREL,

    @SerialName("map_fractal")
    MAP_FRACTAL,

    @SerialName("map_raid_entrance")
    MAP_RAID_ENTRANCE,

    @SerialName("map_adventure")
    MAP_ADVENTURE,

    @SerialName("map_adventure_complete")
    MAP_ADVENTURE_COMPLETE,

    @SerialName("map_adventure_locked")
    MAP_ADVENTURE_LOCKED,

    @SerialName("map_outpost")
    MAP_OUTPOST,

    @SerialName("map_outpost_locked")
    MAP_OUTPOST_LOCKED,

    @SerialName("map_outpost_contested")
    MAP_OUTPOST_CONTESTED,

    @SerialName("map_outpost_active")
    MAP_OUTPOST_ACTIVE,

    @SerialName("map_vendor_festival")
    MAP_VENDOR_FESTIVAL,

    @SerialName("map_guild_armorer")
    MAP_GUILD_ARMORER,

    @SerialName("map_guild_weaponsmith")
    MAP_GUILD_WEAPONSMITH,

    @SerialName("map_vendor_ecto")
    MAP_VENDOR_ECTO,

    @SerialName("map_vendor_guild")
    MAP_VENDOR_GUILD,

    @SerialName("map_vendor_cultural_armor")
    MAP_VENDOR_CULTURAL_ARMOR,

    @SerialName("map_vendor_cultural_weapons")
    MAP_VENDOR_CULTURAL_WEAPONS,

    @SerialName("map_vendor_crystalline_ore")
    MAP_VENDOR_CRYSTALLINE_ORE,

    @SerialName("map_vendor_airship_parts")
    MAP_VENDOR_AIRSHIP_PARTS,

    @SerialName("map_vendor_aurillium")
    MAP_VENDOR_AURILLIUM,

    @SerialName("map_vendor_leyline_crystals")
    MAP_VENDOR_LEYLINE_CRYSTALS,

    @SerialName("map_vendor_dungeon")
    MAP_VENDOR_DUNGEON,

    @SerialName("map_elevator_down")
    MAP_ELEVATOR_DOWN,

    @SerialName("map_elevator_up")
    MAP_ELEVATOR_UP,

    @SerialName("map_ramp_down")
    MAP_RAMP_DOWN,

    @SerialName("map_ramp_up")
    MAP_RAMP_UP,

    @SerialName("map_stairs_down")
    MAP_STAIRS_DOWN,

    @SerialName("map_stairs_up")
    MAP_STAIRS_UP,

}