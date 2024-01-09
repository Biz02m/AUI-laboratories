package th3.lab4.typeOfBeerApplication.TypeOfBeer.Event.Repository.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Entity.TypeOfBeer;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Event.Repository.Api.TypeOfBeerEventRepository;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Function.TypeOfBeerToRequestFunction;

import java.util.UUID;

@Repository
public class TypeOfBeerEventRestRepository implements TypeOfBeerEventRepository {
    private final RestTemplate restTemplate;
    private final TypeOfBeerToRequestFunction typeOfBeerToRequest;
    @Autowired
    public TypeOfBeerEventRestRepository(RestTemplate restTemplate, TypeOfBeerToRequestFunction typeOfBeerToRequest) {
        this.restTemplate = restTemplate;
        this.typeOfBeerToRequest = typeOfBeerToRequest;
    }

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/typeOfBeers/{id}", id);
    }

    @Override
    public void save(TypeOfBeer typeOfBeer) {
        restTemplate.postForLocation("/api/typeOfBeers/", typeOfBeerToRequest.apply(typeOfBeer));
    }

    @Override
    public void update(TypeOfBeer typeOfBeer) {
        restTemplate.put("/api/typeOfBeers/"+typeOfBeer.getId(), typeOfBeerToRequest.apply(typeOfBeer));
    }
}
