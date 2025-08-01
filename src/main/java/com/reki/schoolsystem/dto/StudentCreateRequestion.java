package com.reki.schoolsystem.dto;

public record StudentCreateRequestion(
        String name,
        String sex,
        String email,
        Integer score
) {
}
