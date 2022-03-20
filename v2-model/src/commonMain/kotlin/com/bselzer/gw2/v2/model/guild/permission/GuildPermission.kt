package com.bselzer.gw2.v2.model.guild.permission

import com.bselzer.gw2.v2.model.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildPermission(
    @SerialName("id")
    override val id: GuildPermissionId = GuildPermissionId(),

    @SerialName("name")
    val name: String = "",

    @SerialName("description")
    val description: String = ""
) : Identifiable<String>