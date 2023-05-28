package com.project.loremaster.dto;

import com.project.loremaster.models.Leader;
import lombok.Builder;
import lombok.Data;

import java.sql.Struct;
import java.util.List;

@Data
@Builder
public class LeadersResponseDto {

    String username;
    String score;
}
