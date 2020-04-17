package ua.lviv.iot.DB_Lab.mapper.impl;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.dto.InfoDto;
import ua.lviv.iot.DB_Lab.mapper.GeneralMapper;
import ua.lviv.iot.DB_Lab.model.Info;
import ua.lviv.iot.DB_Lab.repository.AppRepo;
import ua.lviv.iot.DB_Lab.repository.UserRepo;

@Component
public class InfoMapper implements GeneralMapper<Info, InfoDto> {

    final AppRepo appRepo;

    final UserRepo userRepo;

    InfoMapper(AppRepo appRepo, UserRepo userRepo) {
        this.appRepo = appRepo;
        this.userRepo = userRepo;
    }

    @Override
    public InfoDto convertToDto(Info model) {
        return InfoDto.builder()
                .id(model.getId())
                .purchaseDate(model.getPurchaseDate())
                .purchasePrice(model.getPurchasePrice())
                .appId(model.getApp().getId())
                .userId(model.getUser().getId())
                .build();
    }

    @Override
    public Info convertToModel(InfoDto dto) {
        return Info.builder()
                .id(dto.getId())
                .purchaseDate(dto.getPurchaseDate())
                .purchasePrice(dto.getPurchasePrice())
                .app(appRepo.getOne(dto.getAppId()))
                .user(userRepo.getOne(dto.getUserId()))
                .build();
    }
}
