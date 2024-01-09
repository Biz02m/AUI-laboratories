package th3.lab4.beerApplication.TypeOfBeer.Function;

import org.springframework.stereotype.Component;
import th3.lab4.beerApplication.TypeOfBeer.DTO.PostTypeOfBeerRequest;
import th3.lab4.beerApplication.TypeOfBeer.Entity.TypeOfBeer;

import java.util.function.Function;

@Component
public class RequestToTypeOfBeerFunction implements Function<PostTypeOfBeerRequest, TypeOfBeer> {
    @Override
    public TypeOfBeer apply(PostTypeOfBeerRequest postTypeOfBeerRequest) {
        return TypeOfBeer.builder()
                .id(postTypeOfBeerRequest.getId())
                .typeOfBeerName(postTypeOfBeerRequest.getName())
                .build();
    }
}
