package ua.lviv.iot.DB_Lab.controller;

import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DB_Lab.dto.ReviewDto;
import ua.lviv.iot.DB_Lab.mapper.impl.ReviewMapper;
import ua.lviv.iot.DB_Lab.model.Review;
import ua.lviv.iot.DB_Lab.repository.ReviewRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    
    final
    ReviewMapper reviewMapper;
    
    final
    ReviewRepo reviewRepo;

    public ReviewController(ReviewMapper reviewMapper, ReviewRepo reviewRepo) {
        this.reviewMapper = reviewMapper;
        this.reviewRepo = reviewRepo;
    }

    @GetMapping("/{id}")
    public ReviewDto getById(@PathVariable int id) {
        return reviewMapper.convertToDto(reviewRepo.getOne(id));
    }

    @GetMapping("/")
    public List<ReviewDto> getAll() {
        List<Review> users = reviewRepo.findAll();
        List<ReviewDto> reviewDtos = new ArrayList<>();
        for (Review user : users) {
            reviewDtos.add(reviewMapper.convertToDto(user));
        }
        return reviewDtos;
    }

    @PostMapping
    public ReviewDto create(@RequestBody ReviewDto reviewDto) {
        return reviewMapper.convertToDto(reviewRepo.save(reviewMapper.convertToModel(reviewDto)));
    }

    @PutMapping
    public ReviewDto update(@RequestBody ReviewDto reviewDto) {
        return reviewMapper.convertToDto(reviewRepo.save(reviewMapper.convertToModel(reviewDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        reviewRepo.deleteById(id);
    }
}
