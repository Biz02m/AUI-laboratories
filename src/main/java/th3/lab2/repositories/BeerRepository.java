package th3.lab2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th3.lab2.model.Beer;
import th3.lab2.model.TypeOfBeer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BeerRepository extends JpaRepository<Beer, UUID> {
    List<Beer> findAllByTypeOfBeer(TypeOfBeer typeOfBeer);
    List<Beer> findAllByName(String name);
    Optional<Beer> findByName(String name);
}
