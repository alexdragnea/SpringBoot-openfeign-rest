package net.dg.springbootopefeignrestapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse<T> {

    private T data;

}