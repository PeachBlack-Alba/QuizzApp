package com.example.udacity_quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int question4_Answer = R.id.radio_true_rightAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickSubmit(View view) {
        int totalScore = 0;

        if (answerQuestionOne()) {
            totalScore += 20;
        }

        if (answerQuestionTwo()) {
            totalScore += 20;
        }

        if (answerQuestionThree()) {
            totalScore += 20;
        }

        if (questionFourAnswer()) {
            totalScore += 20;
        }

        if (answerQuestionFive()) {
            totalScore += 20;
        }

        if (totalScore < 66) {
            Toast toast = Toast.makeText(getApplicationContext(), "Test Failed! " + totalScore, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Test Passed! " + totalScore, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }
    }

    public String testTakerNameGreeting(String testerName) {
        return "Start " + testerName;
    }

    public boolean answerQuestionOne() {
        CheckBox boxPhython = (CheckBox) findViewById(R.id.q1_ans4);
        CheckBox boxJS = (CheckBox) findViewById(R.id.q1_ans2);
        CheckBox boxUIUX = (CheckBox) findViewById(R.id.q1_ans3);
        CheckBox boxDBMS = (CheckBox) findViewById(R.id.q1_ans1);
        boolean isDBMS = boxDBMS.isChecked();
        boolean isUIUX = boxUIUX.isChecked();
        boolean isJS = boxJS.isChecked();
        boolean isPhython = boxPhython.isChecked();

        if (isJS && isPhython && !isUIUX && !isDBMS) {
            return true;
        } else {
            return false;
        }
    }

    public boolean answerQuestionTwo() {
        CheckBox boxPoint = (CheckBox) findViewById(R.id.q2_ans4);
        CheckBox boxNosql = (CheckBox) findViewById(R.id.q2_ans3);
        CheckBox boxEnterprise = (CheckBox) findViewById(R.id.q2_ans2);
        CheckBox boxSpreadsheets = (CheckBox) findViewById(R.id.q2_ans1);
        boolean isPoint = boxPoint.isChecked();
        boolean isNosql = boxNosql.isChecked();
        boolean isSpreadsheets = boxSpreadsheets.isChecked();
        boolean isEnterprise = boxEnterprise.isChecked();

        if (isPoint && isNosql && !isSpreadsheets && !isEnterprise) {
            return true;
        } else {
            return false;
        }
    }

    public boolean answerQuestionThree() {
        EditText answerThree = (EditText) findViewById(R.id.editText2);
        String answerQuestionThree = answerThree.getText().toString();
        String rightAnswer = "Problem solving";

        if (answerQuestionThree.equalsIgnoreCase(rightAnswer)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean questionFourAnswer() {
        RadioGroup rgQuestionFour = (RadioGroup) findViewById(R.id.radio_group_questionfour);

        if (rgQuestionFour.getCheckedRadioButtonId() == question4_Answer) return true;
        else return false;
    }

    public boolean answerQuestionFive() {
        CheckBox boxPhotoshop = (CheckBox) findViewById(R.id.q5_ans1);
        CheckBox boxIllustrator = (CheckBox) findViewById(R.id.q5_ans3);
        CheckBox boxSpreadsheets = (CheckBox) findViewById(R.id.q5_ans2);
        CheckBox boxNoSQL = (CheckBox) findViewById(R.id.q5_ans4);
        boolean isPhotoshop = boxPhotoshop.isChecked();
        boolean isIllustrator = boxIllustrator.isChecked();
        boolean isSpreadsheets = boxSpreadsheets.isChecked();
        boolean isNoSQL = boxNoSQL.isChecked();

        if (isPhotoshop && isIllustrator && !isSpreadsheets && !isNoSQL) {
            return true;
        } else {
            return false;
        }
    }

    public void submitName(View view) {
        EditText editText1 = (EditText) findViewById(R.id.editText_enter_name);
        String testerName = editText1.getText().toString();
        TextView giveGreeting = (TextView) findViewById(R.id.greeting);
        giveGreeting.setText(testTakerNameGreeting(testerName));
    }
}




