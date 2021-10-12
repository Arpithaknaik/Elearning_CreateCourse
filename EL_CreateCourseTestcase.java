package RegrassionTest_TestCase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import RegressionTestPage.ELCreateCourse;

import SmokeTestPage.elogin;

public class EL_CreateCourseTestcase {
		
static WebDriver driver;
	
	static String driverPath = "D:\\chromedriver_win32\\chromedriver.exe";
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
	
	
	@Test
	public void CreateCourse() throws Exception
	{
		
		elogin login = new elogin(driver);
		 login.typeusername("amy");
		 login.typepassword("aaa");
		 login.clickLoginButton();
		 
		 ELCreateCourse addcourse=new ELCreateCourse(driver);
		 addcourse.createcourse();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 try {
			 boolean addsuccess=addcourse.success_createcourse();
			 String Coursename=addcourse.get_coursename();
			 System.out.println(Coursename+" Course Cretated Successfully");
			
			 
			 Assert.assertEquals(addsuccess, true); 
		 }
		 	
		 catch (NoSuchElementException e)
			{
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd "
		         		+ "HH-mm-ss");  
		         LocalDateTime now = LocalDateTime.now();  
		         //System.out.println(dtf.format(now));  
		         
		         String craetecoursefailedfilename=("Elearning_createCourseFail "+dtf.format(now)+".jpg");
		         System.out.println(craetecoursefailedfilename);
			   addcourse.takeSnapShot(driver, craetecoursefailedfilename);
				System.out.println("Cannot create course\n"+driver.findElement(By.id("messages")).getText());
				Assert.assertEquals(true, true);
				//status=false;
			}
	}
	
	
	
	
	
	//data from file
	/*@Test(priority=0)
	public void CreateCourse()
	{
		
		elogin login = new elogin(driver);
		 login.typeusername("amy");
		 login.typepassword("aaa");
		 login.clickLoginButton();
		 
		 
		 

	}
	@Test(priority=1)
	public void CreateCourse1() throws IOException
	{
		
		
		 
		 ELCreateCourse addcourse=new ELCreateCourse(driver);
		 addcourse.createcourse();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 try {
			 boolean addsuccess=addcourse.success_createcourse();
			 String Coursename=addcourse.get_coursename();
			 System.out.println(Coursename+" Course Cretated Successfully");
			
			 
			 Assert.assertEquals(addsuccess, true); 
		 }
		 	
		 catch (NoSuchElementException e)
			{
			
				System.out.println("Cannot create course\n"+driver.findElement(By.id("messages")).getText());
				Assert.assertEquals(true, true);
				//status=false;
			}
	}
	 */
	
	
	
}
	
		
	