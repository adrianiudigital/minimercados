package co.edu.iudigital.pos.adapter;

import co.edu.iudigital.pos.adapter.mapper.SaleDetailMapper;
import co.edu.iudigital.pos.adapter.mapper.SaleMapper;
import co.edu.iudigital.pos.domain.model.Sale;
import co.edu.iudigital.pos.domain.model.SaleDetail;
import co.edu.iudigital.pos.infrastructure.persistence.*;
import co.edu.iudigital.pos.infrastructure.persistence.entity.*;
import co.edu.iudigital.pos.port.SalePort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleServiceAdapter implements SalePort {

    private final SaleMapper saleMapper = SaleMapper.INSTANCE;
    private final SaleDetailMapper saleDetailMapper = SaleDetailMapper.INSTANCE;

    private final JpaSaleRepository saleRepository;
    private final JpaSaleDetailRepository detailRepository;
    private final JpaProductRepository productRepository;
    private final JpaClientRepository clientRepository;
    private final JpaUserRepository userRepository;

    public SaleServiceAdapter(
            JpaSaleRepository saleRepository,
            JpaSaleDetailRepository detailRepository,
            JpaProductRepository productRepository,
            JpaClientRepository clientRepository,
            JpaUserRepository userRepository
    ) {
        this.saleRepository = saleRepository;
        this.detailRepository = detailRepository;
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Sale> getAll() {
        return saleRepository.findAll().stream()
                .map(saleMapper::toSale)
                .toList();
    }

    @Override
    public Sale getById(Long id) {
        return saleRepository.findById(id)
                .map(saleMapper::toSale)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    @Override
    public Sale save(Sale sale) {

        // Validar cliente y usuario
        ClientEntity client = clientRepository.findById(sale.getClientId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        UserEntity user = userRepository.findById(sale.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Crear entidad venta
        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setClient(client);
        saleEntity.setUser(user);
        saleEntity.setDate(LocalDateTime.now());

        List<SaleDetailEntity> detailEntities = new ArrayList<>();
        double total = 0.0;

        for (SaleDetail detail : sale.getDetails()) {
            ProductEntity product = productRepository.findById(detail.getProductId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + detail.getProductId()));

            if (product.getStock() < detail.getQuantity()) {
                throw new RuntimeException("Stock insuficiente para el producto: " + product.getName());
            }

            double subtotal = detail.getQuantity() * detail.getUnitPrice();
            total += subtotal;

            product.setStock(product.getStock() - detail.getQuantity());
            productRepository.save(product); // actualizar stock

            SaleDetailEntity detailEntity = new SaleDetailEntity();
            detailEntity.setSale(saleEntity);
            detailEntity.setProduct(product);
            detailEntity.setQuantity(detail.getQuantity());
            detailEntity.setUnitPrice(detail.getUnitPrice());
            detailEntity.setSubtotal(subtotal);

            detailEntities.add(detailEntity);
        }

        saleEntity.setTotal(total);
        saleEntity.setDetails(detailEntities);

        SaleEntity savedSale = saleRepository.save(saleEntity); // cascada guarda detalles

        return saleMapper.toSale(savedSale);
    }
}
