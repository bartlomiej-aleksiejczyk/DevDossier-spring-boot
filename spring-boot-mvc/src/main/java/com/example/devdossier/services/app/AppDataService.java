package com.example.devdossier.services.app;
import com.example.devdossier.models.app.App;
import com.example.devdossier.repositories.AppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppDataService {
    private final AppRepository appRepository;
    public App saveApp(App app) {
        return appRepository.save(app);
    }

    public Optional<App> getAppById(Long id) {
        return appRepository.findById(id);
    }

    public Page<App> getAllApps(Pageable pageable) {
        return appRepository.findAll(pageable);
    }

    public void deleteApp(Long id) {
        appRepository.deleteById(id);
    }
}
