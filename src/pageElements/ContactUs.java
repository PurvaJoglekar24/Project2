package pageElements;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {

	WebDriver driver;
	 public ContactUs(WebDriver driver) {
		 this.driver= driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy (xpath="//a[contains(text(),\" Contact us\")]") WebElement Contactus;
	 @FindBy(name="name") WebElement name;
	 @FindBy(name="email") WebElement email; 
	 @FindBy(name="subject") WebElement subject;  
	 @FindBy(name="message") WebElement message; 
	 @FindBy(name="upload_file") WebElement fileInput;
	 @FindBy(name="submit") WebElement submitBtn;
	 @FindBy (xpath="//*[contains(@class,'status')]") WebElement successmsg;
	 @FindBy (xpath="//i[@class='fa fa-angle-double-left']") WebElement homeBtn;
	 
	 public void contactUsForm(String uname, String uemail,String usubject,String umessage) {
	 Contactus.click();
	 name.sendKeys(uname);
	 email.sendKeys(uemail);
	 subject.sendKeys(usubject);
	 message.sendKeys(umessage);
		 
	 
	 fileInput.sendKeys("C:\\Users\\purva\\OneDrive\\Documents\\Assignments\\Assignment-2 Amazon.com.doc");
	 submitBtn.click();
	 
	 Alert a= driver.switchTo().alert();
	 a.accept();
	 successmsg.getText();
	 homeBtn.click();
	 String title= driver.getTitle();
	 System.out.println(title);
	 }	 
}

