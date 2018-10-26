package com.solomon.eyoel.midtermexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
/*
    Eyoel Demissie, Midterm 1, Android Java CIT 243, October 25, 2018
*/
public class MainActivity extends AppCompatActivity {

    // Variable declarations
    TextView mQuestions;
    Button mButtonNext;
    Button mButtonFinish;
    Button mButtonClear;
    RadioGroup mRadioGroup;
    RadioButton mRadio1;
    RadioButton mRadio2;
    TextView questionLabel;

    // Index of array and grade holder
    int mCurrentIndex = 0;
    int totalGrade= 0;
    ArrayList<MultipleChoice> questions = new ArrayList<>();

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign ID's to variables
        questionLabel = findViewById(R.id.numQuestions);
        mButtonClear = findViewById(R.id.clearButton);
        mQuestions = findViewById(R.id.txt_question);
        mButtonNext = findViewById(R.id.nextButton);
        mButtonFinish = findViewById(R.id.finishButton);
        mRadioGroup = findViewById(R.id.radioGroup);
        mRadio1 = findViewById(R.id.radio1);
        mRadio2 = findViewById(R.id.radio2);

        // create questions and add to list
        createQuestions();
        updateQuestion();

        // on click listeners
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadio = mRadioGroup.getCheckedRadioButtonId();
                boolean correctAnswer = checkAnswer(selectedRadio);

                if (correctAnswer) {
                    totalGrade += 5;
                    updateQuestion();
                }
                if (mCurrentIndex == questions.size() - 1) {
                    Toast.makeText(MainActivity.this, "No More Questions. Please Start Over", Toast.LENGTH_SHORT).show();
                }
                else if (mCurrentIndex < questions.size() )
                {
                    mCurrentIndex++;
                    updateQuestion();
                }
                Log.d(TAG, "onClick: " + mCurrentIndex + " / " + questions.size());
            }
        });

        mButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = 0;
                totalGrade = 0;
                updateQuestion();
            }
        });

        mButtonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalGrade == 100)
                    Toast.makeText(MainActivity.this, "Android Genius!", Toast.LENGTH_SHORT).show();
                else if (totalGrade >= 75)
                    Toast.makeText(MainActivity.this, "Proficiency in Android Programming", Toast.LENGTH_SHORT).show();
                else if (totalGrade >= 50)
                    Toast.makeText(MainActivity.this, "Marginal Proficiency in Android Programming", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "No Proficiency in Android Programming", Toast.LENGTH_SHORT).show();

                Log.d(TAG, "onClick: " + totalGrade);
            }
        });

    }

    // add questions to arrayList
    private void createQuestions() {
        questions.add(new MultipleChoice(R.string.question_1, R.string.radio1_choice01, R.string.radio2_choice1, R.id.radio1));
        questions.add(new MultipleChoice(R.string.question_2, R.string.radio1_choice2, R.string.radio2_choice2, R.id.radio1));
        questions.add(new MultipleChoice(R.string.question_3, R.string.radio1_choice3, R.string.radio2_choice3, R.id.radio1));
        questions.add(new MultipleChoice(R.string.question_4, R.string.radio1_choice4, R.string.radio2_choice4, R.id.radio2));
        questions.add(new MultipleChoice(R.string.question_5, R.string.radio1_choice5, R.string.radio2_choice5, R.id.radio2));
        questions.add(new MultipleChoice(R.string.question_6, R.string.radio1_choice6, R.string.radio2_choice6, R.id.radio1));
        questions.add(new MultipleChoice(R.string.question_7, R.string.radio1_choice7, R.string.radio2_choice7, R.id.radio2));
        questions.add(new MultipleChoice(R.string.question_8, R.string.radio1_choice8, R.string.radio2_choice8, R.id.radio2));
        questions.add(new MultipleChoice(R.string.question_9, R.string.radio1_choice9, R.string.radio2_choice9, R.id.radio2));
        questions.add(new MultipleChoice(R.string.question_10, R.string.radio1_choice10, R.string.radio2_choice10, R.id.radio1));
        questions.add(new MultipleChoice(R.string.question_11, R.string.radio1_choice11, R.string.radio2_choice11, R.id.radio1));
        questions.add(new MultipleChoice(R.string.question_12, R.string.radio1_choice12, R.string.radio2_choice12, R.id.radio2));
        questions.add(new MultipleChoice(R.string.question_13, R.string.radio1_choice13, R.string.radio2_choice13, R.id.radio1));
        questions.add(new MultipleChoice(R.string.question_14, R.string.radio1_choice14, R.string.radio2_choice14, R.id.radio1));
        questions.add(new MultipleChoice(R.string.question_15, R.string.radio1_choice15, R.string.radio2_choice15, R.id.radio2));
        questions.add(new MultipleChoice(R.string.question_16, R.string.radio1_choice16, R.string.radio2_choice16, R.id.radio2));
        questions.add(new MultipleChoice(R.string.question_17, R.string.radio1_choice17, R.string.radio2_choice17, R.id.radio1));
        questions.add(new MultipleChoice(R.string.question_18, R.string.radio1_choice18, R.string.radio2_choice18, R.id.radio1));
        questions.add(new MultipleChoice(R.string.question_19, R.string.radio1_choice19, R.string.radio2_choice19, R.id.radio1));
        questions.add(new MultipleChoice(R.string.question_20, R.string.radio1_choice20, R.string.radio2_choice20, R.id.radio2));

    }

    // check answer value
    public boolean checkAnswer(int radioId) {

        if (radioId == questions.get(mCurrentIndex).getRadioButtonId()) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            return true;
        }
        Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        return false;

    }

    // show next question
    public void updateQuestion(){
        int question = questions.get(mCurrentIndex).getQuestion();
        int choice1 = questions.get(mCurrentIndex).getChoice1();
        int choice2 = questions.get(mCurrentIndex).getChoice2();
        int questionNum = mCurrentIndex + 1;

        questionLabel.setText(questionNum + " / 20");
        mQuestions.setText(question);
        mRadio1.setText(choice1);
        mRadio2.setText(choice2);

    }
}
