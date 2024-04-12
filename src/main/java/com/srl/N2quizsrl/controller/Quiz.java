package com.srl.N2quizsrl.controller;

import com.srl.N2quizsrl.entity.Word;
import com.srl.N2quizsrl.model.QuizForm;
import com.srl.N2quizsrl.service.QuizService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
public class Quiz {

    private final String QUESTION_NUMBER = "questionNumber";
    private final String SCORE_NUMBER = "scoreNumber";
    private final String LIST_OF_QUIZ_WORD = "listOfQuizWord";
    private final Integer WORD_LIMITER = 100;
    private final QuizService quizService;

    @Autowired
    public Quiz(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/home")
    public String getHome(HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession(true);
        httpSession.setAttribute(QUESTION_NUMBER, 0);
        httpSession.setAttribute(SCORE_NUMBER, 0);
        httpSession.setAttribute(LIST_OF_QUIZ_WORD, new ArrayList<Long>());
        return "home";
    }

    @GetMapping("/quiz")
    public String getQuiz(HttpServletRequest httpServletRequest,
                          Model model)  {
        String referer = httpServletRequest.getHeader("referer");
        //Check referer
        if (!referer.contains("/home") && !referer.contains("/answer")) {
            return "redirect:/";
        }
        //get session
        HttpSession httpSession = httpServletRequest.getSession();
        Integer questionNumber = (Integer) httpSession.getAttribute(QUESTION_NUMBER);
        Integer scoreNumber = (Integer) httpSession.getAttribute(SCORE_NUMBER);
        List<Long> listOfWord = (ArrayList<Long>) httpSession.getAttribute(LIST_OF_QUIZ_WORD);

        //If more than 10 question to final
        if (questionNumber >= 10) {
            return "redirect:/final";
        }
        //add quiz number + 1
        scoreNumber += 1;
        httpSession.setAttribute(QUESTION_NUMBER, scoreNumber);

        //fetch random word by random number from 0 to word limit
        Random rand = new Random();
        int randomNumber = rand.nextInt(WORD_LIMITER);
        Word question  = quizService.getWord((long) randomNumber);
        listOfWord.add(question.getId());
        httpSession.setAttribute(LIST_OF_QUIZ_WORD,listOfWord);
        model.addAttribute("question", question);
        //add option word
        List<Long> wordIds = new ArrayList<>();
        wordIds.add(question.getId());
        List<Word> wordList = new ArrayList<>();
        while (wordIds.size() < 4) {
            //Generate number
            int randomNumberLoop = rand.nextInt(WORD_LIMITER) + 1;
            //Check if that number is used
            if (!wordIds.contains((long) randomNumberLoop)) {
                //add to wordId if not used
                wordIds.add((long) randomNumberLoop);
            }
        }
        for (Long wordId : wordIds) {
            //add word
            Word word = quizService.getWord(wordId);
            wordList.add(word);
        }
        //Shuffling word
        Collections.shuffle(wordList);
        model.addAttribute("options", wordList);
        QuizForm quizForm = new QuizForm();
        quizForm.setQuestion(question.getId());
        model.addAttribute("myForm", quizForm);
        return "quiz";
    }

    @PostMapping("/answer")
    public String answer(@ModelAttribute(value = "myForm") QuizForm quizForm,
                         Model model) {
        boolean status =  false;
        if (quizForm.getQuestion().equals(quizForm.getAnswer())) {
            status = true;
        }
        model.addAttribute("status", status);
        return "conclusion";
    }
}
