import model.Character;
import model.Profession;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        //Ex2();
        Ex3();
    }

    public static void Ex3(){
        List<Profession> ListOfProfessions = new ArrayList<>();

        addElements(ListOfProfessions);

        Set<Character> allCharacters = ListOfProfessions.stream()
                .flatMap(profession -> profession.getCharacterList().stream())
                .collect(Collectors.toSet());

        System.out.println("\n" + "Zadanie 3"+ "\n" + "**Wszytskie elementy Set Collection**");
        allCharacters.stream()
                .forEach(System.out::println);
    }

    public static void Ex2(){
        List<Profession> ListOfProfessions = new ArrayList<>();

        addElements(ListOfProfessions);
        ListOfProfessions.forEach(profession -> {
            System.out.println("Profession: " + profession.getName());
            System.out.println("Base armour" + profession.getBaseArmor());
            profession.getCharacterList().forEach(character -> {
                System.out.println("- name: " + character.getName());
                System.out.println("- level: " + character.getLevel());
            });
        });
    }

    public static void addElements(List<Profession> ListOfProfessions){
        Profession Witcher = new Profession.Builder().name("Witcher").baseArmor(50).characterList(new ArrayList<>()).build();
        Witcher.getCharacterList().add(new Character.Builder().name("Geralt").level(50).Profession(Witcher).build());
        Witcher.getCharacterList().add(new Character.Builder().name("Eskel").level(50).Profession(Witcher).build());
        Witcher.getCharacterList().add(new Character.Builder().name("Lambert").level(50).Profession(Witcher).build());
        Witcher.getCharacterList().add(new Character.Builder().name("Vesemir").level(50).Profession(Witcher).build());
        ListOfProfessions.add(Witcher);

        Profession Mage = new Profession.Builder().name("Mage").baseArmor(20).characterList(new ArrayList<>()).build();
        Mage.getCharacterList().add(new Character.Builder().name("Gaunter o dimm").level(50).Profession(Mage).build());
        Mage.getCharacterList().add(new Character.Builder().name("Vilgefortz").level(50).Profession(Mage).build());
        Mage.getCharacterList().add(new Character.Builder().name("Stregobor").level(50).Profession(Mage).build());
        ListOfProfessions.add(Mage);

        Profession Sorceress = new Profession.Builder().name("Sorceress").baseArmor(10).characterList(new ArrayList<>()).build();
        Sorceress.getCharacterList().add(new Character.Builder().name("Yennefer of Vengerberg").level(50).Profession(Sorceress).build());
        Sorceress.getCharacterList().add(new Character.Builder().name("Triss Merigold").level(50).Profession(Sorceress).build());
        Sorceress.getCharacterList().add(new Character.Builder().name("Filippa Eilhart").level(50).Profession(Sorceress).build());
        ListOfProfessions.add(Sorceress);
    }
}
