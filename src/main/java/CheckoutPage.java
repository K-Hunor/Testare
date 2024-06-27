import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CheckoutPage extends BasePage {

    public WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy (css = ".svg-inline--fa.fa-sign-in-alt.fa-w-16")
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
    @FindBy(css = ".svg-inline--fa.fa-angle-right.fa-w-8")
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
   public void login(){
        loginButton.click();
        firstName.sendKeys("dino");
        enterPassword.sendKeys("choochoo");
   }

    public WebElement orderComplete(){
        return finishMassage;
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
    public void enterPersonalInfo() {
        addCheckout.click();
        firstName.sendKeys("Joe");
        lastName.sendKeys("Braun");
        address.sendKeys("Secret Hole");
    }
    public void checkout(){
        continueCheckout.click();
        completeOrder.click();
    }
    public void returnTooMainPage(){
        continueShopping.click();
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
 //  public void dropDownSetHL(){
//        dropDown.
 //   }
}

