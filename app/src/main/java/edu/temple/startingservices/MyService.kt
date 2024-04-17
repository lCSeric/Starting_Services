package edu.temple.startingservices

import android.app.Service
import android.content.Intent
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyService: Service(){

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun startCountdown(value: Int){
        coroutineScope.launch {

            for (i in value downTo 0) {
                delay(1000)
                Log.d("MyService", "CountDown: $i")
            }
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val countdownValue = intent?.getIntExtra("countdownValue", 0 ) ?: 0
        startCountdown(countdownValue)
        return START_STICKY
    }


    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }
}