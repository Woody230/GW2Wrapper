package com.bselzer.library.gw2.v2.model.extension.common

import com.bselzer.library.gw2.v2.model.extension.common.chatlink.RecipeLink

class RecipeLinkTests : IdLinkTests<RecipeLink>()
{
    override val instance: RecipeLink = RecipeLink()

    override val mapping: Map<String, Int> = mapOf(
        "[&CQEAAAA=]" to 1,
        "[&CQIAAAA=]" to 2,
        "[&CQcAAAA=]" to 7
    )
}