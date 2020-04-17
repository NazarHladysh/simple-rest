package ua.lviv.iot.DB_Lab.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DB_Lab.dto.AppDto;
import ua.lviv.iot.DB_Lab.mapper.impl.AppMapper;
import ua.lviv.iot.DB_Lab.model.App;
import ua.lviv.iot.DB_Lab.repository.AppRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apps")
public class AppController {

    final
    AppRepo appRepo;

    final
    AppMapper appMapper;

    public AppController(AppRepo appRepo, AppMapper appMapper) {
        this.appRepo = appRepo;
        this.appMapper = appMapper;
    }
    
    @GetMapping("/{id}")
    public AppDto getById(@PathVariable int id) {
        return appMapper.convertToDto(appRepo.getOne(id));
    }

    @GetMapping("/")
    public List<AppDto> getAll() {
        List<App> apps = appRepo.findAll();
        List<AppDto> appDtos = new ArrayList<>();
        for (App app : apps) {
            appDtos.add(appMapper.convertToDto(app));
        }
        return appDtos;
    }

    @PostMapping
    public AppDto create(@RequestBody AppDto appDto) {
        return appMapper.convertToDto(appRepo.save(appMapper.convertToModel(appDto)));
    }

    @PutMapping
    public AppDto update(@RequestBody AppDto appDto) {
        return appMapper.convertToDto(appRepo.save(appMapper.convertToModel(appDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        appRepo.deleteById(id);
    }
}
