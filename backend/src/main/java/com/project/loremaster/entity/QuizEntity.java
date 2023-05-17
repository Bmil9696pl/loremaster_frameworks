package com.project.loremaster.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "quiz", schema = "loremaster", catalog = "loremaster")
public class QuizEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "quiz_id")
    private int quizId;
    @Basic
    @Column(name = "region")
    private Integer region;
    @Basic
    @Column(name = "question")
    private String question;
    @Basic
    @Column(name = "right_answer")
    private String rightAnswer;
    @Basic
    @Column(name = "wrong_answer1")
    private String wrongAnswer1;
    @Basic
    @Column(name = "wrong_answer2")
    private String wrongAnswer2;
    @Basic
    @Column(name = "wrong_answer3")
    private String wrongAnswer3;

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public void setWrongAnswer1(String wrongAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public void setWrongAnswer2(String wrongAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }

    public String getWrongAnswer3() {
        return wrongAnswer3;
    }

    public void setWrongAnswer3(String wrongAnswer3) {
        this.wrongAnswer3 = wrongAnswer3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizEntity that = (QuizEntity) o;
        return quizId == that.quizId && Objects.equals(region, that.region) && Objects.equals(question, that.question) && Objects.equals(rightAnswer, that.rightAnswer) && Objects.equals(wrongAnswer1, that.wrongAnswer1) && Objects.equals(wrongAnswer2, that.wrongAnswer2) && Objects.equals(wrongAnswer3, that.wrongAnswer3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quizId, region, question, rightAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3);
    }
}
