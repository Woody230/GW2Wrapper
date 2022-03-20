package com.bselzer.gw2.v2.model.pvp.game

import com.bselzer.gw2.v2.model.identifier.Identifiable
import com.bselzer.gw2.v2.model.map.MapId
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PvpGame(
    /**
     * The id in the form of a UUID.
     */
    @SerialName("id")
    override val id: PvpGameId = PvpGameId(),

    /**
     * The id of the map the match was played on.
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/maps">the wiki</a>
     */
    @SerialName("map_id")
    val mapId: MapId = MapId(),

    /**
     * The start date.
     */
    @SerialName("started")
    val startedAt: Instant = Instant.DISTANT_PAST,

    /**
     * The end date.
     */
    @SerialName("ended")
    val endedAt: Instant = Instant.DISTANT_PAST,

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
) : Identifiable<String>