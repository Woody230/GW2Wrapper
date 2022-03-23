package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GizmoDetailType {
    @SerialName("Default")
    DEFAULT,

    @SerialName("ContainerKey")
    CONTAINER_KEY,

    @SerialName("RentableContractNpc")
    RENTABLE_NPC,

    @SerialName("UnlimitedConsumable")
    UNLIMITED_CONSUMABLE,
}