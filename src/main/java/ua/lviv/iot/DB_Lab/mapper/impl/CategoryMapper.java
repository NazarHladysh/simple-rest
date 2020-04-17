package ua.lviv.iot.DB_Lab.mapper.impl;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.dto.CategoryDto;
import ua.lviv.iot.DB_Lab.mapper.GeneralMapper;
import ua.lviv.iot.DB_Lab.model.Category;

@Component
public class CategoryMapper implements GeneralMapper<Category, CategoryDto> {
    @Override
    public CategoryDto convertToDto(Category model) {
        return CategoryDto.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

    @Override
    public Category convertToModel(CategoryDto dto) {
        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
