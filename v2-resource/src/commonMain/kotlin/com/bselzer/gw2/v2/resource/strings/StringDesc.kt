package com.bselzer.gw2.v2.resource.strings

import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.ktx.resource.KtxResources
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc

/**
 * @return the [StringDesc] representing the objective owner
 */
fun WvwObjectiveOwner.stringDesc(): StringDesc = when (this) {
    WvwObjectiveOwner.RED -> KtxResources.strings.red
    WvwObjectiveOwner.BLUE -> KtxResources.strings.blue
    WvwObjectiveOwner.GREEN -> KtxResources.strings.green
    WvwObjectiveOwner.NEUTRAL -> KtxResources.strings.gray
}.desc()