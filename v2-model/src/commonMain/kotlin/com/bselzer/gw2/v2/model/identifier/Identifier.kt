package com.bselzer.gw2.v2.model.identifier

interface Identifier<T> {
    val value: T
    val isDefault: Boolean
}