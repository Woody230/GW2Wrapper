package com.bselzer.library.gw2.v2.model.enumeration.extension.file

import com.bselzer.library.gw2.v2.model.enumeration.file.AssetName
import com.bselzer.library.gw2.v2.model.file.Asset
import com.bselzer.library.kotlin.extension.serialization.function.enumValueOrNull

/**
 * The [Asset.id] as an [AssetName]
 */
fun Asset.id(): AssetName? = id.enumValueOrNull<AssetName>()