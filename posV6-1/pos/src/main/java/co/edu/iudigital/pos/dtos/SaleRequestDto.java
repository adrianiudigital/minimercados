package co.edu.iudigital.pos.dtos;

import lombok.Data;
import java.util.List;

@Data
public class SaleRequestDto {
    private Long clientId;
    private List<SaleDetailRequestDto> details;
}

