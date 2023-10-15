import model.Character;
import model.CharacterDto;
import model.Profession;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {

        List<Profession> ListOfProfessions = new ArrayList<>();

        //ex2
        System.out.println("Test for excercise 2");
        addElements(ListOfProfessions);
        ListOfProfessions.forEach(profession -> {
            System.out.println("Profession: " + profession.getName());
            System.out.println("Base armour" + profession.getBaseArmor());
            profession.getCharacterList().forEach(character -> {
                System.out.println("- name: " + character.getName());
                System.out.println("- level: " + character.getLevel());
            });
        });

        //ex3
        System.out.println("Test for excercise 3");
        Set<Character> elements = ListOfProfessions.stream()
                .flatMap(profession -> profession.getCharacterList().stream())
                .collect(Collectors.toSet());

        System.out.println("All elements from ListOfProfessions regardless of professions");
        elements.stream()
                .forEach(System.out::println);


        //ex4
        System.out.println("Test for excercise 4");
        System.out.println("All elements whose level is above 40 sorted alphabetically");
        elements.stream()
                .filter(character -> character.getLevel() > 40)
                .sorted(Comparator.comparing(Character::getName))
                .forEach(System.out::println);

        //ex5
        System.out.println("Test for excercise 5");
        System.out.println("\n" + "Zadanie 5");
        List<CharacterDto> dtoList = elements.stream()
                .map(character -> new CharacterDto(character.getName(), character.getLevel(), character.getProfession().getName()))
                .sorted()
                .collect(Collectors.toList());
        dtoList.forEach(System.out::println);

        //ex6
        System.out.println("Test for excercise 6");
        //serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("professions.dat"))) {
            oos.writeObject(ListOfProfessions);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //reading from binary file
        List<Profession> readProfessions = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("professions.dat"))) {
            readProfessions = (List<Profession>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //reading from file
        readProfessions.forEach(profession -> {
            System.out.println(profession);
            profession.getCharacterList().forEach(character -> {
                System.out.println("\t" + character);
            });
        });

    }

    public static void addElements(List<Profession> ListOfProfessions){
        Profession Witcher = new Profession.Builder().name("Witcher").baseArmor(50).characterList(new ArrayList<>()).build();
        Witcher.getCharacterList().add(new Character.Builder().name("Geralt").level(20).Profession(Witcher).build());
        Witcher.getCharacterList().add(new Character.Builder().name("Eskel").level(39).Profession(Witcher).build());
        Witcher.getCharacterList().add(new Character.Builder().name("Lambert").level(23).Profession(Witcher).build());
        Witcher.getCharacterList().add(new Character.Builder().name("Vesemir").level(72).Profession(Witcher).build());
        ListOfProfessions.add(Witcher);

        Profession Mage = new Profession.Builder().name("Mage").baseArmor(20).characterList(new ArrayList<>()).build();
        Mage.getCharacterList().add(new Character.Builder().name("Gaunter o dimm").level(999).Profession(Mage).build());
        Mage.getCharacterList().add(new Character.Builder().name("Vilgefortz").level(5).Profession(Mage).build());
        Mage.getCharacterList().add(new Character.Builder().name("Stregobor").level(51).Profession(Mage).build());
        ListOfProfessions.add(Mage);

        Profession Sorceress = new Profession.Builder().name("Sorceress").baseArmor(10).characterList(new ArrayList<>()).build();
        Sorceress.getCharacterList().add(new Character.Builder().name("Yennefer of Vengerberg").level(43).Profession(Sorceress).build());
        Sorceress.getCharacterList().add(new Character.Builder().name("Triss Merigold").level(64).Profession(Sorceress).build());
        Sorceress.getCharacterList().add(new Character.Builder().name("Filippa Eilhart").level(87).Profession(Sorceress).build());
        ListOfProfessions.add(Sorceress);
    }
}
