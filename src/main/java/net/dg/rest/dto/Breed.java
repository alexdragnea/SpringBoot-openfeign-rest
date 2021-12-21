package net.dg.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class Breed {

    @ApiModelProperty(value = "Name of the breed")
    private String name;

    @ApiModelProperty(value = "A list of breeds temperaments")
    private List<String> temperaments;

    @ApiModelProperty(value = "Description of the breed")
    private String description;

}