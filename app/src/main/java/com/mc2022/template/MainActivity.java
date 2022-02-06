package com.mc2022.template;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button nextButton;
    Button clearButton;
    Button buttonYes;
    Button buttonNo;
    TextView questionText;
    EditText personName;
    Button done;

    String fever = "Do you suffer from fever?";
    String runnyNose = "Do you have runny nose?";
    String scratchyThroat = "Do you suffer from scratchy throat?";
    String bodyAche = "Do you have body ache?";
    String headAche = "Do you suffer from head ache?";
    String looseMotion = "Do you suffer from loose motion?";
    String tasteSmell = "Are you able to taste and smell?";
    String submit = "SUBMIT";

    int nextCount=0;
    int doneClick = 0;
    int clear = 0;

    String ansFever;
    String ansRN;
    String ansST;
    String ansBA;
    String ansHA;
    String ansLM;
    String ansTS;
    String name;



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("FEVER_KEY", fever);
        outState.putString("RN_KEY", runnyNose);
        outState.putString("ST_KEY", scratchyThroat);
        outState.putString("BA_KEY", bodyAche);
        outState.putString("HA_KEY", headAche);
        outState.putString("LM_KEY", looseMotion);
        outState.putString("TS_KEY", tasteSmell);
//
        outState.putString("FEVER", ansFever);
        outState.putString("RN", ansRN);
        outState.putString("ST", ansST);
        outState.putString("BA", ansBA);
        outState.putString("HA", ansHA);
        outState.putString("LM", ansLM);
        outState.putString("TS", ansTS);
//
        outState.putInt("NEXT_COUNT", nextCount);
        outState.putInt("DONE_CLICK", doneClick);
        outState.putInt("CLEAR", clear);
        outState.putString("QUESTION_TEXT", questionText.getText().toString());
        outState.putString("PERSON_NAME", personName.getText().toString());
        outState.putString("PNAME", name);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        doneClick = savedInstanceState.getInt("DONE_CLICK");
        clear = savedInstanceState.getInt("CLEAR");

        personName.setText(savedInstanceState.getString("PERSON_NAME"));
        questionText.setText(savedInstanceState.getString("QUESTION_TEXT"));

        nextCount = savedInstanceState.getInt("NEXT_COUNT");

        ansFever = savedInstanceState.getString("FEVER");
        ansRN = savedInstanceState.getString("RN");
        ansST = savedInstanceState.getString("ST");
        ansBA = savedInstanceState.getString("BA");
        ansHA = savedInstanceState.getString("HA");
        ansLM = savedInstanceState.getString("LM");
        ansTS = savedInstanceState.getString("TS");

        fever = savedInstanceState.getString("FEVER_KEY");
        runnyNose = savedInstanceState.getString("RN_KEY");
        scratchyThroat = savedInstanceState.getString("ST_KEY");
        bodyAche = savedInstanceState.getString("BA_KEY");
        headAche = savedInstanceState.getString("HA_KEY");
        looseMotion = savedInstanceState.getString("LM_KEY");
        tasteSmell = savedInstanceState.getString("TS_KEY");

        name = savedInstanceState.getString("PNAME");


        if(doneClick==1 && !name.equals("") && clear==0){
            done.setVisibility(View.GONE);
            questionText.setVisibility(View.VISIBLE);
            nextButton.setVisibility(View.VISIBLE);
            clearButton.setVisibility(View.VISIBLE);
            buttonYes.setVisibility(View.VISIBLE);
            buttonNo.setVisibility(View.VISIBLE);
        }
        if(clear==1){
            done.setVisibility(View.VISIBLE);
            questionText.setVisibility(View.INVISIBLE);
            nextButton.setVisibility(View.INVISIBLE);
            clearButton.setVisibility(View.INVISIBLE);
            buttonYes.setVisibility(View.INVISIBLE);
            buttonNo.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fetching buttons ids.
        nextButton = (Button)findViewById(R.id.nextButton);
        clearButton = (Button)findViewById(R.id.clearButton);
        buttonNo = (Button)findViewById(R.id.buttonNo);
        buttonYes = (Button)findViewById(R.id.buttonYes);
        done = (Button)findViewById(R.id.doneButton);

        //Fetching TextView id.
        questionText = (TextView)findViewById(R.id.questionText);
        personName = (EditText)findViewById(R.id.PersonName);

        name = personName.getText().toString();


//        if(savedInstanceState != null && doneClick==1){
//
//            done.setVisibility(View.GONE);
//
//            ansFever = savedInstanceState.getString("FEVER");
//            ansRN = savedInstanceState.getString("RN");
//            ansST = savedInstanceState.getString("ST");
//            ansBA = savedInstanceState.getString("BA");
//            ansHA = savedInstanceState.getString("HA");
//            ansLM = savedInstanceState.getString("LM");
//            ansTS = savedInstanceState.getString("TS");
//
//            nextCount = savedInstanceState.getInt("NEXT_COUNT");
//            doneClick = savedInstanceState.getInt("DONE_CLICK");
////
//            fever = savedInstanceState.getString("FEVER_KEY");
//            runnyNose = savedInstanceState.getString("RN_KEY");
//            scratchyThroat = savedInstanceState.getString("ST_KEY");
//            bodyAche = savedInstanceState.getString("BA_KEY");
//            headAche = savedInstanceState.getString("HA_KEY");
//            looseMotion = savedInstanceState.getString("LM_KEY");
//            tasteSmell = savedInstanceState.getString("TS_KEY");
//
//            questionText.setVisibility(View.VISIBLE);
//            nextButton.setVisibility(View.VISIBLE);
//            clearButton.setVisibility(View.VISIBLE);
//            buttonYes.setVisibility(View.VISIBLE);
//            buttonNo.setVisibility(View.VISIBLE);
//
//
//        }

        Log.i("create","Activity main is onCreate");




        if(name.equals("")){
            questionText.setVisibility(View.INVISIBLE);
            nextButton.setVisibility(View.INVISIBLE);
            clearButton.setVisibility(View.INVISIBLE);
            buttonYes.setVisibility(View.INVISIBLE);
            buttonNo.setVisibility(View.INVISIBLE);
        }

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doneClick = 1;
                clear = 0;
                name = personName.getText().toString();
                if(name.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
                else{
                    done.setVisibility(View.GONE);
                    nextCount = 0;
                    questionText.setVisibility(View.VISIBLE);
                    nextButton.setVisibility(View.VISIBLE);
                    clearButton.setVisibility(View.VISIBLE);
                    buttonYes.setVisibility(View.VISIBLE);
                    buttonNo.setVisibility(View.VISIBLE);
                    questionText.setText(fever);
                    nextButton.setText("NEXT");
                    buttonYes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(name.equals("")){
                                Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                            }
                            ansFever = "YES";
                        }
                    });
                    buttonNo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(name.equals("")){
                                Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                            }
                            ansFever = "NO";
                        }
                    });
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear = 1;
                nextCount = 0;
                personName.setText("");
                ansFever = "";
                ansRN = "";
                ansST = "";
                ansBA = "";
                ansHA = "";
                ansLM = "";
                ansTS = "";
                done.setVisibility(View.VISIBLE);
                questionText.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.INVISIBLE);
                clearButton.setVisibility(View.INVISIBLE);
                buttonYes.setVisibility(View.INVISIBLE);
                buttonNo.setVisibility(View.INVISIBLE);
            }
        });



        if(nextCount==0){

            questionText.setText(fever);
            buttonYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(name.equals("")){
                        Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    }
                    ansFever = "YES";
                }
            });
            buttonNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(name.equals("")){
                        Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    }
                    ansFever = "NO";
                }
            });


        }





        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // nextCount = nextCount + 1;
                if((ansFever == "YES" || ansFever == "NO") && !name.equals("")){
                    nextCount = 1;
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
                if((ansRN == "YES" || ansRN == "NO") && !name.equals("")){
                    nextCount = 2;
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
                if((ansST == "YES" || ansST == "NO") && !name.equals("")){
                    nextCount = 3;
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
                if((ansBA == "YES" || ansBA == "NO") && !name.equals("")){
                    nextCount = 4;
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
                if((ansHA == "YES" || ansHA == "NO") && !name.equals("")){
                    nextCount = 5;
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
                if((ansLM == "YES" || ansLM == "NO") && !name.equals("")){
                    nextCount = 6;
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
                if(nextButton.getText().toString() == submit  && (ansTS == "YES" || ansTS == "NO") && !name.equals("")){
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
                else{
                    Toast.makeText(MainActivity.this, "Please select either 'YES' or 'NO'!!", Toast.LENGTH_SHORT).show();
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