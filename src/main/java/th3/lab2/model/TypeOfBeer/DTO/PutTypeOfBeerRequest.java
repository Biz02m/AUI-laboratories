package th3.lab2.model.TypeOfBeer.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PutTypeOfBeerRequest {
    private String typeOfBeerName;
    private int YearOfInvention;
}
