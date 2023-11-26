package th3.lab4.beerApplication.Beer.Function;

import org.springframework.stereotype.Component;
import th3.lab4.beerApplication.Beer.DTO.GetBeersResponse;
import th3.lab4.beerApplication.Beer.Entity.Beer;

import java.util.List;
import java.util.function.Function;

@Component
public class BeersToResponseFunction implements Function<List<Beer>, GetBeersResponse> {

    @Override
    public GetBeersResponse apply(List<Beer> entities) {
        return GetBeersResponse.builder()
                .beers(entities.stream()
                        .map(beer -> GetBeersResponse.Beer.builder()
                                .id(beer.getId())
                                .name(beer.getName())
                                .build())
                        .toList())
                .build();
    }
}
