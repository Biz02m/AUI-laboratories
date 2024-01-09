package th3.lab4.beerApplication.initializer;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import th3.lab4.beerApplication.Beer.Entity.Beer;
import th3.lab4.beerApplication.TypeOfBeer.Entity.TypeOfBeer;
import th3.lab4.beerApplication.Beer.Service.API.BeerService;
import th3.lab4.beerApplication.TypeOfBeer.Service.API.TypeOfBeerService;

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
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a1"))
                .typeOfBeerName("Lager")
                .build();
        TypeOfBeer Stout = TypeOfBeer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a2"))
                .typeOfBeerName("Stout")
                .build();
        TypeOfBeer Ipa = TypeOfBeer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a3"))
                .typeOfBeerName("Ipa")
                .build();
        typeOfBeerService.create(Lager);
        typeOfBeerService.create(Stout);
        typeOfBeerService.create(Ipa);

        Beer Heineken = Beer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a4"))
                .name("Heineken")
                .percentage(5)
                .typeOfBeer(Lager)
                .build();
        Beer Budweiser = Beer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a5"))
                .name("Budweiser")
                .percentage(3)
                .typeOfBeer(Lager)
                .build();
        Beer Pilsner = Beer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .name("Pilsner")
                .percentage(4)
                .typeOfBeer(Lager)
                .build();
        Beer Guiness = Beer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a7"))
                .name("Guiness")
                .typeOfBeer(Stout)
                .percentage(4)
                .build();
        Beer Founders = Beer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a8"))
                .name("Founders")
                .percentage(8)
                .typeOfBeer(Stout)
                .build();
        Beer Oskar = Beer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a9"))
                .name("Oskar")
                .percentage(10)
                .typeOfBeer(Stout)
                .build();
        Beer Zywiec = Beer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f0a10"))
                .name("Zywiec")
                .percentage(5)
                .typeOfBeer(Ipa)
                .build();
        Beer Ksiazece = Beer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f0a11"))
                .name("Ksiazece")
                .percentage(2)
                .typeOfBeer(Ipa)
                .build();
        Beer Paleale = Beer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f0a12"))
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
