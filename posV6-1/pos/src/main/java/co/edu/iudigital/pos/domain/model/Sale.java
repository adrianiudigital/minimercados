package co.edu.iudigital.pos.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sale {

    Long id;

    LocalDateTime date;

    Double total;

    Long clientId;

    Long userId;

    List<SaleDetail> details;
}
