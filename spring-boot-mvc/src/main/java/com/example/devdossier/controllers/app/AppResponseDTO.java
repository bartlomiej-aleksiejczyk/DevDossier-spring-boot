package com.example.devdossier.controllers.app;

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
