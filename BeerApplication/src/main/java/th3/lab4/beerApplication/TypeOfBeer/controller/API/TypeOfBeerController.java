package th3.lab4.beerApplication.TypeOfBeer.controller.API;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import th3.lab4.beerApplication.TypeOfBeer.DTO.PostTypeOfBeerRequest;

import java.util.UUID;

public interface TypeOfBeerController {

    @PostMapping("api/typeOfBeers/")
    @ResponseStatus(HttpStatus.CREATED)
    void putTypeOfBeer(
            @RequestBody
            PostTypeOfBeerRequest request
    );

    @DeleteMapping("api/typeOfBeers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTypeOfBeer(
            @PathVariable("id")
            UUID id
    );

}
