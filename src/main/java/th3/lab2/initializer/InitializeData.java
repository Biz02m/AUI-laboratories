package th3.lab2.initializer;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import th3.lab2.model.Beer.Entity.Beer;
import th3.lab2.model.TypeOfBeer.Entity.TypeOfBeer;
import th3.lab2.model.Beer.Service.API.BeerService;
import th3.lab2.model.TypeOfBeer.Service.API.TypeOfBeerService;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final BeerService beerService;
    private final TypeOfBeerService typeOfBeerService;

    @Autowired
    public InitializeData(BeerService beerService, TypeOfBeerService typeOfBeerService){
        this.beerService = beerService;
        this.typeOfBeerService = typeOfBeerService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        TypeOfBeer Lager = TypeOfBeer.builder()
                .id(UUID.randomUUID())
                .typeOfBeerName("Lager")
                .yearOfInvention(1842)
                .build();
        TypeOfBeer Stout = TypeOfBeer.builder()
                .id(UUID.randomUUID())
                .typeOfBeerName("Stout")
                .yearOfInvention(1759)
                .build();
        TypeOfBeer Ipa = TypeOfBeer.builder()
                .id(UUID.randomUUID())
                .typeOfBeerName("Ipa")
                .yearOfInvention(1700)
                .build();
        typeOfBeerService.create(Lager);
        typeOfBeerService.create(Stout);
        typeOfBeerService.create(Ipa);

        Beer Heineken = Beer.builder()
                .id(UUID.randomUUID())
                .name("Heineken")
                .percentage(5)
                .typeOfBeer(Lager)
                .build();
        Beer Budweiser = Beer.builder()
                .id(UUID.randomUUID())
                .name("Budweiser")
                .percentage(3)
                .typeOfBeer(Lager)
                .build();
        Beer Pilsner = Beer.builder()
                .id(UUID.randomUUID())
                .name("Pilsner")
                .percentage(4)
                .typeOfBeer(Lager)
                .build();
        Beer Guiness = Beer.builder()
                .id(UUID.randomUUID())
                .name("Guiness")
                .typeOfBeer(Stout)
                .percentage(4)
                .build();
        Beer Founders = Beer.builder()
                .id(UUID.randomUUID())
                .name("Founders")
                .percentage(8)
                .typeOfBeer(Stout)
                .build();
        Beer Oskar = Beer.builder()
                .id(UUID.randomUUID())
                .name("Oskar")
                .percentage(10)
                .typeOfBeer(Stout)
                .build();
        Beer Zywiec = Beer.builder()
                .id(UUID.randomUUID())
                .name("Zywiec")
                .percentage(5)
                .typeOfBeer(Ipa)
                .build();
        Beer Ksiazece = Beer.builder()
                .id(UUID.randomUUID())
                .name("Ksiazece")
                .percentage(2)
                .typeOfBeer(Ipa)
                .build();
        Beer Paleale = Beer.builder()
                .id(UUID.randomUUID())
                .name("Paleale")
                .percentage(5)
                .typeOfBeer(Ipa)
                .build();
        beerService.create(Heineken);
        beerService.create(Budweiser);
        beerService.create(Pilsner);
        beerService.create(Guiness);
        beerService.create(Founders);
        beerService.create(Oskar);
        beerService.create(Zywiec);
        beerService.create(Ksiazece);
        beerService.create(Paleale);


    }
}
