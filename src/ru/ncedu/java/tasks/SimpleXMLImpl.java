package ru.ncedu.java.tasks;

import java.io.*;
import org.xml.sax.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.*;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleXMLImpl implements SimpleXML{
	
	private String rootName;

	@Override
	public String createXML(String tagName, String textNode) {
		
		DocumentBuilderFactory dbf = null;
	    DocumentBuilder        db  = null;
	    Document               document = null;
	    
	    try {

		dbf = DocumentBuilderFactory.newInstance();
        db  = dbf.newDocumentBuilder();
        document = db.newDocument();
        
        Element root = document.createElement(tagName);
        document.appendChild(root);
		root.setTextContent(textNode);

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		
		DOMSource source = new DOMSource(document);
		String str;          
		OutputStream os = new ByteArrayOutputStream();
		StreamResult res = new StreamResult(os);            
		transformer.transform(source, res); 
		System.out.println(os.toString());
		str = os.toString(); 
		return str;
	    }
	    catch (ParserConfigurationException | TransformerConfigurationException | TransformerFactoryConfigurationError e) {
			e.printStackTrace();
			return null;
		} catch (TransformerException e) {
			e.printStackTrace();
			return null;
		}	
        
	}

	@Override
	public String parseRootElement(InputStream xmlStream) throws SAXException {
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance(); 
			factory.setValidating(true);
			SAXParser parser = factory.newSAXParser();					
			DefaultHandler dh = new MyHandler();
			parser.parse(xmlStream, dh);
			
		} catch (ParserConfigurationException e) {
			throw new SAXException();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return rootName;
		
	}
	
	class MyHandler extends DefaultHandler{
		private int elements = 0;
						
		public void startElement(String uri,
                String localName,
                String qName,
                Attributes attributes)
                  throws SAXException {
			elements++;
			if (elements == 1) {
				rootName = qName;
			}
		}
}
		
	//public static void main(String[] args){
	//new SimpleXMLImpl().createXML("person", "Ivanov");
	//}

}
