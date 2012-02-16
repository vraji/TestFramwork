/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDriver;

/**
 *
 * @author Vijitha
 */
public class PageElement {
    String id;
    String name;
    String elmtClass;
    String xpath;
    String handle;
    void setID (String str) {
        id = str;
        handle = "ID";
    }
    public String getId () {
        return id;
    }
    
    void setName (String str) {
        name = str;
        handle = "NAME";
    }
    public String getName () {
        return name;
    }
    
    void setElmtClass (String str) {
        elmtClass = str;
        handle = "CLASS";
    }
    public String getElmtClass () {
        return elmtClass;
    }
    
    void setXpath (String str) {
        xpath = str;
        handle = "XPATH";
    }
    public String getXpath () {
        return xpath;
    }
    
    public String getHandle () {
        return handle;
    }
    public void printElementDetails() {
        //System.out.println(handle);
        System.out.println ("Element : ");
        switch (handle.toLowerCase()) {
            case "id":
                System.out.print("ID : " + id);
                break;
            case "xpath":
                System.out.print("Xpath : " + xpath);
                break;
            case "class":
                System.out.print("Class : " + elmtClass);
                break;
            case "name":
                System.out.print("Name : " + name);
                break;
        }
    }
}
