package net.dg.springbootopefeignrestapi.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dg.springbootopefeignrestapi.client.BreedApiResponse;
import net.dg.springbootopefeignrestapi.client.CatApiClient;
import net.dg.springbootopefeignrestapi.dto.Breed;
import net.dg.springbootopefeignrestapi.dto.BreedCategories;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Service
public class BreedService {

    private final CatApiClient catApiClient;

    public List<Breed> getBreeds(Integer page, Integer limit) {
        log.info("Inside of getBreeds of BreedService");
        return catApiClient.getBreeds(page, limit).stream()
                .map(this::createBreed)
                .collect(Collectors.toList());
    }

    public List<BreedCategories> getBreedCategories(Integer page, Integer limit) {
        log.info("Inside of getBreedCategories of BreedService");
        return catApiClient.getBreedCategories(page, limit).stream()
                .map(this::createBreedCategories)
                .collect(Collectors.toList());
    }

    public List<Breed> findBreedsByKeyword(String q) {
        log.info("Inside of findBreedsByKeword of BreedService");
        return catApiClient.searchBreeds(q).stream()
                .map(this::createBreed)
                .collect(Collectors.toList());
    }

    private Breed createBreed(BreedApiResponse response) {
        return Breed.builder()
                .name(response.getName())
                .temperaments(Arrays.asList(StringUtils.split(response.getTemperament(), ", ")))
                .description(response.getDescription())
                .build();
    }

    private BreedCategories createBreedCategories(BreedApiResponse response) {
        return BreedCategories.builder()
                .name(response.getName())
                .build();
    }




}