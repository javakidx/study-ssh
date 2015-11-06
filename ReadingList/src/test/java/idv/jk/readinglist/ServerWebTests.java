package idv.jk.readinglist;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ReadingListApplication.class)
@WebIntegrationTest(randomPort = true)
public class ServerWebTests
{
	private static FirefoxDriver browser;
	
	@Value("${local.server.port}")
	private int port;
	
	@BeforeClass
	public static void openBrowser()
	{
		browser = new FirefoxDriver();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void closeBrowser()
	{
		browser.quit();
	}
	
	public void addBookToEmptyList()
	{
		String baseUrl = "http://localhost:" + port;
		browser.get(baseUrl);
		
		assertEquals("You have no books in your book list", browser.findElementByName("div").getText());
		browser.findElementByName("title").sendKeys("BOOK TITLE");
		browser.findElementByName("author").sendKeys("BOOK AUTHOR");
		browser.findElementByName("isbn").sendKeys("1234567890");
	}
}
