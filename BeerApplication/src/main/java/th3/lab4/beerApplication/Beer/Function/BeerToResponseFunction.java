package th3.lab4.beerApplication.Beer.Function;

import org.springframework.stereotype.Component;
import th3.lab4.beerApplication.Beer.DTO.GetBeerResponse;
import th3.lab4.beerApplication.Beer.Entity.Beer;

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
                        .build())
                .build();
    }
}
