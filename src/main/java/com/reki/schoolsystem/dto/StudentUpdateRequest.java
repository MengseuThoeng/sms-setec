package com.reki.schoolsystem.dto;

public record StudentUpdateRequest(
        String name,
        String sex,
        String email,
        Integer score
) {
}
