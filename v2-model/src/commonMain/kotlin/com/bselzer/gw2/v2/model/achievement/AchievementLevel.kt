package com.bselzer.gw2.v2.model.achievement

import com.bselzer.gw2.v2.model.character.CharacterLevel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AchievementLevel(
    /**
     * The minimum level requirement.
     */
    @SerialName("min")
    val minimum: CharacterLevel = CharacterLevel(),

    /**
     * The maximum level requirement.
     */
    @SerialName("max")
    val maximum: CharacterLevel = CharacterLevel()
)