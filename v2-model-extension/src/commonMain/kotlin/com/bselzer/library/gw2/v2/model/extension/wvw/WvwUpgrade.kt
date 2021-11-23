package com.bselzer.library.gw2.v2.model.extension.wvw

import com.bselzer.library.gw2.v2.model.wvw.upgrade.WvwUpgrade
import com.bselzer.library.gw2.v2.model.wvw.upgrade.WvwUpgradeTier

/**
 * Calculates the upgrade level based on the number of [yaksDelivered] satisfying the number of [WvwUpgradeTier.yaksRequired].
 *
 * @return the level
 */
fun WvwUpgrade.level(yaksDelivered: Int): Int {
    var level = 0
    var yaksRequired = 0
    for (tier in tiers) {
        // Yaks required is for the current tier and is not cumulative so the tier order matters.
        yaksRequired += tier.yaksRequired
        if (yaksDelivered < yaksRequired) {
            // Since the requirement is not cumulative, then all remaining tiers are also not fulfilled.
            break
        }

        // Have enough yaks so it has been upgraded another level.
        level += 1
    }

    return level
}