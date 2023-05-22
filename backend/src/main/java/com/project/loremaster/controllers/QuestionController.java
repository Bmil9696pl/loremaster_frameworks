package com.project.loremaster.controllers;

import com.project.loremaster.dto.QuestionDto;
import com.project.loremaster.dto.QuestionRequestDto;
import com.project.loremaster.entity.QuizEntity;
import com.project.loremaster.repositories.QuizRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/question")
public class QuestionController {
    private final QuizRepository quizRepository;

    public QuestionController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @PostMapping("/get")
    ResponseEntity<QuestionDto> getQuestion(@RequestBody QuestionRequestDto questionRequestDto){
        String[] numbers = questionRequestDto.getPastQuestionId().split(";");
        Integer[] pastQuestionId = new Integer[numbers.length];
        for(int c = 0; c < numbers.length; c++) pastQuestionId[c] = Integer.parseInt(numbers[c]);
        QuizEntity question = quizRepository.findQuestion(Integer.parseInt(questionRequestDto.getRegionId()), pastQuestionId).orElse(null);


        return ResponseEntity.ok(QuestionDto.builder().questionId(String.valueOf(question.getQuizId())).question(question.getQuestion()).right_answer(question.getRightAnswer()).wrong_answer1(question.getWrongAnswer1()).wrong_answer2(question.getWrongAnswer2()).wrong_answer3(question.getWrongAnswer3()).build());
    }
}
