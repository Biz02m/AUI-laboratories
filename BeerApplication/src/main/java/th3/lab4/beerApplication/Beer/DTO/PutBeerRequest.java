package th3.lab4.beerApplication.Beer.DTO;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PutBeerRequest {
    private String name;
    private int percentage;
    private UUID typeOfBeer;
}