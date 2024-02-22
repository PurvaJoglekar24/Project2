package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderRegisterBeforeCheckout {
WebDriver driver;
	
	public PlaceOrderRegisterBeforeCheckout(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Signupandcreateaccount() throws Exception {
		try{SignUpPage signUpPage=new SignUpPage(driver);
		signUpPage.newUser();
		signUpPage.credentials("Purva", "purva123@gmail.com");
		signUpPage.birthdetails();
		signUpPage.addressdetails();
		signUpPage.accountCreated();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void createorder() {
		PlaceOrderRegisterWhileCheckout createorder1= new PlaceOrderRegisterWhileCheckout(driver);
		try{createorder1.placeOrderWhileCheckout();
		createorder1.clickcartbtn();
		createorder1.proceedtocheckout();
		createorder1.verifydeliveryAddress();
		createorder1.addcomment();
		createorder1.placeOrder();
		createorder1.cardDetails();
		createorder1.orderplacedmsg();
		createorder1.deleteAccount();
	}
		catch(Exception e) {
			e.getStackTrace();
		}
		
}}
