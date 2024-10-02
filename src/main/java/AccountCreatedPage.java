package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class AccountCreatedPage {

	public AccountCreatedPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h2[@data-qa='account-created']/b") WebElement accountCreated;
	@FindBy(xpath="//a[@data-qa='continue-button']") WebElement continueButton;

	public String accountCreatedtext() {
		return accountCreated.getText();
	}
	public void clickContinueButton() {
		BasePage.clickUsingJavaScriptExec(continueButton);
	}
}
