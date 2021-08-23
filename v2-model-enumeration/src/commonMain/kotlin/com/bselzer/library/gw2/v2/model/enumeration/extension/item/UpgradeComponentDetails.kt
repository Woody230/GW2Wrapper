package com.bselzer.library.gw2.v2.model.enumeration.extension.item

import com.bselzer.library.gw2.v2.model.enumeration.item.InfusionUpgradeFlag
import com.bselzer.library.gw2.v2.model.enumeration.item.UpgradeComponentDetailType
import com.bselzer.library.gw2.v2.model.enumeration.item.UpgradeComponentFlag
import com.bselzer.library.gw2.v2.model.item.detail.UpgradeComponentDetails
import com.bselzer.library.kotlin.extension.serialization.common.function.enumValueOrNull
import com.bselzer.library.kotlin.extension.serialization.common.function.validEnumValues

/**
 * The [UpgradeComponentDetails.type] as an [UpgradeComponentDetailType]
 */
fun UpgradeComponentDetails.type(): UpgradeComponentDetailType? = type.enumValueOrNull<UpgradeComponentDetailType>()

/**
 * The [UpgradeComponentDetails.flags] as a collection of [UpgradeComponentFlag]
 */
fun UpgradeComponentDetails.flags(): List<UpgradeComponentFlag> = flags.validEnumValues()

/**
 * The [UpgradeComponentDetails.infusionUpgradeFlags] as a collection of [InfusionUpgradeFlag]
 */
fun UpgradeComponentDetails.infusionUpgradeFlags(): List<InfusionUpgradeFlag> = infusionUpgradeFlags.validEnumValues()