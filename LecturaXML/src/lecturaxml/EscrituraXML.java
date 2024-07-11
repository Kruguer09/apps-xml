/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lecturaxml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
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

/**
 *
 * @author Conti
 */
public class EscrituraXML {
    /**
     * 
     * @param document Objeto documento. Representación en memoria de XML.
     * @throws IOException
     * @throws TransformerException 
     */
    private static void guardarDocument (Document document)throws IOException, TransformerException{
        DOMSource domSource = new DOMSource (document);
        FileWriter fileWriter = new FileWriter (new File ("output.xml"));
        
        //Donde se guardará el fichero 
        StreamResult streamResult = new StreamResult(fileWriter);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(domSource, streamResult);
        fileWriter.close();    
    }
    
    public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException {
        Document document;
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        document=builder.newDocument();
        
        
        //Elemento raiz
        Element elemento = document.createElement("productos");
        document.appendChild(elemento);
        
        //Elemento hijo del anterior. Producto está dentro de productos
        Element producto = document.createElement("producto");
        elemento.appendChild(producto);
        producto.setAttribute("codigo","1");
        
        //Se aniade un elemento nombre con texto en el interior, se hace hijo del anterior...
        Element nombre = document.createElement("nombre");
        nombre.appendChild(document.createTextNode("Teclado"));
        producto.appendChild(nombre);
        
        //Aniado un nuevo atributo a producto
        producto.setAttribute("vendido", "no");
        
       guardarDocument(document);
    
    }
}
