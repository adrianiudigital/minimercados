package co.edu.iudigital.pos.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    Long id;

    String name;

    String description;

    Double price;

    Integer stock;

    Long categoryId;

    Long providerId;
}
