package th3.lab4.typeOfBeerApplication.TypeOfBeer.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PatchTypeOfBeerRequest {
    private String typeOfBeerName;
    private int YearOfInvention;
}
