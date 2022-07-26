package com.bselzer.gw2.v2.client.options

interface Gw2HttpOptions : Gw2RequestOptions, Gw2ResponseOptions {
    companion object : Gw2HttpOptions, Gw2RequestOptions by Gw2RequestOptions, Gw2ResponseOptions by Gw2ResponseOptions
}