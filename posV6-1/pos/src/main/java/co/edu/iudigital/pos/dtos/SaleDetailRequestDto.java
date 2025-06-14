package co.edu.iudigital.pos.dtos;

import lombok.Data;

@Data
public class SaleDetailRequestDto {
    private Long productId;
    private Integer quantity;
}

