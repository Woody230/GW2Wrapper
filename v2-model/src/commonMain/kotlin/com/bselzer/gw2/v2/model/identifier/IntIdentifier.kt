package com.bselzer.gw2.v2.model.identifier

interface IntIdentifier : Identifier<Int> {
    override val isDefault: Boolean
        get() = value <= 0
}