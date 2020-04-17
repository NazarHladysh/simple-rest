package ua.lviv.iot.DB_Lab.mapper.impl;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.dto.AppDto;
import ua.lviv.iot.DB_Lab.mapper.GeneralMapper;
import ua.lviv.iot.DB_Lab.model.App;
import ua.lviv.iot.DB_Lab.repository.AuthorRepo;

@Component
public class AppMapper implements GeneralMapper<App, AppDto> {

    final AuthorRepo authorRepo;

    AppMapper(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public AppDto convertToDto(App model) {
        return AppDto.builder()
                .id(model.getId())
                .name(model.getName())
                .delete(model.getDelete())
                .install(model.getInstall())
                .price(model.getPrice())
                .sale(model.getSale())
                .size(model.getSize())
                .authorId(model.getAuthor().getId())
                .build();
    }

    @Override
    public App convertToModel(AppDto dto) {
        return App.builder()
                .id(dto.getId())
                .name(dto.getName())
                .delete(dto.getDelete())
                .install(dto.getInstall())
                .price(dto.getPrice())
                .sale(dto.getSale())
                .size(dto.getSize())
                .author(authorRepo.getOne(dto.getAuthorId()))
                .build();
    }
}
