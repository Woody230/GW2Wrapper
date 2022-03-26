package com.bselzer.gw2.v2.model.template.build

import com.bselzer.ktx.value.identifier.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BuildTemplateTab(
    /**
     * The id and index of the tab.
     */
    @SerialName("tab")
    override val id: BuildTemplateTabId = BuildTemplateTabId(),

    /**
     * Whether this tab is the currently selected tab.
     */
    @SerialName("is_active")
    val isActive: Boolean = false,

    @SerialName("build")
    val build: BuildTemplate = BuildTemplate()
) : Identifiable<Int>