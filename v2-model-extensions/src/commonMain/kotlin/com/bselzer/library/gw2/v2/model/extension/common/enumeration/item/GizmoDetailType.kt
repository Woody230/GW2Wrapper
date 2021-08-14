package com.bselzer.library.gw2.v2.model.extension.common.enumeration.item

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GizmoDetailType
{
    @SerialName("Default")
    DEFAULT,

    @SerialName("ContainerKey")
    CONTAINER_KEY,

    @SerialName("RentableContractNpc")
    RENTABLE_NPC,

    @SerialName("UnlimitedConsumable")
    UNLIMITED_CONSUMABLE,
}