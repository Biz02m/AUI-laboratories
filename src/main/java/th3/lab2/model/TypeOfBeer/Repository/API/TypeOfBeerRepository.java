package th3.lab2.model.TypeOfBeer.Repository.API;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th3.lab2.model.TypeOfBeer.Entity.TypeOfBeer;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TypeOfBeerRepository extends JpaRepository<TypeOfBeer, UUID> {
    Optional<TypeOfBeer> findByTypeOfBeerName(String typeOfBeerName);
}
