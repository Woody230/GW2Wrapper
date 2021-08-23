package com.bselzer.library.gw2.v2.model.enumeration.extension.dungeon

import com.bselzer.library.gw2.v2.model.dungeon.DungeonPath
import com.bselzer.library.gw2.v2.model.enumeration.dungeon.DungeonPathType
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [DungeonPath.type] as a [DungeonPathType]
 */
fun DungeonPath.type(): DungeonPathType? = type.enumValueOrNull<DungeonPathType>()