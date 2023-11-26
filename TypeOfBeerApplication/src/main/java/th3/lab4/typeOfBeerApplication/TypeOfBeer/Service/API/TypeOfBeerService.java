package th3.lab4.typeOfBeerApplication.TypeOfBeer.Service.API;

import th3.lab4.typeOfBeerApplication.TypeOfBeer.Entity.TypeOfBeer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TypeOfBeerService {
    void update(TypeOfBeer typeOfBeer);
    void create(TypeOfBeer typeOfBeer);
    void delete(UUID id);
    void delete(String typeOfBeerName);
    Optional<TypeOfBeer> find(UUID id);
    Optional<TypeOfBeer> findByName(String typeOfBeerName);
    List<TypeOfBeer> findAll();
}
