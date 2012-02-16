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

public class RunTest {

    String url;
    String browser = "firefox";
    static WebDriver driver;
    static StringBuffer verificationErrors;
    WebElement element;

    public void doTest(Testcase tc) {
        verificationErrors = new StringBuffer();
        Map actionList = tc.getActionList();
        PageElement e = tc.getElement();
        element = getHoldOfElement (e);
        if (element == null ) {
            tc.setErrorMessage("Element was not found.");
            finish();
        }
        for (Object x: actionList.keySet()) {
            performAction (x.toString(), actionList.get(x).toString());
        }
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
            default:return null;
        }
        return tmp;
    }

    private void finish() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void performAction(String action, String value) {
        switch (action.toLowerCase()) {
            case "click": element.click();
                break;
            case "type" : element.sendKeys(value);
                break;
        }
    }
}
