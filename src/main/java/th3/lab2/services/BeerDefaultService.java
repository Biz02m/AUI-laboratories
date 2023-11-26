package th3.lab2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th3.lab2.model.Beer;
import th3.lab2.repositories.BeerRepository;
import th3.lab2.repositories.TypeOfBeerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BeerDefaultService implements BeerService {
    private final BeerRepository repository;
    private final TypeOfBeerRepository typeOfBeerRepository;

    @Autowired
    public BeerDefaultService(BeerRepository repository, TypeOfBeerRepository typeOfBeerRepository){
        this.repository = repository;
        this.typeOfBeerRepository = typeOfBeerRepository;
    }

    @Override
    public void update(Beer beer) {
        repository.save(beer);
    }

    @Override
    public void create(Beer beer) {
        repository.save(beer);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public void delete(String name) {
        repository.findByName(name).ifPresent(repository::delete);
    }

    @Override
    public Optional<Beer> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Beer> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<List<Beer>> findAllByTypeOfBeer(UUID typeOfBeerID) {
        return typeOfBeerRepository.findById(typeOfBeerID).map(repository::findAllByTypeOfBeer);
    }

    @Override
    public List<Beer> findAllByName(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public Optional<Beer> findByName(String name) {
        return repository.findByName(name);
    }
}
