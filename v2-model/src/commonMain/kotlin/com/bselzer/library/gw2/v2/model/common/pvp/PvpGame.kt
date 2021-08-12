package com.bselzer.library.gw2.v2.model.common.pvp

import com.bselzer.library.kotlin.extension.datetime.common.function.minValue
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpGame(
    /**
     * The id in the form of a UUID.
     */
    @SerialName("id")
    val id: String = "",

    /**
     * The id of the map the match was played on.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    @SerialName("map_id")
    val mapId: Int = 0,

    /**
     * The start date.
     */
    @SerialName("started")
    val startedAt: LocalDateTime = LocalDateTime.minValue(),

    /**
     * The end date.
     */
    @SerialName("ended")
    val endedAt: LocalDateTime = LocalDateTime.minValue(),

    /**
     * The result of the match.
     */
    @SerialName("result")
    val result: String = "",

    /**
     * The name of the team the player was on.
     */
    @SerialName("team")
    val team: String = "",

    /**
     * The name of the profession the player used.
     */
    @SerialName("profession")
    val profession: String = "",

    /**
     * The scores for each team.
     */
    @SerialName("scores")
    val scores: Map<String, Int> = emptyMap(),

    /**
     * The type of game mode.
     */
    @SerialName("rating_type")
    val ratingType: String = "",

    /**
     * The change in rating. Positive for a win and negative for a loss.
     */
    @SerialName("rating_change")
    val ratingChange: Int = 0,

    /**
     * The id of the season.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/pvp/seasons">the wiki</a>
     */
    @SerialName("season")
    val season: String = ""
)