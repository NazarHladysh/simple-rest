package ua.lviv.iot.DB_Lab.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DB_Lab.dto.InfoDto;
import ua.lviv.iot.DB_Lab.mapper.impl.InfoMapper;
import ua.lviv.iot.DB_Lab.model.Info;
import ua.lviv.iot.DB_Lab.repository.InfoRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/infos")
public class InfoController {

    final
    InfoMapper infoMapper;

    final
    InfoRepo infoRepo;

    public InfoController(InfoMapper infoMapper, InfoRepo infoRepo) {
        this.infoMapper = infoMapper;
        this.infoRepo = infoRepo;
    }
    
    @GetMapping("/{id}")
    public InfoDto getById(@PathVariable int id) {
        return infoMapper.convertToDto(infoRepo.getOne(id));
    }

    @GetMapping("/")
    public List<InfoDto> getAll() {
        List<Info> infos = infoRepo.findAll();
        List<InfoDto> infoDtos = new ArrayList<>();
        for (Info info : infos) {
            infoDtos.add(infoMapper.convertToDto(info));
        }
        return infoDtos;
    }

    @PostMapping
    public InfoDto create(@RequestBody InfoDto infoDto) {
        return infoMapper.convertToDto(infoRepo.save(infoMapper.convertToModel(infoDto)));
    }

    @PutMapping
    public InfoDto update(@RequestBody InfoDto infoDto) {
        return infoMapper.convertToDto(infoRepo.save(infoMapper.convertToModel(infoDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        infoRepo.deleteById(id);
    }
}
