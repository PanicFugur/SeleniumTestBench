package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrdersPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> itemNames;

    @FindBy(css = "tr th[scope='row']")
    List<WebElement> orderIds;

    By cartButton = By.cssSelector("div button[routerlink*='cart']");

    public OrdersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); //Very Important, research later
        waitForElementToAppear(cartButton);
    }

    public boolean verifyOrderDisplayed(String itemName) {
        boolean matchName = itemNames.stream().anyMatch(item -> item.getText().equalsIgnoreCase(itemName));
        return  matchName;

    }














}
