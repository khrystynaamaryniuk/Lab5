package com.example.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.demo.model.Greeting;
import com.example.demo.model.questions.QuestionTrueFalse; 
import com.example.demo.model.Count;
class ModelTests {

    // Test for Greeting model
    @Test
    void testGreeting() {
        Greeting greeting = new Greeting();
        greeting.setUsername("test");
        greeting.setPassword("password!");

        assertEquals("test", greeting.getUsername());
        assertEquals("password!", greeting.getPassword());
    }
    @Test
      void testCountSettersAndGetters() {
        Count count = new Count();
        count.increment();
        assertEquals(1, count.getCount());
    }


    @Test
    void testQuestionTrueFalse() {
        QuestionTrueFalse question = new QuestionTrueFalse();
        question.setQuestion("This is true");
        question.setAnswer(true);

        assertEquals("This is true", question.getQuestion());
        assertTrue(question.getAnswer());
    }
}