package net.dg.rest.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dg.rest.dto.ApiResponse;
import net.dg.rest.dto.Breed;
import net.dg.rest.dto.BreedCategories;
import net.dg.rest.service.BreedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/v1")
public class BreedController {

    private final BreedService service;

    @GetMapping("/breeds")
    public ResponseEntity<ApiResponse<List<Breed>>> viewBreeds(@RequestParam(required = false) Integer page,
                                                               @RequestParam(required = false) Integer limit) {
        return ResponseEntity.ok(ApiResponse.<List<Breed>>builder()
                .data(service.getBreeds(page, limit))
                .build());
    }

    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<List<BreedCategories>>> viewBreedCategories(@RequestParam(required = false) Integer page,
                                                                         @RequestParam(required = false) Integer limit) {
        return ResponseEntity.ok(ApiResponse.<List<BreedCategories>>builder()
                .data(service.getBreedCategories(page, limit))
                .build());
    }

    @GetMapping("/breeds/search")
    public ResponseEntity<ApiResponse<List<Breed>>> searchBreed(@RequestParam String q) {
        return ResponseEntity.ok(ApiResponse.<List<Breed>>builder()
                .data(service.findBreedsByKeyword(q))
                .build());
    }


}