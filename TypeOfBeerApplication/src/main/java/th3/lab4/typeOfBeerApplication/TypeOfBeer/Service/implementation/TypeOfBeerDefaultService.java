package th3.lab4.typeOfBeerApplication.TypeOfBeer.Service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Event.Repository.Api.TypeOfBeerEventRepository;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Repository.API.TypeOfBeerRepository;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Service.API.TypeOfBeerService;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Entity.TypeOfBeer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class TypeOfBeerDefaultService implements TypeOfBeerService {
    private final TypeOfBeerRepository repository;
    private final TypeOfBeerEventRepository eventRepository;

    @Autowired
    public TypeOfBeerDefaultService(TypeOfBeerRepository repository, TypeOfBeerEventRepository eventRepository){
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void update(TypeOfBeer typeOfBeer) {
        repository.save(typeOfBeer);
    }

    @Override
    public void create(TypeOfBeer typeOfBeer) {
        repository.save(typeOfBeer);
        eventRepository.save(typeOfBeer);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
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
