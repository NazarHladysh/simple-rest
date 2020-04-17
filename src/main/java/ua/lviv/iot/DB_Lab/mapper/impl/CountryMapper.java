package ua.lviv.iot.DB_Lab.mapper.impl;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.dto.CountryDto;
import ua.lviv.iot.DB_Lab.mapper.GeneralMapper;
import ua.lviv.iot.DB_Lab.model.Country;

@Component
public class CountryMapper implements GeneralMapper<Country, CountryDto> {
    @Override
    public CountryDto convertToDto(Country model) {
        return CountryDto.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

    @Override
    public Country convertToModel(CountryDto dto) {
        return Country.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
