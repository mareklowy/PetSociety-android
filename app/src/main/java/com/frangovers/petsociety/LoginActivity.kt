package com.frangovers.petsociety

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frangovers.petsociety.fragments.LoginFragment
import com.frangovers.petsociety.helpers.ScreenManager

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ScreenManager.replaceFrame(this, LoginFragment())
    }
}
