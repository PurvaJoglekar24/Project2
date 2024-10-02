package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class ContactusPage {

	public ContactusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='contact-form']/h2") WebElement getInTouch;
	@FindBy(name ="name") WebElement nameInput;
	@FindBy(name="email") WebElement emailInput;
	@FindBy(name="subject") WebElement subjectInput;
	@FindBy(id="message") WebElement messageInput;
	@FindBy(name="upload_file") WebElement fileUpload;
	@FindBy(name="submit") WebElement submitButton;
	@FindBy(xpath="//div[@class='contact-form']/div[2]") WebElement successMessage;
	@FindBy(xpath="//a[@href='/']")
	public WebElement homeButton;

	public String getInTouchText() {
		return getInTouch.getText();
	}
	public void nameEmailInput(String name, String email) {
		nameInput.sendKeys(name);
		emailInput.sendKeys(email);
		
	}
	public void subjectMessageInput(String Subject,String Message) {
		subjectInput.sendKeys(Subject);
		messageInput.sendKeys(Message);
	}

	public void uploadFile(String Filepath) {
		fileUpload.sendKeys(Filepath);
	}
	public void clickSubmitButton() {
		BasePage.clickOnElement(submitButton);
	}
	public String getSuccessMessage() {
		return successMessage.getText();
	}
}
