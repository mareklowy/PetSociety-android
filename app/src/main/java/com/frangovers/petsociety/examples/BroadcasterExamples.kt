package com.frangovers.petsociety.examples

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.frangovers.petsociety.helpers.Constants

object BroadcasterExamples {

    // - RECEIVER -

    //First you set up instance of BroadcastReceiver
    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            //One fragment can respond to several actions
            //We will use when statement to determine which action has been called
            when (intent?.action) {

                //Actions are defined in Constants file
                Constants.exampleAction -> {
                    onActionReceived()
                }
            }
        }
    }

    private fun onActionReceived() {
        //Do stuff that should happen on notification
    }

    fun onCreateView(context: Context) {
        //Register notifications
        val filter = IntentFilter().apply {
            //We will add all actions we want to listen to into the filter
            addAction(Constants.exampleAction)
        }
        LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, filter)
    }

    //Remenber to unsubscibe from notifications when fragment is about to be destroyed
    fun onDestroy(context: Context) {
        LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver)
    }

    // - SENDER -

    //We send notification with concrete action
    private fun sendAction(context: Context) {
        val intent = Intent(Constants.exampleAction)
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent)
    }
}