package com.bselzer.gw2.v2.model.enumeration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class InfluenceActivity {
    @SerialName("gifted")
    GIFTED,

    @SerialName("daily_login")
    DAILY_LOGIN
}