package pageElements;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifySubscriptions {

WebDriver driver;
	
	public VerifySubscriptions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),\"Subscription\")]") WebElement subscriptiontext;
	@FindBy(xpath="//input[@id='subscribe_email']") WebElement emailTextbox;
	@FindBy(id="subscribe") WebElement subscribeBtn;
	@FindBy(xpath="//ul[@class='nav navbar-nav']/descendant::a[@href='/view_cart']")  WebElement viewcart;
	@FindBy(xpath="//div[@class=\"modal-content\"]/descendant::button") WebElement contBtn;
	@FindBy(xpath="//ul[@class=\"nav navbar-nav\"]/descendant::a[@href=\"/\"]") WebElement HomeBtn;
	@FindBy(xpath="//i[@class=\"fa fa-angle-up\"]") WebElement upArrow;
	public void SubscriptionsHomePage() throws Exception  {

		try{
		HomeBtn.click();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		subscriptiontext.isDisplayed();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		emailTextbox.sendKeys("purvakulkarni99@gmail.com");
		subscribeBtn.click();
		
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void SubscriptionsCartPage() {
		
		try{upArrow.click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(viewcart));
		viewcart.click();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		subscriptiontext.isDisplayed();
		
		emailTextbox.sendKeys("purvakulkarni99@gmail.com");
		subscribeBtn.click();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
}
}