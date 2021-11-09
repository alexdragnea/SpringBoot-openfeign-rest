package net.dg.springbootopefeignrestapi.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dg.springbootopefeignrestapi.client.BreedApiResponse;
import net.dg.springbootopefeignrestapi.client.CatApiClient;
import net.dg.springbootopefeignrestapi.client.CategoriesApiResponse;
import net.dg.springbootopefeignrestapi.dto.Breed;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
@Service
public class BreedService {

    private final CatApiClient client;

    public List<Breed> getBreeds(Integer page, Integer limit) {
        log.info("Inside of getBreeds of BreedService");
        return client.getBreeds(page, limit).stream()
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


}