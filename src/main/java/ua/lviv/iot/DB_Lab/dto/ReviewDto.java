package ua.lviv.iot.DB_Lab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private int id;

    private String text;

    private int score;

    private int userId;

    private int appId;
}
