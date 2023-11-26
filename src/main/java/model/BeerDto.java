package model;

import java.io.Serializable;
import java.util.Objects;

public class BeerDto implements Comparable<BeerDto>, Serializable {
    private String name;
    private int percentage;
    private String TypeOfBeer;

    public BeerDto(String name, int percentage, String typeOfBeer){
        this.name = name;
        this.percentage = percentage;
        this.TypeOfBeer = typeOfBeer;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfBeer() {
        return TypeOfBeer;
    }

    public void setTypeOfBeer(String typeOfBeer) {
        this.TypeOfBeer = typeOfBeer;
    }

    // Metoda toString
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", percentage=" + percentage +
                ", TypeOfBeer=" + TypeOfBeer +
                '}';
    }

    @Override
    public int compareTo(BeerDto o) {
        return 0;
    }
}
