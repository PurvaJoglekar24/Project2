package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveProdctsFromCart {
WebDriver driver;
	
	public RemoveProdctsFromCart(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='/login']") WebElement signUpBtn;
	@FindBy(xpath ="//h2[contains(text(),\"Login to your account\")]") WebElement loginText;
	@FindBy(xpath ="//input[@placeholder='Email Address']") WebElement emailAdd;
	@FindBy(xpath ="//input[@placeholder='Password']") WebElement pwd;
	@FindBy(xpath ="//button[@data-qa='login-button']") WebElement loginBtn;
	@FindBy(xpath="//a[@href='/products']") WebElement productsBtn;
	@FindBy(xpath="//p[contains(text(),'Blue Top')]") WebElement firstProduct;
	@FindBy(xpath="//div[@class=\"product-overlay\"]/div[1]/a[@data-product-id='1']")  WebElement addfirstproduct;
	@FindBy(xpath="//div[@id=\"cartModal\"]/descendant::a") WebElement viewCart;
	@FindBy(xpath="//a[@data-product-id=\"1\"]") WebElement removeproduct;
	@FindBy(xpath="//a[@href=\"/logout\"]") WebElement logoutBtn;
	public void loginforremoveaccount() {
		try{signUpBtn.click();		
		emailAdd.sendKeys("purvakulkarni99@gmail.com");	
		pwd.sendKeys("123456");	
		loginBtn.click();}
		catch(Exception e){
			e.getStackTrace();
		}
	}
	public void addproduct() {
		try{

		productsBtn.click();
		Actions a= new Actions(driver);
		a.scrollByAmount(0, 200).build().perform();
		a.moveToElement(firstProduct).build().perform();
		addfirstproduct.click();
		viewCart.click();
		removeproduct.click(); 
			System.out.println("Product removed from cart");
	
	}
	catch(Exception e){
		e.getStackTrace();
	}
}}
