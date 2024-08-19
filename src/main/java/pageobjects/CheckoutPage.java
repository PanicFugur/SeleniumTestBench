package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(css = "[placeholder='Select Country']")
    private WebElement countryField;
    @FindBy(css = ".action__submit")
    private WebElement placeOrderButton;

    final By searchResults = By.cssSelector("section.ta-results button span");
    final By searchDropdown = By.cssSelector(".ta-results");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); //Very Important, research later
    }

    public void selectCountry(String country) {
        countryField.sendKeys(country);
        waitForElementToAppear(searchDropdown);
        List<WebElement> searchItems = driver.findElements(searchResults);
        searchItems.stream().
                filter(searchItem -> searchItem.getText().trim().equalsIgnoreCase(country)).
                findFirst().
                get().
                click();
    }

    public ThankYouPage placeOrder() {
        placeOrderButton.click();
        return new ThankYouPage(driver);
    }








}
