package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Character {
    private String name;
    private int level;
    private Profession profession;

    @Override
    public String toString(){
        return "Character{name=" + this.name + ",  level=" + level + ", profession=" + profession.getName() + "}";
    }
}
