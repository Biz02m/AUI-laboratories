package th3.lab2.model.TypeOfBeer.Function;

import org.springframework.stereotype.Component;
import th3.lab2.model.TypeOfBeer.DTO.PatchTypeOfBeerRequest;
import th3.lab2.model.TypeOfBeer.Entity.TypeOfBeer;

import java.util.function.BiFunction;

@Component
public class UpdateTypeOfBeerWithRequestFunction implements BiFunction<TypeOfBeer, PatchTypeOfBeerRequest, TypeOfBeer> {
    @Override
    public TypeOfBeer apply(TypeOfBeer entity, PatchTypeOfBeerRequest request) {
        return TypeOfBeer.builder()
                .id(entity.getId())
                .typeOfBeerName(request.getTypeOfBeerName())
                .yearOfInvention(request.getYearOfInvention())
                .beers(entity.getBeers())
                .build();
    }
}
