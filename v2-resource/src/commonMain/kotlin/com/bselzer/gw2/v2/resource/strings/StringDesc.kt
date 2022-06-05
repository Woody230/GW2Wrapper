package com.bselzer.gw2.v2.resource.strings

import com.bselzer.gw2.v2.model.enumeration.WvwMapType
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveOwner
import com.bselzer.gw2.v2.model.enumeration.WvwObjectiveType
import com.bselzer.gw2.v2.resource.Gw2Resources
import com.bselzer.ktx.resource.KtxResources
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc

fun WvwObjectiveOwner.stringDesc(): StringDesc = when (this) {
    WvwObjectiveOwner.RED -> KtxResources.strings.red
    WvwObjectiveOwner.BLUE -> KtxResources.strings.blue
    WvwObjectiveOwner.GREEN -> KtxResources.strings.green
    WvwObjectiveOwner.NEUTRAL -> Gw2Resources.strings.neutral
}.desc()

fun WvwMapType.stringDesc(): StringDesc = when (this) {
    WvwMapType.ETERNAL_BATTLEGROUNDS -> Gw2Resources.strings.eternal_battlegrounds
    WvwMapType.RED_BORDERLANDS -> Gw2Resources.strings.red_borderlands
    WvwMapType.BLUE_BORDERLANDS -> Gw2Resources.strings.blue_borderlands
    WvwMapType.GREEN_BORDERLANDS -> Gw2Resources.strings.green_borderlands
    WvwMapType.EDGE_OF_THE_MISTS -> Gw2Resources.strings.edge_of_the_mists
}.desc()

fun WvwObjectiveType.stringDesc(): StringDesc = when (this) {
    WvwObjectiveType.CAMP -> Gw2Resources.strings.camp
    WvwObjectiveType.CASTLE -> Gw2Resources.strings.castle
    WvwObjectiveType.KEEP -> Gw2Resources.strings.keep
    WvwObjectiveType.MERCENARY -> Gw2Resources.strings.mercenary
    WvwObjectiveType.TOWER -> Gw2Resources.strings.tower
    WvwObjectiveType.RUINS -> Gw2Resources.strings.ruins
    WvwObjectiveType.RESOURCE -> Gw2Resources.strings.resource
    WvwObjectiveType.GENERIC -> Gw2Resources.strings.generic
    WvwObjectiveType.SPAWN -> Gw2Resources.strings.spawn
}.desc()