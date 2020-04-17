package ua.lviv.iot.DB_Lab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppDto {

    private int id;

    private String name;

    private double size;

    private BigDecimal price;

    private int authorId;

    private float sale;

    private int install;

    private int delete;
}
