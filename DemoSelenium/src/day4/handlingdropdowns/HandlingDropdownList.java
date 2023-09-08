package day4.handlingdropdowns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.SeleniumUtil;

public class HandlingDropdownList extends SeleniumUtil {
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = setUp("chrome","https://demo.automationtesting.in/Register.html");	
		WebElement dropdown = driver.findElement(By.id("Skills"));
		Select selectDropdown = new Select(dropdown);
		System.out.println("Is dropdown multiselect ? "+selectDropdown.isMultiple());
		System.out.println("Already Selected value "+selectDropdown.getFirstSelectedOption().getText());
		List <WebElement> allOptions = selectDropdown.getOptions();
		System.out.println("Total options: "+allOptions.size());
		for(int i=0;i<allOptions.size();i++)
		{
			System.out.println("Option "+i+":"+allOptions.get(i).getText());
		}
		
		selectDropdown.selectByIndex(2);
		System.out.println("Already Selected value "+selectDropdown.getFirstSelectedOption().getText());
		
		selectDropdown.selectByValue("Backup Management");
		System.out.println("Already Selected value "+selectDropdown.getFirstSelectedOption().getText());
		
		selectDropdown.selectByVisibleText("Android");
		System.out.println("Already Selected value "+selectDropdown.getFirstSelectedOption().getText());
		
		String act_skillName= "";
		for(int i=0;i<allOptions.size();i++)
		{
			if((allOptions.size()-1)!= i)
			{
				act_skillName= act_skillName+allOptions.get(i).getText()+", ";
				
			}
			else
			{
				act_skillName= act_skillName+allOptions.get(i).getText();
			}
		}
		System.out.println(act_skillName);
		String exp_skillName ="Select Skills, Adobe InDesign, Adobe Photoshop, Analytics, Android, APIs, Art Design, AutoCAD, Backup Management, C, C++, Certifications, Client Server, Client Support, Configuration, Content Managment, Content Management Systems (CMS), Corel Draw, Corel Word Perfect, CSS, Data Analytics, Desktop Publishing, Design, Diagnostics, Documentation, End User Support, Email, Engineering, Excel, FileMaker Pro, Fortran, HTML, Implementation, Installation, Internet, iOS, iPhone, Linux, Java, Javascript, Mac, Matlab, Maya, Microsoft Excel, Microsoft Office, Microsoft Outlook, Microsoft Publisher, Microsoft Word, Microsoft Visual, Mobile, MySQL, Networks, Open Source Software, Oracle, Perl, PHP, Presentations, Processing, Programming, PT Modeler, Python, QuickBooks, Ruby, Shade, Software, Spreadsheet, SQL, Support, Systems Administration, Tech Support, Troubleshooting, Unix, UI / UX, Web Page Design, Windows, Word Processing, XML, XHTML";
		System.out.println("Skills are in sorted order or not :"+act_skillName.equals(exp_skillName));
		
		
		//validating days dropdown
		Select dayDrop = new Select(driver.findElement(By.id("daybox")));
		List <Integer> days = new ArrayList <Integer>();
		for(int i=1;i<dayDrop.getOptions().size();i++)
		{
			String day= dayDrop.getOptions().get(i).getText();
			days.add(Integer.parseInt(day));
		}
		List <Integer> dupdays = new ArrayList <Integer>(days);
		Collections.sort(dupdays);
		System.out.println(days.equals(dupdays));
		
		//validating month dropdown
				Select monthDrop = new Select(driver.findElement(By.cssSelector("select[placeholder='Month']")));
				List <String> months = new ArrayList <String>();
				for(int i=1;i<monthDrop.getOptions().size();i++)
				{
					String month= monthDrop.getOptions().get(i).getText();
					months.add(month);
				}
				List <String> dupMonths = new ArrayList <String>();
				dupMonths.add("January");
				dupMonths.add("February");
				dupMonths.add("March");
				dupMonths.add("April");
				dupMonths.add("May");
				dupMonths.add("June");
				dupMonths.add("July");
				dupMonths.add("August");
				dupMonths.add("September");
				dupMonths.add("October");
				dupMonths.add("November");
				dupMonths.add("December");
				
				System.out.println("Months are in sorted order or not : "+months.equals(dupMonths));
		
				//validating year dropdown
				Select yearDrop = new Select(driver.findElement(By.id("yearbox")));
				List <Integer> years = new ArrayList <Integer>();
				for(int i=1;i<yearDrop.getOptions().size();i++)
				{
					String year= yearDrop.getOptions().get(i).getText();
					years.add(Integer.parseInt(year));
				}
				//System.out.println(years);
				List <Integer> dupYears = new ArrayList <Integer>(years);
				Collections.sort(dupYears);
				System.out.println("years are in sorted order or not : "+years.equals(dupYears));
		
				
				driver.close();
				
	}

}
