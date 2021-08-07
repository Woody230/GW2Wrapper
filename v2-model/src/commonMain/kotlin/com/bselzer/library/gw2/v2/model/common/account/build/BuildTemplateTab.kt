package com.bselzer.library.gw2.v2.model.common.account.build

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuildTemplateTab(
    /**
     * The id and index of the tab.
     */
    @SerialName("tab")
    val id: Int = 0,

    /**
     * Whether this tab is the currently selected tab.
     */
    @SerialName("is_active")
    val isActive: Boolean = false,

    @SerialName("build")
    val build: BuildTemplate = BuildTemplate()
)