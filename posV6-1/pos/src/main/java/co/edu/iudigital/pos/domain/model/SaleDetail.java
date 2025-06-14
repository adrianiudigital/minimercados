package co.edu.iudigital.pos.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaleDetail {

    Long id;

    Long productId;

    Integer quantity;

    Double unitPrice;

    Double subtotal;
}
