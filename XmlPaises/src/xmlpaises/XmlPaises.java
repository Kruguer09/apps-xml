/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlpaises;

import java.io.File;
import java.io.IOException;
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
 * @author Usuario
 */
public class XmlPaises {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        File fXmlFile = new File("paises.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(fXmlFile);

        Element nodoRaiz = document.getDocumentElement();
        NodeList listaPaises = nodoRaiz.getChildNodes();

        //Apartado 1
        for (int i = 0; i < listaPaises.getLength(); i++) {
            Node paisActual = listaPaises.item(i);
            if (paisActual.getNodeType() == Node.ELEMENT_NODE) {
                Element elementPaisActual = (Element) paisActual;
                String hayPais = (elementPaisActual.getAttribute("name"));
                if (hayPais.equals("france")) {
                    System.out.println("la capital del país cuyo nombre es france es: " + elementPaisActual.getAttribute("capital"));
                }

            }
            
        }
        NodeList listaComunidades = nodoRaiz.getElementsByTagName("comunidad");
            for (int j = 0; j < listaComunidades.getLength(); j++) {
                Node comunidadActual = listaComunidades.item(j);
                if (comunidadActual.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementComunidadActual = (Element) comunidadActual;
                    String provinciaUno = (elementComunidadActual.getAttribute("name"));
                    if (provinciaUno.equals("setubal")) {
                        System.out.println("la tercera provincia de Setubal es: " + elementComunidadActual.getElementsByTagName("provincia").item(2).getTextContent());
                    } else if (provinciaUno.equals("Leiria")) {
                        System.out.println("la segunda provincia de Liria es: " + elementComunidadActual.getElementsByTagName("provincia").item(1).getTextContent());
                    }

                }

            }
    }

    }
