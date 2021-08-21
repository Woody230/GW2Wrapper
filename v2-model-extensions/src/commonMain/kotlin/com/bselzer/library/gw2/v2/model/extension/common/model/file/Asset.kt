package com.bselzer.library.gw2.v2.model.extension.common.model.file

import com.bselzer.library.gw2.v2.model.common.file.Asset
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.file.AssetName
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull

/**
 * The [Asset.id] as an [AssetName]
 */
fun Asset.id(): AssetName? = id.enumValueOrNull<AssetName>()