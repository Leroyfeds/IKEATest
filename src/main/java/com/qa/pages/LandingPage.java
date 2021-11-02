package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.IKEATestBase;

public class LandingPage extends IKEATestBase{
	
	@FindBy(id="com.ikea.alfuttaim.store:id/textView7")
	WebElement landingsearchfield;
	
	@FindBy(id="com.ikea.alfuttaim.store:id/search_products_text_view")
	WebElement landingpagesearchinput;
	
	@FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.TextView")
	WebElement landingscreensearchresultsuggestion;
	
	@FindBy(id="com.ikea.alfuttaim.store:id/tab_badge")
	WebElement homescreenproductcartcount;
	
	@FindBy(xpath="(//android.widget.ImageView[@content-desc=\"IKEA UAE\"])[1]")
	WebElement homescreencartbtn;
	
	
	public LandingPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clicklandingsearchfield() {
		landingsearchfield.click();
	}
	
	public void entersearchinputfieldtext(String searchinput) {
		landingpagesearchinput.sendKeys(searchinput);
	}
	
	public void selectsearchresult() {
		landingscreensearchresultsuggestion.click();
	
	}
	
	public String gethomescreenproductcartcounttext() {
		String homescreenproductcartcounttxt = homescreenproductcartcount.getText();
		return homescreenproductcartcounttxt;
	}
	
	public void clickhomescreencartbutton() {
		homescreencartbtn.click();
	}
	
	
}
