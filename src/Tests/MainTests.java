/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 *
 * @author Vijitha
 */
public class MainTests {
    String url;
    String browser = "firefox";
    WebDriver driver;
    static StringBuffer errors;
    
    public void setUp(String url, String browser) throws Exception {
        if (browser.compareToIgnoreCase("ie") == 0) {
            driver = new InternetExplorerDriver ();
        } else if (browser.compareToIgnoreCase("firefox") == 0) {
            driver = new FirefoxDriver();
         } else if (browser.compareToIgnoreCase("chrome") == 0) {
             //System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY , "C:/Automation/SeleniumRC/chromedriver.exe");
             System.setProperty("webdriver.chrome.driver", "../../../../lib/chromedriver.exe");
             driver = new ChromeDriver ();
         } else {
            driver = new HtmlUnitDriver();
        }
        wait (30);
        driver.get(url);
        wait(50);
        driver.manage().deleteAllCookies();
    }
    
    
}
