package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderLoginBeforeCheckout {
WebDriver driver;
	
	public PlaceOrderLoginBeforeCheckout(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/login']") WebElement signUpBtn;
	@FindBy(xpath ="//h2[contains(text(),\"Login to your account\")]") WebElement loginText;
	@FindBy(xpath ="//input[@placeholder='Email Address']") WebElement emailAdd;
	@FindBy(xpath ="//input[@placeholder='Password']") WebElement pwd;
	@FindBy(xpath ="//button[@data-qa='login-button']") WebElement loginBtn;
	@FindBy(xpath="//a[@href=\"/logout\"]") WebElement logoutBtn;
	public void login() {
		signUpBtn.click();		
		emailAdd.sendKeys("purvakulkarni99@gmail.com");	
		pwd.sendKeys("123456");	
		loginBtn.click();
	}
	
	public void placeorderloginbeforecheckout() {
		PlaceOrderRegisterWhileCheckout createorder2=new PlaceOrderRegisterWhileCheckout(driver);
		createorder2.placeOrderWhileCheckout();
		createorder2.clickcartbtn();
		createorder2.proceedtocheckout();
		createorder2.verifydeliveryAddress();
		createorder2.addcomment();
		createorder2.placeOrder();
		createorder2.cardDetails();
		createorder2.orderplacedmsg();
		
		}
	public void Logout() {
		logoutBtn.click();
	}
	
	
}
