package com.bselzer.library.gw2.v2.model.common.pvp.standing

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("best")
data class BestStanding(
    override val totalPoints: Int = 0,
    override val division: Int = 0,
    override val points: Int = 0,
    override val repeats: Int = 0
) : PvpStanding()