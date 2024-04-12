package com.srl.N2quizsrl.service;

import com.srl.N2quizsrl.entity.Word;
import com.srl.N2quizsrl.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    private final WordRepository wordRepository;

    @Autowired
    public QuizService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word getWord(Long theId) {
        return wordRepository.getReferenceById(theId);
    }
}
