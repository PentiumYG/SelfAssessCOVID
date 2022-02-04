package com.mc2022.template;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("create","Activity main is onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("start", "Activity main is onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("pause", "Activity main is onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("resume", "Activity main is onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("stop", "Activity main is onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("destroy", "Activity main is onDestroy");
    }
}