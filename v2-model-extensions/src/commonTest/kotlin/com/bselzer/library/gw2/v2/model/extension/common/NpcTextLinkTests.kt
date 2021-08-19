package com.bselzer.library.gw2.v2.model.extension.common

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.NpcTextLink

class NpcTextLinkTests : IdLinkTests<NpcTextLink>()
{
    override val instance: NpcTextLink = NpcTextLink()

    override val mapping: Map<String, Int> = mapOf(
        "[&AxcnAAA=]" to 10007,
        "[&AxgnAAA=]" to 10008,
        "[&AxknAAA=]" to 10009,
        "[&AyAnAAA=]" to 10016
    )
}