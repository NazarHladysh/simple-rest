package ua.lviv.iot.DB_Lab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoDto {
    private int id;

    private int userId;

    private int appId;

    private Date purchaseDate;

    private BigDecimal purchasePrice;
}
