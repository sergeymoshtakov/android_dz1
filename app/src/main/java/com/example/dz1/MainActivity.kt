package com.example.dz1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    private var startTime: Long = 0
    private var resumeTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            Log.d(TAG, "Кнопка была нажата!")
        }

        startTime = System.currentTimeMillis()
        Log.d(TAG, "onCreate вызван. Время: $startTime")
    }

    override fun onStart() {
        super.onStart()
        val onStartTime = System.currentTimeMillis()
        Log.d(TAG, "onStart вызван. Разница с onCreate: ${onStartTime - startTime} мс")
    }

    override fun onResume() {
        super.onResume()
        resumeTime = System.currentTimeMillis()
        Log.d(TAG, "onResume вызван. Разница с onCreate: ${resumeTime - startTime} мс")
    }

    override fun onPause() {
        super.onPause()
        val pauseTime = System.currentTimeMillis()
        Log.d(TAG, "onPause вызван. Разница с onResume: ${pauseTime - resumeTime} мс")
    }

    override fun onStop() {
        super.onStop()
        val stopTime = System.currentTimeMillis()
        Log.d(TAG, "onStop вызван. Разница с onPause: ${stopTime - resumeTime} мс")
    }

    override fun onDestroy() {
        super.onDestroy()
        val destroyTime = System.currentTimeMillis()
        Log.d(TAG, "onDestroy вызван. Время с onCreate: ${destroyTime - startTime} мс")
    }
}