import model.Beer;
import model.TypeOfBeer;

import java.util.List;

public class SomeTask implements Runnable{
    List<TypeOfBeer> TypeBeerList;

    public SomeTask(List<TypeOfBeer> TypeBeerList){
        this.TypeBeerList = TypeBeerList;
    }

    @Override
    public void run() {
        for (TypeOfBeer typeOfBeer : TypeBeerList) {
            System.out.println("Processing profession: " + typeOfBeer.getName());
            for(Beer beer : typeOfBeer.getBeerList()){
                System.out.println(beer.getName());
                System.out.println(beer.getPercentage());
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
