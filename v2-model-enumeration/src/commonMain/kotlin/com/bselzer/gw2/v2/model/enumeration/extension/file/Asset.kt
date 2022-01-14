package com.bselzer.gw2.v2.model.enumeration.extension.file

import com.bselzer.gw2.v2.model.enumeration.file.AssetName
import com.bselzer.gw2.v2.model.file.Asset
import com.bselzer.ktx.serialization.function.enumValueOrNull

/**
 * The [Asset.id] as an [AssetName]
 */
fun Asset.id(): AssetName? = id.enumValueOrNull<AssetName>()