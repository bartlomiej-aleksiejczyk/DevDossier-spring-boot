package com.example.devdossier.repositories;

import com.example.devdossier.models.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}