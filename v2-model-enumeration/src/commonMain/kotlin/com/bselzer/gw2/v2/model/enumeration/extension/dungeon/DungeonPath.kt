package com.bselzer.gw2.v2.model.enumeration.extension.dungeon

import com.bselzer.gw2.v2.model.dungeon.DungeonPath
import com.bselzer.gw2.v2.model.enumeration.dungeon.DungeonPathType
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [DungeonPath.type] as a [DungeonPathType]
 */
fun DungeonPath.type(): DungeonPathType? = type.enumValueOrNull<DungeonPathType>()