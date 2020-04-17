package ua.lviv.iot.DB_Lab.mapper.impl;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.dto.ReviewDto;
import ua.lviv.iot.DB_Lab.mapper.GeneralMapper;
import ua.lviv.iot.DB_Lab.model.Review;
import ua.lviv.iot.DB_Lab.repository.AppRepo;
import ua.lviv.iot.DB_Lab.repository.UserRepo;

@Component
public class ReviewMapper implements GeneralMapper<Review, ReviewDto> {

    final AppRepo appRepo;

    final UserRepo userRepo;

    ReviewMapper(AppRepo appRepo, UserRepo userRepo) {
        this.appRepo = appRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ReviewDto convertToDto(Review model) {
        return ReviewDto.builder()
                .id(model.getId())
                .score(model.getScore())
                .text(model.getText())
                .appId(model.getApp().getId())
                .userId(model.getUser().getId())
                .build();
    }

    @Override
    public Review convertToModel(ReviewDto dto) {
        return Review.builder()
                .id(dto.getId())
                .score(dto.getScore())
                .text(dto.getText())
                .app(appRepo.getOne(dto.getAppId()))
                .user(userRepo.getOne(dto.getUserId()))
                .build();
    }
}
