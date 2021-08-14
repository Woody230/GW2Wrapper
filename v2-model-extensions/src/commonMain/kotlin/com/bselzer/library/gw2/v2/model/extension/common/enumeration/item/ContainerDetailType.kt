package com.bselzer.library.gw2.v2.model.extension.common.enumeration.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ContainerDetailType
{
    @SerialName("Default")
    DEFAULT,

    @SerialName("GiftBox")
    GIFT,

    @SerialName("Immediate")
    CONTAINER_WITHOUT_UI,

    @SerialName("OpenUI")
    CONTAINER_WITH_UI,
}