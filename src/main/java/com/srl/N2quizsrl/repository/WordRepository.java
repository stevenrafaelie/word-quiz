package com.srl.N2quizsrl.repository;

import com.srl.N2quizsrl.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
