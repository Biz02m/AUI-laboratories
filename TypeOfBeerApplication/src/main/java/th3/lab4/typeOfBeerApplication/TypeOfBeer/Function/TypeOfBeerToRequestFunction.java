package th3.lab4.typeOfBeerApplication.TypeOfBeer.Function;

import org.springframework.stereotype.Component;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.DTO.PostTypeOfBeerRequest;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Entity.TypeOfBeer;

import java.util.function.Function;

@Component
public class TypeOfBeerToRequestFunction implements Function<TypeOfBeer, PostTypeOfBeerRequest> {

    @Override
    public PostTypeOfBeerRequest apply(TypeOfBeer typeOfBeer) {
        return PostTypeOfBeerRequest
                .builder()
                .id(typeOfBeer.getId())
                .name(typeOfBeer.getTypeOfBeerName())
                .build();
    }
}
