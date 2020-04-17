package ua.lviv.iot.DB_Lab.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DB_Lab.dto.AuthorDto;
import ua.lviv.iot.DB_Lab.mapper.impl.AuthorMapper;
import ua.lviv.iot.DB_Lab.model.Author;
import ua.lviv.iot.DB_Lab.repository.AuthorRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    final
    AuthorRepo authorRepo;

    final
    AuthorMapper authorMapper;

    public AuthorController(AuthorRepo authorRepo, AuthorMapper authorMapper) {
        this.authorRepo = authorRepo;
        this.authorMapper = authorMapper;
    }
    
    @GetMapping("/{id}")
    public AuthorDto getById(@PathVariable int id) {
        return authorMapper.convertToDto(authorRepo.getOne(id));
    }

    @GetMapping("/")
    public List<AuthorDto> getAll() {
        List<Author> authors = authorRepo.findAll();
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (Author author : authors) {
            authorDtos.add(authorMapper.convertToDto(author));
        }
        return authorDtos;
    }

    @PostMapping
    public AuthorDto create(@RequestBody AuthorDto authorDto) {
        return authorMapper.convertToDto(authorRepo.save(authorMapper.convertToModel(authorDto)));
    }

    @PutMapping
    public AuthorDto update(@RequestBody AuthorDto authorDto) {
        return authorMapper.convertToDto(authorRepo.save(authorMapper.convertToModel(authorDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        authorRepo.deleteById(id);
    }
}
