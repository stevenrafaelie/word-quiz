package com.srl.N2quizsrl.repository;

import com.srl.N2quizsrl.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findTop100ByOrderByMasteryAsc();
    List<Word> findTop100By();
}
