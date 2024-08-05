package com.example.eternal_bloom2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView, setAnswer;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD/*, ansE, ansF, ansG, ansH, ansI, ansJ*/;
    Button submitBtn;

    int score=0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        setAnswer = findViewById(R.id.textView20);
        /*ansE = findViewById(R.id.ans_E);
        ansF = findViewById(R.id.ans_F);
        ansG = findViewById(R.id.ans_G);
        ansH = findViewById(R.id.ans_H);
        ansI = findViewById(R.id.ans_I);
        ansJ = findViewById(R.id.ans_J);*/

        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
       /* ansE.setOnClickListener(this);
        ansF.setOnClickListener(this);
        ansG.setOnClickListener(this);
        ansH.setOnClickListener(this);
        ansI.setOnClickListener(this);
        ansJ.setOnClickListener(this);*/
        submitBtn.setOnClickListener(this);

        //totalQuestionsTextView.setText("Total questions : "+totalQuestion);

        loadNewQuestion();




    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        setAnswer.setText(QuestionAnswer.info[currentQuestionIndex]);
        setAnswer.setVisibility(View.VISIBLE);
        //Toast.makeText(this,QuestionAnswer.info[currentQuestionIndex],Toast.LENGTH_LONG ).show();
      /*  ansE.setBackgroundColor(Color.WHITE);
        ansF.setBackgroundColor(Color.WHITE);
        ansG.setBackgroundColor(Color.WHITE);
        ansH.setBackgroundColor(Color.WHITE);
        ansI.setBackgroundColor(Color.WHITE);
        ansJ.setBackgroundColor(Color.WHITE);*/


        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                score++;
            }
            //Toast.makeText(this,QuestionAnswer.info[currentQuestionIndex],Toast.LENGTH_LONG ).show();
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.parseColor("#E90064"));


        }

    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
       /* ansE.setText(QuestionAnswer.choices[currentQuestionIndex][4]);
        ansF.setText(QuestionAnswer.choices[currentQuestionIndex][5]);
        ansG.setText(QuestionAnswer.choices[currentQuestionIndex][6]);
        ansH.setText(QuestionAnswer.choices[currentQuestionIndex][7]);
        ansI.setText(QuestionAnswer.choices[currentQuestionIndex][8]);
        ansJ.setText(QuestionAnswer.choices[currentQuestionIndex][9]);*/

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+" out of "+ totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();


    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }

}
