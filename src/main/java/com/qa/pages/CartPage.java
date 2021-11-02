package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.IKEATestBase;

public class CartPage extends IKEATestBase{
	
	
	@FindBy(id="com.ikea.alfuttaim.store:id/btn_checkout")
	WebElement checkoutbtn;
	
	@FindBy(id="com.ikea.alfuttaim.store:id/toolbar_title")
	WebElement checkoutscreentitletext;
	
	@FindBy(xpath="//android.widget.ImageButton[@content-desc=\"‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‏‏‏‏‏‎‏‎‎‎‏‏‎‏‎‎‎‏‏‎‎‎‏‏‏‏‎‏‎‎‎‎‏‏‎‏‏‎‏‎‎‏‎‎‏‎‎‎‎‎‎‏‎‏‎‎‎‎‏‏‏‎‎‎‎‎Navigate up‎‏‎‎‏‎\"]")
	WebElement closepagebtn;
	
	@FindBy(id="com.ikea.alfuttaim.store:id/popup_other_btn")
	WebElement closeconfirmationcancelbtn;
	
	@FindBy(id="com.ikea.alfuttaim.store:id/iv_remove")
	WebElement removeproductbtn;
	
	@FindBy(id="com.ikea.alfuttaim.store:id/empty_text")
	WebElement emptybaskettext;
	
	@FindBy(id="com.ikea.alfuttaim.store:id/popup_btn")
	WebElement removeproductconfirmationpopupyesbtn;
	
	public  CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickcheckoutbutton() {
		checkoutbtn.click();
	}
	
	public String getcheckoutscreentitletext() {
		String checkoutscreentitletxt = checkoutscreentitletext.getText();
		return checkoutscreentitletxt;
	}
	
	public void closepagebutton() {
		closepagebtn.click();
	}
	
	public void clickcloseconfirmationcancelbutton() {
		closeconfirmationcancelbtn.click();
	}
	
	public String getemptybaskettext() {
		String emptybaskettxt = emptybaskettext.getText();
		return emptybaskettxt;
	}
	
	public void removeproductbutton() {
		removeproductbtn.click();
	}
	
	public void removeproductconfirmationpopupyesbutton() {
		removeproductconfirmationpopupyesbtn.click();
	}

}
