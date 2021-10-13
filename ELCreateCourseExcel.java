package RegrassionTest_TestCase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RegressionTestPage.ELCreateCourse;
import RegressionTestPage.ExcelApiTest;
import SmokeTestPage.elogin;

public class ELCreateCourseExcel {
	static WebDriver driver;
	 String xlFilePath1 = "Course_name.xlsx";
	    String sheetName1 = "Sheet1";
	    ExcelApiTest eat1 = null;
	     
	
	static String driverPath = "D:\\chromedriver_win32\\chromedriver.exe";
	
	
	By username= By.id("login");
	By password = By.id("password");
	By loginstatus = By.xpath("//*[@id=\"cm-content\"]/div/ul/li");
	By loginbutton = By.id("form-login_submitAuth");

	By footerText = By.xpath("//*[contains(text(),'Administrator')]");

	By SignUpBotton=By.linkText("Sign up!");
	
	
	String xlFilePath = "Course_name.xlsx";
	String sheetName = "Sheet1";
	ExcelApiTest eat = null;
	By CreateCourse=By.linkText("Create a course");
	By Coursename=By.id("title");
	By AddCourse=By.cssSelector("#add_course_submit");
	By view= By.id("view_as_link");
	By Cname=By.xpath("//*[@id=\"cm-content\"]/div/ul/li");
	
	
	@AfterTest
	 public void closeAll()
    {
    	driver.close();
    }
	
	@BeforeTest
	public void veryfylogin()
	{
	
		System.setProperty("webdriver.chrome.driver", driverPath);
		 driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();
	}
	@Test(dataProvider="userData")
	public void CreateCourse(String course_name) throws InterruptedException 
	{
		
		driver.findElement(username).sendKeys("amy");
		driver.findElement(password).sendKeys("aaa");
		driver.findElement(loginbutton).click();
		driver.findElement(CreateCourse).click();
		driver.findElement(Coursename).sendKeys(course_name);
		driver.findElement(AddCourse).click();
		 
		 
		try {
			 WebElement coursename;
			 coursename=driver.findElement(By.xpath("//*[@id=\'course_tools\']/div[3]/h4"));
			System.out.println("Course created Successfully ");
		
		
		
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Cannot create course\n"+driver.findElement(By.id("messages")).getText());
			//status=false;
		}
	}
	 @DataProvider(name="userData")
	    public Object[][] userFormData() throws Exception
	    {
	        Object[][] data = testData(xlFilePath, sheetName);
	        return data;
	    }
	     
	    public Object[][] testData(String xlFilePath, String sheetName) throws Exception
	    {
	        Object[][] excelData = null;
	        eat = new ExcelApiTest(xlFilePath);
	        int rows = eat.getRowCount(sheetName);
	        int columns = eat.getColumnCount(sheetName);
	                 
	        excelData = new Object[rows-1][columns];
	         
	        for(int i=1; i<rows; i++)
	        {
	            for(int j=0; j<columns; j++)
	            {
	                excelData[i-1][j] = eat.getCellData(sheetName, j, i);
	            }
	             
	        }
	        return excelData;
	    }
	
		
	}
	





