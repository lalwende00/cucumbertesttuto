package checkout;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

    private List<Item> items = new ArrayList<>();

    public void add(int count, Item item){
        while(count-- > 0) items.add(item);
    }

    public int total(){
        return items.stream()
                .map(Item::getPrice)
                .reduce(0, Integer::sum);

    }
}
