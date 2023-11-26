package th3.lab2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th3.lab2.model.TypeOfBeer;
import th3.lab2.repositories.TypeOfBeerRepository;

import java.util.List;
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
    public void update(TypeOfBeer typeOfBeer) {
        repository.save(typeOfBeer);
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
    public void delete(String typeOfBeerName) {
        repository.findByTypeOfBeerName(typeOfBeerName).ifPresent(repository::delete);
    }

    @Override
    public Optional<TypeOfBeer> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<TypeOfBeer> findByName(String typeOfBeerName) {
        return repository.findByTypeOfBeerName(typeOfBeerName);
    }

    @Override
    public List<TypeOfBeer> findAll() {
        return repository.findAll();
    }
}
