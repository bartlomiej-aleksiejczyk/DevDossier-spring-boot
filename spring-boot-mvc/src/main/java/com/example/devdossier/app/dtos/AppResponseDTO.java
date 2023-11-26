package com.example.devdossier.app.dtos;

import java.time.LocalDateTime;

public record AppResponseDTO(
        String name,
        String description,
        String repoLink,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt,
        String authorName,
        String authorProfileLink) {

}
