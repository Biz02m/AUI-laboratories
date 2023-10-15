package model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CharacterDto {
    private String name;
    private int level;
    private String profession;

    public CharacterDto(String name, int level, String profession){
        this.name = name;
        this.level = level;
        this.profession = profession;
    }
}
