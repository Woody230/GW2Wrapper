package com.bselzer.library.gw2.v2.model.extension.common.model.dungeon

import com.bselzer.library.gw2.v2.model.common.dungeon.DungeonPath
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.dungeon.DungeonPathType
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull

/**
 * The [DungeonPath.type] as a [DungeonPathType]
 */
fun DungeonPath.type(): DungeonPathType? = type.enumValueOrNull<DungeonPathType>()