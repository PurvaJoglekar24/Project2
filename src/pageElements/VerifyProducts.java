package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyProducts {

	WebDriver driver;
	
	public VerifyProducts(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='/products']") WebElement productsBtn;
	@FindBy(xpath="//h2[contains(text(),'All Products')]") WebElement productsText;
	@FindBy(xpath="//a[@href='/product_details/1']") WebElement firstProduct;
	@FindBy(xpath="//h2[contains(text(),'Blue Top')]") WebElement nameofProduct;
	@FindBy(xpath="//p[contains(text(),\"Category: Women > Tops\")]") WebElement categoryofProduct;
	@FindBy(xpath="//span[contains(text(),\"Rs. 500\")]") WebElement priceofProduct;
	@FindBy(xpath="//b[contains(text(),\"Availability:\")]") WebElement availability;
	@FindBy(xpath="//b[contains(text(),\"Condition:\")]") WebElement condition;
	@FindBy(xpath="//b[contains(text(),\"Brand:\")]") WebElement Brand;
	@FindBy(id="search_product") WebElement searchTab;
	@FindBy(id="submit_search") WebElement searchBtn;
	@FindBy(xpath="//h2[contains(text(),\"Searched Products\")]") WebElement searchedproducttext;
	@FindBy(xpath="//p[contains(text(),\"Winter Top\")]") WebElement searchedproductname;
	
	public void products() {
		productsBtn.click();
		productsText.isDisplayed();
		firstProduct.click();
		String title=driver.getTitle();
		System.out.println(title);
		nameofProduct.getText();
		categoryofProduct.getText();
		priceofProduct.getText();
		availability.getText();
		condition.getText();
		Brand.getText();
		driver.navigate().back();
	}
	
	public void searchProduct() {
		
		searchTab.sendKeys("Winter Top");
		searchBtn.click();
		searchedproducttext.isDisplayed();
		searchedproductname.getText();
		
	}
}
