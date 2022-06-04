package com.bselzer.gw2.v2.intl.cache.operation

import com.bselzer.gw2.v2.intl.model.Translation
import com.bselzer.ktx.kodein.db.operation.clear
import com.bselzer.ktx.kodein.db.transaction.Transaction

/**
 * Clears the [Translation] models.
 */
fun Transaction.clearTranslation() {
    clear<Translation>()
}