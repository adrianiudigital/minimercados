package co.edu.iudigital.pos.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Provider {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;

    String nit;

    String name;

    String address;

    String phone;

    @JsonProperty(value = "web_site")
    String webSite;

    @JsonProperty(value="created_at", access = JsonProperty.Access.READ_ONLY)
    LocalDateTime createdAt;

    @JsonProperty(value="updated_at", access = JsonProperty.Access.READ_ONLY)
    LocalDateTime updatedAt;
}
