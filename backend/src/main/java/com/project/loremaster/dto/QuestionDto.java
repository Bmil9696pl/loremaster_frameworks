package com.project.loremaster.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class QuestionDto {
    String questionId;
    String question;
    String right_answer;
    String wrong_answer1;
    String wrong_answer2;
    String wrong_answer3;
}
