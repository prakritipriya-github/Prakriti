package assingment1;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Automation_Assingment.genericLibrary.BaseClass;
import com.Automation_Assingment.objectRepository.assingment1.AmazonPage;
import com.Automation_Assingment.objectRepository.assingment1.FlipkartPage;

/**
 * 
 * @author Prakriti Priya
 *
 */
public class AmazonTest extends BaseClass {
	
	@Test
	public void comparePriceAmazonFlipkartTest() throws Throwable {
		/* Navigating to Amazon */
		AmazonPage amazon = new AmazonPage(BaseClass.driver);
		
		/* Search for product */
		amazon.searchProduct("Sheet1", 1, 0);
		
		/* get the price of a product */
		int amazonPrice = amazon.priceOfProduct();
		
		/* navigating to flipkart */
		FlipkartPage flipkart = new FlipkartPage(BaseClass.driver);
		
		/* Search for product */
		flipkart.searchProduct("Sheet1", 1, 0);
		
		/* get the price of a product */
		int flipkartPrice = flipkart.priceOfProduct();
		
		/* Compare the price from amazon and flipkart and display it in console */
		if(amazonPrice > flipkartPrice) {
			Reporter.log("Flipkart has Lesser Price than Amazon", true);
			Reporter.log("price of flipkart"+flipkartPrice ,true);
		}else if (amazonPrice < flipkartPrice) {
			Reporter.log("Amazon has Lesser Price than flipkart", true);
			Reporter.log("price of amazon"+amazonPrice,true );
		}else {
			Reporter.log("Amazon and Flipkart Both have same price", true);
			Reporter.log("price of amazon"+amazonPrice+"price of flipkart"+flipkartPrice ,true);
		}
		
		
       }
	}

