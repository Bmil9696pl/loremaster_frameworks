package com.project.loremaster.models;

import javax.persistence.*;

@Entity(name = "Quiz")
public class Quiz {

    @Id
    @SequenceGenerator(
            name = "question_sequence",
            sequenceName = "question_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "question_sequence"
    )
    private long quiz_id;
    private int region;
    private String question;
    private String right_answer;
    private String wrong_answer1;
    private String wrong_answer2;
    private String wrong_answer3;

    public Quiz(int region, String question, String rightAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
        this.region = region;
        this.question = question;
        this.right_answer = rightAnswer;
        this.wrong_answer1 = wrongAnswer1;
        this.wrong_answer2 = wrongAnswer2;
        this.wrong_answer3 = wrongAnswer3;
    }

    public Quiz() {

    }

    public long getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(long quiz_id) {
        this.quiz_id = quiz_id;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRight_answer() {
        return right_answer;
    }

    public void setRight_answer(String right_answer) {
        this.right_answer = right_answer;
    }

    public String getWrong_answer1() {
        return wrong_answer1;
    }

    public void setWrong_answer1(String wrong_answer1) {
        this.wrong_answer1 = wrong_answer1;
    }

    public String getWrong_answer2() {
        return wrong_answer2;
    }

    public void setWrong_answer2(String wrong_answer2) {
        this.wrong_answer2 = wrong_answer2;
    }

    public String getWrong_answer3() {
        return wrong_answer3;
    }

    public void setWrong_answer3(String wrong_answer3) {
        this.wrong_answer3 = wrong_answer3;
    }
}
