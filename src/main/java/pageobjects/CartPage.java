package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;
    By products = By.cssSelector(".cartSection h3");

    @FindBy(css = ".totalRow button")
    WebElement checkout;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); //Very Important, research later
    }

    public boolean isProductInCart(String productName) {
        waitForElementToAppear(products);
        List<WebElement> productList = driver.findElements(products);
        return productList.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
    }

    public CheckoutPage checkout(){
        checkout.click();
        return new CheckoutPage(driver);
    }







}
