
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


@Listeners(ExtentTestNGITestListener.class)

public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Login process")54
    public void login(){
        checkoutPage.login();
    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       qa qa                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   B


    @Test(description = "Adding item to Wishlist and then to Cart to finish we buy the product and return to Home page.")
    public void testWishlist() {
        checkoutPage.addTooWishlist();
        checkoutPage.addTooCart();
        checkoutPage.enterPersonalInfo();
        checkoutPage.checkout();
        assertEquals("Order complete", checkoutPage.orderComplete().getText());
        checkoutPage.returnTooMainPage();
    }

    @Test(description = "We change the quantity of what wer buy")
    public void changeQuantity() {
        checkoutPage.addTooCart();
        checkoutPage.quantityPlus();
        checkoutPage.enterPersonalInfo();
        checkoutPage.checkout();
        assertEquals("Order complete", checkoutPage.orderComplete().getText());
        checkoutPage.returnTooMainPage();
    }

    //    @Test
//    public  void sortPriceHighToLow()throws InterruptedException{
//
//    }
    @Test(description = "Searching a specific item then we change the quantity of what wer buy")
    public void testingSearchEngine() {
        checkoutPage.search();
        checkoutPage.buyHat();
        checkoutPage.quantityPlus();
        checkoutPage.enterPersonalInfo();
        checkoutPage.checkout();
        assertEquals("Order complete", checkoutPage.orderComplete().getText());
        checkoutPage.returnTooMainPage();
    }

    @Test(description = "Calculating product quantity")
    public void quantityOfProduct() {
        checkoutPage.addTooCart();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product after updating quantity to 3 time's");
        double expectedTotal = checkoutPage.productPrice() * 3;
        checkoutPage.quantityPlus();
        assertEquals(checkoutPage.productPrice(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The prices match");
    }

    @Test(description = "Calculating product quantity")
    public void totalQuantityOfProduct() {
        checkoutPage.addTooCart();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product" + checkoutPage.productPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The text price" + checkoutPage.taxPrice());
        double expectedTotal = checkoutPage.productPrice() + checkoutPage.taxPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Total Amount should be: " + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Total Amount is : " + checkoutPage.totalPrice());

        assertEquals(checkoutPage.totalPrice(), expectedTotal);

    }
}
