package th3.lab4.typeOfBeerApplication.TypeOfBeer.Function;

import org.springframework.stereotype.Component;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.DTO.PatchTypeOfBeerRequest;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Entity.TypeOfBeer;

import java.util.function.BiFunction;

@Component
public class UpdateTypeOfBeerWithRequestFunction implements BiFunction<TypeOfBeer, PatchTypeOfBeerRequest, TypeOfBeer> {
    @Override
    public TypeOfBeer apply(TypeOfBeer entity, PatchTypeOfBeerRequest request) {
        return TypeOfBeer.builder()
                .id(entity.getId())
                .typeOfBeerName(request.getTypeOfBeerName())
                .yearOfInvention(request.getYearOfInvention())
                .build();
    }
}
