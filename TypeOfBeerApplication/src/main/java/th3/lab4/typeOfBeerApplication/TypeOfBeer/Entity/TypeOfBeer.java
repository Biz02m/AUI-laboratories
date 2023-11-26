package th3.lab4.typeOfBeerApplication.TypeOfBeer.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
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

    @Override
    public String toString() {
        return "TypeOfBeer{" +
                "typeOfBeerName='" + typeOfBeerName + '\'' +
                ", YearOfInvention=" + yearOfInvention + " }";
    }

}