package model;

import java.util.Objects;

public class Character {
    private String name;
    private int level;
    private Profession profession;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return level == character.level && Objects.equals(name, character.name) && Objects.equals(profession, character.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }

    @Override
    public String toString(){
        return "Character{name=" + this.name + ",  level=" + level + ", profession=" + profession.getName() + "}";
    }

    public Character(String name, int level, Profession profession){
        this.name = name;
        this.level = level;
        this.profession = profession;
    }

    public static class Builder{
        private String name;
        private int level;
        private Profession profession;

        public Builder(){
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder level(int level){
            this.level = level;
            return this;
        }

        public Builder Profession(Profession profession){
            this.profession = profession;
            return this;
        }

        public Character build(){
            return new Character(name, level, profession);
        }
    }
}
