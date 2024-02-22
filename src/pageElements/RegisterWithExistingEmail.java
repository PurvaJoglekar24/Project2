package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterWithExistingEmail {

WebDriver driver;
	
	public RegisterWithExistingEmail(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[@href='/login']") WebElement signUpBtn;
	@FindBy(xpath="//h2[contains(text(),\"New User Signup!\")]") WebElement newUser;
	@FindBy(name="name") WebElement enterName;
	@FindBy(xpath="//form[@action=\"/signup\"]/input[3]") WebElement enterEmail;
	@FindBy(xpath="//button[@data-qa=\"signup-button\"]") WebElement newUserSignup;
	@FindBy(xpath="//p[contains(text(),\"Email Address already exist!\")]") WebElement errormsg2;
	
	public void registerExistingEmail(String name,String email) throws Exception {
		signUpBtn.click();
		newUser.isDisplayed();
		enterName.sendKeys(name);
		enterEmail.sendKeys(email);
		newUserSignup.click();
		Thread.sleep(3000);
		errormsg2.isDisplayed();
	}
}
