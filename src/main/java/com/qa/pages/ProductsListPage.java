package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.IKEATestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductsListPage extends IKEATestBase{
	
	@FindBy(id="com.ikea.alfuttaim.store:id/tv_product_name")
	WebElement productslistfirstproductname;
	
	@FindBy(id="com.ikea.alfuttaim.store:id/tv_regular_price")
	WebElement productslistfirstproductprice;
	
	@FindBy(xpath="//android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
	WebElement productlistclickfirstproduct;
	
	public ProductsListPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getproductlistfirstproductname() {
		String productlistfirstproductnametxt = productslistfirstproductname.getText();
		return productlistfirstproductnametxt;
	}
	
	public String getproductlistfirstproductprice() {
		String productlistfirstproductpricetxt = productslistfirstproductprice.getText();
		return productlistfirstproductpricetxt;
	}
	public void clickproductlistfirstproduct() {
		productlistclickfirstproduct.click();
	}

}
