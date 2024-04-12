package com.srl.N2quizsrl.model;

import com.srl.N2quizsrl.entity.Word;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuizForm {
    private Long question;
    private Long answer;
}
