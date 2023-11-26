package th3.lab2.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
    @Column(name = "typeOfBeerName")
    String typeOfBeerName;
    @Column(name = "year_of_invention")
    int YearOfInvention;
    @OneToMany(mappedBy = "typeOfBeer")
    @Basic(fetch = FetchType.LAZY)
    @Singular
    @EqualsAndHashCode.Exclude
    List<Beer> beers;

    @Override
    public String toString() {
        return "TypeOfBeer{" +
                "typeOfBeerName='" + typeOfBeerName + '\'' +
                ", YearOfInvention=" + YearOfInvention + " }";
    }

}