package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:
        Button mTrueButton;
        Button mFalseButton;


    // TODO: Uncomment to create question bank
//    private TrueFalse[] mQuestionBank = new TrueFalse[] {
//            new TrueFalse(R.string.question_1, true),
//            new TrueFalse(R.string.question_2, true),
//            new TrueFalse(R.string.question_3, true),
//            new TrueFalse(R.string.question_4, true),
//            new TrueFalse(R.string.question_5, true),
//            new TrueFalse(R.string.question_6, false),
//            new TrueFalse(R.string.question_7, true),
//            new TrueFalse(R.string.question_8, false),
//            new TrueFalse(R.string.question_9, true),
//            new TrueFalse(R.string.question_10, true),
//            new TrueFalse(R.string.question_11, false),
//            new TrueFalse(R.string.question_12, false),
//            new TrueFalse(R.string.question_13,true)
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);

        double x = 5.99;
        int y = (int)x;
        Log.d("DebInfo","y=" + y);

        View.OnClickListener myOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DebugInfo","Listener: True button pressed");
                Toast myToast = Toast.makeText(getApplicationContext(),"True button pressed",Toast.LENGTH_LONG);
                myToast.show();
            }
        };

        mTrueButton.setOnClickListener(myOnClickListener);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DebugInfo","Listener: False button pressed");
                Toast.makeText(getApplicationContext(),"False button pressed",Toast.LENGTH_LONG).show();
            }
        });

        TrueFalse exQuestion = new TrueFalse(R.string.question_1,true);


    }
}
