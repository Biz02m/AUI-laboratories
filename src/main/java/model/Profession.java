package model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class Profession {
    private String name;

    private int baseArmor;

    private List<Character> characterList;
}
