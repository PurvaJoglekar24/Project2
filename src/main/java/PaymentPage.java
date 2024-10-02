package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class PaymentPage {

	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@data-qa='name-on-card']") WebElement nameOnCardInput;
	@FindBy(xpath="//input[@data-qa='card-number']") WebElement cardNumberInput;
	@FindBy(xpath="//input[@data-qa='cvc']")WebElement cvcInput;
	@FindBy(xpath="//input[@data-qa='expiry-month']")WebElement expirationMonthInput;
	@FindBy(xpath="//input[@data-qa='expiry-year']")WebElement expirationYearInput;
	@FindBy(xpath="//button[@data-qa='pay-button']")WebElement payAndConfirmOrder;
	@FindBy(xpath="//div[@id=\"success_message\"]/div")WebElement successMessage;
	@FindBy(xpath="//div[text()='You have been successfully subscribed!']")WebElement orderConfirmationMessage;
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div/a")WebElement downloadInvoice;
	@FindBy(xpath="//a[@data-qa='continue-button']")WebElement continueButton;
	
	public void enterPaymentDetails() {
		nameOnCardInput.sendKeys("abc");
		cardNumberInput.sendKeys("1234 4567 7891 1235");
		cvcInput.sendKeys("568");
		expirationMonthInput.sendKeys("may");
		expirationYearInput.sendKeys("2030");
		
	}
	public void paynConfirmOrder() {
		BasePage.clickOnElement(payAndConfirmOrder);
	}
	public String confirmationMessage() {
		BasePage.elementwithWait(orderConfirmationMessage);
		return orderConfirmationMessage.getText();
	}
	public void clickOnDownloadInvoice() {
		BasePage.clickUsingJavaScriptExec(downloadInvoice);
	}
	public void clickOnContinue() {
		BasePage.clickUsingJavaScriptExec(continueButton);
	}
}
