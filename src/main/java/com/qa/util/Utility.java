package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Dimension;

import com.qa.base.IKEATestBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Utility extends IKEATestBase{
	
	public void scrollverticalup() {

		Dimension dimension = driver.manage().window().getSize(); 

		Double scrollHeightStart = dimension.getHeight()*0.7;
		int scrollstartheight = scrollHeightStart.intValue();

		Double scrollHeightEnd = dimension.getHeight()*0.2;
		int scrollendheight = scrollHeightEnd.intValue();

		Double scrollWidthStart = dimension.getWidth()*0.5;
		int scrollstartwidth = scrollWidthStart.intValue();

		Double scrollWidthEnd = dimension.getWidth()*0.5;
		int scrollendwidth = scrollWidthEnd.intValue();

		new TouchAction((PerformsTouchActions) driver)
		.press(PointOption.point(scrollstartwidth, scrollstartheight))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(scrollendwidth, scrollendheight))
		.release().perform();
	}
	
	static Workbook book;
	static Sheet sheet; 
	
	
	//Sheet from where the data to be tested.
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\leroy.anthony\\eclipse-workspace\\IKEATestProject\\src\\main\\java\\com\\qa\\testdata\\IKEATestdata.xlsx";
	
	public static Object[][] getTestData(String sheetName) {

		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file); 
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		

		for(int i=0; i<sheet.getLastRowNum();i++) {
			for(int k=0; k < sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]= sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;

	}

}
