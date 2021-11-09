package net.dg.springbootopefeignrestapi.client;

import lombok.Data;

@Data
public class BreedApiResponse {

    private String id;
    private String name;
    private String temperament;
    private String description;

}