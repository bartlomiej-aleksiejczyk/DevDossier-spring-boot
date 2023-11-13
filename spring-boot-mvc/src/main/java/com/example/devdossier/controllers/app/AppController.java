package com.example.devdossier.controllers.app;
import com.example.devdossier.models.app.App;
import com.example.devdossier.repositories.AppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/app")
public class AppController {

    private final AppRepository appRepository;


    public List<App> getAllApps(AppRequestDTO appRequestDTO) {

        PageRequest pageRequest = PageRequest.of(
                Integer.parseInt(appRequestDTO.getPage()),
                Integer.parseInt(appRequestDTO.getSize()),
                Sort.Direction.valueOf(appRequestDTO.getDirection()),
                appRequestDTO.getSortParam());

        return appRepository.findAll();
    }
}
