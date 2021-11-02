package com.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.IKEATestBase;
import com.qa.pages.CartPage;
import com.qa.pages.LandingPage;
import com.qa.pages.ProductDetailsPage;
import com.qa.pages.ProductsListPage;
import com.qa.util.Constant;
import com.qa.util.Utility;


public class AddRemoveProductTest extends IKEATestBase{

	LandingPage landingPage;
	ProductsListPage productsListPage;
	ProductDetailsPage productDetailsPage;
	Utility utility;
	CartPage cartPage;


public AddRemoveProductTest() {
	super();
}


	@BeforeClass()
	public void setup() throws MalformedURLException{

		
		System.out.println("Opening App...");
		openikeaapp();
		

		landingPage = new LandingPage();
		productsListPage = new ProductsListPage();
		productDetailsPage = new ProductDetailsPage();
		cartPage = new CartPage();
		utility = new Utility();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@DataProvider
	public Object[][] getikeatestdata() {
		Object data[] [] = Utility.getTestData("ProductSearchInput");
		return data;
	}
	
	@Test(description="To compare the product name on Product List and Product screens.", dataProvider = "getikeatestdata", priority=1, enabled=true)
	public void compareproductnameproductlistandproductdetails(String inputsearch) throws InterruptedException, IOException {

		System.out.println("\n\nTo compare the product name on Product List and Product screens.");
		
		Thread.sleep(2000);
		
		landingPage.clicklandingsearchfield();
		landingPage.entersearchinputfieldtext(inputsearch);
		Thread.sleep(1000);
		landingPage.selectsearchresult();
		
		Thread.sleep(2000);
		
		String firstproductname = productsListPage.getproductlistfirstproductname();
		System.out.println("First Product Name is : "+firstproductname);
		
		productsListPage.clickproductlistfirstproduct();
		
		String productdetailsproductname = productDetailsPage.getproductdetailsproductname();
		System.out.println("Product Name on Product Details screen is : "+productdetailsproductname);
		
		Assert.assertEquals(firstproductname, firstproductname, "The Product name on Product List and Product Details screen do not match");
		

	}
	
	@Test(description="To compare the product price on Product List and Product screens.", priority=2, enabled=true)
	public void compareproductpriceproductlistandproductdetails() throws InterruptedException, IOException {

		System.out.println("\n\nTo compare the product price on Product List and Product screens.");
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		String firstproductprice = productsListPage.getproductlistfirstproductprice();
		System.out.println("First product Price is : "+firstproductprice);
		
		productsListPage.clickproductlistfirstproduct();
		
		String productdetailsproductprice = productDetailsPage.getproductsdetailsproductprice();
		System.out.println("Product Price on Product Details screen is : "+productdetailsproductprice);
		
		Assert.assertEquals(firstproductprice, productdetailsproductprice, "The Product Price on Product List and Product Details screen do not match");
		

	}
	
	@Test(description="To verify that the user can increase the product quantity of a product on product details screen.", priority=3, enabled=true)
	public void productdetailsincreaseproductqty() throws InterruptedException, IOException {

		System.out.println("\n\nTo verify that the user can increase the product quantity of a product on product details screen.");
		
		Thread.sleep(2000);

		productDetailsPage.clickproductdetailsproductspinner();
		
		productDetailsPage.clickproductcounterbutton();
		
		productDetailsPage.clickproductqtyconfirmationpopupokbutton();
		
		String productdetailsqty =productDetailsPage.getproductdetailsproductquantitytext();
		System.out.println("Product Quanitity on Product Details screen is : "+productdetailsqty);
		
		utility.scrollverticalup();
		
		productDetailsPage.clickproductdetailsaddtocartbutton();
		
		Thread.sleep(5000);
		
		Assert.assertEquals(productdetailsqty, "2", "Product Quantity on Product Details screen ");
		
	}
	
	@Test(description="To verify whether the Cart quantity on Home screen increments when the user adds a product to the cart.", priority=4, enabled=true)
	public void verifyhomescreencartbuttonquantity() throws InterruptedException, IOException {

		System.out.println("\n\nTo verify whether the Cart quantity on Home screen increments when the user adds a product to the cart.");
		
		Thread.sleep(2000);

		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		
		String homescreencartproductcount = landingPage.gethomescreenproductcartcounttext();
		System.out.println("Product count on Home Screen Cart icon is : "+homescreencartproductcount);
		
		Assert.assertEquals(homescreencartproductcount, "1", "Product Quantity on Cart icon on home screen is not shown appropriately.");
		
	}
	
	@Test(description="To verify whether the user navigates to the checkout screen on clicking on the Proceed to Checkout button.", priority=5, enabled=true)
	public void verifynavigationtocheckout() throws InterruptedException, IOException {

		System.out.println("\n\nTo verify whether the user navigates to the checkout screen on clicking on the Proceed to Checkout button.");
		
		Thread.sleep(2000);
		
		landingPage.clickhomescreencartbutton();
		
		cartPage.clickcheckoutbutton();
		
		String getcheckoutscreentitle = cartPage.getcheckoutscreentitletext();
		System.out.println("Checkout screen tite text is : "+getcheckoutscreentitle);
		
		cartPage.closepagebutton();
		
		cartPage.clickcloseconfirmationcancelbutton();
		
		Assert.assertEquals(getcheckoutscreentitle, Constant.checkoutscreentitleexpected, "Product Quantity on Cart icon on home screen is not shown appropriately.");
		
	}
	
	@Test(description="To verify whether the user can remove product from the basket.", priority=6, enabled=true)
	public void verifyremoveproductfrombasket() throws InterruptedException, IOException {

		System.out.println("\n\nTo verify whether the user can remove product from the basket.");
		
		Thread.sleep(2000);
		
		cartPage.removeproductbutton();
		
		cartPage.removeproductconfirmationpopupyesbutton();
		
		String emptybaskettextactual = cartPage.getemptybaskettext();
		System.out.println("Empty cart text is : "+emptybaskettextactual);
		
		Assert.assertEquals(emptybaskettextactual, Constant.emptybasketmessage, "On removing all products the empty basket message is incorrect or is missing.");
		
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void teardown() {
		
		
		driver.quit();
		System.out.println("Closing Driver...");
	}

}
