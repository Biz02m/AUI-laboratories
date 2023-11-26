import model.Beer;
import model.BeerDto;
import model.TypeOfBeer;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {

        List<TypeOfBeer> TypeBeerList = new ArrayList<>();
        addElements(TypeBeerList);

        //ex2
        System.out.println("Test for exercise 2");
        TypeBeerList.forEach(typeOfBeer -> {
            System.out.println("TypeOfBeer: " + typeOfBeer.getName());
            System.out.println("Year of invention " + typeOfBeer.getYearOfInvention());
            typeOfBeer.getBeerList().forEach(beer -> {
                System.out.println("- name: " + beer.getName());
                System.out.println("- percentage: " + beer.getPercentage());
            });
        });

        //ex3
        System.out.println("\nTest for exercise 3");
        Set<Beer> elements = TypeBeerList
                .stream()
                .flatMap(beer -> beer.getBeerList().stream())
                .collect(Collectors.toSet());

        System.out.println("All elements from TypeBeerList regardless of type of beer");
        Stream<Beer> elementStream = elements.stream();
        elementStream.forEach(System.out::println);


        //ex4
        System.out.println("\nTest for exercise 4");
        System.out.println("Only elements whose percentage is above 4 and sorted by percentage");
        elements.stream()
                .filter(beer -> beer.getPercentage() > 2)
                .sorted(Comparator.comparingInt(Beer::getPercentage))
                .forEach(System.out::println);


        //ex5
        System.out.println("\nTest for exercise 5");
        List<BeerDto> beerDtoList = elements.stream()
                .map(beer -> new BeerDto(beer.getName(), beer.getPercentage(), beer.getTypeOfBeer().getName()))
                .sorted()
                .collect(Collectors.toList());

        beerDtoList
                .forEach(System.out::println);


        //ex6
        System.out.println("\nTest for exercise 6");
        //serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("typeOfBeers.dat"))) {
            oos.writeObject(TypeBeerList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //reading from binary file
        List<TypeOfBeer> readBeers = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("typeOfBeers.dat"))) {
            readBeers = (List<TypeOfBeer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //reading from file
        readBeers.forEach(typeOfBeer -> {
            System.out.println(typeOfBeer);
            typeOfBeer.getBeerList().forEach(beer -> {
                System.out.println("\t" + beer);
            });
        });

    }

    public static void addElements(List<TypeOfBeer> TypeBeerList){
        TypeOfBeer Witcher = TypeOfBeer.builder().name("Lager").YearOfInvention(1842).beerList(new ArrayList<>()).build();
        Witcher.getBeerList().add(Beer.builder().name("Pilsner Urquell").percentage(4).typeOfBeer(Witcher).build());
        Witcher.getBeerList().add(Beer.builder().name("Stella Artois").percentage(5).typeOfBeer(Witcher).build());
        Witcher.getBeerList().add(Beer.builder().name("Heineken").percentage(5).typeOfBeer(Witcher).build());
        Witcher.getBeerList().add(Beer.builder().name("Budweiser").percentage(3).typeOfBeer(Witcher).build());
        TypeBeerList.add(Witcher);

        TypeOfBeer Mage = TypeOfBeer.builder().name("Ipa").YearOfInvention(1700).beerList(new ArrayList<>()).build();
        Mage.getBeerList().add(Beer.builder().name("Sierra Nevada Pale Ale").percentage(6).typeOfBeer(Mage).build());
        Mage.getBeerList().add(Beer.builder().name("Zywiec").percentage(4).typeOfBeer(Mage).build());
        Mage.getBeerList().add(Beer.builder().name("Ksiazeca").percentage(5).typeOfBeer(Mage).build());
        TypeBeerList.add(Mage);

        TypeOfBeer Sorceress = TypeOfBeer.builder().name("Stout").YearOfInvention(1759).beerList(new ArrayList<>()).build();
        Sorceress.getBeerList().add(Beer.builder().name("Guinness Draught").percentage(4).typeOfBeer(Sorceress).build());
        Sorceress.getBeerList().add(Beer.builder().name("Founders Breakfast Stout").percentage(8).typeOfBeer(Sorceress).build());
        Sorceress.getBeerList().add(Beer.builder().name("Oskar Blues Ten FIDY").percentage(10).typeOfBeer(Sorceress).build());
        TypeBeerList.add(Sorceress);
    }
}
