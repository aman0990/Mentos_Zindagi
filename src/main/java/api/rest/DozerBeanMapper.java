package api.rest;

import entity.Flight;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link entity.AirlineCompany} entity
 */
@Data
public class DozerBeanMapper implements Serializable {
    private final Long airlineCompanyId;
    private final String airlineCode;
    private final String name;
    private final List < Flight > flights;
}