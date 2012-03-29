/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDriver;

import java.util.Map;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Vijitha
 */
public class TestcaseTest {
     Testcase instance = new Testcase("123", "Test test case");
    public TestcaseTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        //super.setUp();
        instance.setActionList("click", null);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTestId method, of class Testcase.
     */
    @Test
    public void testGetTestId() {
        System.out.println("getTestId");
        String expResult = "123";
        String result = instance.getTestId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTestName method, of class Testcase.
     */
    @Test
    public void testGetTestName() {
        System.out.println("getTestName");
        String expResult = "Test test case";
        String result = instance.getTestName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setActionList method, of class Testcase.
     */
    @Test
    public void testSetActionList() {
        System.out.println("setActionList");
        String key = "type";
        String value = "aaa";
        instance.setActionList(key, value);
        Map result = instance.getActionList();
        assertEquals("aaa", result.get("type"));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getActionList method, of class Testcase.
     */
    @Test
    public void testGetActionList_1() {
        System.out.println("getActionList");
        Map result = instance.getActionList();
        assertNull(result.get("click"));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
        

    /**
     * Test of setResult method, of class Testcase.
     */
    @Test
    public void testSetResult() {
        System.out.println("setResult");
        String tempResult = "Pass";
        instance.setResult(tempResult);
        String result = instance.getResult();
        assertEquals("PASS", result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getResult method, of class Testcase.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        String expResult = "FAIL";
        String result = instance.getResult();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setErrorMessage method, of class Testcase.
     */
    @Ignore
    @Test
    public void testSetErrorMessage() {
        System.out.println("setErrorMessage");
        String tempMessage = "";
        instance.setErrorMessage(tempMessage);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getMessage method, of class Testcase.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getElement method, of class Testcase.
     */
    @Ignore
    @Test
    public void testGetElement() {
        System.out.println("getElement");
        PageElement expResult = null;
        PageElement result = instance.getElement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of printTestCase method, of class Testcase.
     */
    @Ignore
    @Test
    public void testPrintTestCase() {
        System.out.println("printTestCase");
        Testcase instance = new Testcase();
        instance.printTestCase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
