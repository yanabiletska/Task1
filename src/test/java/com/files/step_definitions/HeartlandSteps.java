package com.files.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HeartlandSteps {
    private WebDriver driver;

    @Given("user accesses {string}")
    public void user_accesses(String string) {
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
    }
    @When("user accesses the Shop")
    public void user_accesses_the_shop() {
        WebElement shopLink = driver.findElement(By.linkText("Shop New Yoga"));
        shopLink.click();
    }
    @When("user filters for a certain category")
    public void user_filters_for_a_certain_category_e_g(String category) {
        WebElement categoryDropdown = driver.findElement(By.className("filter-options-title"));
        Select select = new Select(categoryDropdown);
        select.selectByIndex(0);
    }
    @When("user opens the Product Page")
    public void user_opens_the_product_page() {
        WebElement productLink = driver.findElement(By.className("product-item-link"));
        productLink.click();
    }
    @When("user adds multiple quantities of the product to the cart")
    public void user_adds_multiple_quantities_of_the_product_to_the_cart() {
        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        quantityInput.clear();
        quantityInput.sendKeys("3");

        WebElement addToCartButton = driver.findElement(By.id("product-addtocart-button"));
        addToCartButton.click();
    }
    @And("user performs a Checkout")
    public void user_performs_a_checkout() {
        WebElement checkoutButton = driver.findElement(By.xpath("//a[@class=\"action showcart active\"]"));
        checkoutButton.click();

        WebElement proceedToCheckoutButton = driver.findElement(By.id("top-cart-btn-checkout"));
        proceedToCheckoutButton.click();

        

    }
    @And("user fills out the necessary information")
    public void userFillsOutTheNecessaryInformation() {
        WebElement emailInput = driver.findElement(By.xpath("(//div[@class=\"control _with-tooltip\"]//input)[1]"));
        emailInput.sendKeys("user12345@gmail.com");

        WebElement firstnameInput = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        firstnameInput.sendKeys("User");

        WebElement lastNameInput = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        lastNameInput.sendKeys("User");

        WebElement streetAddressInput = driver.findElement(By.xpath("//input[@name=\"street[0]\"]"));
        streetAddressInput.sendKeys("123 Street");

        WebElement cityInput = driver.findElement(By.xpath("//input[@name=\"city\"]"));
        cityInput.sendKeys("User City");

        WebElement state = driver.findElement(By.xpath("//select[@name=\"region_id\"]"));

        Select dropdown = new Select(state);
        dropdown.selectByValue("1");

        WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@name=\"telephone\"]"));
        phoneNumberInput.sendKeys("123-456-7899");

        WebElement shippingMethod = driver.findElement(By.xpath("(//input[@type=\"radio\"])[1]"));
        shippingMethod.click();

        WebElement nextButton = driver.findElement(By.xpath("//button[@type=\"submit\"]//span[.=\"Next\"]"));
        nextButton.click();

        WebElement placeOrderButton = driver.findElement(By.xpath("//button[@type=\"submit\"]//span[.=\"Place Order\"]"));
        placeOrderButton.click();



    }


    @Then("user should be able to see successful checkout message")
    public void userShouldBeAbleToSeeSuccessfulCheckoutMessage() {

        WebElement successMessage = driver.findElement(By.xpath("//span[@class=\"base\"]"));
        String expectedSuccessMessage = successMessage.getText();

        String actualSuccessMessage = "Thank you for your purchase!";

        Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);


    }


}
