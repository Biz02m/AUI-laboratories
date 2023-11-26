package th3.lab2.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="beers")
public class Beer implements Serializable {
    @Id
    private UUID id;
    @Column(name = "typeOfBeerName")
    String name;
    @Column(name = "percentage")
    int percentage;
    @ManyToOne
    @JoinColumn(name = "typeOfBeer")
    @EqualsAndHashCode.Exclude
    TypeOfBeer typeOfBeer;

    public BeerDto toDto(){
        return BeerDto.builder().name(this.name).percentage(this.percentage).TypeOfBeer(this.getTypeOfBeer().getTypeOfBeerName()).build();
    }


    @Override
    public String toString(){
        return "Beer{BeerName=" + this.name + ",  percentage=" + percentage + ", typeOfBeer=" + typeOfBeer.getTypeOfBeerName() + "}";
    }

}
