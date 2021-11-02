package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.IKEATestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductDetailsPage extends IKEATestBase{
	
	@FindBy(id="com.ikea.alfuttaim.store:id/product_detail_name")
	WebElement productdetailsproductname;
	
	@FindBy(id="com.ikea.alfuttaim.store:id/product_detail_price_value")
	WebElement productsdetailsproductprice;
	
	@FindBy(id="com.ikea.alfuttaim.store:id/product_qty")
	WebElement productdetailsspinner;
	
	@FindBy(className = "android.widget.Button")
	WebElement productcounterbtn;
	
	@FindBy(id="android:id/button1")
	WebElement productconfirmationquantityokbtn;
	
	@FindBy(id="com.ikea.alfuttaim.store:id/product_qty")
	WebElement productdetailsproductqty;
	
	@FindBy(id="com.ikea.alfuttaim.store:id/btn_add_to_cart")
	WebElement productdetailsaddtocartbtn;
	
	public ProductDetailsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getproductdetailsproductname() {
		String productlistfirstproductnametxt = productdetailsproductname.getText();
		return productlistfirstproductnametxt;
	}
	
	public String getproductsdetailsproductprice() {
		String productsdetailsproductpricetxt = productsdetailsproductprice.getText();
		return productsdetailsproductpricetxt;
	}
	
	public void clickproductdetailsproductspinner() {
		productdetailsspinner.click();
	}
	
	public void clickproductcounterbutton() {
		productcounterbtn.click();
	}
	
	public void clickproductqtyconfirmationpopupokbutton() {
		productconfirmationquantityokbtn.click();
	}
	
	public String getproductdetailsproductquantitytext() {
		String productdetailsproductqtytxt= productdetailsproductqty.getText();
		return productdetailsproductqtytxt;
	}
	
	public void clickproductdetailsaddtocartbutton() {
		productdetailsaddtocartbtn.click();
	}
	

}
