package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ThankYouPage extends AbstractComponent {

    WebDriver driver;

    By messageSelector = By.cssSelector(".hero-primary");

    @FindBy(css = "label.ng-star-inserted")
    WebElement orderID;


    public ThankYouPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); //Very Important, research later
    }

    public String getMessage() {
        waitForElementToAppear(messageSelector);
        return driver.findElement(messageSelector).getText();
    }

    public String getOrderId() {
        waitForElementToAppear(orderID);
        return orderID.getText().split(" ")[1];
    }










}
