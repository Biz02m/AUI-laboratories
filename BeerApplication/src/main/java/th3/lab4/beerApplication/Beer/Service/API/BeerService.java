package th3.lab4.beerApplication.Beer.Service.API;

import th3.lab4.beerApplication.Beer.Entity.Beer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    void update(Beer beer);
    void create(Beer beer);
    void delete(UUID id);
    void delete(String name);
    Optional<Beer> find(UUID id);
    List<Beer> findAll();
    Optional<List<Beer>> findAllByTypeOfBeer(UUID typeOfBeerID);

    List<Beer> findAllByName(String name);
    Optional<Beer> findByName(String name);
}
