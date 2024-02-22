package test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import pageElements.AddProducts;
import pageElements.AddtoCartRecommendedItems;
import pageElements.ContactUs;
import pageElements.Login;
import pageElements.PlaceOrderLoginBeforeCheckout;
import pageElements.PlaceOrderRegisterBeforeCheckout;
import pageElements.PlaceOrderRegisterWhileCheckout;
import pageElements.RegisterWithExistingEmail;
import pageElements.RemoveProdctsFromCart;
import pageElements.ReviewonProduct;
import pageElements.ScrollUpandDown;
import pageElements.SearchAndVerifyCart;
import pageElements.SignUpPage;
import pageElements.TestCase;
import pageElements.VerifyProducts;
import pageElements.VerifySubscriptions;
import pageElements.ViewCategoryProducts;

public class BaseTest {
	

	WebDriver driver;

	@Test
	public void adBlocker() {
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
	@Test(priority=1)
	public void launchApplication() {
		
		driver.navigate().to("http://automationexercise.com");
		driver.manage().window().maximize();
		}
	
	@Test(priority=2)
	public void signUp() throws Exception {
		SignUpPage s=new SignUpPage(driver);
		s.deletingAlreadyregisteredaccount();
		s.registerUser();
		s.newUser();
		s.credentials("Purva Joglekar", "purvakulkarni99@gmail.com");
		s.birthdetails();
		s.addressdetails();
		s.accountCreated();
	}
	@Test(priority=3)
	public void login() {
		Login l=new Login(driver);
		l.validCredentials("purvakulkarni99@gmail.com", "123456");
		l.invalidCredentials("purva@gmail.com", "123");
	}
	
	@Test(priority=4)
	public void registerwithexistingemail() throws Exception{
		RegisterWithExistingEmail reg=new RegisterWithExistingEmail(driver);
		reg.registerExistingEmail("Purva Joglekar", "purvakulkarni99@gmail.com");
		
	}
	
	@Test(priority=5)
	public void contactUsform() {
		ContactUs contact=new ContactUs(driver);
		contact.contactUsForm("Purva","purvakulkarni99@gmail.com", "delete account","unable to delete account");
	}
	@Test(priority=6)
	public void testCase() {
		TestCase tc=new TestCase(driver);
		tc.testCases();
	}
	@Test(priority=7)
	public void verifyProducts() {
		VerifyProducts vp=new VerifyProducts(driver);
		vp.products();
		vp.searchProduct();
	}
	@Test(priority=8)
	public void verifySubscriptions() throws Exception  {
		VerifySubscriptions vs=new VerifySubscriptions(driver);
		vs.SubscriptionsHomePage();
		vs.SubscriptionsCartPage();
	}
	@Test(priority=9)
	public void addProducts() throws IOException {
		AddProducts ap=new AddProducts(driver);
		ap.subscriptionsHomePage();
		
	}
	@Test(priority=10)
	public void verifyProductQuantity() throws IOException {
		AddProducts vp=new AddProducts(driver);
		vp.verifyProductQtty();
	}
	@Test(priority=11)
	public void whileCheckout() throws Exception  {
		PlaceOrderRegisterWhileCheckout wc=new PlaceOrderRegisterWhileCheckout(driver);
		wc.placeOrderWhileCheckout();
		wc.checkout();
		wc.registerLogin();
		wc.Signupandcreateaccount();
		wc.clickcartbtn();
		wc.proceedtocheckout();
		wc.addcomment();
		wc.placeOrder();
		wc.cardDetails();
		wc.orderplacedmsg();
		wc.deleteAccount();
		
	}
	@Test(priority=12)
	public void beforeCheckout() throws Exception {
		PlaceOrderRegisterBeforeCheckout bc= new PlaceOrderRegisterBeforeCheckout(driver);
		bc.Signupandcreateaccount();
		bc.createorder();
	}
	@Test(priority=13)
	public void loginbeforeCheckout(){
	    PlaceOrderLoginBeforeCheckout lbc=new PlaceOrderLoginBeforeCheckout(driver);
			lbc.login();
			lbc.placeorderloginbeforecheckout();
			lbc.Logout();
}
	@Test(priority=14)
	public void removeproducts(){
		RemoveProdctsFromCart rp= new RemoveProdctsFromCart(driver);
		rp.loginforremoveaccount();
		rp.addproduct();
	}
	@Test(priority=15)
	public void viewcateproducts() throws Exception{
		ViewCategoryProducts vcp=new ViewCategoryProducts(driver);
		vcp.home();
		vcp.category();
	}
	@Test(priority=16)
	public void viewbrandproducts() throws Exception{
		ViewCategoryProducts vbp=new ViewCategoryProducts(driver);
		vbp.brands();
	}
	@Test(priority=17)
	public void searchAndverifycart(){
		SearchAndVerifyCart svc=new SearchAndVerifyCart(driver);
		svc.searchandverifycart();
		svc.verifycart();
		svc.login();
	}
	@Test(priority=18)
	public void reviewonProduct(){
		ReviewonProduct r= new ReviewonProduct(driver);
		r.reviewonProduct();
	}
	@Test(priority=19)
	public void addrecommendedproducts(){
	AddtoCartRecommendedItems arp= new AddtoCartRecommendedItems(driver);
	arp.recommendeditems();
	}
	@Test(priority=20)
	public void verifyaddress(){
	PlaceOrderRegisterWhileCheckout powc=new PlaceOrderRegisterWhileCheckout(driver);
	powc.verifydeliveryAddress();
	powc.verifybillingAddress();
	}
	@Test(priority=21)
	public void usingarrowbtn(){
		ScrollUpandDown su=new ScrollUpandDown(driver);
		su.usingArrowBtn();
		}
	@Test(priority=22)
	public void withoutarrowbtn(){
		ScrollUpandDown swabu=new ScrollUpandDown(driver);
		swabu.withoutArrowBtn();
		}
	}
	
	
		