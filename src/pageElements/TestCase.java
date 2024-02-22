package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCase {

	WebDriver driver;
	 public TestCase(WebDriver driver) {
		 this.driver= driver;
		 PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath="//a[@href='/test_cases']/child::i") WebElement testCasesBtn;
	 @FindBy(xpath="//h2[@class='title text-center']") WebElement text;
	 
	 public void testCases() {
		 testCasesBtn.click();
		 text.isDisplayed();
	 }
	 
}
