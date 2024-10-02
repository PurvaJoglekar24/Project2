package utils;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.AccountCreatedPage;
import main.java.AccountDeletedPage;
import main.java.CartPage;
import main.java.CheckoutPage;
import main.java.ContactusPage;
import main.java.EnterAccountInformationPage;
import main.java.HomePage;
import main.java.PaymentPage;
import main.java.ProductDetailsPage;
import main.java.ProductsPage;
import main.java.SignupLoginPage;
import main.java.TestcasesPage;

public class BasePage {
       public static WebDriver driver;
       static WebDriverWait wait;
       static JavascriptExecutor js;
       static Actions action;
       static Random rand;
       public static Object hoverOverElement;
       
        public static void launchUrl() {
        	ChromeOptions options=new ChromeOptions();
        	options.addExtensions(new File("C:\\Users\\purva\\OneDrive\\Documents\\Project 2- Automation\\AdBlock.crx"));
        	DesiredCapabilities capabilities = new DesiredCapabilities();
        	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        	options.merge(capabilities);
        	options.addArguments("--disable-notifications");
        	options.setExperimentalOption("prefs",new HashMap<String,Object>()
        	{{put ("autofill.profile_enabled",false);}});
        	options.addArguments("--save-password-bubble");
        	driver= new ChromeDriver(options);
        }
        public static void clickOnElement(WebElement element) {
    		//wait.until(ExpectedConditions.visibilityOf(element));
    		element.click();
    		}
        public static void elementwithWait(WebElement element) {
        	wait.until(ExpectedConditions.visibilityOf(element));
        }
        public static void clickUsingJavaScriptExec(WebElement element) {
        	js.executeScript("arguments[0].click();", element);
        }
        public static void scrollUsingJavaScriptExe(WebElement element) {
        	js.executeScript("arguments[0].scrollIntoView();", element);
        }
        public static void selectdropdown(WebElement element, String visibletext) {
        	Select s= new Select(element);
        	s.selectByVisibleText(visibletext);
        }
        public static void hoverOverElement(WebElement element) {
    		action.moveToElement(element).perform(); 
    	}
        public static String currentUrl() {
        	return driver.getCurrentUrl();
        }
        public static String currentTitle() {
        	return driver.getTitle();
        }
        
        public static void handleAlerts() {
        	Alert a= driver.switchTo().alert();
        	System.out.println(a.getText());
        	a.accept();
        }
        
        public static void waitUntillUrlContains(String url) {
        	wait.until(ExpectedConditions.urlToBe(url));
        }
        
        public static void refreshPage() {
			driver.navigate().refresh();
			
		}
        
        public static HomePage homePageInitialization() {
        	HomePage homepage= new HomePage(driver);
        	return homepage;
        }
        public static SignupLoginPage signupLoginPageInitialization() {
        	SignupLoginPage signUpLogin= new SignupLoginPage(driver);
        	return signUpLogin;
        }
        public static EnterAccountInformationPage enterAccountInformationPageInitialization() {
        	EnterAccountInformationPage enterAccountInformationPage= new EnterAccountInformationPage(driver);
        			return enterAccountInformationPage;
        }
		public static ProductsPage productsPageInitialization() {
			ProductsPage productsPage= new ProductsPage(driver);
			return productsPage;
		}
		public static AccountCreatedPage accountCreatedPageInitialization() {
			AccountCreatedPage accountCreatedPage= new AccountCreatedPage(driver);
			return accountCreatedPage;
		}
		public static AccountDeletedPage accountDeletedPageInitialization() {
			AccountDeletedPage accountDeletedPage= new AccountDeletedPage(driver);
			return accountDeletedPage;
		}
		public static CartPage cartPageInitialization() {
			CartPage cartPage=new CartPage(driver);
			return cartPage;
		}
		public static CheckoutPage CheckoutPageInitialization() {
			CheckoutPage checkoutPage = new CheckoutPage(driver);
			return checkoutPage;
		}
		public static PaymentPage paymentPageInitialization() {
			PaymentPage paymentPage = new PaymentPage(driver);
			return paymentPage;
		}

		public static ContactusPage ContactusPageInitialization() {
			ContactusPage contactusPage = new ContactusPage(driver);
			return contactusPage;
		}
		public static TestcasesPage testcasesPageInitialization() {
			TestcasesPage testcasesPage = new TestcasesPage(driver);
			return testcasesPage;
		}
		public static ProductDetailsPage productDetailsPageInitialization() {
			ProductDetailsPage productDetailsPage= new ProductDetailsPage(driver);
			return productDetailsPage;
			}
		
		
}
