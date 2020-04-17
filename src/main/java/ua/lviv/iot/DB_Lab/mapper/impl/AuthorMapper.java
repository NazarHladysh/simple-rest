package ua.lviv.iot.DB_Lab.mapper.impl;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.dto.AuthorDto;
import ua.lviv.iot.DB_Lab.mapper.GeneralMapper;
import ua.lviv.iot.DB_Lab.model.Author;

@Component
public class AuthorMapper implements GeneralMapper<Author, AuthorDto> {
    @Override
    public AuthorDto convertToDto(Author model) {
        return AuthorDto.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

    @Override
    public Author convertToModel(AuthorDto dto) {
        return Author.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
