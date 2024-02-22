package pageElements;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProducts {

WebDriver driver;
	
	public AddProducts(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='/products']") WebElement productsBtn;
	@FindBy(xpath="//p[contains(text(),'Blue Top')]") WebElement firstProduct;
	@FindBy(xpath="//div[@class=\"product-overlay\"]/div[1]/a[@data-product-id='1']")  WebElement addfirstproduct;
	@FindBy(xpath="//div[@class='modal-content']/child::div[3]/button")  WebElement contShopping;
	@FindBy(xpath="//p[contains(text(),'Men Tshirt')]") WebElement secondProduct;
	@FindBy(xpath="//div[@class='product-overlay']/div[1]/a[@data-product-id='2']")  WebElement addsecondproduct;
	@FindBy(xpath="//div[@id=\"cartModal\"]/descendant::a") WebElement viewCart;
	@FindBy(xpath="//a[@href=\"/product_details/7\"]") WebElement viewthirdproduct;
	@FindBy(xpath="//h2[contains(text(),'Madame Top For Women')]") WebElement thirdproductdetails;
	@FindBy(xpath="//input[@id=\"quantity\"]") WebElement quantity;
	@FindBy(xpath="//button[@class=\"btn btn-default cart\"]") WebElement addToCart;
	@FindBy(xpath="//p[@class=\"text-center\"]/a") WebElement viewCartBtn;
	@FindBy(xpath="//button[contains(text(),'4')]") WebElement verifyQtty;
	
	public void subscriptionsHomePage() throws IOException {
		try {		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(document.body.scrollHeight,0)");
		productsBtn.click();
		Actions a=new Actions(driver);
		a.scrollByAmount(0,200).build().perform();
		WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.elementToBeClickable(addfirstproduct));
		addfirstproduct.click();
		
//		wait1.until(ExpectedConditions.elementToBeClickable(contShopping));
//		contShopping.click();
		a.moveToElement(secondProduct).build().perform();
		wait1.until(ExpectedConditions.elementToBeClickable(addsecondproduct));
		addsecondproduct.click();
		viewCart.click();
		
		TakesScreenshot sc= (TakesScreenshot) driver;
		File src= sc.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\purva\\OneDrive\\Documents\\Project 2- Automation\\automationexercise.jpeg");
		FileHandler.copy(src, dest);
		System.out.println("ScreenshotTaken");
		}
		catch(Exception e) {
			e.getStackTrace();
		}
}
	public void verifyProductQtty() {
		try{
			Actions ac= new Actions(driver);
		
		ac.scrollByAmount(0, -200).build().perform();
		productsBtn.click();
		ac.scrollByAmount(0, 300).build().perform();
		viewthirdproduct.click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(thirdproductdetails));
		thirdproductdetails.getText();
		quantity.clear();
		quantity.sendKeys("4");
		addToCart.click();
		viewCartBtn.click();
		ac.scrollByAmount(0, 300).build().perform();
		verifyQtty.getText();
		}
		catch(Exception e1) {
			e1.getStackTrace();
		}
		
	}
	
}