package pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {

    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); //Very Important, research later
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;


    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By productsBy = By.cssSelector(".mb-3");
    By toastMessage = By.cssSelector("#toast-container");
    By spinnerLocator = By.cssSelector("[class*='ngx-spinner-overlay']");

    public List<WebElement> getProductList(){
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        return getProductList().stream().filter(products1 ->
                products1.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
    }

    public void addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForElementToAppear(spinnerLocator);
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(spinnerLocator);


    }






}
