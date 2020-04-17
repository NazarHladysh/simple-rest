package ua.lviv.iot.DB_Lab.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.dto.UserDto;
import ua.lviv.iot.DB_Lab.mapper.GeneralMapper;
import ua.lviv.iot.DB_Lab.model.User;
import ua.lviv.iot.DB_Lab.repository.CountryRepo;

@Component
public class UserMapper implements GeneralMapper<User, UserDto> {

    @Autowired
    CountryRepo countryRepo;

    @Override
    public UserDto convertToDto(User model) {
        return UserDto.builder()
                .id(model.getId())
                .name(model.getName())
                .surname(model.getSurname())
                .birthDate(model.getBirthDate())
                .sex(model.getSex())
                .email(model.getEmail())
                .photoUrl(model.getPhotoUrl())
                .phone(model.getPhone())
                .countryId(model.getCountry().getId())
                .build();
    }

    @Override
    public User convertToModel(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .surname(dto.getSurname())
                .birthDate(dto.getBirthDate())
                .sex(dto.getSex())
                .email(dto.getEmail())
                .photoUrl(dto.getPhotoUrl())
                .phone(dto.getPhone())
                .country(countryRepo.getOne(dto.getCountryId()))
                .build();
    }
}
