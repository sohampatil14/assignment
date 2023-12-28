package xml_io;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * DOM Parser treats XML as a tree
 */

public class XMLReaderDOM {

	private static void printNodeList(NodeList nodeList) {  
		
		for (int count = 0; count < nodeList.getLength(); count++) {  
			
			Node elemNode = nodeList.item(count);  
			if (elemNode.getNodeType() == Node.ELEMENT_NODE) {  
				// get node name and value
				System.out.println("\nNode Name: <" + elemNode.getNodeName() + ">");  
				System.out.println("Node Content: " + elemNode.getTextContent());  
				if (elemNode.hasAttributes()) {  
					NamedNodeMap nodeMap = elemNode.getAttributes();  
					for (int i = 0; i < nodeMap.getLength(); i++) {  
						Node node = nodeMap.item(i);  
						System.out.println("Attribute name: " + node.getNodeName());  
						System.out.println("Attribute value: " + node.getNodeValue());  
					}  
				}  
				if (elemNode.hasChildNodes()) {  
					//recursive call if the node has child nodes  
					printNodeList(elemNode.getChildNodes());  
				}  
				System.out.println("Node Name: </" + elemNode.getNodeName() + ">");  
			}  
		}  
	}  
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File file = new File("xml\\read.xml");  
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();  
		Document document = documentBuilder.parse(file);  
		System.out.println("Root element: "+ document.getDocumentElement().getNodeName());  
		
		if (document.hasChildNodes()) {  
			printNodeList(document.getChildNodes());  
		}
	}
}
