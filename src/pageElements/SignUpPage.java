package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpPage {

WebDriver driver;
	
	public SignUpPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/login']") WebElement signUpBtn;
	@FindBy(xpath="//h2[contains(text(),\"New User Signup!\")]") WebElement newUser;
	@FindBy(name="name") WebElement enterName;
	@FindBy(xpath="//form[@action=\"/signup\"]/input[3]") WebElement enterEmail;
	@FindBy(xpath="//form[@action=\"/signup\"]/button") WebElement newUserSignup;
	@FindBy(xpath="//b[contains(text(),\"Enter Account Information\")]") WebElement accInfo;
	@FindBy(id="id_gender2") WebElement title;
	@FindBy(id="password") WebElement password;
	@FindBy(id="days") WebElement days;
	@FindBy(id="months") WebElement months;
	@FindBy(id="years") WebElement years;
//	@FindBy(xpath="//select[@id='days']/option[6]") WebElement day;
	@FindBy(id="newsletter") WebElement newsLetter;
	@FindBy(id="optin") WebElement offers;
	@FindBy(id="first_name") WebElement first_name;
	@FindBy(id="last_name") WebElement last_name;
	@FindBy(id="company") WebElement company;
	@FindBy(id="address1") WebElement address1;
	@FindBy(id="address2") WebElement address2;
	@FindBy(id="country") WebElement country;
	@FindBy(id="state") WebElement state;
	@FindBy(id="city") WebElement city;
	@FindBy(id="zipcode") WebElement zipcode;
	@FindBy(id="mobile_number") WebElement mobile_number;
	@FindBy(xpath="//button[@type=\"submit\"]") WebElement createAccount;
	@FindBy(xpath="//b[contains(text(),'Account Created')]") WebElement AccCreated;
	@FindBy(xpath="//a[contains(text(),'Continue')]") WebElement continueBtn;
	@FindBy(xpath="//i[@class='fa fa-user']") WebElement loggedinAs;
	@FindBy(xpath="//a[@href=\"/logout\"]")  WebElement logout;
	@FindBy(xpath="//i[@class='fa fa-trash-o']") WebElement deleteBtn;
	@FindBy(xpath="//b[contains(text(),\"Account Deleted!\")]") WebElement delAcc;
	@FindBy(xpath="//a[@data-qa=\"continue-button\"]") WebElement cont;
	
	
	@Test
	public void deletingAlreadyregisteredaccount() {
		
				
		signUpBtn.click();
		Login lp=new Login(driver);
		lp.validCredentials("purvakulkarni99@gmail.com","123456");
		deleteBtn.click();
		cont.click();
	}
	
	@Test
	public void registerUser() {
		signUpBtn.click();
		String title=driver.getTitle();
		System.out.println(title);
		
	}
	public void newUser() throws Exception  {
		Thread.sleep(4000);
		signUpBtn.click();
//		New user signup
		newUser.getText();}
	
	public void credentials(String name, String email) {
		
		enterName.sendKeys(name);
		enterEmail.sendKeys(email);
		newUserSignup.click();
		accInfo.getText();
		title.click();
		password.sendKeys("123456");
		}
	
		public void birthdetails() {
		Select s1= new Select(days);
		s1.selectByValue("5");
		Select s2= new Select(months);
		s2.selectByValue("6");
		Select s3= new Select(years);
		s3.selectByValue("1994");
		}
		public void addressdetails() {
		newsLetter.click();
		offers.click();
		
		first_name.sendKeys("Purva");
		last_name.sendKeys("Joglekar");
		company.sendKeys("abc");
		address1.sendKeys("lane1");
		address2.sendKeys("abc colony");
		
		Select s4= new Select(country);
		s4.selectByValue("India");
		
		state.sendKeys("Maharashtra");
		city.sendKeys("Pune");
		zipcode.sendKeys("123456");
		mobile_number.sendKeys("1234567890");
		
	}
		public void accountCreated() {
		createAccount.click();
		
		AccCreated.getText();
		continueBtn.click();
		loggedinAs.isDisplayed();
		logout.click();
	}
		
		public void accountDeleted() {
		deleteBtn.click();
		delAcc.isDisplayed();
		cont.click();
		
	}
}
