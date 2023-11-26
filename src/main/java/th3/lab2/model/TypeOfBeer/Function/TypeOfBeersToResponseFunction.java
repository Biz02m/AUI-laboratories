package th3.lab2.model.TypeOfBeer.Function;

import org.springframework.stereotype.Component;
import th3.lab2.model.TypeOfBeer.DTO.GetTypeOfBeersResponse;
import th3.lab2.model.TypeOfBeer.Entity.TypeOfBeer;

import java.util.List;
import java.util.function.Function;

@Component
public class TypeOfBeersToResponseFunction implements Function<List<TypeOfBeer>, GetTypeOfBeersResponse> {
    @Override
    public GetTypeOfBeersResponse apply(List<TypeOfBeer> entities) {
        return GetTypeOfBeersResponse.builder()
                .typeOfBeers(entities.stream()
                        .map(typeOfBeer -> GetTypeOfBeersResponse.TypeOfBeer.builder()
                                .id(typeOfBeer.getId())
                                .typeOfBeerName(typeOfBeer.getTypeOfBeerName())
                                .build())
                        .toList())
                .build();
    }
}
