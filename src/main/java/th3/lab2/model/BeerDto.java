package th3.lab2.model;

import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerDto {
    private String name;
    private int percentage;
    private String TypeOfBeer;
}
