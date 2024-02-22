package pageElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderRegisterWhileCheckout  {
WebDriver driver;
	
	public PlaceOrderRegisterWhileCheckout(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href=\"/logout\"]") WebElement logoutBtn;
	@FindBy(xpath="//a[@href=\"/products\"]") WebElement productsBtn;
	@FindBy(xpath="//div[@class=\"productinfo text-center\"]/p[contains(text(),'Summer White Top')]") WebElement addproducttocart;
	@FindBy(xpath="//div[@class='modal-content']/descendant::a") WebElement viewcart;
	@FindBy(xpath="//a[@class=\"btn btn-default check_out\"]") WebElement checkoutBtn;
	@FindBy(xpath="//div[@class=\"modal-content\"]/descendant::a") WebElement registerLogin;
	@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]/li[3]/a") WebElement cartBtn;
	@FindBy(xpath="//h3[contains(text(),\"Your delivery address\")]/parent::li/following-sibling::li[1]") List<WebElement> address;
	@FindBy(xpath="//h3[contains(text(),\"Your billing address\")]/parent::li/following-sibling::li[1]") List<WebElement> billingaddress;
	@FindBy(name="message") WebElement ordercomment;
	@FindBy(xpath="//a[contains(text(),\"Place Order\")]") WebElement placeorderBtn;
	@FindBy(name="name_on_card") WebElement nameoncard;
	@FindBy(name="card_number") WebElement cardnumber;
	@FindBy(name="cvc") WebElement cvc;
	@FindBy(name="expiry_month") WebElement expirymonth;
	@FindBy(name="expiry_year") WebElement expiryyear;
	@FindBy(id="submit") WebElement submit;
	@FindBy(xpath="//p[contains(@style,\"font\")]") WebElement orderplacedmsg;
	@FindBy(xpath="//b[contains(text(),\"Account Deleted!\")]") WebElement delAcc;
	
//	public void logout() {
//		logoutBtn.click();
//	}
	
	public void placeOrderWhileCheckout() {
		try {
		productsBtn.click();
//		WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait1.until(ExpectedConditions.elementToBeClickable(addproducttocart));
		Actions a=new Actions(driver);
		a.scrollByAmount(0,1100).build().perform();
		addproducttocart.click();
		viewcart.click();
		String title=driver.getTitle();
		System.out.println(title);
	}	 catch(Exception e1) {
		e1.getStackTrace();
	}}
	
		public void checkout() {
			try {checkoutBtn.click();
	}
			catch(Exception e2) {
				e2.getStackTrace();
			}}
		
	public void registerLogin() {
		try {registerLogin.click();		
	}catch(Exception e3) {
		e3.getStackTrace();
	}}
	public void Signupandcreateaccount() throws Exception {
		try {SignUpPage signUpPage=new SignUpPage(driver);
		signUpPage.newUser();
		signUpPage.credentials("Purva", "purvamk24@gmail.com");
		signUpPage.birthdetails();
		signUpPage.addressdetails();
		signUpPage.accountCreated();
			}
		catch(Exception e4) {
			e4.getStackTrace();
		}}
		
	public void clickcartbtn() {
		try {cartBtn.click();
	}
		catch(Exception e5) {
			e5.getStackTrace();
		}}
	public void proceedtocheckout() {
		try {checkoutBtn.click();
		
		}
		catch(Exception e6) {
			e6.getStackTrace();
		}}
	public List<WebElement> verifydeliveryAddress() {
		try {
		for (WebElement add : address) {
			System.out.println(add.getText());
		}
		
		return address;
	}
		catch(Exception e6) {
			e6.getStackTrace();
		}
		return address;}
		
	
public List<WebElement> verifybillingAddress() {
	try {
		for (WebElement add : billingaddress) {
			System.out.println(add.getText());
			
		}
		return billingaddress;
	}
	catch(Exception e6) {
		e6.getStackTrace();
	}
	return address;}

	public void addcomment() {
	ordercomment.sendKeys("Place the order");
		
	}
	public void placeOrder() {
	placeorderBtn.click();
}
	public void cardDetails() {
		try{nameoncard.sendKeys("purva");
		cardnumber.sendKeys("123456789");
		cvc.sendKeys("123");
		expirymonth.sendKeys("09");
		expiryyear.sendKeys("2025");
		submit.click();
	}
		catch(Exception e7) {
			e7.getStackTrace();
		}}
	public void orderplacedmsg() {
	orderplacedmsg.getText();
	}
	public void deleteAccount() {
		try{delAcc.click();
		}
		catch(Exception e8) {
			e8.getStackTrace();
		}
}}