package co.edu.iudigital.pos.dtos;

public class SaleDetailDTO {

    private Long productId;
    private int quantity;

    // Getters y setters

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
