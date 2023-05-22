package com.project.loremaster.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class QuestionRequestDto {
    String regionId;
    String pastQuestionId;
}
