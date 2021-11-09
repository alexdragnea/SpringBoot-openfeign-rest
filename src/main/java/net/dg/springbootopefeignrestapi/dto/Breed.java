package net.dg.springbootopefeignrestapi.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class Breed {

    private String name;
    private List<String> temperaments;
    private String description;

}