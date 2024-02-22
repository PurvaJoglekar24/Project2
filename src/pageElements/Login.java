package pageElements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login  {

WebDriver driver;
	
	public Login(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//a[@href='/login']") WebElement signUpBtn;
	@FindBy(xpath ="//h2[contains(text(),\"Login to your account\")]") WebElement loginText;
	@FindBy(xpath ="//input[@placeholder='Email Address']") WebElement emailAdd;
	@FindBy(xpath ="//input[@placeholder='Password']") WebElement pwd;
	@FindBy(xpath ="//button[@data-qa='login-button']") WebElement loginBtn;
	@FindBy(xpath ="//p[@style=\"color: red;\"]") WebElement errormsg;
	@FindBy(xpath ="//a[contains(text(),\" Logout\")] ") WebElement logout;
	public void validCredentials(String validuname, String validpwd ) {
	signUpBtn.click();		
	emailAdd.sendKeys(validuname);	
	pwd.sendKeys(validpwd);	
	loginBtn.click();	
	
	}
	

	public void invalidCredentials(String invaliduname, String invalidpwd ) {
	logout.click();	
	signUpBtn.click();		
	emailAdd.sendKeys(invaliduname);	
	pwd.sendKeys(invalidpwd);	
	loginBtn.click();	
	errormsg.isDisplayed();
	
	}
	public void logout() {
	logout.click();
	String currtitle= driver.getTitle();
	System.out.println(currtitle);
	assertEquals(currtitle, "Automation Exercise - Signup / Login");
	}
	
}
