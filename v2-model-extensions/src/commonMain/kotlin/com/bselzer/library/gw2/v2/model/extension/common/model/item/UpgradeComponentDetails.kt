package com.bselzer.library.gw2.v2.model.extension.common.model.item

import com.bselzer.library.gw2.v2.model.common.item.detail.UpgradeComponentDetails
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.InfusionUpgradeFlag
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.UpgradeComponentDetailType
import com.bselzer.library.gw2.v2.model.extension.common.enumeration.item.UpgradeComponentFlag
import com.bselzer.library.kotlin.extension.function.common.objects.enumValueOrNull
import com.bselzer.library.kotlin.extension.function.common.objects.validEnumValues

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