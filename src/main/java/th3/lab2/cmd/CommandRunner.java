package th3.lab2.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import th3.lab2.model.Beer.Entity.Beer;
import th3.lab2.model.TypeOfBeer.Entity.TypeOfBeer;
import th3.lab2.model.Beer.Service.API.BeerService;
import th3.lab2.model.TypeOfBeer.Service.API.TypeOfBeerService;

import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Component
public class CommandRunner implements CommandLineRunner {
    private final TypeOfBeerService typeOfBeerService;
    private final BeerService beerService;
    @Autowired
    public CommandRunner(BeerService beerService, TypeOfBeerService typeOfBeerService){
        this.typeOfBeerService = typeOfBeerService;
        this.beerService = beerService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");;
        String command;
        String help = "\ncommands: getBeers, getTypeOfBeers, addBeer, deleteBeer, end\n";
        main_loop:
        while (true)
        {
            System.out.println(help);
            command = scanner.next();
            switch (command)
            {
                case "getTypeOfBeers":
                    typeOfBeerService.findAll().forEach(System.out::println);
                    break;
                case "getBeers":
                    beerService.findAll().forEach(System.out::println);
                    break;
                case "deleteBeer":
                    System.out.println("Enter beer Name: ");
                    command = scanner.next();
                    Optional<Beer> beer1 = beerService.findByName(command);
                    if(beer1.isPresent()){
                        beerService.delete(command);
                        System.out.println("Beer successfully deleted");
                    }
                    else{
                        System.out.println("Incorrect beer name");
                    }
                    break;
                case "addBeer":
                    UUID id = UUID.randomUUID();
                    System.out.println("Enter beer name: ");
                    String name = scanner.next();
                    System.out.println("Enter beer percentage: ");
                    Integer percentage = Integer.parseInt(scanner.next());
                    System.out.println("Choose type of beer: ");
                    typeOfBeerService.findAll().stream().map(TypeOfBeer::getTypeOfBeerName).forEach(System.out::println);
                    Optional<TypeOfBeer> typeOfBeer = typeOfBeerService.findByName(scanner.next());
                    if (typeOfBeer.isPresent())
                    {
                        beerService.create(Beer.builder()
                                .id(id)
                                .name(name)
                                .percentage(percentage)
                                .typeOfBeer(typeOfBeer.get())
                                .build());
                        System.out.println("Beer successfully added");
                    }else
                    {
                        System.out.println("TypeOfBeer doesn't exist");
                    }
                    break;
                case "end":
                    System.out.println("Command line runner ended");
                    //break main_loop;
                    System.exit(0);
            }
        }
    }
}
