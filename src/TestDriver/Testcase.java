/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDriver;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vijitha
 */
public class Testcase {
    
    private String testId;
    private String testName; // A name for the testcase
    //private String type; // More infor about the test case, will say what it does
    private String result; // Assumed to fail
    private String errorMessage; // Error messages are added here for reporting
    Map<String, String> actionList = new HashMap<String, String>();
    PageElement element;
    
    
    Testcase (String tempId, String tempName) {
        testId = tempId;
        testName = tempName;
        result = "FAIL";
        errorMessage = "";
        element = new PageElement ();
    }

    Testcase() {
        
    }
    public String getTestId () {
        return testId;
    }
    public String getTestName() {
        return testName;
    }
    
    void setActionList (String key, String value) {
        actionList.put(key, value);
    }
    public Map getActionList (){
        return actionList;
    }
    public void setResult (String tempResult) {
        if (tempResult.toLowerCase().equals ("pass") || tempResult.toLowerCase().equals ("passed") ) {
            result = "PASS";
        } else if (tempResult.toLowerCase().equals ("fail") || tempResult.toLowerCase().equals ("failed")) {
            result = "FAIL";
        }
    }
    String getResult() {
        return result;
    }
    public void setErrorMessage (String tempMessage) {
        errorMessage = errorMessage + tempMessage + "\n" ;
    }
    public String getMessage() {
        return errorMessage;
    }
    
    public PageElement getElement () {
        return element;
    }
    
    public void printTestCase () {
        System.out.println (testName);
        element.printElementDetails();
        System.out.println ("Actions : ");
        for (Object x: actionList.keySet()) {
            System.out.println (x.toString() + " : " + actionList.get(x));
        }
        if (errorMessage.length() > 0 ) {
            System.out.println (errorMessage);
        }
    }
    
    
}
