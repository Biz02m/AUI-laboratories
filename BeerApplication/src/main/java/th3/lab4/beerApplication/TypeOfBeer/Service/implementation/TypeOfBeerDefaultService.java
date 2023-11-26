package th3.lab4.beerApplication.TypeOfBeer.Service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th3.lab4.beerApplication.TypeOfBeer.Repository.API.TypeOfBeerRepository;
import th3.lab4.beerApplication.TypeOfBeer.Service.API.TypeOfBeerService;
import th3.lab4.beerApplication.TypeOfBeer.Entity.TypeOfBeer;

import java.util.Optional;
import java.util.UUID;


@Service
public class TypeOfBeerDefaultService implements TypeOfBeerService {
    private final TypeOfBeerRepository repository;

    @Autowired
    public TypeOfBeerDefaultService(TypeOfBeerRepository repository){
        this.repository = repository;
    }

    @Override
    public void create(TypeOfBeer typeOfBeer) {
        repository.save(typeOfBeer);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public Optional<TypeOfBeer> find(UUID id) {
        return repository.findById(id);
    }

}
