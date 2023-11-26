package th3.lab4.beerApplication.TypeOfBeer.controller.implementation;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import th3.lab4.beerApplication.TypeOfBeer.DTO.PostTypeOfBeerRequest;
import th3.lab4.beerApplication.TypeOfBeer.Function.RequestToTypeOfBeerFunction;
import th3.lab4.beerApplication.TypeOfBeer.Service.API.TypeOfBeerService;
import th3.lab4.beerApplication.TypeOfBeer.controller.API.TypeOfBeerController;

import java.util.UUID;

@RestController
@Log
public class TypeOfBeerDefaultController implements TypeOfBeerController {

    private final TypeOfBeerService typeOfBeerService;
    private final RequestToTypeOfBeerFunction requestToTypeOfBeer;

    @Autowired
    public TypeOfBeerDefaultController(TypeOfBeerService typeOfBeerService,
                                       RequestToTypeOfBeerFunction requestToTypeOfBeer) {
        this.typeOfBeerService = typeOfBeerService;
        this.requestToTypeOfBeer = requestToTypeOfBeer;
    }

    @Override
    public void putTypeOfBeer(PostTypeOfBeerRequest request) {
        typeOfBeerService.create(requestToTypeOfBeer.apply(request));
    }

    @Override
    public void deleteTypeOfBeer(UUID id) {
        typeOfBeerService.delete(id);
    }
}
