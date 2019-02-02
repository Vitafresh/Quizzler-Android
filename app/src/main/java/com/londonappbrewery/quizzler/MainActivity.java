package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:
        Button mTrueButton;
        Button mFalseButton;

        TextView mQuestionTextView;
        TextView mScoreTextView;
        ProgressBar mProgressBar;

        int mScore = 0;
        int mIndexQuestion = 0;
        int mQuestionID;



    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);

        mQuestionTextView=(TextView)findViewById(R.id.question_text_view);
        mScoreTextView=(TextView)findViewById(R.id.score);

        mProgressBar=(ProgressBar)findViewById(R.id.progress_bar);
        mProgressBar.setMax(mQuestionBank.length);  //Number of questions
        mProgressBar.setProgress(1);                //First question (in progress)



//        TrueFalse firstQuestion = mQuestionBank[mIndexQuestion];
//        int questionID = firstQuestion.getmQuestionID();
//        mQuestionTextView.setText(questionID);
        mQuestionTextView.setText(mQuestionBank[mIndexQuestion].getmQuestionID());


        //Set callback for True button
        View.OnClickListener trueOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DebugInfo","Listener: True button pressed");

                checkAnswer(true);
                updateQuestion();

//                Toast myToast = Toast.makeText(getApplicationContext(),"True button pressed",Toast.LENGTH_LONG);
//                myToast.show();
            }
        };
        mTrueButton.setOnClickListener(trueOnClickListener);

        //Set callback for False button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DebugInfo","Listener: False button pressed");

                checkAnswer(false);
                updateQuestion();
            }
        });



    }

    private void updateQuestion(){
//        mIndexQuestion = (mIndexQuestion + 1) % mQuestionBank.length;
        mIndexQuestion++;
        if(mIndexQuestion >= mQuestionBank.length){
//            mIndexQuestion--;
            return;
        };
        mQuestionTextView.setText(mQuestionBank[mIndexQuestion].getmQuestionID());
        mProgressBar.setProgress(mIndexQuestion+1);
    }

    private void checkAnswer(boolean userSelected){
        if(mIndexQuestion >= mQuestionBank.length){
            return;
        };
        boolean correctAnswer = mQuestionBank[mIndexQuestion].isAnswer();
        if(userSelected==correctAnswer){
            mScore++;
            mScoreTextView.setText("Score: "+ Integer.toString(mScore) + " of " + mQuestionBank.length);
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

}
