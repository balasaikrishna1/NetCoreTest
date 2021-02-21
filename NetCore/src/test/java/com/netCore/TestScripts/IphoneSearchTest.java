package com.netCore.TestScripts;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netCore.CommonUtilities.BaseClass;
import com.netCore.ObjectsRepository.FlipKartHomePage;
import com.opencsv.CSVWriter;
/**
 * 
 * @author BALA SAI KRISHNA
 *
 */
public class IphoneSearchTest extends BaseClass {
	@Test
	public void iphonesearchtestcase() throws Throwable
	{
		
		FlipKartHomePage fp=new FlipKartHomePage(driver);
		// Handling login popup
		fp.getLoginPopup().click();
		//Enter iphone in search bar
		fp.getSearchBOX().sendKeys("iphones under 40000",Keys.ENTER);
		// verifing content message
		WebElement searchResult = fp.getContentVal();
		Assert.assertEquals(searchResult.isDisplayed(), true);
		// Gathering all search information in list
		List<WebElement> devicelist = fp.getIphonedevices();
		List<WebElement> pricelist = fp.getIphonePrice();
		List<WebElement> ratingslist = fp.getIphoneRatings();
		
		// Adding values into List of String Array
		String[] header = {"Device Details", "Price", "Ratings"};
		List<String[]> list = new ArrayList<>();
		list.add(0,header);
		for(int i=0;i<devicelist.size();i++)
		{
			String[] row1 = {devicelist.get(i).getText(),pricelist.get(i).getText().substring(1),ratingslist.get(i).getText()};
			list.add(i+1, row1);
		}
		
		 // Storing/writing in a CSV file
		CSVWriter writecsv = new CSVWriter(new FileWriter("./TestOutputs/Iphonedetails.csv"));
		writecsv.writeAll(list);
		writecsv.close();
	}
}
