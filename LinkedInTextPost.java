package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LinkedInTextPost {
    ChromeDriver driver;
    public LinkedInTextPost()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
     //Linkedin text post
     public void testCase05() throws InterruptedException{
        // Launch the browser :
        // Maximize the window :using  driver.manage().window().maximize();
        // implicitly wait for 30 sec :using driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Load the url   https://www.linkedin.com/
        driver.get("https://www.linkedin.com/");
        // Enter the user name  Using Locator "ID" "session_key" using sendKeys("username");
        driver.findElementById("session_key").sendKeys("priyanka.sonawane2810@gmail.com");
        // Enter the password Using Locator "ID":"session_password" using sendKeys("Automation23")
        driver.findElementById("session_password").sendKeys("Automation23");

        // Click on the signin button  Using Locator "XPath" "*//button[contains(text(),'Sign in')]" using click();
        driver.findElementByXPath("*//button[contains(text(),'Sign in')]").click();
        // wait for 30 sec 
        Thread.sleep(1000); 
        // verify the user is loged in successfully Using Locator "Class" Name "t-16 t-black t-bold" using method getText().equals("username");
        if(driver.findElementByClassName("t-16 t-black t-bold").getText().equals("Priya Patel")){
            System.out.println("user is successfully loged in");
        }
        // get the value Who's viewed your profile Using Locator "XPath" "(*//span[@class='feed-identity-widget-item__stat'])[1]" using getText()
        String view= driver.findElementByXPath("(*//span[@class='feed-identity-widget-item__stat'])[1]").getText();
        System.out.println("who's viwe your profile "+ view);
                // get the value Impressions of your post Using Locator "XPath" "(*//span[@class='feed-identity-widget-item__stat'])[2]" using getText()
        String impression= driver.findElementByXPath("(*//span[@class='feed-identity-widget-item__stat'])[2]").getText();
        System.out.println("impression of your post "+ impression);
        // wait for 30 sec 
        Thread.sleep(1000); 
        // click on the post button Using Locator "ID" "*//div[@class='share-box-feed-entry__top-bar']//button"
        driver.findElementByXPath("*//div[@class='share-box-feed-entry__top-bar']//button").click();
        // wait for 30 sec  
        Thread.sleep(1000);
        // Enter the post Using Locator "XPath" "*//div[@class='ql-editor ql-blank']/p"
        driver.findElementByXPath("*//div[@class='ql-editor ql-blank']/p").sendKeys("This is an automated post");
        
        // Click on the dropDown to select the option Using Locator "XPath" "*//div[@class='share-creation-state__content-scrollable']//button"
        if(!driver.findElementByXPath("(//span[@class='share-state-change-button__label'])[1]").getText().equals("CONNECTIONS_ONLY")){
            driver.findElementByXPath("*//div[@class='share-creation-state__content-scrollable']//button").click();
        }
        // Click on the button connections only Using Locator "ID" "CONNECTIONS_ONLY"
        driver.findElementById("CONNECTIONS_ONLY").click();
        // Click on the save button Using Locator "ID" "(*//div[@class='share-box-footer__main-actions']//button)[2]"
        driver.findElementByXPath("(*//div[@class='share-box-footer__main-actions']//button)[2]").click();
        // click on the post button if enabled Using Locator "ID" "*//div[@class='share-box_actions']//button" isEnabled()
        if(driver.findElementByXPath("*//div[@class='share-box_actions']//button").isEnabled()){
            driver.findElementByXPath("*//div[@class='share-box_actions']//button").click();
        }

        if(driver.findElementByXPath("(//span[@dir='ltr'])[1]").getText().equals("Priya Patel")){
            System.out.println("post successfull");
        }
    }
}
