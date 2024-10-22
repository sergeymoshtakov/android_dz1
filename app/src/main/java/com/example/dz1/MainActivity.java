package com.example.dz1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.activity.ComponentActivity;

public class MainActivity extends ComponentActivity {
    private static final String TAG = "MainActivity";
    private long startTime = 0;
    private long resumeTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> Log.d(TAG, "Кнопка была нажата"));

        startTime = System.currentTimeMillis();
        Log.d(TAG, "onCreate вызван. Время: " + startTime);
    }

    @Override
    protected void onStart() {
        super.onStart();
        long onStartTime = System.currentTimeMillis();
        Log.d(TAG, "onStart вызван. Разница с onCreate: " + (onStartTime - startTime) + " мс");
    }

    @Override
    protected void onResume() {
        super.onResume();
        resumeTime = System.currentTimeMillis();
        Log.d(TAG, "onResume вызван. Разница с onCreate: " + (resumeTime - startTime) + " мс");
    }

    @Override
    protected void onPause() {
        super.onPause();
        long pauseTime = System.currentTimeMillis();
        Log.d(TAG, "onPause вызван. Разница с onResume: " + (pauseTime - resumeTime) + " мс");
    }

    @Override
    protected void onStop() {
        super.onStop();
        long stopTime = System.currentTimeMillis();
        Log.d(TAG, "onStop вызван. Разница с onPause: " + (stopTime - resumeTime) + " мс");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        long destroyTime = System.currentTimeMillis();
        Log.d(TAG, "onDestroy вызван. Время с onCreate: " + (destroyTime - startTime) + " мс");
    }
}
