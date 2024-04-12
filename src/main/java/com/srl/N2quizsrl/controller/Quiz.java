package com.srl.N2quizsrl.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;

@Controller
public class Quiz {

    private final String QUESTION_NUMBER = "questionNumber";
    private final String SCORE_NUMBER = "scoreNumber";
    private final String LIST_OF_QUIZ_WORD = "listOfQuizWord";

    @GetMapping("/")
    public String getHome(HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession(true);
        httpSession.setAttribute(QUESTION_NUMBER, 0);
        httpSession.setAttribute(SCORE_NUMBER, 0);
        httpSession.setAttribute(LIST_OF_QUIZ_WORD, new ArrayList<Integer>());
        return "home";
    }

    @GetMapping("/quiz")
    public String getQuiz(HttpServletRequest httpServletRequest)  {
        return "quiz";
    }
}
