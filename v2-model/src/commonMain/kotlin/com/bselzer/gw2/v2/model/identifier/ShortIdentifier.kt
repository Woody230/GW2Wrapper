package com.bselzer.gw2.v2.model.identifier

interface ShortIdentifier : Identifier<Short> {
    override val isDefault: Boolean
        get() = value <= 0
}