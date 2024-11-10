package com.example.demo.controller;

import com.example.demo.model.Greeting; 
import com.example.demo.model.GetQuestion; 
import com.example.demo.model.Count; 
import com.example.demo.model.questions.CurrentQuestionTrueFalse; 
import com.example.demo.model.questions.QuestionTrueFalse; 
import com.example.demo.model.questions.ArrayQuestionsTrueFalse; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping; 

@Controller 
public class HomeController {
	 @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/login")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(Greeting greeting, Model model) {
        String password = greeting.getPassword();
        String username = greeting.getUsername();

        // Check password validity
        if (username!=null && password != null && password.matches("^(?=.*[0-9])(?=.*[!@#\\$%\\^&*]).{8,}$")) {
			Count.count=0;
			CurrentQuestionTrueFalse.currentTFquestion = 0;  
			model.addAttribute("count", Count.getCount()); 
            model.addAttribute("answeredQuestions", CurrentQuestionTrueFalse.currentTFquestion);  // Track answered questions
           return "redirect:https://expert-halibut-97qp669w65wrfxj6-8080.app.github.dev/quiz";


        } else {
            return "badlogin";
        }
    }

    @GetMapping("/quiz")
    public String showQuizPage(Model model) {
      
        GetQuestion getQuestion = new GetQuestion();
        QuestionTrueFalse question = getQuestion.nextQuestion();

        // Check if all questions have been answered
        if (CurrentQuestionTrueFalse.currentTFquestion >= 4) {
            return "result";  // Redirect to result page if all questions are answered
        }

        model.addAttribute("question", question);
        model.addAttribute("count", Count.count); 
        return "quiz"; 
    }

     @PostMapping("/quiz/answer")
    public String checkAnswer(String answer, Model model) {
        GetQuestion getQuestion = new GetQuestion();
        QuestionTrueFalse currentQuestion = getQuestion.nextQuestion();
        
        boolean isCorrect = currentQuestion.getAnswer().toString().equals(answer);  

        if (isCorrect) {
            Count.increment();
        }


        CurrentQuestionTrueFalse.currentTFquestion++;


        if (CurrentQuestionTrueFalse.currentTFquestion >= 4) {
            return "redirect:https://expert-halibut-97qp669w65wrfxj6-8080.app.github.dev/result";  // Redirect to result page if all questions are answered
        }


        model.addAttribute("question", getQuestion.nextQuestion());
        model.addAttribute("count", Count.count);
        return "quiz";  
    }

    @GetMapping("/badlogin")
    public String showBadLoginPage() {
        return "badlogin";
    }

    @GetMapping("/result")
    public String showResultPage(Model model) {
        model.addAttribute("count", Count.count);
        return "result";
    }
}
