package drillproductions.tests;

import drillproductions.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class OrderTest extends BaseTest {

    @Test(dataProvider = "getData", groups = "Purchase")
    public void submitOrder(HashMap<String,String> dataset) throws IOException {
        String productName = dataset.get("product");
        String country = "India";
        ProductCatalogue productCatalogue = loginPage.loginApplication(dataset.get("email"), dataset.get("password"));
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCart();
        Assert.assertTrue(cartPage.isProductInCart(productName));
        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.selectCountry(country);
        ThankYouPage thankYouPage = checkoutPage.placeOrder();
        Assert.assertEquals(thankYouPage.getMessage(), "THANKYOU FOR THE ORDER.");
    }

    @Test(dataProvider = "getData", dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest(HashMap<String,String> dataset) {
        ProductCatalogue productCatalogue = loginPage.loginApplication(dataset.get("email"), dataset.get("password"));
        OrdersPage ordersPage = productCatalogue.goToOrders();
        boolean testresult = ordersPage.verifyOrderDisplayed(dataset.get("product"));
        Assert.assertTrue(testresult);
    }

    @DataProvider
    public Object[] [] getData() throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//drillproductions//data//PurchaseOrder.json");
        return new Object[][] {{data.get(0)},{data.get(1)}};
    }

}
