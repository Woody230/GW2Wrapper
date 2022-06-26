package com.bselzer.gw2.v2.model.enumeration.extension

import com.bselzer.gw2.v2.model.enumeration.AssetName
import com.bselzer.gw2.v2.model.enumeration.LegendName
import com.bselzer.gw2.v2.model.enumeration.ProfessionName
import com.bselzer.gw2.v2.model.enumeration.RaceName
import com.bselzer.gw2.v2.model.file.AssetId
import com.bselzer.gw2.v2.model.legend.LegendId
import com.bselzer.gw2.v2.model.profession.ProfessionId
import com.bselzer.gw2.v2.model.race.RaceId

fun AssetId.decodeOrNull() = value.decodeOrNull<AssetName>()
fun ProfessionId.decodeOrNull() = value.decodeOrNull<ProfessionName>()
fun LegendId.decodeOrNull() = value.decodeOrNull<LegendName>()
fun RaceId.decodeOrNull() = value.decodeOrNull<RaceName>()