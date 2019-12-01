package com.frangovers.petsociety

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frangovers.petsociety.fragments.LatestArticlesFragment
import com.frangovers.petsociety.helpers.ScreenManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Example of fragment call from an activity
        ScreenManager.replaceFrame(this, LatestArticlesFragment().apply {
            //Set Data Here
        }, false)
    }

    override fun onStart() {
        super.onStart()

    }
}
