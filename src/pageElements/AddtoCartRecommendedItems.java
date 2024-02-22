package pageElements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCartRecommendedItems {

WebDriver driver;
	
	public AddtoCartRecommendedItems(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="recommended-item-carousel") WebElement recitemcarousel;
	@FindBy(xpath="//div[@class='product-overlay']/descendant::a[@data-product-id=\"4\")") WebElement recproduct;
	@FindBy(xpath="//u[contains(text(),\"View Cart\")]") WebElement viewcart;
	
	
	public void recommendeditems() {try {
		Actions action= new Actions(driver);
		action.scrollByAmount(0, 600).build().perform();
		recitemcarousel.isDisplayed();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(recproduct)).click();
		viewcart.click();
		recproduct.getText();
	}
	catch(Exception e){
		e.getStackTrace();
	}
	}
}
