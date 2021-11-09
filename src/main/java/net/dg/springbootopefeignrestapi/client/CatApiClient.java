package net.dg.springbootopefeignrestapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "catApiClient", url = "https://api.thecatapi.com/v1", configuration = CatApiConfig.class)
public interface CatApiClient {

    @GetMapping("/breeds")
    List<BreedApiResponse> getBreeds(@RequestParam Integer page, @RequestParam Integer limit);


}