package com.frangovers.petsociety.helpers

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.frangovers.petsociety.R

object ScreenManager {

    fun replaceFrame(activity: FragmentActivity?, fragment: Fragment, backStack: Boolean = false) {
        activity?.apply {
            if (backStack) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frame, fragment)
                    .addToBackStack(null)
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frame, fragment)
                    .commit()
            }
        }
    }

    fun replaceLayout(activity: FragmentActivity?, fragment: Fragment, backStack: Boolean = false) {
        activity?.apply {
            if (backStack) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_layout, fragment)
                    .addToBackStack(null)
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_layout, fragment)
                    .commit()
            }
        }
    }

}