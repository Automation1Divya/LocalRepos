package switching;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class ErailAssignment extends SeleniumUtility {
	
  @Test
  public void restaurantAndTrainNames() {
		
	  	setUp("chrome","https://erail.in/");
		String pWinId=driver.getWindowHandle();
		clickOnElement(driver.findElement(By.xpath("//a[text()='eCatering']")));
		Set<String> allWinId=driver.getWindowHandles();
		allWinId.remove(pWinId);
		String cWinId=allWinId.iterator().next();
		System.out.println("Parent win id: "+pWinId);
		System.out.println("Child win id: "+cWinId);
		driver.switchTo().window(cWinId);
		clickOnElement(driver.findElement(By.xpath("//input[@placeholder='Search Train or Station to explore']")));
		typeInput(driver.findElement(By.xpath("//input[@placeholder='Start typing Nagpur, NGP, Rajdhani']")),"12627");
		clickOnElement(driver.findElement(By.xpath("//button[text()='KARNATAKA EXP']")));
		clickOnElement(driver.findElement(By.name("date")));
		//inspect date picker----pending
		for (int i = 0; i < 7; i++) {
			if (i == 6) {
				driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			} else {
				driver.switchTo().activeElement().sendKeys(Keys.ARROW_DOWN);
			}
		}

		Select selectBoardingStation = new Select(driver.findElement(By.xpath("//select[@placeholder='Boarding Station']")));
		selectBoardingStation.selectByValue("ET");
		clickOnElement(driver.findElement(By.xpath("//button[text()='FIND FOOD']")));
		//List<WebElement>restoNames=driver.findElements(By.cssSelector(".flex.flex-col.gap-4.pt-10>div *:nth-child(2)>*:nth-child(1)>h5"));
		List<WebElement>restoNames=driver.findElements(By.cssSelector(".min-h-screen>.flex.flex-col>div>div:not([class^='hidden']) .tracking-normal"));
		System.out.println("Total restaurants: "+restoNames.size());
		for(int i=0;i<restoNames.size();i++)
		{
			System.out.println("Restaurant Name : "+restoNames.get(i).getText());
		}
		
		//switch to parent window
		driver.switchTo().window(pWinId);
		typeInput(driver.findElement(By.id("txtStationFrom")), "pune");
		clickOnElement(driver.findElement(By.xpath("//div[@title='Pune Jn']")));
		typeInput(driver.findElement(By.id("txtStationTo")), "bangalore");
		clickOnElement(driver.findElement(By.xpath("//div[@title='Bangalore Cant']")));
		clickOnElement(driver.findElement(By.xpath("//input[@title='Select Departure date for availability']")));
		clickOnElement(driver.findElement(By.xpath("//div[@id='divCalender']//tr[1]/td[2]//tr[7]/td[1]")));
		clickOnElement(driver.findElement(By.id("buttonFromTo")));
		List<WebElement>trainNos=driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr/td[1]"));
		List<WebElement>trainNames=driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr/td[2]"));
		System.out.println("**************Train Information******************");
		for(int i=0;i<trainNos.size();i++)
		{
			WebElement element = trainNos.get(i);
			if(element.getText().contains("Below trains not departing on"))
			{
				System.out.println("********"+element.getText()+"***********");
				continue;
			}
			else
			System.out.println((i+1)+"Train no is: "+trainNos.get(i).getText()+" Train name is : "+trainNames.get(i).getText());
		}
		
  }
}
