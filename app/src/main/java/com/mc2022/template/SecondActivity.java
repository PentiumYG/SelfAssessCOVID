package com.mc2022.template;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
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
    TextView userN;


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
        userN = (TextView)findViewById(R.id.userName);

        Intent i = getIntent();

        String uname = i.getStringExtra("Pname");
        userN.setText(uname);

        String ansFev = i.getStringExtra("ansFever");
        if(ansFev.equals("YES")){
            count++;
        }
        String ansR = i.getStringExtra("ansRN");
        if(ansR.equals("YES")){
            count++;
        }
        String ansS = i.getStringExtra("ansST");
        if(ansS.equals("YES")){
            count++;
        }
        String ansB = i.getStringExtra("ansBA");
        if(ansB.equals("YES")){
            count++;
        }
        String ansH = i.getStringExtra("ansHA");
        if(ansH.equals("YES")){
            count++;
        }
        String ansL = i.getStringExtra("ansLM");
        if(ansL.equals("YES")){
            count++;
        }
        String ansT = i.getStringExtra("ansTS");
        if(ansT.equals("YES")){
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
        Log.i("start", "State of activity main changed from Create to Start");
        Toast.makeText(this, "State of activity main changed from Create to Start", Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onPause() {
        super.onPause();
        Log.i("pause", "State of activity main changed from Create to Start");
        Toast.makeText(SecondActivity.this, "State of activity main changed from Resume to Pause", Toast.LENGTH_SHORT).show();
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