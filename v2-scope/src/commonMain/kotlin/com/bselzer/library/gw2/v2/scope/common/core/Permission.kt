package com.bselzer.library.gw2.v2.scope.common.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Permission
{
    /**
     * The account endpoint is accessible.
     *
     * This is required for all API keys.
     */
    @SerialName("account")
    ACCOUNT,

    /**
     * The character specializations and gear are accessible.
     */
    @SerialName("builds")
    BUILDS,

    /**
     * The characters endpoint is accessible.
     */
    @SerialName("characters")
    CHARACTERS,

    /**
     * The guild/{id} endpoints are accessible.
     */
    @SerialName("guilds")
    GUILDS,

    /**
     * The characters, account/bank, and account/material endpoints are accessible.
     */
    @SerialName("inventories")
    INVENTORIES,

    /**
     * The achievements, dungeon unlock status, mastery point assignments, and general PvE progress are accessible.
     */
    @SerialName("progression")
    PROGRESSION,

    /**
     * The pvp endpoints are accessible.
     */
    @SerialName("pvp")
    PVP,

    /**
     * The commerce/transactions endpoint is accessible.
     */
    @SerialName("tradingpost")
    TRADING_POST,

    /**
     * The account/skins and account/dyes endpoints are accessible.
     */
    @SerialName("unlocks")
    UNLOCKS,

    /**
     * The account/wallet endpoint is accessible.
     */
    @SerialName("wallet")
    WALLET
}