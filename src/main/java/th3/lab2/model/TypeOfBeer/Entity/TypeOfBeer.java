package th3.lab2.model.TypeOfBeer.Entity;

import jakarta.persistence.*;
import lombok.*;
import th3.lab2.model.Beer.Entity.Beer;

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
    @ToString.Exclude
    private UUID id;
    @Column(name = "typeOfBeerName")
    String typeOfBeerName;
    @Column(name = "year_of_invention")
    int yearOfInvention;
    @OneToMany(mappedBy = "typeOfBeer",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @Singular
    @EqualsAndHashCode.Exclude
    List<Beer> beers;

    @Override
    public String toString() {
        return "TypeOfBeer{" +
                "typeOfBeerName='" + typeOfBeerName + '\'' +
                ", YearOfInvention=" + yearOfInvention + " }";
    }

}