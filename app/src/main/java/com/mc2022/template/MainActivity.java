package com.mc2022.template;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
        Log.i("start", "State of activity main changed from Create to Start");
        Toast.makeText(this, "State of activity main changed from Create to Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("pause", "State of activity main changed from Resume to Pause");
        Toast.makeText(this, "State of activity main changed from Resume to Pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("resume", "State of activity main changed from Start to Resume");
        Toast.makeText(this, "State of activity main changed from Start to Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("stop", "State of activity main changed from Pause to Stop");
        Toast.makeText(this, "State of activity main changed from Pause to Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("destroy", "State of activity main changed from Stop to Destroy");
        Toast.makeText(this, "State of activity main changed from Stop to Destroy", Toast.LENGTH_SHORT).show();
    }
}