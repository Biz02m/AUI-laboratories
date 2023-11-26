package th3.lab4.typeOfBeerApplication.TypeOfBeer.controller.API;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.DTO.GetTypeOfBeerResponse;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.DTO.GetTypeOfBeersResponse;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.DTO.PatchTypeOfBeerRequest;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.DTO.PutTypeOfBeerRequest;

import java.util.UUID;

public interface TypeOfBeerController {
    @GetMapping("api/typeOfBeers")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetTypeOfBeersResponse getTypeOfBeers();

    @GetMapping("api/typeOfBeers/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetTypeOfBeerResponse getTypeOfBeer(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("api/typeOfBeers/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    void putTypeOfBeer(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutTypeOfBeerRequest request
    );

    @PatchMapping("api/typeOfBeers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    void updateFleet(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchTypeOfBeerRequest request
    );

    @DeleteMapping("api/typeOfBeers/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteTypeOfBeer(
            @PathVariable("id")
            UUID id
    );

}
