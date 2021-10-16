package com.bselzer.library.gw2.v2.tile.image

import android.os.Environment
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ImageGeneratorTests {
    // NOTE: AndroidJUnit4 tests must be in the java directory, not the kotlin directory otherwise you will get "No tasks available" when trying to run the tests
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun writeWvwMap() {
        // Outputs to sdcard/Android/data/{{PackageName}}/files/download in View -> Tool Windows -> Device File Explorer
        runBlocking {
            val directory = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)!!.path
            ImageGenerator().generateWvwMap(directory)
        }
    }
}