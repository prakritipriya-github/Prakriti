package com.Automation_Assingment.objectRepository.assingment1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation_Assingment.genericLibrary.CommonLibrary;
import com.Automation_Assingment.genericLibrary.FileLib;

/**
 * 
 * @author Prakriti Priya
 *
 */
public class FlipkartPage {
	@FindBy(xpath = "//button[text()='✕']")
	private WebElement closeLogin;
	
	@FindBy(xpath = "//div[text()='Apple iPhone XR (Yellow, 64 GB)']/../following-sibling::div/div/div/div")
	private WebElement productPrice;
	
	@FindBy(name = "q")
	private WebElement searchBox;
	
	private WebDriver driver;
	private CommonLibrary common;
	
	FileLib flib = new FileLib();
	
	public FlipkartPage(WebDriver driver)  {
		// TODO Auto-generated constructor stub
		driver.get(flib.getPropertyKeyValue("urlFlipkart"));
		PageFactory.initElements(driver, this);
		this.driver = driver;
		common = new CommonLibrary(driver);
	}
	
	
	public void searchProduct(String sheetName, int rowNum, int celNum) throws Throwable {
		common.waitForPageToLoad();
		closeLogin.click();
		searchBox.sendKeys(flib.getExcelData(sheetName, rowNum, celNum), Keys.ENTER);
	}
	
	public int priceOfProduct() throws Throwable {
		common.waitForPageToLoad();
		common.waitForElemnetToAppear(productPrice);
		String data = productPrice.getText();
		int productPrice = common.removeSpecialChars(data);
		return productPrice;
	}

}
