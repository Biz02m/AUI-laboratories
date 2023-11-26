package th3.lab4.typeOfBeerApplication.TypeOfBeer.controller.implementation;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.controller.API.TypeOfBeerController;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.DTO.GetTypeOfBeerResponse;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.DTO.GetTypeOfBeersResponse;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.DTO.PatchTypeOfBeerRequest;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.DTO.PutTypeOfBeerRequest;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Function.RequestToTypeOfBeerFunction;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Function.TypeOfBeerToResponseFunction;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Function.TypeOfBeersToResponseFunction;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Function.UpdateTypeOfBeerWithRequestFunction;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Entity.TypeOfBeer;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Service.API.TypeOfBeerService;

import java.util.Optional;
import java.util.UUID;

@RestController
@Log
public class TypeOfBeerDefaultController implements TypeOfBeerController {

    private final TypeOfBeerService typeOfBeerService;
    private final TypeOfBeerToResponseFunction typeOfBeerToResponse;
    private final TypeOfBeersToResponseFunction typeOfBeersToResponse;
    private final RequestToTypeOfBeerFunction requestToTypeOfBeer;
    private final UpdateTypeOfBeerWithRequestFunction updateTypeOfBeerWithRequest;


    @Autowired
    public TypeOfBeerDefaultController(TypeOfBeerService typeOfBeerService,
                                       TypeOfBeerToResponseFunction typeOfBeerToResponse,
                                       TypeOfBeersToResponseFunction typeOfBeersToResponse,
                                       RequestToTypeOfBeerFunction requestToTypeOfBeer,
                                       UpdateTypeOfBeerWithRequestFunction updateTypeOfBeerWithRequest) {
        this.typeOfBeerService = typeOfBeerService;
        this.typeOfBeerToResponse = typeOfBeerToResponse;
        this.typeOfBeersToResponse = typeOfBeersToResponse;
        this.requestToTypeOfBeer = requestToTypeOfBeer;
        this.updateTypeOfBeerWithRequest = updateTypeOfBeerWithRequest;
    }


    @Override
    public GetTypeOfBeersResponse getTypeOfBeers() {
        return typeOfBeersToResponse.apply(typeOfBeerService.findAll());
    }

    @Override
    public GetTypeOfBeerResponse getTypeOfBeer(UUID id) {
        return typeOfBeerToResponse.apply(typeOfBeerService.find(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public void putTypeOfBeer(UUID id, PutTypeOfBeerRequest request) {
        typeOfBeerService.create(requestToTypeOfBeer.apply(id, request));
    }

    @Override
    public void updateFleet(UUID id, PatchTypeOfBeerRequest request) {
        typeOfBeerService.update(updateTypeOfBeerWithRequest.apply(typeOfBeerService.find(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), request));
    }

    @Override
    public void deleteTypeOfBeer(UUID id) {
        Optional<TypeOfBeer> typeOfBeer = typeOfBeerService.find(id);
        if(typeOfBeer.isPresent()){
            typeOfBeerService.delete(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
