package api.rest;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link entity.AirlineCompany} entity
 */
@Data
public class Api implements Serializable {
    private final Long airlineCompanyId;
}