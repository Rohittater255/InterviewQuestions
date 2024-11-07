package codingPart.cucumber.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Order {
    @Given("User adds {string} phone to cart worth {string}")
    public void user_adds_phone_to_cart_worth(String string, String string2) throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertNotEquals(string, "Apple", "Generating one failure scenario for report");
        System.out.println( "User adds "+string+" phone to cart worth "+ string2);
    }

    @When("makes payment on Payment screen")
    public void makes_payment_on_payment_screen() {
        System.out.println( "makes payment on Payment screen");
    }

    @When("clicks on Submit Order Button")
    public void clicks_on_submit_order_button() {
        System.out.println("clicks on Submit Order Button");
    }

    @Then("Verify {string} phones is purchased")
    public void verify_phones_is_purchased(String string) {
        System.out.println("Verify {string} phones is purchased");
    }

}
