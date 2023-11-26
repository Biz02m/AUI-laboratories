package th3.lab2.model.Beer.Function;

import org.springframework.stereotype.Component;
import th3.lab2.model.Beer.DTO.GetBeerResponse;
import th3.lab2.model.Beer.Entity.Beer;

import java.util.function.Function;

@Component
public class BeerToResponseFunction implements Function<Beer, GetBeerResponse> {

    @Override
    public GetBeerResponse apply(Beer entity) {
        return GetBeerResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .percentage(entity.getPercentage())
                .typeOfBeer(GetBeerResponse.TypeOfBeer.builder()
                        .id(entity.getTypeOfBeer().getId())
                        .typeOfBeerName(entity.getTypeOfBeer().getTypeOfBeerName())
                        .build())
                .build();
    }
}
