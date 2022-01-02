package com.bselzer.gw2.asset.cdn.model

import kotlinx.serialization.Serializable

@Serializable
data class Build(
    val id: Int,
    val executableFileId: Int,
    val executableFileSize: Int,
    val manifestFileId: Int,
    val manifestFileSize: Int
)