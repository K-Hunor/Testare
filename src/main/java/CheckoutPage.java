import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CheckoutPage extends BasePage {

    public WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy (css = ".btn.btn-link")
    private WebElement loginButton;
    @FindBy (id="user-name")
    private WebElement enterUsername;
    @FindBy (id="password")
    private  WebElement enterPassword;
    @FindBy (css = ".btn.btn-primary")
    private WebElement loginFinal;
    @FindBy(linkText = "Awesome Metal Chair")
    private WebElement metalChair;
    @FindBy(css = ".btn.btn-link")
    private WebElement addTooCrtChips;
    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16.fa-3x")
    private WebElement likeMetalChair;
    @FindBy(css = ".svg-inline--fa.fa-heart.fa-w-16")
    private WebElement wishlist;
    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-2x")
    private WebElement addTooCartFW;
    @FindBy(css = ".svg-inline--fa.fa-shopping-cart.fa-w-18")
    private WebElement cartTopIcon;
    @FindBy(css = ".btn.btn-success")
//    @FindBy(linkText = "Checkout")
    private WebElement addCheckout;
    @FindBy(id="first-name")
    private WebElement firstName;
    @FindBy(id="last-name")
    private WebElement lastName;
    @FindBy(id="address")
    private WebElement address;
    @FindBy(css = ".svg-inline--fa.fa-angle-right.fa-w-8")
    private WebElement continueCheckout;
    @FindBy(css = ".svg-inline--fa.fa-angle-right.fa-w-8")
    private WebElement completeOrder;
    @FindBy(css = ".svg-inline--fa.fa-angle-right.fa-w-8")
    private WebElement continueShopping;
    @FindBy(css = ".svg-inline--fa.fa-plus-circle.fa-w-16")
    private WebElement quantity;
    public void quantityPlus(){
        quantity.click();
        quantity.click();
    }
    @FindBy(css = ".svg-inline--fa.fa-shopping-bag.fa-w-14.fa-3x.brand-logo")
    private WebElement homePage;
    @FindBy(css = ".sort-products-select.form-control.form-control-sm")
    private WebElement dropDown;
    @FindBy(id="input-search")
    private WebElement searchItem;
    @FindBy(css = ".btn.btn-light.btn-sm")
    private WebElement searchButton;
    @FindBy(css = ".card-link")
    private WebElement hatLink;
    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
    private WebElement addTooCartHat;
    @FindBy(css = ".text-muted")
    private WebElement finishMassage;
    @FindBy(css = ".error")
    private WebElement errorFirstName;
    @FindBy(css = ".error")
    private WebElement errorLastName;
    @FindBy(css = ".error")
    private WebElement errorAddress;

    @FindBy(xpath = "(//td[@class='amount'])[1]")
    private WebElement itemsTotal;
    @FindBy(xpath = "(//td[@class='amount'])[2]")
    private WebElement taxAmount;
    @FindBy(xpath = "(//td[@class='amount'])[3]")
    private WebElement totalAmount;
    public double productPrice(){
    String amountValue = itemsTotal.getText();
    String cleanAmountValue = amountValue.replace("$","");
        return Double.parseDouble(cleanAmountValue);

    }
    public double taxPrice(){
        String taxValue = taxAmount.getText();
        String cleanTaxValue = taxValue.replace("$","");
        return Double.parseDouble(cleanTaxValue);

    }
    public double totalPrice(){
        String totalValue = totalAmount.getText();
        String cleanTotalValue = totalValue.replace("$","");
        return Double.parseDouble(cleanTotalValue);

    }


    @FindBy(xpath = "//*[@id=\"responsive-navbar-nav\"]/div[2]/span/span/span/a")
    private WebElement hiMassage;
    public WebElement massageHi(){
        return hiMassage;
    }
    @FindBy(css = ".error")
    private WebElement errorLogin;
    public WebElement loginError(){
        return errorLogin;
    }
   public void goodLogin(){
        loginButton.click();
        enterUsername.sendKeys("dino");
        enterPassword.sendKeys("choochoo");
        loginFinal.click();
    }
    public void websiteLogin(String user){
        loginButton.click();
        enterUsername.sendKeys(user);
        enterPassword.sendKeys("choochoo");
        loginFinal.click();
    }
    @FindBy(xpath = "//*[@id=\"responsive-navbar-nav\"]/div[2]/span/a[2]/span")
    private WebElement wishlistProductCount;
    public WebElement countWishlistProducts(){
        return wishlistProductCount;
    }
    @FindBy(xpath = "//*[@id=\"responsive-navbar-nav\"]/div[2]/span/a[1]/span")
    private WebElement cartProductCount;
    public WebElement countCartProducts(){
        return cartProductCount;
    }
    public void buggedLogin(){
        loginButton.click();
        enterUsername.sendKeys("beetle");
        enterPassword.sendKeys("choochoo");
        loginFinal.click();
    }
    public void slowLogin(){
        loginButton.click();
        enterUsername.sendKeys("turtle");
        enterPassword.sendKeys("choochoo");
        loginFinal.click();
    }

   public void badLoginBadCredentials(){
        loginButton.click();
        enterUsername.sendKeys("rex");
        enterPassword.sendKeys("chocolate");
        loginFinal.click();
   }
    public void badLoginNoUsername(){
        loginButton.click();
        enterUsername.sendKeys("");
        enterPassword.sendKeys("choochoo");
        loginFinal.click();
    }
    public void badLoginNoPassword(){
        loginButton.click();
        enterUsername.sendKeys("dino");
        enterPassword.sendKeys("");
        loginFinal.click();
    }
    public void badLoginSpecialCharacters(){
        loginButton.click();
        enterUsername.sendKeys("dinő");
        enterPassword.sendKeys("hoochoő");
        loginFinal.click();
    }
    public void lockedOutUser(){
        loginButton.click();
        enterUsername.sendKeys("locked");
        enterPassword.sendKeys("choochoo");
        loginFinal.click();
    }
    public WebElement orderComplete(){
        return finishMassage;
    }
    public WebElement noFirstNameError(){
        return errorFirstName;
    }
    public WebElement noLastNameError(){
        return errorLastName;
    }
    public WebElement noAddressError(){
        return errorAddress;
    }

    public void addTooWishlist()  {
        metalChair.click();
        likeMetalChair.click();
        wishlist.click();
    }
    public void addTooCart() {
        addTooCartFW.click();
        cartTopIcon.click();
    }
    public void addTooCartMC() {
        metalChair.click();
        clickCart.click();
        cartTopIcon.click();
    }
    public void enterAllPersonalInfo() {
        addCheckout.click();
        firstName.sendKeys("Joe");
        lastName.sendKeys("Braun");
        address.sendKeys("Secret Hole");
    }
    public void enterPersonalInfoNoFirstName() {
        addCheckout.click();
        firstName.sendKeys("");
        lastName.sendKeys("Braun");
        address.sendKeys("Secret Hole");
    }
    public void enterPersonalInfoNoLastName() {
        addCheckout.click();
        firstName.sendKeys("Joe");
        lastName.sendKeys("");
        address.sendKeys("Secret Hole");
    }
    public void enterPersonalInfoNoAddress() {
        addCheckout.click();
        firstName.sendKeys("Joe");
        lastName.sendKeys("Braun");
        address.sendKeys("");
    }
    public void checkoutClick(){
        addCheckout.click();
    }
    public void firstNamePersonalInfo(String fName) {
        firstName.sendKeys(fName);
    }
    public void clearFirstName(){
        firstName.clear();
    }
    public WebElement getFirstName(){
        return firstName;
    }

    public void  lastNamePersonalInfo(String lName) {
        lastName.sendKeys(lName);
    }
    public WebElement getLastName(){
        return lastName;
    }

    public void addressPersonalInfo(String addressTxt){
        address.sendKeys(addressTxt);
    }
    public WebElement getAddress(){
        return address;
    }

    public void checkout(){
        continueCheckout.click();
        completeOrder.click();
    }
    public void returnTooMainPage(){
        continueShopping.click();
        homePage.click();
    }
    public void continueHomepage(){
        homePage.click();
    }
    public void search(){
        searchItem.sendKeys("hat");
        searchButton.click();
    }
    public void buyHat(){
        hatLink.click();
        addTooCartHat.click();
        cartTopIcon.click();
    }
    @FindBy(linkText = "Practical Wooden Bacon")
    private WebElement balcony;
    public void clickBalcony(){
        balcony.click();
        clickCart.click();
        clickCart.click();
    }
    @FindBy(css = ".svg-inline--fa.fa-cart-plus.fa-w-18.fa-3x")
    private WebElement clickCart;

    public void clickMetal(){
        metalChair.click();
        clickCart.click();
        clickCart.click();
        cartTopIcon.click();
//        trashCan.click();
    }
    public void tCan(){
        trashCan.click();
    }
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div[1]/div/div[5]/button")
    private WebElement trashCan;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div[1]/div/div[3]/div")
    private WebElement metalNumber;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/div")
    private WebElement baconNumber;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/table/tbody/tr[3]/td[2]")
    private WebElement totalNumber;
    public double metalPrice(){
        String amountValue = metalNumber.getText();
        String cleanAmountValue = amountValue.replace("$","");
        return Double.parseDouble(cleanAmountValue);
    }
    public double baconPrice(){
        String amountValue = baconNumber.getText();
        String cleanAmountValue = amountValue.replace("$","");
        return Double.parseDouble(cleanAmountValue);
    }
    public double totalPriceM_B(){
        String amountValue = totalNumber.getText();
        String cleanAmountValue = amountValue.replace("$","");
        return Double.parseDouble(cleanAmountValue);
    }
    public double finalPrice(){
        String amountValue = totalNumber.getText();
        String cleanAmountValue = amountValue.replace("$","");
        return Double.parseDouble(cleanAmountValue);
    }
    public void betele() {
        Select dropdown = new Select(driver.findElement(By.cssSelector("sort-products-select form-control form-control-sm")));
        dropdown.selectByVisibleText("Sort by name (A to Z)");
    }
    @FindBy(css = ".text-center.container")
    private WebElement addItemM;
    public WebElement addItemMassage(){
        return addItemM;
    }




    //  public void dropDownSetHL(){
//        dropDown.
 //   }
}

