package com.bselzer.gw2.asset.cdn.model

import com.bselzer.gw2.v2.model.build.BuildId
import kotlinx.serialization.Serializable

@Serializable
data class Build(
    val id: BuildId,
    val executableFileId: Int,
    val executableFileSize: Int,
    val manifestFileId: Int,
    val manifestFileSize: Int
)