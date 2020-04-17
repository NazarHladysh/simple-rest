package ua.lviv.iot.DB_Lab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;

    private String name;

    private String surname;

    private Date birthDate;

    private String sex;

    private String email;

    private String photoUrl;

    private String phone;

    private int countryId;

}
