package com.bselzer.library.gw2.library


class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
