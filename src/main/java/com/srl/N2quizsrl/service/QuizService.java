package com.srl.N2quizsrl.service;

import com.srl.N2quizsrl.entity.Word;
import com.srl.N2quizsrl.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final WordRepository wordRepository;

    @Autowired
    public QuizService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<Word> getWord() {
        return wordRepository.findTop100ByOrderByMasteryAsc();
    }

    public void plusOneMasteryWord(Long theId) {
        Optional<Word> theWord = wordRepository.findById(theId);
        theWord.ifPresent(word -> word.setMastery(word.getMastery() + 1));
        wordRepository.save(theWord.get());
        System.out.println(theWord.get().getMastery());
    }

    public List<Word> getTheWord(){
        return wordRepository.findTop100By();
    }

    public Word getWordWithId(Long theId) {
        return wordRepository.findById(theId).get();
    }
}
