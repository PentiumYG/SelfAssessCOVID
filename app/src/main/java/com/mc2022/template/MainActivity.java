package com.mc2022.template;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button nextButton;
    Button clearButton;
    Button buttonYes;
    Button buttonNo;
    TextView questionText;
    TextView personName;

    String fever = "Do you suffer from fever?";
    String runnyNose = "Do you have runny nose?";
    String scratchyThroat = "Do you suffer from scratchy throat?";
    String bodyAche = "Do you have body ache?";
    String headAche = "Do you suffer from head ache?";
    String looseMotion = "Do you suffer from loose motion?";
    String tasteSmell = "Are you able to taste and smell?";
    String submit = "SUBMIT";

    int nextCount=0;
    String ansFever;
    String ansRN;
    String ansST;
    String ansBA;
    String ansHA;
    String ansLM;
    String ansTS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fetching buttons ids.
        nextButton = (Button)findViewById(R.id.nextButton);
        clearButton = (Button)findViewById(R.id.clearButton);
        buttonNo = (Button)findViewById(R.id.buttonNo);
        buttonYes = (Button)findViewById(R.id.buttonYes);

        //Fetching TextView id.
        questionText = (TextView)findViewById(R.id.questionText);
        personName = (TextView)findViewById(R.id.PersonName);



//        questionText.setVisibility(View.GONE);
//        nextButton.setVisibility(View.GONE);
//        clearButton.setVisibility(View.GONE);
//        buttonYes.setVisibility(View.GONE);
//        buttonNo.setVisibility(View.GONE);
//
//
        String name = personName.getText().toString();
//        if(name == ""){
//            questionText.setVisibility(View.INVISIBLE);
//            nextButton.setVisibility(View.INVISIBLE);
//            clearButton.setVisibility(View.INVISIBLE);
//            buttonYes.setVisibility(View.INVISIBLE);
//            buttonNo.setVisibility(View.INVISIBLE);
//        }





        Log.i("create","Activity main is onCreate");

        if(nextCount==0){
            questionText.setText(fever);
            buttonYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ansFever = "YES";
                }
            });
            buttonNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ansFever = "NO";
                }
            });


        }
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextCount = nextCount + 1;
                if(nextCount == 1 ){
                    questionText.setText(runnyNose);
                    buttonYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ansRN = "YES";
                        }
                    });
                    buttonNo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ansRN = "NO";
                        }
                    });
                }
                if(nextCount == 2){
                    questionText.setText(scratchyThroat);
                    buttonYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ansST = "YES";
                        }
                    });
                    buttonNo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ansST = "NO";
                        }
                    });
                }
                if(nextCount == 3){
                    questionText.setText(bodyAche);
                    buttonYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ansBA = "YES";
                        }
                    });
                    buttonNo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ansBA = "NO";
                        }
                    });
                }
                if(nextCount == 4){
                    questionText.setText(headAche);
                    buttonYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ansHA = "YES";
                        }
                    });
                    buttonNo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ansHA = "NO";
                        }
                    });
                }
                if(nextCount == 5){
                    questionText.setText(looseMotion);
                    buttonYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ansLM = "YES";
                        }
                    });
                    buttonNo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ansLM = "NO";
                        }
                    });
                }
                if(nextCount == 6){
                    questionText.setText(tasteSmell);
                    buttonYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ansTS = "YES";
                        }
                    });
                    buttonNo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ansTS = "NO";
                        }
                    });
                    nextButton.setText(submit);

                }
                if(nextCount >= 7){
                    Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("ansFever", ansFever);
                    intent.putExtra("ansRN", ansRN);
                    intent.putExtra("ansST", ansST);
                    intent.putExtra("ansBA", ansBA);
                    intent.putExtra("ansHA", ansHA);
                    intent.putExtra("ansLM", ansLM);
                    intent.putExtra("ansTS", ansTS);
                    intent.putExtra("Pname", name);
                    startActivity(intent);
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