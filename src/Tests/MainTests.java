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
        
    void verifyTitle(WebDriver driver, String value) {
        String title = driver.getTitle();
        if (!title.contains(value)) {
            RunTest.verificationErrors.append("Title Check Failed: Found - ").append(title);
        }
            
    }
    
    
}
