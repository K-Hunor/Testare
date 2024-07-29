
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(ExtentTestNGITestListener.class)

public class CheckoutTest extends Hooks {

    public CheckoutPage checkoutPage;
    public WebDriverWait wait;

    @BeforeMethod
    public void SetupPageObject() {
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Login should succeed")
    public void goodLogin(){
        checkoutPage.goodLogin();
        String hiUser = "dino";
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
    }
    @Test(description = "Login should succeed")
    public void slowLogin(){
        checkoutPage.slowLogin();
        String hiUser = "turtle";
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
    }
    @Test(description = "Login should fail with bad credentials")
    public void badLoginBadCredentials(){
        checkoutPage.badLoginBadCredentials();
        String errorMessage = "Incorrect username or password!";
        assertTrue(checkoutPage.loginError().getText().equals(errorMessage),("The Login was not successful do to incorrect username or password"));

    }
    @Test(description = "Login should fail with no username entered")
    public void badLoginNoUsername(){
        checkoutPage.badLoginNoUsername();
        String errorMessage = "Please fill in the username!";
        assertTrue(checkoutPage.loginError().getText().equals(errorMessage),("The Login was not successful do to missing username"));
    }
    @Test(description = "Login should fail with no password entered")
    public void badLoginNoPassword(){
        checkoutPage.badLoginNoPassword();
        String errorMessage = "Please fill in the password!";
        assertTrue(checkoutPage.loginError().getText().equals(errorMessage),("The Login was not successful do to missing password"));
    }
    @Test(description = "Login should fail special characters in username and password")
    public void badLoginSpecialCharacters(){
        checkoutPage.badLoginSpecialCharacters();
        String errorMessage = "Incorrect username or password!";
        assertTrue(checkoutPage.loginError().getText().equals(errorMessage),("The Login was not successful do to incorrect(Special characters) username or password"));
    }
    @Test(description = "Login should fail with locked out User")
    public void lockedOutUser(){
        checkoutPage.lockedOutUser();
        String errorMessage = "The user has been locked out.";
        assertTrue(checkoutPage.loginError().getText().equals(errorMessage),("The Login was not successful do to the user has been Locked Out"));
    }

    @Test(description = "Bug test normal user")
    public void normalUserBugTest() {

        String hiUser = "dino";
        String fName = "Joe";
        String lName = "Braun";
        String address = "Wonder Land";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.addTooCart();
        checkoutPage.checkoutClick();
        checkoutPage.firstNamePersonalInfo(fName);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        checkoutPage.lastNamePersonalInfo(lName);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        checkoutPage.addressPersonalInfo(address);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);

    }
    @Test(description = "Bug test normal user last name first")
    public void normalUserBugTestLastNameFirst() {

        String hiUser = "dino";
        String fName = "Joe";
        String lName = "Braun";
        String address = "Wonder Land";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.addTooCart();
        checkoutPage.checkoutClick();
        checkoutPage.lastNamePersonalInfo(lName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        checkoutPage.firstNamePersonalInfo(fName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        checkoutPage.addressPersonalInfo(address);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);

    }
    @Test(description = "Bug test normal user address first")
    public void normalUserBugTestAddressFirst() {

        String hiUser = "dino";
        String fName = "Joe";
        String lName = "Braun";
        String address = "Wonder Land";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.addTooCart();
        checkoutPage.checkoutClick();
        checkoutPage.addressPersonalInfo(address);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);
        checkoutPage.firstNamePersonalInfo(fName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        checkoutPage.lastNamePersonalInfo(lName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            ExtentTestNGITestListener.getTest().log(Status.INFO, "This should work");
        }
    }
    @Test(description = "Bug test beetle. Cant add item to cart from Homepage ")
    public void beetleCantAddItemToCart() {

        String hiUser = "beetle";
        String itemMassage = "How about adding some products in your cart?";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.addTooCart();
        assertTrue(checkoutPage.addItemMassage().getText().equals(itemMassage),"The cart is empty, No item was added");
        checkoutPage.checkoutClick();

    }
    @Test(description = "Bug test beetle user")
    public void beetleUserBugTest() {

        String hiUser = "beetle";
        String fName = "B.Joe";
        String lName = "B.Braun";
        String address = "Beetle Land";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser), ("The Login was not successful do to incorrect user"));
        checkoutPage.addTooCartMC();
        checkoutPage.checkoutClick();
        checkoutPage.firstNamePersonalInfo(fName);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"), fName);
        checkoutPage.lastNamePersonalInfo(lName);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"), fName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"), lName);
        checkoutPage.addressPersonalInfo(address);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"), fName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"), lName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"), address);
    }
    @Test(description = "Bug test beetle user last name first")
    public void beetleUserBugTestLastNameFirst() {

        String hiUser = "beetle";
        String fName = "B.Joe";
        String lName = "B.Braun";
        String address = "Beetle Land";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.addTooCartMC();
        checkoutPage.checkoutClick();
        checkoutPage.lastNamePersonalInfo(lName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        checkoutPage.clearFirstName();
        checkoutPage.firstNamePersonalInfo(fName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        checkoutPage.addressPersonalInfo(address);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);

    }
    @Test(description = "Bug test beetle user address first")
    public void beetleUserBugTestAddressFirst() {

        String hiUser = "beetle";
        String fName = "B.Joe";
        String lName = "B.Braun";
        String address = "Beetle Land";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.addTooCartMC();
        checkoutPage.checkoutClick();
        checkoutPage.addressPersonalInfo(address);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);
        checkoutPage.firstNamePersonalInfo(fName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        checkoutPage.lastNamePersonalInfo(lName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);

    }
    @Test(description = "Bug test beetle user address and lastname first")
    public void beetleUserBugTestAddressLFirst() {

        String hiUser = "beetle";
        String fName = "B.Joe";
        String lName = "B.Braun";
        String address = "Beetle Land";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.addTooCartMC();
        checkoutPage.checkoutClick();
        checkoutPage.addressPersonalInfo(address);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);
        checkoutPage.lastNamePersonalInfo(lName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        checkoutPage.clearFirstName();
        checkoutPage.firstNamePersonalInfo(fName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);

    }
    @Test(description = "Bug test turtle user")
    public void turtleUserBugTest() {

        String hiUser = "turtle";
        String fName = "T.Joe";
        String lName = "T.Braun";
        String address = "Turtle Land";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.addTooCart();
        checkoutPage.checkoutClick();
        checkoutPage.firstNamePersonalInfo(fName);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        checkoutPage.lastNamePersonalInfo(lName);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        checkoutPage.addressPersonalInfo(address);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);
    }
    @Test(description = "Bug test turtle user last name first")
    public void turtleUserBugTestLastNameFirst() {

        String hiUser = "turtle";
        String fName = "T.Joe";
        String lName = "T.Braun";
        String address = "Turtle Land";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.addTooCart();
        checkoutPage.checkoutClick();
        checkoutPage.lastNamePersonalInfo(lName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        checkoutPage.firstNamePersonalInfo(fName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        checkoutPage.addressPersonalInfo(address);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);

    }
    @Test(description = "Bug test turtle user address first")
    public void turtleUserBugTestAddressFirst() {

        String hiUser = "turtle";
        String fName = "T.Joe";
        String lName = "T.Braun";
        String address = "Turtle Land";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.addTooCart();
        checkoutPage.checkoutClick();
        checkoutPage.addressPersonalInfo(address);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);
        checkoutPage.firstNamePersonalInfo(fName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        checkoutPage.lastNamePersonalInfo(lName);
        assertEquals(checkoutPage.getAddress().getAttribute("value"),address);
        assertEquals(checkoutPage.getFirstName().getAttribute("value"),fName);
        assertEquals(checkoutPage.getLastName().getAttribute("value"),lName);

    }


    @Test(description = "Adding item to Wishlist and then to Cart to finish we buy the product and return to Home page.")
    public void testWishlist() {
        checkoutPage.addTooWishlist();
        checkoutPage.addTooCart();
        checkoutPage.enterAllPersonalInfo();
        checkoutPage.checkout();
        assertTrue(checkoutPage.orderComplete().getText().equals("Order complete"),"The order was not completed successfully something went wrong in the checkout section");
        checkoutPage.returnTooMainPage();
    }
    @Test(description = "Test checkout with no FistName to se if the error massage is the right one.")
    public void testWishlistNoFirstName() {
        checkoutPage.addTooWishlist();
        checkoutPage.addTooCart();
        checkoutPage.enterPersonalInfoNoFirstName();
        checkoutPage.checkout();
        assertTrue(checkoutPage.noFirstNameError().getText().equals("First Name is required"),"The order was not completed Missing FistName");

    }
    @Test(description = "Test checkout with no LastName to se if the error massage is the right one.")
    public void testWishlistNoLastName() {
        checkoutPage.addTooWishlist();
        checkoutPage.addTooCart();
        checkoutPage.enterPersonalInfoNoLastName();
        checkoutPage.checkout();
        assertTrue(checkoutPage.noLastNameError().getText().equals("Last Name is required"),"The order was not completed Missing LastName");
    }
    @Test(description = "Test checkout with no Address to se if the error massage is the right one.")
    public void testWishlistNoAddress() {
        checkoutPage.addTooWishlist();
        checkoutPage.addTooCart();
        checkoutPage.enterPersonalInfoNoAddress();
        checkoutPage.checkout();
        assertTrue(checkoutPage.noAddressError().getText().equals("Address is required"),"The order was not completed Missing Address");
    }
    @Test(description = "Bugged user checkout test ")
    public void buggedCheckout(){
        checkoutPage.buggedLogin();
        String hiUser = "beetle";

        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.addTooWishlist();

        assertTrue(checkoutPage.countWishlistProducts().getText().equals("1"),"Product added to wishlist but no products in wishlist");
        checkoutPage.addTooCart();
        String numberOfProductsInCart;
        try {
            numberOfProductsInCart = checkoutPage.countCartProducts().getText();
        } catch (NoSuchElementException e){
            numberOfProductsInCart = "0";
        }
        assertTrue(numberOfProductsInCart.equals("1"), "Product added to cart but no products in cart");
        checkoutPage.enterAllPersonalInfo();
        checkoutPage.checkout();
        assertTrue(checkoutPage.orderComplete().getText().equals("Order complete"),"The order was not completed successfully something went wrong in the checkout section");
    }
    @Test(description = "We change the quantity of what we buy")
    public void changeQuantity() {
        checkoutPage.addTooCart();
        checkoutPage.quantityPlus();
        checkoutPage.enterAllPersonalInfo();
        checkoutPage.checkout();
        assertTrue(checkoutPage.orderComplete().getText().equals("Order complete"),"The order was not completed successfully something went wrong in the checkout section");
        checkoutPage.returnTooMainPage();
    }
    @Test(description = "Normal user. Searching a specific item then we change the quantity of what we buy")
    public void normalUTestingSearchEngine() {
        String hiUser = "dino";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.search();
        checkoutPage.buyHat();
        checkoutPage.quantityPlus();
        checkoutPage.enterAllPersonalInfo();
        checkoutPage.checkout();
        assertTrue(checkoutPage.orderComplete().getText().equals("Order complete"),"The order was not completed successfully something went wrong in the checkout section");
        checkoutPage.returnTooMainPage();
    }
    @Test(description = "Turtle user. Searching a specific item then we change the quantity of what we buy")
    public void turtleUTestingSearchEngine() {
        String hiUser = "turtle";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.search();
        checkoutPage.buyHat();
        checkoutPage.quantityPlus();
        checkoutPage.enterAllPersonalInfo();
        checkoutPage.checkout();
        assertTrue(checkoutPage.orderComplete().getText().equals("Order complete"),"The order was not completed successfully something went wrong in the checkout section");
        checkoutPage.returnTooMainPage();
    }
    @Test(description = "Beetle user. Searching a specific item then we change the quantity of what we buy")
    public void beetleUTestingSearchEngine() {
        String hiUser = "beetle";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.search();
        checkoutPage.buyHat();
        checkoutPage.quantityPlus();
        checkoutPage.enterAllPersonalInfo();
        checkoutPage.checkout();
        assertTrue(checkoutPage.orderComplete().getText().equals("Order complete"),"The order was not completed successfully something went wrong in the checkout section");
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
    @Test(description = "Calculating total product quantity")
    public void totalQuantityOfProduct() {
        checkoutPage.addTooCart();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The price of the product" + checkoutPage.productPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The text price" + checkoutPage.taxPrice());
        double expectedTotal = checkoutPage.productPrice() + checkoutPage.taxPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Total Amount should be: " + expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "Total Amount is : " + checkoutPage.totalPrice());

        assertEquals(checkoutPage.totalPrice(), expectedTotal);

    }
    @Test(description = "Differing prices. 4 items added to checkout but you pay only 2")
    public void differingPrices() {
        checkoutPage.clickBalcony();
        checkoutPage.continueHomepage();
        checkoutPage.clickMetal();
//        ExtentTestNGITestListener.getTest().log(Status.INFO, "");
        double expectedTotal = checkoutPage.metalPrice() + checkoutPage.baconPrice();
//        ExtentTestNGITestListener.getTest().log(Status.INFO,checkoutPage.metalPrice());
//        ExtentTestNGITestListener.getTest().log(Status.INFO,checkoutPage.baconPrice());
        ExtentTestNGITestListener.getTest().log(Status.INFO, String.format("%f", expectedTotal));
        assertEquals(checkoutPage.totalPriceM_B(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The prices match");

    }
    @Test(description = "Items disappear from the cart when to delete something ")
    public void dinoUGhostCart() {
        String hiUser = "dino";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.continueHomepage();
        checkoutPage.clickBalcony();
        checkoutPage.continueHomepage();
        checkoutPage.clickMetal();
        double expectedTotal = checkoutPage.metalPrice() + checkoutPage.baconPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, String.format("%f", expectedTotal));
        assertEquals(checkoutPage.totalPriceM_B(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The prices match");
        checkoutPage.tCan();

        }
    @Test(description = "Items disappear from the cart when to delete something ")
    public void beetleUGhostCart() {
        String hiUser = "beetle";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.continueHomepage();
        checkoutPage.clickBalcony();
        checkoutPage.continueHomepage();
        checkoutPage.clickMetal();
        double expectedTotal = checkoutPage.metalPrice() + checkoutPage.baconPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, String.format("%f", expectedTotal));
        assertEquals(checkoutPage.totalPriceM_B(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The prices match");
        checkoutPage.tCan();

    }
    @Test(description = "Items disappear from the cart when to delete something ")
    public void turtleUGhostCart() {
        String hiUser = "turtle";
        checkoutPage.websiteLogin(hiUser);
        assertTrue(checkoutPage.massageHi().getText().equals(hiUser),("The Login was not successful do to incorrect user"));
        checkoutPage.continueHomepage();
        checkoutPage.clickBalcony();
        checkoutPage.continueHomepage();
        checkoutPage.clickMetal();
        double expectedTotal = checkoutPage.metalPrice() + checkoutPage.baconPrice();
        ExtentTestNGITestListener.getTest().log(Status.INFO, String.format("%f", expectedTotal));
        assertEquals(checkoutPage.totalPriceM_B(), expectedTotal);
        ExtentTestNGITestListener.getTest().log(Status.INFO, "The prices match");
        checkoutPage.tCan();

    }


}



//   try {
//        Thread.sleep(5000);
//        } catch (InterruptedException e) {
//        ExtentTestNGITestListener.getTest().log(Status.INFO, "This should work");
//        }