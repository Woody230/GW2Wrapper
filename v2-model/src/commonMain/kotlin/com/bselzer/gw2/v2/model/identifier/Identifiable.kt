package com.bselzer.gw2.v2.model.identifier

import kotlinx.serialization.SerialName

interface Identifiable<Id> {
    @SerialName("id")
    val id: Identifier<Id>
}