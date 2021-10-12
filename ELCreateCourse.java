package RegressionTestPage;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import RegressionTestPage.ExcelApiTest;




 //This class will store all the locators and methods of Login page
 
public class ELCreateCourse {
	
WebDriver driver;	

By CreateCourse=By.linkText("Create a course");
By Coursename=By.id("title");
By AddCourse=By.cssSelector("#add_course_submit");
By view= By.id("view_as_link");
By Cname=By.xpath("//*[@id=\"cm-content\"]/div/ul/li");

//*[@id="course_tools"]/div[3]/h4
//By Authoring1=By.xpath("//*[@id=\"course_tools\"]/div[3]/h4");
//driver.findElement(By.id("title")).sendKeys("TestSeleniumAB");
//driver.findElement(By.cssSelector("#add_course_submit")).click();
//authoring=driver.findElement(By.xpath("//*[@id=\'course_tools\']/div[3]/h4"));





//creating parameterized constructor to initialize WebDriver reference
public ELCreateCourse(WebDriver driver)
{
	this.driver =driver;
}

public void createcourse()  
{
	driver.findElement(CreateCourse).click();
	driver.findElement(Coursename).sendKeys("Css2");
	driver.findElement(AddCourse).click();
	
	
}





/*//course name from file
public void createcourse() throws IOException  
{
	driver.findElement(CreateCourse).click();
	
	Properties obj = new Properties();
	FileInputStream objfile = new FileInputStream("Coursename");
	obj.load(objfile);
	String cn = obj.getProperty("course_name");
	
	driver.findElement(Coursename).sendKeys(cn);
	
	//driver.findElement(Coursename).sendKeys("Css2");
	driver.findElement(AddCourse).click();
	
	
}*/



/*
public boolean success_createcourse()
{
	boolean addsuccess;
	WebElement Authoring;
	 Authoring=driver.findElement(By.xpath("//*[@id=\'course_tools\']/div[3]/h4"));
	 
	 addsuccess=true;
     System.out.println("\nCourse created successfully  ");
	   // boolean addsuccess=driver.findElement(Authoring1).isDisplayed();
		//System.out.println(driver.findElement(Authoring1).getText());
		return addsuccess;
	

	
}
*/

public boolean success_createcourse()
{
	
    boolean regsuccess=driver.findElement(view).isDisplayed();
    //System.out.println("\nCourse created successfully");
	return regsuccess;
	

	
}
public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
    //Convert web driver object to TakeScreenshot
    TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    //Call getScreenshotAs method to create image file
    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
    //Move image file to new destination
     File DestFile=new File(fileWithPath);
  //Copy file at destination
    FileUtils.copyFile(SrcFile, DestFile);
}

public String get_coursename() {
	// TODO Auto-generated method stub
	return driver.findElement(Cname).getText();
}

}