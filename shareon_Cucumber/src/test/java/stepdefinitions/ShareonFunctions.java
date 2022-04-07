package stepdefinitions;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;

public class ShareonFunctions extends ConfigFileReader
{
	public static WebDriver driver;
	public static String exptitle; 
	public static String acttitle;
	public static String window1;
	public static String window2;
	
	
	Logger log = Logger.getLogger(ShareonFunctions.class);
	
	
	@Given("^I open browser with url \"([^\"]*)\"$")
	public void i_open_browser_with_url(String url) 
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");		
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		driver.get(url);
		log.info("Browser opened given URL");
	
	}

	@Then("^I should see Shareon logo$")
	public void i_should_see_Shareon_logo()
	{
		if (driver.findElement(By.className("shareon_logo")).isDisplayed())
		{
			System.out.println("App launch Sucessfully");
		}
		else
		{
			System.out.println("App launch failed");
		}
		
	}

	@When("^I click on Sign in$")
	public void i_click_on_Sign_in() 
	{
		driver.findElement(By.className("userName")).click();
	}

	@Then("^I should see Sign In page$")
	public void i_should_see_Sign_In_page()
	{
		driver.findElement(By.className("text-center"));
		
	}

	@When("^I click on Sign Up$")
	public void i_click_on_Sign_Up()
	{
		driver.findElement(By.linkText("Sign Up")).click();
	}

	@Then("^I should see Sign Up page$")
	public void i_should_see_Sign_Up_page()
	{
		driver.findElement(By.xpath("//div[2]/div/div[1]/h1"));
	}

	@When("^I click on i want to donate$")
	public void i_click_on_i_want_to_donate()
	{
		WebElement chkbox = driver.findElement(By.xpath("//div[2]/form/div[1]/label[1]/input")); 
		
		if(!chkbox.isSelected())
		{
			chkbox.click();
		}

	}

	@When("^i enter full name$")
	public void i_enter_full_name()
	{
		driver.findElement(By.name("field1")).sendKeys("Raju");
		
	}

	@When("^I enter mobileno$")
	public void i_enter_mobileno()
	{
		driver.findElement(By.name("mobileno")).sendKeys("9441816139");
	}

	@When("^I enter email$")
	public static void i_enter_email() throws IOException
	{
		
        driver.findElement(By.name("field2")).sendKeys(getemail());
	}

	@When("^I enter password$")
	public void i_enter_password() throws IOException
	{
		
		driver.findElement(By.name("psw")).sendKeys(getpassword());
		
	}

	@When("^I enter retype password$")
	public void i_enter_retype_password() throws IOException
	{
		
		driver.findElement(By.name("re_psw")).sendKeys(getpassword());
	}

	@When("^I click on submit$")
	public void i_click_on_submit()
	{
		driver.findElement(By.className("brown-btn")).click();

	}
	
	@When("^I click on close$")
	public void i_click_on_close() 
	{
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/span")).click();
	}


	@Then("^I should see username$")
	public void i_should_see_username()
	{
		driver.findElement(By.className("userName"));
		
	}

	@When("^I click on username$")
	public void i_click_on_username()
	{
		driver.findElement(By.className("userName")).click();
		
	}

	@When("^I click on Logout$")
	public void i_click_on_Logout()
	{
		driver.findElement(By.linkText("Sign Out")).click();
	}
	
	@When("^I click on donate$")
	public void i_click_on_donate()
	{
		WebElement chkbox = driver.findElement(By.xpath("//div[2]/div/div[3]/form/div[1]/label[1]/input")); 
		
		if(!chkbox.isSelected())
		{
			chkbox.click();
		}
	}
	
	@When("^I enter email and password$")
	public void i_enter_email_and_password() throws IOException
	{
		driver.findElement(By.xpath("//div[2]/div[2]/div/div[3]/form/div[2]/input")).sendKeys(getemail());
		driver.findElement(By.xpath("//*[@id='signuin_pass']")).sendKeys(getpassword());
	}

	@When("^I clicked submit$")
	public void i_clicked_submit()
	{
		driver.findElement(By.xpath("//div[3]/form/div[5]/div[1]/button")).click();
	}
	
	@When("^I click on Donate$")
	public void i_click_on_Donate() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='donate']")).click();
	}
	
	@When("^I scroll down to Support rural youth$")
	public void i_scroll_down_to_Support_rural_youth() 
	{
	  // identify element
	     WebElement l=driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div[1]/div[1]/a/div"));
	  // Javascript executor
	     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
	}

	@When("^I click on DonateNow$")
	public void i_click_on_DonateNow() throws InterruptedException
	{
	
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@contribute_key='6215e3a2806f54462fd40bba']")));

		driver.findElement(By.xpath("//button[@contribute_key='6215e3a2806f54462fd40bba']")).click();

	}


	@When("^I click on selected amount$")
	public void i_click_on_selected_amount()
	{
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[2]/div/div[1]/div/button[1]")));
		
		driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div[1]/div[5]/div[2]/div[2]/div/div[1]/div/button[1]")).click();
		
	}

	@When("^I click on pay$")
	public void i_click_on_pay() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Modalcontribute_6215e3a2806f54462fd40bba']/div[2]/div/div[2]/form/div[2]/button")));
		driver.findElement(By.xpath("//*[@id='Modalcontribute_6215e3a2806f54462fd40bba']/div[2]/div/div[2]/form/div[2]/button")).click();
	}

	
	@Then("^I click close$")
	public void i_click_close() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.switchTo().frame("ebc-checkout-frame");
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/span")).click();
		driver.switchTo().defaultContent();
	}

	@Then("^I should see error message$")
	public void i_should_see_error_message()
	{
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div[6]/div[1]/div/p"));


	}
	
	@When("^I scroll down to email id$")
	public void i_scroll_down_to_email_id() throws InterruptedException, IOException
	{
	     // identify element
	     WebElement l=driver.findElement(By.xpath("//input[@placeholder='Enter your e-mail id']"));
	     // Javascript executor
	     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
	     Thread.sleep(5000);
	     driver.findElement(By.xpath("//input[@placeholder='Enter your e-mail id']")).sendKeys(getsubscription_mail());
		
	}

	@When("^I click on subscription$")
	public void i_click_on_subscription() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@class='subscribe_now']")).click();
		Thread.sleep(3000);
		
	}
	
	@When("^I click on contact us$")
	public void i_click_on_contact_us() 
	{
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='support-btn']"))));
		driver.findElement(By.xpath("//button[@class='support-btn']")).click();
		log.info("Contact us opened");
	}

	@When("^I enter contact name and contact email$")
	public void i_enter_contact_name_and_contact_email()
	{
		driver.findElement(By.xpath("//input[@placeholder='Name'and @name='field1']")).sendKeys("rajesh");
		driver.findElement(By.xpath("//input[@placeholder = 'Email' and @name = 'field2']")).sendKeys("demoautomation11@gmail.com");
	}

	@When("^I enter contact number$")
	public void i_enter_contact_number()
	{
		driver.findElement(By.xpath("//div[3]/div/input")).sendKeys("9032073279");
	}

	@Then("^I select a question from list$")
	public void i_select_a_question_from_list()
	{
		driver.findElement(By.xpath("//div[4]/select/option[6]")).click();

	}

	@Then("^I write a message$")
	public void i_write_a_message()
	{
		driver.findElement(By.xpath("//*[@placeholder='Message']")).sendKeys("comments");
		
	}

	@Then("^I click on contact_submit$")
	public void i_click_on_contact_submit()
	{
		driver.findElement(By.xpath("//div[2]/div[6]/button[1]")).click();
	}

	@Then("^I click on search button and pass the data$")
	public void i_click_on_search_button_and_pass_the_data()
	{
		driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("rajasthan");
		
	}
	@When("^I scroll down to Learn About SDGs$")
	public void i_scroll_down_to_Learn_About_SDGs()
	{
		// identify element
	     WebElement l=driver.findElement(By.partialLinkText("Learn About SDGs"));
	  // Javascript executor
	     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
	     
	}

	@When("^I click on it$")
	public void i_click_on_it() 
	{
		driver.findElement(By.partialLinkText("Learn About SDGs")).click();
	}

	@Then("^I should redirect to child page$")
	public void i_should_redirect_to_child_page()
	{
		Set<String> allwindows = driver.getWindowHandles();
		Object[] windows = allwindows.toArray();
		window1 = windows[0].toString();
		window2 = windows[1].toString();
		
		driver.switchTo().window(window2);
		log.info("driver focused to child tab opened");
	}

	@Then("^I close popup$")
	public void i_close_popup() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[3]/div/div/div/div/div/img")).click();
		log.info("pop up message closed");
		
	}

	@Then("^I redirect to parent page$")
	public void i_redirect_to_parent_page()
	{
		driver.switchTo().defaultContent();
		log.info("driver focused to parent tab");
	}
	
	@When("^I click on sharenow$")
	public void i_click_on_sharenow() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@campaign_path='/campaign/supportrural-youth-in-tackling-unemployment']")).click();
	}

	@When("^I click on fb image$")
	public void i_click_on_fb_image() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@aria-label='facebook']")).click();
		Thread.sleep(3000);
	}

	@When("^I  click content$")
	public void i_click_content()
	{
		driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div[1]/div[1]/a")).click();
	}
	@Then("^I perform scroll to read more about and click it$")
	public void i_perform_scroll_to_read_more_about_and_click_it()
	{
		// identify element
	     WebElement l=driver.findElement(By.partialLinkText("Read more about the campaign"));
	     // Javascript executor
	     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
	     driver.findElement(By.partialLinkText("Read more about the campaign")).click();
	}
	
	
	@Then("^I should see new window opened with facebook$")
	public void i_should_see_new_window_opened_with_facebook()
	{
		 Set<String>  allwindows = driver.getWindowHandles();		 
		 Object[] windows =  allwindows.toArray();
		 String window1 = windows[0].toString();
		 String window2 = windows[1].toString();

		 driver.switchTo().window(window2);
		 driver.manage().window().maximize();
		 String title =driver.getTitle();
		 log.info("Title of the tab "+title);
		
	}

	@Then("^I enter email and Password$")
	public void i_enter_email_and_Password()
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("demoautomation27@rediffmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Atos123!@#");
		
	}

	@Then("^I click Login$")
	public void i_click_Login() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		
	}

	@Then("^I click on post to fb$")
	public void i_click_on_post_to_fb()
	{
		
		driver.findElement(By.xpath("//button[@name='__CONFIRM__']")).click();
		
	}
	@Then("^I close browser$")
	public void i_close_browser()
	{
		driver.close();
		log.info("browser closed");
	}

}
