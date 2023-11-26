package th3.lab4.typeOfBeerApplication.initializer;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Entity.TypeOfBeer;
import th3.lab4.typeOfBeerApplication.TypeOfBeer.Service.API.TypeOfBeerService;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final TypeOfBeerService typeOfBeerService;

    @Autowired
    public InitializeData(TypeOfBeerService typeOfBeerService){
        this.typeOfBeerService = typeOfBeerService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        TypeOfBeer Lager = TypeOfBeer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a1"))
                .typeOfBeerName("Lager")
                .yearOfInvention(1842)
                .build();
        TypeOfBeer Stout = TypeOfBeer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a2"))
                .typeOfBeerName("Stout")
                .yearOfInvention(1759)
                .build();
        TypeOfBeer Ipa = TypeOfBeer.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a3"))
                .typeOfBeerName("Ipa")
                .yearOfInvention(1700)
                .build();
        typeOfBeerService.create(Lager);
        typeOfBeerService.create(Stout);
        typeOfBeerService.create(Ipa);
    }
}
