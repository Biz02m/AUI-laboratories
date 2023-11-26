package th3.lab4.beerApplication.Beer.DTO;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetBeerResponse {

    /**
     * Represents single Type of beer - copied from wojciks example
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class TypeOfBeer {

        /**
         * Unique id identifying type of beer.
         */
        private UUID id;

    }

    private UUID id;
    private String name;
    private int percentage;
    private TypeOfBeer typeOfBeer;
}
