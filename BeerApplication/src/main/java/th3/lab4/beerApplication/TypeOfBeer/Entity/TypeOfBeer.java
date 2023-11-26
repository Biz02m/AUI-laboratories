package th3.lab4.beerApplication.TypeOfBeer.Entity;

import jakarta.persistence.*;
import lombok.*;
import th3.lab4.beerApplication.Beer.Entity.Beer;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "type_of_beers")
public class TypeOfBeer implements Serializable {
    @Id
    private UUID id;

    @OneToMany(mappedBy = "typeOfBeer",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Beer> beers;


}