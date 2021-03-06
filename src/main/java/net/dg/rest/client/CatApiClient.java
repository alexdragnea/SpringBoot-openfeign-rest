package net.dg.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "catApiClient", url = "${thecat.api}", configuration = CatApiConfig.class)
public interface CatApiClient {

    @GetMapping("/breeds")
    List<BreedApiResponse> getBreeds(@RequestParam Integer page, @RequestParam Integer limit);

    @GetMapping("/categories")
    List<BreedApiResponse> getBreedCategories(@RequestParam Integer page, @RequestParam Integer limit);

    @GetMapping("/breeds/search")
    List<BreedApiResponse> searchBreeds(@RequestParam String q);


}