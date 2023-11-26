package th3.lab4.beerApplication.TypeOfBeer.Repository.API;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th3.lab4.beerApplication.TypeOfBeer.Entity.TypeOfBeer;

import java.util.UUID;

@Repository
public interface TypeOfBeerRepository extends JpaRepository<TypeOfBeer, UUID> {
}
