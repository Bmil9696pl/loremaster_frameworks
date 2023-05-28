package com.project.loremaster.models;

public interface LeaderRepo {
    String getUsername();
    Integer getScore();

    default String getUsernameString(){
        return getUsername();
    }

    default String getScoreString(){
        return getScore().toString();
    }
}
