package xml;

/*
 * Librerias de entrada/salida, parseadors de xml, estructuradores.
 */


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import edu.itcr.logictec.constants.Constants;

public class Toxml {
	int exits;
	
	public Toxml(){
		this.exits = 0;		
	}
	
	public void save(int[] parray) throws IOException {

	      try {

	        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

	        // root elements
	        Document doc = docBuilder.newDocument();
	        Element rootElement = doc.createElement("Component");
	        doc.appendChild(rootElement);

	        // Tree of one exit
	        Element tree = doc.createElement("ExitTree");
	        rootElement.appendChild(tree);

	        // number of exit on component
	        Attr attr = doc.createAttribute("exit");
	        attr.setValue(Integer.toString(exits));
	        tree.setAttributeNode(attr);

	        // Creates node on a loop for the nodes in an array send as 
	        // parameter.
	        for (int i = 0 ; i < parray.length; i++){
	        	Element node = doc.createElement("node");
		        node.appendChild(doc.createTextNode(Integer.toString(parray[i])));
		        tree.appendChild(node);
	        }
	        

	        // write the content into xml file
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File(Constants.fileXML));
	        //System.out.println(source);

	        transformer.transform(source, result);

	        System.out.println("File saved!");
	        this.exits++;

	      } catch (ParserConfigurationException pce) {
	        pce.printStackTrace();
	      } catch (TransformerException tfe) {
	        tfe.printStackTrace();
	      }
	}
}
