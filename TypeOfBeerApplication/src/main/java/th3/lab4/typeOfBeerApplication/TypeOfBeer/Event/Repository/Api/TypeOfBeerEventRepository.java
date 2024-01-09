package th3.lab4.typeOfBeerApplication.TypeOfBeer.Event.Repository.Api;

import th3.lab4.typeOfBeerApplication.TypeOfBeer.Entity.TypeOfBeer;

import java.util.UUID;

public interface TypeOfBeerEventRepository {
    void delete(UUID id);

    void save(TypeOfBeer typeOfBeer);

    void update(TypeOfBeer typeOfBeer);
}
