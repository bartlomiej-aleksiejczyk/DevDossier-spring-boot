package com.example.devdossier.repositories;

import com.example.devdossier.models.entry.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}