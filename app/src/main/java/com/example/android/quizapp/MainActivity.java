package com.example.android.quizapp;

import android.content.Context;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  //  private final static String Q1ANS = "Paris";
   // private final static String Q2ANS = "Gabrielle Bonheur Coco Chanel";
    private final static String Q3ANS = "Belgium";
 //   private final static String Q4ANS = "Michael Burke";
    private final static String Q5ANS = "7";
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.submit_button);
        submit.setOnClickListener(v->onSubmitButtonPressed());

    }
    public void checkQuiz () {

        ArrayList<String> wrongAnswers = new ArrayList<>();
        int correctQuestions = 0;
        if (checkQ1()) {
            correctQuestions++;
        } else {
            wrongAnswers.add("Question 1");
        }
        if (checkQ2()) {
            correctQuestions++;
        } else {
            wrongAnswers.add("Question 2");
        }
        if (checkQ3()) {
            correctQuestions++;
        } else {
            wrongAnswers.add("Question 3");
        }
        if (checkQ4()) {
            correctQuestions++;
        } else {
            wrongAnswers.add("Question 4");
        }
        if (checkQ5()) {
            correctQuestions++;
        } else {
            wrongAnswers.add("Question 5");
        }
        if (checkQ6()) {
            correctQuestions++;
        }else {
            wrongAnswers.add("Question 6");
        }
        StringBuilder sb = new StringBuilder();
        for (String s : wrongAnswers) {
            sb.append(s);
            sb.append("\n");
        }
        Context context = getApplicationContext();
        CharSequence text = "You got " + correctQuestions + "/6 answers right. Recheck the following:" + sb.toString();
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    private boolean checkQ6() {
        CheckBox c1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox c2 = (CheckBox) findViewById(R.id.checkbox2);
        CheckBox c3 = (CheckBox) findViewById(R.id.checkbox3);
        CheckBox c4 = (CheckBox) findViewById(R.id.checkbox4);
        CheckBox c5 = (CheckBox) findViewById(R.id.checkbox5);

        if (c1.isChecked() && c2.isChecked() && c3.isChecked() && !c4.isChecked() && !c5.isChecked()){
            return true;
        } else {
            return false;
        }

    }

    private void onSubmitButtonPressed() {
        checkQuiz();
    }

    private boolean checkQ5() {
        String ans = getQ5ans();
        if (ans.trim().equalsIgnoreCase(Q5ANS)){
            return true;
        } else {
            return false;
        }

    }
    private String getQ5ans(){
        EditText uInput = (EditText) findViewById(R.id.question5Ans);
        String ans = uInput.getText().toString();
        return ans;
    }

    private boolean checkQ4() {
        RadioButton question4ans = (RadioButton) findViewById(R.id.question4Ans);
        boolean isQ4Checked = question4ans.isChecked();
        if (isQ4Checked){
            return true;
        } else {
            return false;
        }
    }

    private boolean checkQ3() {
        String ans = getQ3ANS();
        if (ans.trim().equalsIgnoreCase(Q3ANS)){
            return true;
        } else {
            return false;
        }

    }
    private String getQ3ANS(){
        EditText userInput = (EditText) findViewById(R.id.question3Ans);
        String ans = userInput.getText().toString();
        return ans;
    }


    private boolean checkQ2() {
        RadioButton question2Ans = (RadioButton) findViewById(R.id.question2Ans);
        boolean isQ2AnsChecked = question2Ans.isChecked();
        if (isQ2AnsChecked) {
            return true;
        } else {
            return false;
        }

    }

    private boolean checkQ1() {
        RadioButton question1Ans = (RadioButton) findViewById(R.id.question1Ans);

        boolean isQuestion1RightAnsChecked = question1Ans.isChecked();

        if (isQuestion1RightAnsChecked) {
            return true;
        } else {
            return false;
        }
    }

}
