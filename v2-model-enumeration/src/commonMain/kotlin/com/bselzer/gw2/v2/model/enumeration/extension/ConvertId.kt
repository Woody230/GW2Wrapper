package com.bselzer.gw2.v2.model.enumeration.extension

import com.bselzer.gw2.v2.model.enumeration.AssetName
import com.bselzer.gw2.v2.model.enumeration.LegendName
import com.bselzer.gw2.v2.model.enumeration.ProfessionName
import com.bselzer.gw2.v2.model.enumeration.RaceName
import com.bselzer.gw2.v2.model.file.AssetId
import com.bselzer.gw2.v2.model.legend.LegendId
import com.bselzer.gw2.v2.model.profession.ProfessionId
import com.bselzer.gw2.v2.model.race.RaceId
import com.bselzer.ktx.serialization.json.function.enumValueOrNull

fun AssetId.enumValueOrNull() = value.enumValueOrNull<AssetName>()
fun ProfessionId.enumValueOrNull() = value.enumValueOrNull<ProfessionName>()
fun LegendId.enumValueOrNull() = value.enumValueOrNull<LegendName>()
fun RaceId.enumValueOrNull() = value.enumValueOrNull<RaceName>()