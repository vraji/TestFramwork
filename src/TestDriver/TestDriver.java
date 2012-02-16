/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDriver;

/**
 *
 * @author Vijitha
 */
import Tests.RunTest;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class TestDriver {
    RunTest runTest = new RunTest ();
    public static void main(String[] args) {
        TestDriver TD = new TestDriver();
        TD.readAndExcecuteTests();
    }

    private void readAndExcecuteTests() {
        try {

            File fXmlFile = new File("D:/Vijitha/WorkSpace/TestFramework/src/XmlTestCases/sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            Node setupNode = getElementByTagName(doc, "setup");
            Testcase tc = new Testcase("Setup", "setup");
            parseSetupNode(setupNode);
            NodeList elementNodes = doc.getElementsByTagName("element");
            Element elmt;
            
            for (int i = 0; i < elementNodes.getLength(); i++) {

                elmt = (Element) elementNodes.item(i);
                String tcName = elmt.getAttribute("testname");
                String tcId = elmt.getAttribute("testid");
                tc = new Testcase(tcId, tcName);
                if (elmt.hasAttribute("id")) {
                    String tmp = elmt.getAttribute("id");
                    tc.element.setID(tmp);
                }
                if (elmt.hasAttribute("name")) {
                    String tmp = elmt.getAttribute("name");
                    tc.element.setName(tmp);
                }
                if (elmt.hasAttribute("class")) {
                    String tmp = elmt.getAttribute("class");
                    tc.element.setElmtClass(tmp);
                }
                if (elmt.hasAttribute("xpath")) {
                    String tmp = elmt.getAttribute("xpath");
                    tc.element.setXpath(tmp);
                }
                NodeList actionNodes = elmt.getElementsByTagName("*");
                
                for (int j = 0; j < actionNodes.getLength(); j++) {
                    Element actionNode = (Element) actionNodes.item(j);
                    String action = actionNode.getTagName();
                    NodeList secondNodeLst = actionNode.getChildNodes();
                    if (secondNodeLst.getLength() == 0) {
                        tc.setActionList(action, "");
                        //System.out.println(action);
                    } else { 
                        String value = ((Node) secondNodeLst.item(0)).getNodeValue();
                        tc.setActionList(action, value);
                        //System.out.println(action + " : " + value);
                    }
                    tc.printTestCase();
                    runTest.doTest(tc);
                }
            }

        } catch (Exception e) {
        }
    }

    private Node getElementByTagName(Document doc, String searchString) throws WrongFileFormat {
        NodeList nList = doc.getElementsByTagName(searchString);
        if (nList.getLength() != 1) {
            System.out.println("There can be only one node : " + searchString);
            throw new WrongFileFormat("There can be only one node : " + searchString);
        }
        return nList.item(0);
    }

    private void parseSetupNode(Node setupNode) throws WrongFileFormat {
        String name = getElementByTagName(setupNode, "name").getNodeValue();
        String url = getElementByTagName(setupNode, "url").getNodeValue();
        String browser = getElementByTagName(setupNode, "browser").getNodeValue();
        runTest.setup(url, browser);
        System.out.println(name);
    }

    private Node getElementByTagName(Node givenNode, String searchString) throws WrongFileFormat {
        Element elmt = (Element) givenNode;
        NodeList nList = elmt.getElementsByTagName(searchString);
        if (nList.getLength() != 1) {
            System.out.println("There Must be on Node : " + searchString);
            throw new WrongFileFormat("There can be only one node : " + searchString);
        }
        elmt = (Element) nList.item(0);
        nList = elmt.getChildNodes();
        System.out.println(nList.item(0));
        return nList.item(0);
    }
}
