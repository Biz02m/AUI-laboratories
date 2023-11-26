package th3.lab2.model.TypeOfBeer.Function;

import org.springframework.stereotype.Component;
import th3.lab2.model.TypeOfBeer.DTO.PutTypeOfBeerRequest;
import th3.lab2.model.TypeOfBeer.Entity.TypeOfBeer;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToTypeOfBeerFunction implements BiFunction<UUID, PutTypeOfBeerRequest, TypeOfBeer> {
    @Override
    public TypeOfBeer apply(UUID id, PutTypeOfBeerRequest request) {
        return TypeOfBeer.builder()
                .id(id)
                .typeOfBeerName(request.getTypeOfBeerName())
                .yearOfInvention(request.getYearOfInvention())
                .build();
    }
}
