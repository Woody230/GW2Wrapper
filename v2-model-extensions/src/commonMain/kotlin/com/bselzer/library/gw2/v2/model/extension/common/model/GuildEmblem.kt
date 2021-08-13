package com.bselzer.library.gw2.v2.model.extension.common.model

import com.bselzer.library.gw2.v2.model.common.guild.emblem.GuildEmblem
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.guild.GuildEmblemFlag
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

/**
 * The [GuildEmblem.flags] as a collection of [GuildEmblemFlag]
 */
fun GuildEmblem.flags(): List<GuildEmblemFlag> = flags.validEnumValues()