package com.example.demo.model;

import com.example.demo.model.questions.ArrayQuestionsTrueFalse;
import com.example.demo.model.questions.QuestionTrueFalse;
import com.example.demo.model.questions.CurrentQuestionTrueFalse;

public class GetQuestion {
    private ArrayQuestionsTrueFalse questionList;

    public GetQuestion() {
        questionList = new ArrayQuestionsTrueFalse();
    }

    public QuestionTrueFalse nextQuestion() {
        // Get the current question based on the current index
        return questionList.nextQuestion(CurrentQuestionTrueFalse.currentTFquestion);
    }
}