package com.frangovers.petsociety

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frangovers.petsociety.fragments.ExampleFragment
import com.frangovers.petsociety.helpers.ScreenManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Example of fragment call from an activity
        ScreenManager.replaceFrame(this, ExampleFragment().apply {
            fragmentText = this@MainActivity.getString(R.string.example_fragment_1) ?: ""
        }, false)
    }
}
