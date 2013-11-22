package xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UserResourcesFromXML{
	String resources;

	public UserResourcesFromXML(){
		resources = new String();
	}
	
	public String XMLtoResources (int number){
		try {
			String path = new File(".").getCanonicalPath();
            FileInputStream file = 
            		new FileInputStream(new File(path + "/xml/resources.xml"));
            DocumentBuilderFactory builderFactory = 
            		DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =  builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(file); 
            XPath xPath =  XPathFactory.newInstance().newXPath();
 
            System.out.println("************************************");
            
            String expression01 = "/Levels/level[@stage="
            					+ Integer.toString(number) + "]/firstname";

            NodeList nodeList01 = (NodeList) xPath.compile(expression01)
            		.evaluate(xmlDocument, XPathConstants.NODESET);
            for (int i = 0; i < nodeList01.getLength(); i++) {
                System.out.println(nodeList01.item(i).getFirstChild()
                		.getNodeValue());
                resources = nodeList01.item(i).getFirstChild()
                		.getNodeValue();
            }
            System.out.println("************************************");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
		return resources;
	}
}
