package th3.lab4.beerApplication.TypeOfBeer.Service.API;

import th3.lab4.beerApplication.TypeOfBeer.Entity.TypeOfBeer;

import java.util.Optional;
import java.util.UUID;

public interface TypeOfBeerService {
    void create(TypeOfBeer typeOfBeer);
    void delete(UUID id);
    Optional<TypeOfBeer> find(UUID id);
}
