package com.example.devdossier.repositories;

import com.example.devdossier.models.app.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<App, Long> {
}