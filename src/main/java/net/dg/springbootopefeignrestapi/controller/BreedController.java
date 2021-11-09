package net.dg.springbootopefeignrestapi.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dg.springbootopefeignrestapi.dto.ApiResponse;
import net.dg.springbootopefeignrestapi.dto.Breed;
import net.dg.springbootopefeignrestapi.service.BreedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/v1/breeds")
public class BreedController {

    private final BreedService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Breed>>> viewBreeds(@RequestParam(required = false) Integer page,
                                                               @RequestParam(required = false) Integer limit) {
        return ResponseEntity.ok(ApiResponse.<List<Breed>>builder()
                .data(service.getBreeds(page, limit))
                .build());
    }


}