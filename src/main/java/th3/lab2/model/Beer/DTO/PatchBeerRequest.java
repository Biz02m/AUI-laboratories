package th3.lab2.model.Beer.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PatchBeerRequest {
    private String name;
    private int percentage;
}
