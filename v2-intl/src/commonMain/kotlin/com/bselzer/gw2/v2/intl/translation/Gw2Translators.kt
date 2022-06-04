package com.bselzer.gw2.v2.intl.translation

import com.bselzer.gw2.v2.model.continent.Continent
import com.bselzer.gw2.v2.model.continent.floor.Floor
import com.bselzer.gw2.v2.model.guild.upgrade.GuildUpgrade
import com.bselzer.gw2.v2.model.map.Map
import com.bselzer.gw2.v2.model.world.World
import com.bselzer.gw2.v2.model.wvw.ability.WvwAbility
import com.bselzer.gw2.v2.model.wvw.objective.WvwObjective
import com.bselzer.gw2.v2.model.wvw.rank.WvwRank
import com.bselzer.gw2.v2.model.wvw.upgrade.WvwUpgrade

object Gw2Translators {
    val continent: Translator<Continent> = ContinentTranslator()
    val floor: Translator<Floor> = FloorTranslator()
    val guildUpgrade: Translator<GuildUpgrade> = GuildUpgradeTranslator()
    val map: Translator<Map> = MapTranslator()
    val world: Translator<World> = WorldTranslator()
    val wvwAbility: Translator<WvwAbility> = WvwAbilityTranslator()
    val wvwObjective: Translator<WvwObjective> = WvwObjectiveTranslator()
    val wvwRank: Translator<WvwRank> = WvwRankTranslator()
    val wvwUpgrade: Translator<WvwUpgrade> = WvwUpgradeTranslator()
}