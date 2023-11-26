package th3.lab4.typeOfBeerApplication.TypeOfBeer.DTO;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetTypeOfBeersResponse {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class TypeOfBeer{
        private UUID id;
        private String typeOfBeerName;
    }

    @Singular
    private List<TypeOfBeer> typeOfBeers;
}
