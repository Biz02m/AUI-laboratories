import model.Character;
import model.Profession;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        ArrayList<Profession> Profesions = new ArrayList<>();
        AddItems(Profesions);

        /*Profesions.forEach(profession -> {
            System.out.println("Profession: " + profession.getName());
            System.out.println("Base Armour: " + profession.getBaseArmor());
            profession.getCharacterList().forEach(System.out::println);
        });*/

        Stream<Profession> stream = Profesions.stream();
        Set<Profession> collected = stream.collect(Collectors.toSet());
        stream = collected.stream();
        stream.forEach(profession -> {
            System.out.println("Profession: " + profession.getName());
            System.out.println("Base Armour: " + profession.getBaseArmor());
            profession.getCharacterList().forEach(System.out::println);
        });
    }

    public static void AddItems(ArrayList<Profession> Profesions){
        Profesions.add(Profession.builder().name("Witcher").baseArmor(100).characterList(new ArrayList<>()).build());
        Profesions.get(0).getCharacterList().add(Character.builder().name("Geralt of Rivia").level(50).profession(Profesions.get(0)).build());
        Profesions.get(0).getCharacterList().add(Character.builder().name("Eskel").level(23).profession(Profesions.get(0)).build());
        Profesions.get(0).getCharacterList().add(Character.builder().name("Lambert").level(36).profession(Profesions.get(0)).build());
        Profesions.get(0).getCharacterList().add(Character.builder().name("Vesemir").level(99).profession(Profesions.get(0)).build());

        Profesions.add(Profession.builder().name("Mage").baseArmor(20).characterList(new ArrayList<>()).build());
        Profesions.get(1).getCharacterList().add(Character.builder().name("Vilgefortz").level(50).profession(Profesions.get(1)).build());
        Profesions.get(1).getCharacterList().add(Character.builder().name("Stregobor").level(55).profession(Profesions.get(1)).build());
        Profesions.get(1).getCharacterList().add(Character.builder().name("Gaunter o Dimm").level(999).profession(Profesions.get(1)).build());

        Profesions.add(Profession.builder().name("Sorceress").baseArmor(10).characterList(new ArrayList<>()).build());
        Profesions.get(2).getCharacterList().add(Character.builder().name("Yennefer of Vengerberg").level(99).profession(Profesions.get(2)).build());
        Profesions.get(2).getCharacterList().add(Character.builder().name("Triss Merigold").level(54).profession(Profesions.get(2)).build());
        Profesions.get(2).getCharacterList().add(Character.builder().name("Filippa Eilhart").level(54).profession(Profesions.get(2)).build());

    }
}
