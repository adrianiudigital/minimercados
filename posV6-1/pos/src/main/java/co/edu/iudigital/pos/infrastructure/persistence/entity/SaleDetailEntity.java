package co.edu.iudigital.pos.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "detalle_venta")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaleDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venta_id")
    SaleEntity sale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id")
    ProductEntity product;

    @Column(nullable = false)
    Integer quantity;

    @Column(name = "precio_unitario", nullable = false)
    Double unitPrice;

    @Column(name = "subtotal", nullable = false)
    Double subtotal;
}
