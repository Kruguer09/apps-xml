/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lecturaxml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Conti
 */
public class LecturaXML {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        File fXmlFile = new File("libros.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(fXmlFile);
        
        Element nodoRaiz = document.getDocumentElement();
        NodeList listaLibros = nodoRaiz.getChildNodes();
        
        //Se recorre la lista de hijos del nodo Raiz y se busca cuáles son digitales.
        for (int i = 0; i < listaLibros.getLength(); i++) {
            Node libroActual = listaLibros.item(i);
            if(libroActual.getNodeType()==Node.ELEMENT_NODE){
                Element elementLibroActual  = (Element) libroActual;
                boolean hayDigital = Boolean.parseBoolean(elementLibroActual.getAttribute("digital"));
                if(hayDigital){
                    System.out.println(elementLibroActual.getElementsByTagName("titulo").item(0).getTextContent());
                }
            }
            
        }
                
    }
    
}
