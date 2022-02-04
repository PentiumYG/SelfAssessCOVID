package com.mc2022.template;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("create","Activity second is onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("start", "Activity second is onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("pause", "Activity second is onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("resume", "Activity second is onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("stop", "Activity second is onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("destroy", "Activity second is onDestroy");
    }
}