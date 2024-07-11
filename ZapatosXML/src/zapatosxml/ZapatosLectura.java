/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zapatosxml;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author USER
 */
public class ZapatosLectura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException , TransformerException{
        File fXmlFile = new File("zapatos.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(fXmlFile);
        Element nodoRaiz = document.getDocumentElement();
        NodeList listaZapatos = nodoRaiz.getElementsByTagName("zapatos");
        int iID;
        Scanner sLector = new Scanner(System.in);
        do {
            System.out.println("Introduzca ID del zapato:");
            iID = sLector.nextInt()-1;
            if (iID >= listaZapatos.getLength()||iID<0) {
                System.out.println("ID erroneo");
            }
        }while(iID >= listaZapatos.getLength()||iID<0);
        Node nZapato=listaZapatos.item(iID);
        if(nZapato.getNodeType()==Node.ELEMENT_NODE){
            Element eleZapato=(Element)nZapato;
            System.out.println("La marca es: "+eleZapato.getElementsByTagName("marca").item(0).getTextContent());
        }
    }

}
