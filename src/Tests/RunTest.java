/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

/**
 *
 * @author Vijitha
 */
import TestDriver.*;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class RunTest extends MainTests {

    String url;
    String browser = "firefox";
    static WebDriver driver;
    static StringBuffer verificationErrors;
    WebElement element;

    public void doTest(Testcase tc) {
        //Initializing a new verificationErrors for each test case - they are reported once for all
        verificationErrors = new StringBuffer();
        Map actionList = tc.getActionList();
        PageElement e = tc.getElement();
        element = getHoldOfElement (e);
        if (element == null ) {
            tc.setErrorMessage("Element was not found.");
            finish(tc);
        }
        for (Object x: actionList.keySet()) {
            performAction (x.toString(), actionList.get(x).toString());
        }
        tc.setResult("PASS");
        finish(tc);
    }

    public void setup(String url1, String browser1) {
        this.url = url1;
        if (browser1.length() > 0) {
            this.browser = browser1;
        }
        if (browser1.compareToIgnoreCase("ie") == 0) {
            driver = new InternetExplorerDriver();
        } else if (browser1.compareToIgnoreCase("firefox") == 0) {
            driver = new FirefoxDriver();
        } else if (browser1.compareToIgnoreCase("chrome") == 0) {
            //System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY , "C:/Automation/SeleniumRC/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

            driver = new ChromeDriver();
        } else {
            driver = new HtmlUnitDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url1);
        driver.manage().deleteAllCookies();
    }

    private WebElement getHoldOfElement(PageElement e) {
        String handle = e.getHandle();
        WebElement tmp = null;
        switch (handle.toLowerCase()) {
            case "id":
                tmp = driver.findElement(By.id (e.getId()));
                break;
            case "xpath":
                tmp = driver.findElement(By.xpath(e.getXpath()));
                break;
            case "class":
                tmp = driver.findElement(By.className(e.getElmtClass()));
                break;
            case "name":
                tmp = driver.findElement(By.name(e.getName()));
                break;
            case "general":
                tmp = driver.findElement(By.tagName("html"));
                break;
            default:return null;
        }
        return tmp;
    }

    private void finish(Testcase tc) {
        System.out.print (tc.getTestName() + " :  ");
        if (tc.getResult().equalsIgnoreCase("Pass") && verificationErrors.length() == 0)  {
            System.out.print( "Pass\n");
        } else if (tc.getResult().equalsIgnoreCase("Pass")) {
            System.out.print( "Pass with warnings");
            System.out.println ("Warnings : ");
            System.out.println (verificationErrors);
        } else {
            System.out.print( "Failed\n");
            System.out.println (verificationErrors);
            
        }
        
    }

    private void performAction(String action, String value) {
        //System.out.println ("Performing : " + action);
        switch (action.toLowerCase()) {
            case "click": element.click();
                break;
            case "type" : element.sendKeys(value);
                break;
            case "verifyTitle": verifyTitle (driver, value);
                break;
            case "select" : new Select(element).selectByVisibleText(value);
                break;
            case "teardown" : driver.close();
                break;
        }
    }

    private void report(Testcase tc) {
        // TODO: create a reporting class and stuff. For not printing on console
        
    }

    
}
