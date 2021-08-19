package com.bselzer.library.gw2.v2.model.extension.common

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.MapLink

class MapLinkTests : IdLinkTests<MapLink>()
{
    override val instance: MapLink = MapLink()

    override val mapping: Map<String, Int> = mapOf(
        "[&BDgAAAA=]" to 56,
        "[&BEgAAAA=]" to 72,
        "[&BDkDAAA=]" to 825,
    )
}