package co.edu.iudigital.pos.dtos;

import java.util.List;

public class SaleRequest {

    private Long clientId;
    private List<SaleDetailDTO> details;

    // Getters y setters

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<SaleDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<SaleDetailDTO> details) {
        this.details = details;
    }
}
