/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDriver;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Vijitha
 */
public class PageElementTest {
    
    public PageElementTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setID method, of class PageElement.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        String str = "abc";
        PageElement instance = new PageElement();
        instance.setID(str);
        String result = instance.getId();
        assertEquals (result, str);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class PageElement.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        PageElement instance = new PageElement();
        String result = instance.getId();
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class PageElement.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String str = "abc-name";
        PageElement instance = new PageElement();
        instance.setName(str);
        String result = instance.getName();
        assertEquals (result, str);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class PageElement.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        PageElement instance = new PageElement();
        String result = instance.getName();
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setElmtClass method, of class PageElement.
     */
    @Test
    public void testSetElmtClass() {
        System.out.println("setElmtClass");
        String str = "nnn";
        PageElement instance = new PageElement();
        instance.setElmtClass(str);
        String result = instance.getElmtClass();
        assertEquals (str, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getElmtClass method, of class PageElement.
     */
    @Test
    public void testGetElmtClass() {
        System.out.println("getElmtClass");
        PageElement instance = new PageElement();
        String result = instance.getElmtClass();
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setXpath method, of class PageElement.
     */
    @Test
    public void testSetXpath() {
        System.out.println("setXpath");
        String str = "/a/b/c";
        PageElement instance = new PageElement();
        instance.setXpath(str);
        String result = instance.getXpath();
        assertEquals (str, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getXpath method, of class PageElement.
     */
    @Test
    public void testGetXpath() {
        System.out.println("getXpath");
        PageElement instance = new PageElement();
        String result = instance.getXpath();
        assertNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getHandle method, of class PageElement.
     */
    @Test
    public void testGetHandle() {
        System.out.println("getHandle");
        PageElement instance = new PageElement();
        String expResult = "ID";
        instance.setID("abc");
        String result = instance.getHandle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of printElementDetails method, of class PageElement.
     */
    @Ignore
    @Test
    public void testPrintElementDetails() {
        System.out.println("printElementDetails");
        PageElement instance = new PageElement();
        instance.printElementDetails();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
