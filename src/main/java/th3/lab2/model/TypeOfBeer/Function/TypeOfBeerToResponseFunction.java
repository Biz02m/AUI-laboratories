package th3.lab2.model.TypeOfBeer.Function;

import org.springframework.stereotype.Component;
import th3.lab2.model.TypeOfBeer.DTO.GetTypeOfBeerResponse;
import th3.lab2.model.TypeOfBeer.Entity.TypeOfBeer;

import java.util.function.Function;

@Component
public class TypeOfBeerToResponseFunction implements Function<TypeOfBeer, GetTypeOfBeerResponse> {

    @Override
    public GetTypeOfBeerResponse apply(TypeOfBeer entity) {
        return GetTypeOfBeerResponse.builder()
                .id(entity.getId())
                .typeOfBeerName(entity.getTypeOfBeerName())
                .YearOfInvention(entity.getYearOfInvention())
                .build();
    }
}
