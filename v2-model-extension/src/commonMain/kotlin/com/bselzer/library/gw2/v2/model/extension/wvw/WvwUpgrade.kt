package com.bselzer.library.gw2.v2.model.extension.wvw

import com.bselzer.library.gw2.v2.model.wvw.upgrade.WvwUpgrade
import com.bselzer.library.gw2.v2.model.wvw.upgrade.WvwUpgradeTier
import kotlin.math.min

/**
 * Calculates the upgrade level based on the number of [yaksDelivered] satisfying the number of [WvwUpgradeTier.yaksRequired].
 *
 * @param yaksDelivered the number of yaks delivered to the associated objective
 * @return the level, or zero if no tiers are fulfilled
 */
fun WvwUpgrade.level(yaksDelivered: Int): Int {
    val tier = tier(yaksDelivered) ?: return 0
    return tiers.indexOf(tier) + 1
}

/**
 * Finds the current [WvwUpgradeTier] based on the number of [yaksDelivered] satisfying the number of [WvwUpgradeTier.yaksRequired].
 *
 * @param yaksDelivered the number of yaks delivered to the associated objective
 * @return the tier, or null if no tiers are fulfilled
 */
fun WvwUpgrade.tier(yaksDelivered: Int): WvwUpgradeTier? {
    var upgradeTier: WvwUpgradeTier? = null
    var yaksRequired = 0
    for (tier in tiers) {
        // Yaks required is for the current tier and is not cumulative so the tier order matters.
        yaksRequired += tier.yaksRequired
        if (yaksDelivered < yaksRequired) {
            // Since the requirement is not cumulative, then all remaining tiers are also not fulfilled.
            break
        }

        // Have enough yaks so it has been upgraded another level.
        upgradeTier = tier
    }

    return upgradeTier
}

/**
 * Calculates the ratio of delivered yaks to the total number of yaks required. The ratio is capped by the total.
 *
 * @param yaksDelivered the number of yaks delivered to the associated objective
 * @return the ratio represented as a pair
 */
fun WvwUpgrade.yakRatio(yaksDelivered: Int): Pair<Int, Int> {
    val total = tiers.sumOf { tier -> tier.yaksRequired }
    val delivered = min(yaksDelivered, total)
    return Pair(delivered, total)
}

/**
 * Determines whether the number of yaks delivered satisfies all upgrade tiers.
 *
 * @param yaksDelivered the number of yaks delivered to the associated objective
 * @return true if the number of [yaksDelivered] fulfills all of the [WvwUpgradeTier.yaksRequired]
 */
fun WvwUpgrade.isFullyUpgraded(yaksDelivered: Int): Boolean {
    val ratio = yakRatio(yaksDelivered)
    return ratio.first == ratio.second
}