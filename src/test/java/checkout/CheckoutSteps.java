package checkout;

import checkout.Checkout;
import checkout.Item;
import cucumber.api.java8.En;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CheckoutSteps implements En {

    private Checkout checkout = new Checkout();
    private List<Item> items = new ArrayList<>();

    public CheckoutSteps() {

        Given("the price of a {string} is {int}c", (String name, Integer price) -> {
            items.add(new Item(name, price));
        });

        When("I checkout {int} {string}", (Integer itemCount, String itemName) -> {
            Optional<Item> requestedItem = items.stream()
                    .filter(t -> t.getName().equals(itemName))
                    .findFirst();
            if(requestedItem.isPresent())
                checkout.add(itemCount, requestedItem.get());
            else
                throw new Exception("checkout.Item not specified in test");
        });

        Then("^the total price should be (\\d+)c$", (Integer total) -> {
            Assert.assertEquals(total.intValue(), checkout.total());
        });

    }

}
