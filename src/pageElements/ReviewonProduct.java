package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewonProduct {

WebDriver driver;
	
	public ReviewonProduct(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='/products']") WebElement productsBtn;
	@FindBy(xpath="//a[@href=\"/product_details/1\")]") WebElement viewproduct;
	@FindBy(id="name") WebElement yourname;
	@FindBy(id="email") WebElement email;
	@FindBy(id="review") WebElement review;
	@FindBy(id="button-review") WebElement Btnreview;
	public void reviewonProduct() {
		try {
	productsBtn.click();
	viewproduct.click();
	yourname.sendKeys("Purva");
	email.sendKeys("purvakulkarni99@gmail.com");
	review.sendKeys("Very nice product");
	Btnreview.click();
		}
		catch(Exception e){
			e.getStackTrace();
		}
}
}