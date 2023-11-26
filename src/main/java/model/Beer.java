package model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
public class Beer implements Serializable {
    private String name;
    private int percentage;
    private TypeOfBeer typeOfBeer;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return percentage == beer.percentage && Objects.equals(name, beer.name) && Objects.equals(typeOfBeer, beer.typeOfBeer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, percentage);
    }

    @Override
    public String toString(){
        return "Beer{name=" + this.name + ",  percentage=" + percentage + ", typeOfBeer=" + typeOfBeer.getName() + "}";
    }

}
