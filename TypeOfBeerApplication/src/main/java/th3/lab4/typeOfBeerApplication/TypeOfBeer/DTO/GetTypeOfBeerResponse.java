package th3.lab4.typeOfBeerApplication.TypeOfBeer.DTO;

import lombok.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetTypeOfBeerResponse {
    private UUID id;
    private String typeOfBeerName;
    private int YearOfInvention;
}
