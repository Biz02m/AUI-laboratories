package model;

import java.util.List;
import java.util.Objects;

public class Profession {
    private String name;
    private int baseArmor;
    private List<Character> characterList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseArmor() {
        return baseArmor;
    }

    public void setBaseArmor(int baseArmor) {
        this.baseArmor = baseArmor;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "name='" + name + '\'' +
                ", baseArmor=" + baseArmor + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profession that = (Profession) o;
        return baseArmor == that.baseArmor && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, baseArmor, characterList);
    }

    private Profession(ProfessionBuilder builder){
        this.name = builder.name;
        this.baseArmor = builder.baseArmor;
        this.characterList = builder.characterList;
    }

    public static class ProfessionBuilder{
        private String name;
        private int baseArmor;
        private List<Character> characterList;

        public ProfessionBuilder(String name, int baseArmor, List<Character> characterList){
            this.name = name;
            this.baseArmor = baseArmor;
            this.characterList = characterList;
        }

        public Profession build(){
            return new Profession(this);
        }
    }
}
