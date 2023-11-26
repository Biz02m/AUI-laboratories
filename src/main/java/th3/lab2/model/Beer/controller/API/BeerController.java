package th3.lab2.model.Beer.controller.API;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import th3.lab2.model.Beer.DTO.GetBeerResponse;
import th3.lab2.model.Beer.DTO.GetBeersResponse;
import th3.lab2.model.Beer.DTO.PatchBeerRequest;
import th3.lab2.model.Beer.DTO.PutBeerRequest;

import java.util.UUID;

public interface BeerController {
    @GetMapping("api/beers")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBeersResponse getBeers();

    @GetMapping("api/typeOfBeers/{typeOfBeerId}/beers")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBeersResponse getTypeOfBeerBeers(
            @PathVariable("typeOfBeerId")
            UUID typeOfBeerId
    );

    @GetMapping("api/beers/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBeerResponse getBeer(
            @PathVariable("id")
            UUID id
    );

    @GetMapping("api/typeOfBeers/{typeOfBeerId}/beers/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetBeerResponse getTypeOfBeerBeer(
            @PathVariable("typeOfBeerId")
            UUID typeOfBeerID,
            @PathVariable("id")
            UUID id
    );

    @PutMapping("api/beers/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void putBeer(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutBeerRequest request
    );

    @PatchMapping("api/beers/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void updateBeer(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchBeerRequest request
    );

    @DeleteMapping("api/beers/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void deleteBeer(
            @PathVariable("id")
            UUID id
    );
}
