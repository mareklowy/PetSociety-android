package com.frangovers.petsociety

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frangovers.petsociety.fragments.LatestArticlesFragment
import com.frangovers.petsociety.helpers.ScreenManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(main_toolbar)

        ScreenManager.replaceFrame(this, LatestArticlesFragment().apply {
            //Set Data Here
        }, false)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

//CRASH TEST
//Crashlytics.getInstance().crash()
