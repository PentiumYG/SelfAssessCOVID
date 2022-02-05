package com.mc2022.template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    TextView fever;
    TextView rn;
    TextView st;
    TextView ba;
    TextView ha;
    TextView lm;
    TextView ts;
    TextView ansResult;
    Button checkButton;
    TextView userName;


    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i("create","Activity second is onCreate");

        checkButton = (Button)findViewById(R.id.checkButton);
        fever = (TextView)findViewById(R.id.ansFever);
        rn = (TextView)findViewById(R.id.ansRunnyNose);
        st = (TextView)findViewById(R.id.ansScratchyThroat);
        ba = (TextView)findViewById(R.id.ansBodyAche);
        ha = (TextView)findViewById(R.id.ansHeadAche);
        lm = (TextView)findViewById(R.id.ansLooseMotion);
        ts = (TextView)findViewById(R.id.ansTansS);
        ansResult = (TextView)findViewById(R.id.ansResult);
        userName = (TextView)findViewById(R.id.userName);

        Intent i = getIntent();

        String uname = i.getStringExtra("Pname");
        userName.setText(uname);

        String ansFev = i.getStringExtra("ansFever");
        if(ansFev == "YES"){
            count++;
        }
        String ansR = i.getStringExtra("ansRN");
        if(ansR == "YES"){
            count++;
        }
        String ansS = i.getStringExtra("ansST");
        if(ansS == "YES"){
            count++;
        }
        String ansB = i.getStringExtra("ansBA");
        if(ansB == "YES"){
            count++;
        }
        String ansH = i.getStringExtra("ansHA");
        if(ansH == "YES"){
            count++;
        }
        String ansL = i.getStringExtra("ansLM");
        if(ansL == "YES"){
            count++;
        }
        String ansT = i.getStringExtra("ansTS");
        if(ansT == "YES"){
            count++;
        }

        //displaying answers given by user.
        fever.setText(ansFev);
        rn.setText(ansR);
        st.setText(ansS);
        ba.setText(ansB);
        ha.setText(ansH);
        lm.setText(ansL);
        ts.setText(ansT);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count > 3){
                    ansResult.setText("Please go for RT-PCR test!!.");
                }
                else{
                    ansResult.setText("RT-PCR test NOT required!!");
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("start", "Activity second is onStart");
        Toast.makeText(this, "State of activity main changed from Create to Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("pause", "Activity second is onPause");
        Toast.makeText(this, "State of activity main changed from Resume to Pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("resume", "Activity second is onResume");
        Toast.makeText(this, "State of activity main changed from Start to Resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("stop", "Activity second is onStop");
        Toast.makeText(this, "State of activity main changed from Pause to Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("destroy", "Activity second is onDestroy");
        Toast.makeText(this, "State of activity main changed from Stop to Destroy", Toast.LENGTH_SHORT).show();
    }
}