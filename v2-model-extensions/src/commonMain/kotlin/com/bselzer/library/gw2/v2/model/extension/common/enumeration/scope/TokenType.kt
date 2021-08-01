package com.bselzer.library.gw2.v2.model.extension.common.enumeration.scope

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TokenType
{
    /**
     * An API key.
     */
    @SerialName("APIKey")
    API_KEY,

    /**
     * A sub-token.
     *
     * @see <a href="https://wiki.guildwars2.com/wiki/API:2/createsubtoken">the wiki</a>
     */
    @SerialName("Subtoken")
    SUBTOKEN
}