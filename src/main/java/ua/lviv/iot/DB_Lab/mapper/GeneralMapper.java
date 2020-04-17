package ua.lviv.iot.DB_Lab.mapper;

public interface GeneralMapper<M, D> {

     D convertToDto(M model);

     M convertToModel(D dto);
}
