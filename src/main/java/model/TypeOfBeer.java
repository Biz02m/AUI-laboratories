package model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@Builder
public class TypeOfBeer implements Serializable {
    private String name;
    private int YearOfInvention;
    private List<Beer> beerList;

    @Override
    public String toString() {
        return "TypeOfBeer{" +
                "name='" + name + '\'' +
                ", YearOfInvention=" + YearOfInvention + ", " +
                beerList + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeOfBeer that = (TypeOfBeer) o;
        return YearOfInvention == that.YearOfInvention && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, YearOfInvention, beerList);
    }

}
