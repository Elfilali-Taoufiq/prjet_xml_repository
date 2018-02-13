package com.xml;

import java.awt.List;
import java.io.File;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.bo.Line;
import com.bo.Point;

public class XmlWriter {
	
	
	private Document doc;

		public void convert(String pFile,java.util.List<Line>lines) throws XmlException{
			try{
				  DocumentBuilderFactory dbFactory =
			    	         DocumentBuilderFactory.newInstance();
			    	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			    	         Document doc = dBuilder.newDocument();
				
			

	         // root element
	         Element rootElement = doc.createElement("cars");
	         doc.appendChild(rootElement);
	         
	         for(Line it:lines){	
	        	 //ligne
	        	 
	         Element ligne= doc.createElement("ligne");
	         // poiny A
	         Element pointA=doc.createElement("pointA");
	         pointA.setAttribute("x",String.valueOf(it.getA().getX()));
	         pointA.setAttribute("y",String.valueOf(it.getA().getY()));

	         // poiny B
	         Element pointB=doc.createElement("pointB");
	         pointA.setAttribute("x",String.valueOf(it.getB().getX()));
	         pointA.setAttribute("y",String.valueOf(it.getB().getY()));
	         
	         ligne.appendChild(pointA);
	         ligne.appendChild(pointB);

	         
	         rootElement.appendChild(ligne);
	         
	         }
	         
	         
	         // write the content into xml file
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File(pFile));
	         transformer.transform(source, result);
	         
	         
	         // Output to console for testing
	         StreamResult consoleResult = new StreamResult(System.out);
	         transformer.transform(source, consoleResult);
			   
		} catch (Exception ex){
			 throw new XmlException(ex);
		}
		}
}

