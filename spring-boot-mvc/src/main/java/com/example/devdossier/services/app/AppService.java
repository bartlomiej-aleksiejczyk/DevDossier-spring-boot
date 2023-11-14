package com.example.devdossier.services.app;

import com.example.devdossier.controllers.app.AppsRequestDTO;
import com.example.devdossier.models.app.App;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppService {
    private final AppDataService appDataService;

    public App saveApp(App app) {
        return appDataService.saveApp(app);
    }

    public Optional<App> getAppById(Long id) {
        return appDataService.getAppById(id);
    }

    public Page<App> getAllApps(AppsRequestDTO appsRequestDTO) {
        PageRequest pageable = PageRequest.of(
                Integer.parseInt(appsRequestDTO.getPage()),
                Integer.parseInt(appsRequestDTO.getSize()),
                Sort.Direction.valueOf(appsRequestDTO.getDirection()),
                appsRequestDTO.getSortParam());
        return appDataService.getAllApps(pageable);
    }

    public void deleteApp(Long id) {
        appDataService.deleteApp(id);
    }
}
