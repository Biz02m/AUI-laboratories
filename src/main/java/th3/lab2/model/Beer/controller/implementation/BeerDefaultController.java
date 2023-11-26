package th3.lab2.model.Beer.controller.implementation;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import th3.lab2.model.Beer.DTO.GetBeerResponse;
import th3.lab2.model.Beer.DTO.GetBeersResponse;
import th3.lab2.model.Beer.DTO.PatchBeerRequest;
import th3.lab2.model.Beer.DTO.PutBeerRequest;
import th3.lab2.model.Beer.Function.BeerToResponseFunction;
import th3.lab2.model.Beer.Function.BeersToResponseFunction;
import th3.lab2.model.Beer.Function.RequestToBeerFunction;
import th3.lab2.model.Beer.Function.UpdateBeerWithRequestFunction;
import th3.lab2.model.Beer.Service.API.BeerService;
import th3.lab2.model.Beer.controller.API.BeerController;
import th3.lab2.model.Beer.Entity.Beer;
import th3.lab2.model.TypeOfBeer.Service.API.TypeOfBeerService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Log
public class BeerDefaultController implements BeerController {

    private final BeerService beerService;
    private final TypeOfBeerService typeOfBeerService;
    private final BeerToResponseFunction beerToResponse;
    private final BeersToResponseFunction beersToResponse;
    private final RequestToBeerFunction requestToBeer;
    private final UpdateBeerWithRequestFunction updateBeerWithRequest;


    @Autowired
    public BeerDefaultController(
            BeerService beerService,
            TypeOfBeerService typeOfBeerService,
            BeerToResponseFunction beerToResponse,
            BeersToResponseFunction beersToResponse,
            RequestToBeerFunction requestToBeer,
            UpdateBeerWithRequestFunction updateBeerWithRequest) {
        this.beerService = beerService;
        this.typeOfBeerService = typeOfBeerService;
        this.beerToResponse = beerToResponse;
        this.beersToResponse = beersToResponse;
        this.requestToBeer = requestToBeer;
        this.updateBeerWithRequest = updateBeerWithRequest;
    }


    @Override
    public GetBeersResponse getBeers() {
        return beersToResponse.apply(beerService.findAll());
    }

    @Override
    public GetBeersResponse getTypeOfBeerBeers(UUID typeOfBeerId) {
        GetBeersResponse beersResponse = beerService.findAllByTypeOfBeer(typeOfBeerId)
                .map(beersToResponse)
                .orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND)));
        if(beersResponse.getBeers().isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return beersResponse;
    }

    @Override
    public GetBeerResponse getBeer(UUID id) {
        return beerService.find(id)
                .map(beerToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetBeerResponse getTypeOfBeerBeer(UUID typeOfBeerID, UUID id) {
        List<Beer> beers = beerService.findAllByTypeOfBeer(typeOfBeerID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return beers.stream()
                .filter(beer -> beer.getId().equals(id))
                .findFirst().map(beerToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putBeer(UUID id, PutBeerRequest request) {
        typeOfBeerService.find(request.getTypeOfBeer())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        beerService.create(requestToBeer.apply(id, request));
    }

    @Override
    public void updateBeer(UUID id, PatchBeerRequest request) {
        beerService.update(updateBeerWithRequest.apply(beerService.find(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)),request));
    }

    @Override
    public void deleteBeer(UUID id) {
        Optional<Beer> beer = beerService.find(id);
        if(beer.isPresent()){
            beerService.delete(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
