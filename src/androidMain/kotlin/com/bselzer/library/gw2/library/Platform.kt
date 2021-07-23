package com.bselzer.library.gw2.library

actual class Platform actual constructor()
{
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}