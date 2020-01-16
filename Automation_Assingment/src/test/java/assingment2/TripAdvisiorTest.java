package assingment2;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.Automation_Assingment.genericLibrary.BaseClass;
import com.Automation_Assingment.objectRepository.assingment2.TripAdvisorPage;

/**
 * 
 * @author Prakriti Priya
 *
 */
public class TripAdvisiorTest extends BaseClass {
	@Test
	public void ratingsAndReviewTest() throws Throwable {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	/* Navigating to TripAdvisorPage */
	TripAdvisorPage tripAdvisor = new TripAdvisorPage(BaseClass.driver);
	
	/* Search for Club Mahindra inTripAdvisor */
	tripAdvisor.searchInTripAdvisor(driver,"Sheet1", 1, 1);
	/* Search for  reviewTitleTripAdvisor inTripAdvisor */
	tripAdvisor.reviewTitleTripAdvisor(driver,"Sheet1", 1, 2);
	/* Search for  reviewTextTripAdvisor inTripAdvisor */
	
	tripAdvisor.reviewTextTripAdvisor("Sheet1", 1, 3);
		
	}

}
