package com.example.demo.model.questions;

import java.util.ArrayList;
import java.util.List;

public class ArrayQuestionsTrueFalse {
    private static List<QuestionTrueFalse> arrayListQuestionsTF = new ArrayList<>();
    private int totalQuestions = 0;

    public ArrayQuestionsTrueFalse() {
        arrayListQuestionsTF.add(new QuestionTrueFalse("The earth is the 3rd planet from its star", true));
        arrayListQuestionsTF.add(new QuestionTrueFalse("The earth and mars have the same atmosphere", false));
        arrayListQuestionsTF.add(new QuestionTrueFalse("Saturn is the largest planet", false));
        arrayListQuestionsTF.add(new QuestionTrueFalse("Jupiter is the largest planet", true));

        totalQuestions = arrayListQuestionsTF.size();
    }

    // Return the next question based on the index i
    public QuestionTrueFalse nextQuestion(int i) {
        return arrayListQuestionsTF.get(i % totalQuestions);  // Handle the wrapping logic if all questions are used
    }
}
