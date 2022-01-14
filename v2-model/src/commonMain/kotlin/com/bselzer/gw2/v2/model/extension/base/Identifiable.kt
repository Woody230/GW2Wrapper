package com.bselzer.gw2.v2.model.extension.base

import kotlinx.serialization.SerialName

interface Identifiable<Id> {
    @SerialName("id")
    val id: Id
}