package com.example.devdossier.app;

import com.example.devdossier.app.dtos.AppsRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppService {
    private final AppRepository appRepository;
    public App saveApp(App app) {
        return appRepository.save(app);
    }

    public Optional<App> getAppById(Long id) {
        return appRepository.findById(id);
    }


    public void deleteApp(Long id) {
        appRepository.deleteById(id);
    }

    public Page<App> getAllApps(AppsRequestDTO appsRequestDTO) {
        PageRequest pageable = PageRequest.of(
                Integer.parseInt(appsRequestDTO.getPage()),
                Integer.parseInt(appsRequestDTO.getSize()),
                Sort.Direction.valueOf(appsRequestDTO.getDirection()),
                appsRequestDTO.getSortParam());
        return appRepository.findAll(pageable);
    }

}
