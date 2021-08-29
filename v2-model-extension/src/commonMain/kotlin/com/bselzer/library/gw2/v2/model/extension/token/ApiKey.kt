package com.bselzer.library.gw2.v2.model.extension.token

import com.bselzer.library.gw2.v2.model.extension.base.Validate
import kotlinx.serialization.Serializable

/**
 * An API key wrapper.
 */
@Serializable
data class ApiKey(val key: String) : Validate
{
    companion object
    {
        /**
         * The validation regex. The key is case-insensitive. Example value: 5954509A-5EE9-B24A-AD70-84181D85457D4F38FAB3-3AF5-4E87-8BA5-CA0988519447
         */
        private val regex: Regex =
            Regex("(?i)[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{20}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")

        /**
         * @return whether the api key is valid
         */
        fun isValid(key: String) = regex.matches(key)
    }

    /**
     * @return whether the api key is valid
     */
    override fun isValid(): Boolean = isValid(key)
}