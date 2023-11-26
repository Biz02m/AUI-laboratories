package th3.lab2.model.Beer.Function;

import org.springframework.stereotype.Component;
import th3.lab2.model.Beer.DTO.PutBeerRequest;
import th3.lab2.model.Beer.Entity.Beer;
import th3.lab2.model.TypeOfBeer.Entity.TypeOfBeer;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToBeerFunction implements BiFunction<UUID, PutBeerRequest, Beer> {
    @Override
    public Beer apply(UUID id, PutBeerRequest request) {
        return Beer.builder()
                .id(id)
                .percentage(request.getPercentage())
                .name(request.getName())
                .typeOfBeer(TypeOfBeer.builder()
                        .id(request.getTypeOfBeer())
                        .build())
                .build();
    }
}
