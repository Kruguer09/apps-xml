/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zapatosxml;

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
 * @author Usuario
 */
public class ZapatosXML {

    /**
     * @param args the command line arguments
     */
    private static void guardarDocument(Document document) throws IOException, TransformerException {
        DOMSource domSource = new DOMSource(document);
        FileWriter fileWriter = new FileWriter(new File("zapatos.xml"));

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
        document = builder.newDocument();
        int iNumZapatos;
        //Raiz
        Element eZapateria = document.createElement("zapateria");
        document.appendChild(eZapateria);
        //Pedimos datos para cer cantos zapatos vamos a meter:
        Scanner lector = new Scanner(System.in);
        System.out.print("¿Cuántos zapatos desea ingresar?: ");
        iNumZapatos = lector.nextInt();
        lector.nextLine();
        
        String sTemporal;

        for (int i = 1; i <= iNumZapatos; i++) {
            //Elemento hijo
            Element eZapatos = document.createElement("zapatos");
            eZapateria.appendChild(eZapatos);
            eZapatos.setAttribute("ID", Integer.toString(i));
            //Grupo de elementos hijos del anterior, los cuales llevarán texto en el inerior 
            Element eMarca = document.createElement("marca");
            eZapatos.appendChild(eMarca);
            System.out.print("Introduzca la marca sin espacios en blanco: ");
            sTemporal = lector.nextLine();
            eMarca.appendChild(document.createTextNode(sTemporal));
            Element eModelo = document.createElement("modelo");
            eZapatos.appendChild(eModelo);
            System.out.print("Introduzca el modelo sin espacios en blanco: ");
            sTemporal = lector.nextLine();
            eModelo.appendChild(document.createTextNode(sTemporal));
            Element ePrecio = document.createElement("precio");
            eZapatos.appendChild(ePrecio);
            System.out.print("Introduzca el precio sin espacios en blanco: ");
            sTemporal = lector.nextLine();
            ePrecio.appendChild(document.createTextNode(sTemporal));

        }
        guardarDocument(document);
        
    }

}
