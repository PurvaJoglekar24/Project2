package pageElements;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCategoryProducts {

WebDriver driver;
	
	public ViewCategoryProducts(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),\"Home\")]") WebElement home;
	@FindBy(xpath="//h2[contains(text(),\"Category\")]") WebElement category;
	@FindBy(linkText="WOMEN") WebElement women;
	@FindBy(linkText="SAREE") WebElement saree;
	@FindBy(xpath="//a[contains(text(),\"Women - Saree Products\")]") WebElement sareeproductstext;
	@FindBy(linkText="MEN") WebElement men;
	@FindBy(linkText="TSHIRTS") WebElement tshirts;
	@FindBy(xpath="//h2[contains(text(),\"Brands\")]") WebElement brands;
	@FindBy(linkText="MADAME") WebElement madame;
	@FindBy(linkText="BABYHUG") WebElement babyhug;
	
	
	public void home() {
		home.click();
	}
	public void category() throws IOException {
		try{
			Actions action= new Actions(driver);
		
		action.scrollByAmount(0, 100).build().perform();
		category.getText();
		TakesScreenshot sc2= (TakesScreenshot) driver;
		File src=sc2.getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\purva\\OneDrive\\Documents\\Project 2- Automation\\screenshot2");
		FileHandler.copy(src, dest);
		System.out.println("Screenshot taken");
		women.click();
		saree.click();
		String title= driver.getTitle();
		System.out.println(title);
		sareeproductstext.getText();
		men.click();
		tshirts.click();
		String title2= driver.getTitle();
		System.out.println(title2);
		}
	
	catch(Exception e){
		e.getStackTrace();
	}
	}
	
	public void brands() throws IOException {
		try{Actions action= new Actions(driver);
		action.scrollByAmount(0, 200).build().perform();
		brands.getText();
		TakesScreenshot sc3= (TakesScreenshot) driver;
		File src=sc3.getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\purva\\OneDrive\\Documents\\Project 2- Automation\\screenshot3");
		FileHandler.copy(src, dest);
		System.out.println("Screenshot taken");
		madame.click();
		String title= driver.getTitle();
		System.out.println(title);
		babyhug.click();
		String title2=driver.getTitle();
		System.out.println(title2);
		}
	catch(Exception e){
		e.getStackTrace();
	}
	}
	
}
