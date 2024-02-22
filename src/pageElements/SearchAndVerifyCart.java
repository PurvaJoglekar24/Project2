package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchAndVerifyCart {

WebDriver driver;
	
	public SearchAndVerifyCart(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/products']") WebElement productsBtn;
	@FindBy(xpath="//a[@data-product-id='5']") WebElement productadd;
	@FindBy(xpath="//div[@class='modal-content']/descendant::a") WebElement viewcart;
	@FindBy(xpath="//button[@data-dismiss='modal']") WebElement contshopping;
	@FindBy(xpath = "//a[@href='/login']") WebElement signUpBtn;
	@FindBy(xpath ="//h2[contains(text(),\"Login to your account\")]") WebElement loginText;
	@FindBy(xpath ="//input[@placeholder='Email Address']") WebElement emailAdd;
	@FindBy(xpath ="//input[@placeholder='Password']") WebElement pwd;
	@FindBy(xpath ="//button[@data-qa='login-button']") WebElement loginBtn;
	@FindBy(linkText="Cart") WebElement cartBtn;
	@FindBy(linkText="Winter Top") WebElement productincart;
	
	public void searchandverifycart() {
		try{driver.navigate().back();
		driver.navigate().back();
		Actions action= new Actions(driver);
		action.scrollByAmount(0, -200).build().perform();
		productsBtn.click();
	
		VerifyProducts v= new VerifyProducts(driver);
		v.searchProduct();
		}
		catch(Exception e){
			e.getStackTrace();
		}
	}
	public void verifycart() {
		try{Actions action= new Actions(driver);
		action.scrollByAmount(0, 200).build().perform();
		productadd.click();
		viewcart.click();
		System.out.println("Products are visible in cart");
		contshopping.click();
		}
		catch(Exception e){
			e.getStackTrace();
		}
	}
	public void login() {
		try {
		signUpBtn.click();		
		emailAdd.sendKeys("purvakulkarni99@gmail.com");	
		pwd.sendKeys("123456");	
		loginBtn.click();
		cartBtn.click();
		Actions action= new Actions(driver);
		action.scrollByAmount(0, 200).build().perform();
		productincart.getText();
		}
		catch(Exception e){
			e.getStackTrace();
		}
	}
}
