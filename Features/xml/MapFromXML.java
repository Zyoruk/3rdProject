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

import datastructs.doublelist.DoubleList;

public class MapFromXML<K> extends DoubleList<K>{
	DoubleList<	DoubleList<String>> map;

	public MapFromXML(){
		map = new DoubleList<DoubleList<String>>();
	}
	
	public DoubleList<DoubleList<String>> XMLtoMap (int plevel){
		try {
			String path = new File(".").getCanonicalPath();
            FileInputStream file = 
            		new FileInputStream(new File(path + "/xml/map.xml"));
            DocumentBuilderFactory builderFactory = 
            		DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =  builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(file); 
            XPath xPath =  XPathFactory.newInstance().newXPath();
 
            System.out.println("************************************");
            
            String expression01 = "/Map/Column/Node/type";
            String expressionY = "/Map/Size/y";
            
            NodeList nodeList01 = 
            		(NodeList) xPath.compile(expression01)
            						.evaluate(xmlDocument, 
            								  XPathConstants.NODESET);
            
            int y = Integer.parseInt(xPath.compile(expressionY)
            							  .evaluate(xmlDocument));
            
        	DoubleList<String> column = new DoubleList<String>();
        	
            for (int i = 0; i < nodeList01.getLength(); i++) {
            	if(i < 9){
	        		System.out.println("Inserting node " + "00" + (i+1) + ": " +
	        						  nodeList01.item(i).getFirstChild()
	        											.getNodeValue());
            	} else if ((i+1) >= 10 && i < 99) {
            		System.out.println("Inserting node " + "0" + (i+1) + ": " +
  						  nodeList01.item(i).getFirstChild()
  											.getNodeValue());
            	} else {
            		System.out.println("Inserting node " + (i+1) + ": " +
  						  nodeList01.item(i).getFirstChild()
  											.getNodeValue());
            	}
            	
        		column.append(nodeList01.item(i).getFirstChild()
        										.getNodeValue());
        		if (y == column.length()) {
        			map.append(column);
        			column.clear();
        		}
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
		return map;
	}	
}
