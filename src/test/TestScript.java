package test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
import utils.BasePage;

public class TestScript {

	HomePage homePage; SignupLoginPage signupLoginPage; AccountCreatedPage accountCreatedPage; EnterAccountInformationPage enterAccountInformationPage; AccountDeletedPage accountDeletedPage; 
	ProductsPage productsPage; ProductDetailsPage productDetailsPage; CartPage cartPage; CheckoutPage checkoutPage; PaymentPage paymentPage; ContactusPage contactusPage; TestcasesPage testcasesPage;
	
	@BeforeTest
	public void launchUrl() {
		BasePage.launchUrl();
		homePage= BasePage.homePageInitialization();
		signupLoginPage= BasePage.signupLoginPageInitialization();
		enterAccountInformationPage= BasePage.enterAccountInformationPageInitialization();
		accountCreatedPage= BasePage.accountCreatedPageInitialization();
		accountDeletedPage= BasePage.accountDeletedPageInitialization();
		productsPage= BasePage.productsPageInitialization();
		productDetailsPage= BasePage.productDetailsPageInitialization();
		cartPage= BasePage.cartPageInitialization();
		checkoutPage= BasePage.CheckoutPageInitialization();
		paymentPage= BasePage.paymentPageInitialization();
		contactusPage= BasePage.ContactusPageInitialization();
		testcasesPage= BasePage.testcasesPageInitialization();
		
	}
	@Test(priority= 1)
	public void registerUser() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		Assert.assertEquals(BasePage.currentTitle(), "Automation Exercise");
		homePage.clickOnHeaderElement("Signup / Login");
		Assert.assertEquals(signupLoginPage.signUpText(), "New User Signup!");
		signupLoginPage.signUpCredentials("Purva Joglekar", "purvakulkarni99@gmail.com");
		Assert.assertEquals(enterAccountInformationPage.enterAccountInformationText(), "ENTER ACCOUNT INFORMATION");
		enterAccountInformationPage.fillRegistrationform();
		Assert.assertEquals(accountCreatedPage.accountCreatedtext(), "ACCOUNT CREATED!");
		accountCreatedPage.clickContinueButton();
		Assert.assertEquals(homePage.getUserName(), "Purva Joglekar");
		accountDeletedPage.clickOnDeleteAccount();
		Assert.assertEquals(accountDeletedPage.accountDeletedText(), "ACCOUNT DELETED!");
		accountDeletedPage.clickContinue();
	}
	@Test(priority=2)
	public void validateSignUpLoginbt() throws InterruptedException {
		homePage.clickOnHeaderElement("Signup / Login");
		signupLoginPage.signUpCredentials("Purva Joglekar", "purvakulkarni99@gmail.com");
		enterAccountInformationPage.fillRegistrationform();
		accountCreatedPage.clickContinueButton();
		accountDeletedPage.clickOnLogout();
		signupLoginPage.loginCredentials("purvakulkarni99@gmail.com", "123456");
		Assert.assertEquals(homePage.getUserName(), "Purva Joglekar");
		accountDeletedPage.clickOnDeleteAccount();
		Assert.assertEquals(accountDeletedPage.accountDeletedText(), "ACCOUNT DELETED!");
		
	}

@Test(priority=3)
public void loginUserwithincorrectemailandpassword() throws InterruptedException {
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
	homePage.clickOnHeaderElement("Signup / Login");
	Assert.assertEquals(signupLoginPage.loginText(), "Login to your account");
	signupLoginPage.loginCredentials("purva@gmail.com", "123");
	Assert.assertEquals(signupLoginPage.wrongCredentialsError(), "Your email or password is incorrect!");
	
}
@Test(priority=4)
public void logoutUser() throws InterruptedException {
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
	homePage.clickOnHeaderElement("Signup / Login");
	Assert.assertEquals(signupLoginPage.loginText(), "Login to your account");
	signupLoginPage.loginCredentials("purvakulkarni99@gmail.com", "123456");
	Assert.assertEquals(homePage.getUserName(), "Purva Joglekar");
	accountDeletedPage.clickOnLogout();
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/login");


}

@Test(priority=5)
public void registerUserwithExistingEmail() throws InterruptedException {
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
	homePage.clickOnHeaderElement("Signup / Login");
	Assert.assertEquals(signupLoginPage.signUpText(), "New User Signup!");
	signupLoginPage.signUpCredentials("Purva Joglekar", "purvakulkarni99@gmail.com");
	Assert.assertEquals(signupLoginPage.emailExistError(), "Email Address already exist!");
	
	
}
@Test (priority = 6)
public void  ContactUsForm() throws InterruptedException {
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
	homePage.clickOnHeaderElement("Contact us");
	Assert.assertEquals(contactusPage.getInTouchText(), "GET IN TOUCH");
	contactusPage.nameEmailInput("Purva", "purva@gmail.com");
	contactusPage.subjectMessageInput("Parcel delivery", "Haven't got parcel yet.");
	contactusPage.uploadFile("C:\\Users\\purva\\OneDrive\\Pictures\\Screenshots\\Screenshot 2023-09-13 164354.png");
	contactusPage.clickSubmitButton();
	BasePage.handleAlerts();
	Assert.assertEquals(contactusPage.getSuccessMessage(),"Success! Your details have been submitted successfully.");
	BasePage.clickOnElement(contactusPage.homeButton);
	BasePage.waitUntillUrlContains("https://automationexercise.com/");
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
}
@Test (priority = 7)
public void  verifyTestCasesPage() throws InterruptedException {
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
	homePage.clickOnHeaderElement("Test Cases");
	BasePage.waitUntillUrlContains("https://automationexercise.com/test_cases");
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/test_cases");

}
@Test (priority = 8)
public void  verifyAllProductsAndProductDetailPage() throws InterruptedException {
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
	homePage.clickOnHeaderElement(" Products");
	BasePage.waitUntillUrlContains("https://automationexercise.com/products");
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/products");
	Assert.assertEquals(productsPage.getAllProductsText(), "ALL PRODUCTS");
	productsPage.clickOnFirstProduct();
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/product_details/1");
	productDetailsPage.getProductDetails(); 
	
}
@Test (priority = 9)
public void  SearchProduct() throws InterruptedException {
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
	homePage.clickOnHeaderElement(" Products");
	BasePage.waitUntillUrlContains("https://automationexercise.com/products");
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/products");
	productsPage.searchProduct("Tops");
	Assert.assertEquals(productsPage.centerText(), "SEARCHED PRODUCTS");
	productsPage.listOfAllProducts();

}

@Test(priority=10)
public void verifySubscriptionInHomePage1() {
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
	BasePage.scrollUsingJavaScriptExe(homePage.SubscriptionText);
	Assert.assertEquals(homePage.getSubscriptiontext(), "SUBSCRIPTION");
	homePage.enterEmailforSubscription("purva@gmail.com");
	homePage.clickOnSubscriptionbtn();
	Assert.assertEquals(homePage.getSuccessSubscriptionText(), "You have been successfully subscribed!"); 
}

@Test(priority=11)
public void verifySubscriptionInCartPage() {
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
	BasePage.scrollUsingJavaScriptExe(homePage.SubscriptionText);
	Assert.assertEquals(homePage.getSubscriptiontext(), "SUBSCRIPTION");
	homePage.enterEmailforSubscription("purva@gmail.com");
	homePage.clickOnSubscriptionbtn();
	Assert.assertEquals(homePage.getSuccessSubscriptionText(), "You have been successfully subscribed!"); 
}

@Test(priority=12)
public void addProductInCart() throws InterruptedException {
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
	homePage.clickOnHeaderElement(" Products");
	BasePage.waitUntillUrlContains("https://automationexercise.com/products");
	List<String> productNames= productsPage.firstSecondProductNames();
	List<String> productPrices= productsPage.firstSecondProductPrices();
	BasePage.hoverOverElement(productsPage.hoverOnFirstproduct());
	BasePage.clickUsingJavaScriptExec(productsPage.AddtoCartButtonproduct1);
	BasePage.clickUsingJavaScriptExec(productsPage.ContinueShoppingbutton);
	BasePage.hoverOverElement(productsPage.hoverOnSecondproduct());	
	BasePage.clickUsingJavaScriptExec(productsPage.AddtoCartButtonproduct2);
	BasePage.clickUsingJavaScriptExec(productsPage.ViewCartButton);
	List<WebElement> cartProductNames= cartPage.getCartProductNames();
	List<WebElement> cartProductPrices= cartPage.getCartProductPrices();
	for(int i=0;i<productNames.size();i++) {
		Assert.assertEquals(productNames.get(i), cartProductNames.get(i).getText());
	}
	for(int i=0;i<productPrices.size();i++) {
		Assert.assertEquals(productPrices.get(i), cartProductPrices.get(i).getText());
	}
	List<Integer>calculatedTotal= cartPage.productTotalValidation();
	List<Integer>cartTotal= cartPage.cartTotalValues();
	for(int i=0;i<calculatedTotal.size();i++) {
		Assert.assertEquals(calculatedTotal, cartTotal);
	}
}

@Test(priority=13)
	public void verifyProductQuantityInCart() {
	Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
	productsPage.clickOnFirstProduct();
	BasePage.waitUntillUrlContains("https://automationexercise.com/product_details/1");
	Assert.assertTrue(BasePage.currentUrl().contains("product_details"));
	productDetailsPage.clearQuantity();
	productDetailsPage.changeQuantity("4");
	productDetailsPage.clickOnAddToCart();
	productsPage.viewCart();
	List<WebElement> cartQuantity= cartPage.getCartQuantity();
	for(int i=0;i<cartQuantity.size();i++) {
		Assert.assertEquals(cartQuantity.get(i).getText(),"4");
		
	}
}
	@Test(priority=14)
	public void PlaceOrderRegisterWhileCheckout() throws InterruptedException{ 
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		List<String> productNames= productsPage.firstSecondProductNames();
		List<String> productPrices= productsPage.firstSecondProductPrices();
		productsPage.addToCartFirstProduct();
		productsPage.clickOnContinueShoppingButton();
		productsPage.addToCartSecondProduct();
		productsPage.viewCart();
		cartPage.clickOnProceedtocheckout();
		cartPage.clickOnRegisterLoginLink();
		Assert.assertEquals(signupLoginPage.signUpText(), "New User Signup!");
		signupLoginPage.signUpCredentials("Purva", "purva@gmail.com");
		Assert.assertEquals(enterAccountInformationPage.enterAccountInformationText(), "ENTER ACCOUNT INFORMATION");
		enterAccountInformationPage.fillRegistrationform();
		Assert.assertEquals(accountCreatedPage.accountCreatedtext(), "ACCOUNT CREATED!");
		accountCreatedPage.clickContinueButton();
		Assert.assertEquals(homePage.getUserName(), "Purva");
		homePage.clickOnHeaderElement("Cart"); 
		cartPage.clickOnProceedtocheckout();
		List<WebElement> DeliveryAddress = checkoutPage.getDeliveryAddress();
		List<WebElement> BillingAddress = checkoutPage.getBillingAddress();
		for(int i = 0; i<DeliveryAddress.size();i++) {
			System.out.println(DeliveryAddress.get(i).getText());
		}
		for(int i = 0; i<BillingAddress.size();i++) {
			if(i == 0) {
				continue;
			}
			Assert.assertEquals(DeliveryAddress.get(i).getText(), BillingAddress.get(i).getText());
		}		
		List<WebElement> CartProductNames = cartPage.getCartProductNames();//2
		List<WebElement> CartProductPrices = cartPage.getCartProductPrices();
		for(int i = 0; i<productNames.size();i++) {
			Assert.assertEquals(productNames.get(i), CartProductNames.get(i).getText());
		}
		for(int i = 0; i<productPrices.size();i++) {
			Assert.assertEquals(productPrices.get(i), CartProductPrices.get(i).getText());
		}
		checkoutPage.enterComment();
		checkoutPage.clickOnPlaceOrder();
		paymentPage.enterPaymentDetails();
		paymentPage.paynConfirmOrder();
		accountCreatedPage.clickContinueButton();		
		accountDeletedPage.clickOnDeleteAccount();
		accountDeletedPage.accountDeletedText();
		accountDeletedPage.clickContinue();
		
	}
	@Test(priority=15)
	public void   PlaceOrderRegisterBeforeCheckout() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement("Signup / Login");
		signupLoginPage.signUpCredentials("Sweety", "sweety47@gmail.com");
		enterAccountInformationPage.fillRegistrationform();
		Assert.assertEquals(accountCreatedPage.accountCreatedtext(), "ACCOUNT CREATED!");
		accountCreatedPage.clickContinueButton();
		Assert.assertEquals(homePage.getUserName(), "Sweety");

		List<String> ProdcutNames = productsPage.firstSecondProductNames();//2
		List<String> ProdcutPrices = productsPage.firstSecondProductPrices();
		productsPage.addToCartFirstProduct();
		productsPage.clickOnContinueShoppingButton();
		productsPage.addToCartSecondProduct();
		productsPage.viewCart(); 
		cartPage.clickOnProceedtocheckout();
		List<WebElement> DeliveryAddress = checkoutPage.getDeliveryAddress();
		List<WebElement> BillingAddress = checkoutPage.getBillingAddress();
		for(int i = 0; i<DeliveryAddress.size();i++) {
			System.out.println(DeliveryAddress.get(i).getText());
		}
		for(int i = 0; i<BillingAddress.size();i++) {
			if(i == 0) {
				continue;
			}
			Assert.assertEquals(DeliveryAddress.get(i).getText(), BillingAddress.get(i).getText());
		}		
		List<WebElement> CartProductNames = cartPage.getCartProductNames();//2
		List<WebElement> CartProductPrices = cartPage.getCartProductPrices();
		for(int i = 0; i<ProdcutNames.size();i++) {
			Assert.assertEquals(ProdcutNames.get(i), CartProductNames.get(i).getText());
		}
		for(int i = 0; i<ProdcutPrices.size();i++) {
			Assert.assertEquals(ProdcutPrices.get(i), CartProductPrices.get(i).getText());
		}
		checkoutPage.enterComment();
		checkoutPage.clickOnPlaceOrder();
		paymentPage.enterPaymentDetails();
		paymentPage.paynConfirmOrder();
		accountCreatedPage.clickContinueButton();		
		accountDeletedPage.clickOnDeleteAccount();
		accountDeletedPage.accountDeletedText();
		accountDeletedPage.clickContinue();
	}

	@Test (priority = 16)
	public void  PlaceOrderLoginBeforeCheckout () throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement("Signup / Login");
		Assert.assertEquals(signupLoginPage.loginText(), "Login to your account");
		signupLoginPage.loginCredentials("ojas@gmail.com", "12345");// Existing account credentials
		Assert.assertEquals(homePage.getUserName(), "Ojas");
		List<String> ProdcutNames = productsPage.firstSecondProductNames();//2
		List<String> ProdcutPrices = productsPage.firstSecondProductPrices();
		productsPage.addToCartFirstProduct();
		productsPage.clickOnContinueShoppingButton();
		productsPage.addToCartSecondProduct();
		productsPage.viewCart(); 
		BasePage.waitUntillUrlContains("https://automationexercise.com/view_cart");
		Assert.assertTrue(BasePage.currentUrl().contains("cart"));
		cartPage.clickOnProceedtocheckout();
		List<WebElement> DeliveryAddress = checkoutPage.getDeliveryAddress();
		List<WebElement> BillingAddress = checkoutPage.getBillingAddress();
		for(int i = 0; i<DeliveryAddress.size();i++) {
			System.out.println(DeliveryAddress.get(i).getText());
		}
		for(int i = 0; i<BillingAddress.size();i++) {
			if(i == 0) {
				continue;
			}
			Assert.assertEquals(DeliveryAddress.get(i).getText(), BillingAddress.get(i).getText());
		}		
		List<WebElement> CartProductNames = cartPage.getCartProductNames();//2
		List<WebElement> CartProductPrices = cartPage.getCartProductPrices();
		for(int i = 0; i<ProdcutNames.size();i++) {
			Assert.assertEquals(ProdcutNames.get(i), CartProductNames.get(i).getText());
		}
		for(int i = 0; i<ProdcutPrices.size();i++) {
			Assert.assertEquals(ProdcutPrices.get(i), CartProductPrices.get(i).getText());
		}
		checkoutPage.enterComment();
		checkoutPage.clickOnPlaceOrder();
		paymentPage.enterPaymentDetails();
		paymentPage.paynConfirmOrder();
		//System.out.println(paymentPage.confirmationMessage());
		accountCreatedPage.clickContinueButton();		
		accountDeletedPage.clickOnDeleteAccount();
		accountDeletedPage.accountDeletedText();
		accountDeletedPage.clickContinue();

	}
	
	@Test(priority=17)
	public void removeProductsFromCart() {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");	
		productsPage.addToCartFirstProduct();
		productsPage.clickOnContinueShoppingButton();
		productsPage.addToCartSecondProduct();
		productsPage.viewCart(); 
		BasePage.waitUntillUrlContains("https://automationexercise.com/view_cart");
		int BeforeDelete = cartPage.getTableSize();
		cartPage.clickOnXButton();
		BasePage.refreshPage();
		int AfterDelte = cartPage.getTableSize();
		Assert.assertNotEquals(BeforeDelete, AfterDelte);
		
}
	@Test(priority=18)
	public void viewCategoryProducts() {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnWomenCategory();
		homePage.clickOnWomenDressCategory();
		BasePage.waitUntillUrlContains("https://automationexercise.com/category_products/1");
		Assert.assertTrue(homePage.isCentreTextVisible());
		homePage.clickOnMensCategory();
		homePage.ClickOnMensTshirtCategory();
		Assert.assertTrue(homePage.isCentreTextVisible());		
}
	@Test(priority=19)
	public void viewCartBrandProducts() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement(" Products");
		BasePage.waitUntillUrlContains("https://automationexercise.com/products");
		List<WebElement> ListOfAllBrands = homePage.listOfAllBands(); 
		for(int i=0;i<ListOfAllBrands.size();i++) {
			System.out.println(ListOfAllBrands.get(i).getText());
		}
		productsPage.clickOnBiba();
		List <WebElement> AllProductsName = productsPage.listOfAllProducts();
		for(int i=0; i<AllProductsName.size();i++) {
			System.out.println(AllProductsName.get(i).getText());
		}
		Assert.assertEquals(productsPage.centerText(), "BRAND - BIBA PRODUCTS") ;
		productsPage.clickOnHnM(); 
		Assert.assertEquals(productsPage.centerText(), "BRAND - H&M PRODUCTS") ;

}
	@Test (priority = 20) 
	public void SearchProductsAndVerifyCartAfterLogin() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement(" Products");
		BasePage.waitUntillUrlContains("https://automationexercise.com/products");
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/products");
		Assert.assertEquals(productsPage.getAllProductsText(), "ALL PRODUCTS");
		productsPage.searchProduct("SAREE".toLowerCase()); 
		Assert.assertEquals(productsPage.centerText(), "SEARCHED PRODUCTS");
		BasePage.waitUntillUrlContains("https://automationexercise.com/products?search=saree");
		productsPage.clickOnEachProductAddToCart();
		homePage.clickOnHeaderElement("Cart");
		BasePage.waitUntillUrlContains("https://automationexercise.com/view_cart");
		List<WebElement>CartProductNames = cartPage.getCartProductNames();
		for(int i = 0; i<CartProductNames.size();i++) {
			System.out.println(CartProductNames.get(i).getText());
		}
		homePage.clickOnHeaderElement("Signup / Login");
		signupLoginPage.loginCredentials("Ojas@gmail.com", "12345");
		homePage.clickOnHeaderElement("Cart");
		for(int i = 0; i<CartProductNames.size();i++) {
			System.out.println(CartProductNames.get(i).getText());
		}
	}

	@Test (priority = 21)
	public void  AddReviewOnProduct() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement(" Products");
		BasePage.waitUntillUrlContains("https://automationexercise.com/products");
		Assert.assertEquals(productsPage.centerText(), "ALL PRODUCTS");
		productsPage.clickOnFirstProduct();
		Assert.assertTrue(productDetailsPage.isYourReviewVisible());
		productDetailsPage.nameEmailInput("Ojas", "ojas@gmail.com");
		productDetailsPage.reviewInput("This website is terrible");
		productDetailsPage.clickOnSubmit();
		Assert.assertEquals(productDetailsPage.isSuccessMessageVisible(), "Thank you for your review.");

	}

	@Test (priority = 22)
	public void   AddToCarFromRecommendedItems() {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		BasePage.scrollUsingJavaScriptExe(homePage.RecommendedItems); 
		Assert.assertTrue(homePage.isRecommendeditemsVisible());
		homePage.addProductFromRecommendationList();
		productsPage.viewCart(); 
		Assert.assertTrue(homePage.isProductDisplayedInCart());

	}

	@Test (priority = 23) 
	public void  VerifyAddressDetailsIncheckoutPage() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		homePage.clickOnHeaderElement("Signup / Login");
		signupLoginPage.signUpCredentials("Sweety", "sweety47@gmail.com");
		enterAccountInformationPage.fillRegistrationform();
		Assert.assertEquals(accountCreatedPage.accountCreatedtext(), "ACCOUNT CREATED!");
		accountCreatedPage.clickContinueButton();
		Assert.assertEquals(homePage.getUserName(), "Sweety");

		List<String> ProdcutNames = productsPage.firstSecondProductNames();//2
		List<String> ProdcutPrices = productsPage.firstSecondProductPrices();
		productsPage.addToCartFirstProduct();
		productsPage.clickOnContinueShoppingButton();
		productsPage.addToCartSecondProduct();
		productsPage.viewCart(); 
		cartPage.clickOnProceedtocheckout();
		List<WebElement> DeliveryAddress = checkoutPage.getDeliveryAddress();
		List<WebElement> BillingAddress = checkoutPage.getBillingAddress();
		for(int i = 0; i<DeliveryAddress.size();i++) {
			System.out.println(DeliveryAddress.get(i).getText());
		}
		for(int i = 0; i<BillingAddress.size();i++) {
			if(i == 0) {
				continue;
			}
			Assert.assertEquals(DeliveryAddress.get(i).getText(), BillingAddress.get(i).getText());
		}		
		List<WebElement> CartProductNames = cartPage.getCartProductNames();//2
		List<WebElement> CartProductPrices = cartPage.getCartProductPrices();
		for(int i = 0; i<ProdcutNames.size();i++) {
			Assert.assertEquals(ProdcutNames.get(i), CartProductNames.get(i).getText());
		}
		for(int i = 0; i<ProdcutPrices.size();i++) {
			Assert.assertEquals(ProdcutPrices.get(i), CartProductPrices.get(i).getText());
		}
		checkoutPage.enterComment();
		checkoutPage.clickOnPlaceOrder();
		paymentPage.enterPaymentDetails();
		paymentPage.paynConfirmOrder();
		accountCreatedPage.clickContinueButton();		
		accountDeletedPage.clickOnDeleteAccount();
		accountDeletedPage.accountDeletedText();
		accountDeletedPage.clickContinue();
	}

	@Test (priority = 24) 
	public void   DownloadInvoiceAfterPurchaseOrder() throws InterruptedException {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		List<String> ProdcutNames = productsPage.firstSecondProductNames();//2
		List<String> ProdcutPrices = productsPage.firstSecondProductPrices();
		productsPage.addToCartFirstProduct();
		productsPage.clickOnContinueShoppingButton();
		productsPage.addToCartSecondProduct();
		productsPage.viewCart(); 
		cartPage.clickOnProceedtocheckout();
		cartPage.clickOnRegisterLoginLink();
		Assert.assertEquals(signupLoginPage.signUpText(), "New User Signup!");
		signupLoginPage.signUpCredentials("Sweety", "sweety47@gmail.com");
		Assert.assertEquals(enterAccountInformationPage.enterAccountInformationText(), "ENTER ACCOUNT INFORMATION");
		enterAccountInformationPage.fillRegistrationform();
		Assert.assertEquals(accountCreatedPage.accountCreatedtext(), "ACCOUNT CREATED!");
		accountCreatedPage.clickContinueButton();
		Assert.assertEquals(homePage.getUserName(), "Sweety");
		homePage.clickOnHeaderElement("Cart"); 
		cartPage.clickOnProceedtocheckout();
		List<WebElement> DeliveryAddress = checkoutPage.getDeliveryAddress();
		List<WebElement> BillingAddress = checkoutPage.getBillingAddress();
		for(int i = 0; i<DeliveryAddress.size();i++) {
			System.out.println(DeliveryAddress.get(i).getText());
		}
		for(int i = 0; i<BillingAddress.size();i++) {
			if(i == 0) {
				continue;
			}
			Assert.assertEquals(DeliveryAddress.get(i).getText(), BillingAddress.get(i).getText());
		}		
		List<WebElement> CartProductNames = cartPage.getCartProductNames();//2
		List<WebElement> CartProductPrices = cartPage.getCartProductPrices();
		for(int i = 0; i<ProdcutNames.size();i++) {
			Assert.assertEquals(ProdcutNames.get(i), CartProductNames.get(i).getText());
		}
		for(int i = 0; i<ProdcutPrices.size();i++) {
			Assert.assertEquals(ProdcutPrices.get(i), CartProductPrices.get(i).getText());
		}
		checkoutPage.enterComment();
		checkoutPage.clickOnPlaceOrder();
		paymentPage.enterPaymentDetails();
		paymentPage.paynConfirmOrder();
		paymentPage.clickOnDownloadInvoice();
		paymentPage.clickOnContinue();
		accountDeletedPage.clickOnDeleteAccount();
		accountDeletedPage.clickContinue();
	}

	@Test (priority = 25)
	public void   VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality() {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		BasePage.scrollUsingJavaScriptExe(homePage.SubscriptionText); 
		Assert.assertEquals(homePage.getSubscriptiontext(), "SUBSCRIPTION");
		homePage.clickOnArrow();
		Assert.assertEquals(homePage.getFullFledgeWebsitetext(), "Full-Fledged practice website for Automation Engineers");
	}

	@Test (priority = 26)
	public void  VerifyScrollUpwithoutArrowButtonAndScrollDownFunctionality() {
		Assert.assertEquals(BasePage.currentUrl(), "https://automationexercise.com/");
		BasePage.scrollUsingJavaScriptExe(homePage.SubscriptionText); 
		Assert.assertEquals(homePage.getSubscriptiontext(), "SUBSCRIPTION");
		BasePage.scrollUsingJavaScriptExe(homePage.FullFledgedWebsite);
		Assert.assertEquals(homePage.getFullFledgeWebsitetext(), "Full-Fledged practice website for Automation Engineers");
	}

	}
	
