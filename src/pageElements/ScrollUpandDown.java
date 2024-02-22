package pageElements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScrollUpandDown {
WebDriver driver;
	
	public ScrollUpandDown(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h2[contains(text(),\"Subscription\")]") WebElement Subscription;
	@FindBy(xpath="//i[@class=\"fa fa-angle-up\"]") WebElement upArrow;
	@FindBy(xpath="//h2[contains(text(),\"Full-Fledged practice website for Automation Engineers\"") WebElement text;

	
	public void usingArrowBtn() {try {
		
	
		driver.navigate().back();
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Subscription.isDisplayed();
		upArrow.click();
		text.isDisplayed();
	}
	catch(Exception e){
		e.getStackTrace();
	}
	}
	public void withoutArrowBtn() {try {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Subscription.isDisplayed();
		Actions action= new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		text.isDisplayed();
	}
	catch(Exception e){
		e.getStackTrace();
	}
}
}