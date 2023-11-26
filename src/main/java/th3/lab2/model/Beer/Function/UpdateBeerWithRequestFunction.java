package th3.lab2.model.Beer.Function;

import org.springframework.stereotype.Component;
import th3.lab2.model.Beer.DTO.PatchBeerRequest;
import th3.lab2.model.Beer.Entity.Beer;

import java.util.function.BiFunction;

@Component
public class UpdateBeerWithRequestFunction implements BiFunction<Beer, PatchBeerRequest, Beer> {
    @Override
    public Beer apply(Beer entity, PatchBeerRequest request) {
        return Beer.builder()
                .id(entity.getId())
                .name(request.getName())
                .percentage(request.getPercentage())
                .typeOfBeer(entity.getTypeOfBeer())
                .build();
    }
}
