package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class EnterAccountInformationPage {

	public EnterAccountInformationPage(WebDriver driver) {
		
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//div[@class='login-form']/h2/b") WebElement enterAccountInformation;
		@FindBy(id="id_gender2") WebElement titleMrsCheckbox;
		@FindBy(id="password") WebElement passwordInput;
		@FindBy(id="days") WebElement daySelect;
		@FindBy(id="months") WebElement monthSelect;
		@FindBy(id="years") WebElement yearSelect;
		@FindBy(id="newsletter") WebElement newsletterCheckbox;
		@FindBy(id="optin") WebElement specialOfferCheckbox;
		@FindBy(xpath="//h2[@class='title text-center']/b") WebElement addressInformation;
		@FindBy(id="first_name") WebElement firstNameInput;
		@FindBy(id="last_name") WebElement lastNameInput;
		@FindBy(id="company") WebElement companyInput;
		@FindBy(id="address1") WebElement address1Input;
		@FindBy(id="address2") WebElement address2Input;
		@FindBy(id="country") WebElement countrySelect;
		@FindBy(id="state") WebElement stateInput;
		@FindBy(id="city") WebElement cityInput;
		@FindBy(id="zipcode") WebElement zipcodeInput;
		@FindBy(id="mobile_number") WebElement mobileNumberInput;
		@FindBy(xpath="//button[@type='submit']") WebElement createAccountButton;
		
		public String enterAccountInformationText() {
			return enterAccountInformation.getText();
		}
		
		public void fillRegistrationform() {
			BasePage.clickOnElement(titleMrsCheckbox);
			passwordInput.sendKeys("purva");
			BasePage.clickOnElement(newsletterCheckbox);
			BasePage.clickOnElement(specialOfferCheckbox);
			BasePage.selectdropdown(daySelect, "6");
			BasePage.selectdropdown(monthSelect, "June");
			BasePage.selectdropdown(yearSelect, "1994");
			firstNameInput.sendKeys("Purva");
			lastNameInput.sendKeys("K");
			companyInput.sendKeys("ABC");
			address1Input.sendKeys("Ideal colony");
			address2Input.sendKeys("Mumbai");
			BasePage.selectdropdown(countrySelect, "India");
			stateInput.sendKeys("Maharashtra");
			cityInput.sendKeys("Mumbai");
			zipcodeInput.sendKeys("412563");
			mobileNumberInput.sendKeys("4567891230");
			BasePage.clickOnElement(createAccountButton);
		}
		public String addressInformationText() {
			return addressInformation.getText();
		}
		
		
	

}
