package ba.unsa.rpr.tutorijal7;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {

    public static void ispisiElement(Element element,ArrayList<Grad>g) {


        NodeList djeca = element.getChildNodes();

        for(int i = 0; i < djeca.getLength(); i++) {
            Node dijete = djeca.item(i);
            if (dijete instanceof Element) {
                upisiElement((Element) dijete,g);
                ispisiElement((Element)dijete,g);
            }
        }
    }

    public static void upisiElement(Element drzava,ArrayList<Grad> g) {

      Drzava d = new Drzava();
      d.setNaziv(drzava.getTagName());

      NodeList elementi = drzava.getChildNodes();
      String naziv = elementi.item(0).getTextContent();
      Node glavniGrad = elementi.item(1).getFirstChild();
      String x = glavniGrad.getTextContent();

        g =  ucitajGradove();



         for (Grad g1 : g) {
             if (x.equals(g1.getNaziv())) {
                 double[] temp = new double[1000];
                 temp = g1.getTemperature();
                 Grad gr = new Grad(x, temp, g1.getBrojMjerenja());
                 d.setGlavniGrad(gr);
             }

         }


         Node n = elementi.item(2);
         NodeList povrsina1 = n.getChildNodes();





         String p = elementi.item(3).getTextContent();


    }

    public static UN ucitajXml (ArrayList<Grad> g) throws FileNotFoundException {

        UN un = new UN();






        Document xmldoc = null;
        try {
            DocumentBuilder docReader
                    = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = (Document) docReader.parse(new File("drzave.xml"));
        } catch (Exception e) {
            System.out.println("drzave.xml nije validan XML dokument");
        }

        Element korijen = (Element) xmldoc.getDefaultRootElement();
        ispisiElement(korijen,g);









 return un;

    }




    public static void zapisiXml (UN un) {

         XMLEncoder izlaz= null;
         try {
              izlaz = new XMLEncoder(new FileOutputStream("un.xml"));
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
         izlaz.writeObject(un);
         izlaz.close();
     }





    public static ArrayList<Grad> ucitajGradove() {
        String s;
        ArrayList<Grad> gradovi = new ArrayList<>();
        double[] temp = new double[1000];
        int i, broj;
        broj = 0;

        Scanner ulaz;

        try {
            ulaz = new Scanner(new FileReader("mjerenja.txt"));
            while (ulaz.hasNext()) {
                broj=0;
                s = ulaz.nextLine();
                String[] niz = s.split(",");
                i = 1;
                while (i < niz.length) {
                    temp[i - 1] = Double.parseDouble(niz[i]);
                    i++;
                    broj++;
                }

                Grad g = new Grad(niz[0], temp, broj);
                gradovi.add(g);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gradovi;

    }

    public static void main(String[] args) {

        ArrayList<Grad> gradovi;
        gradovi = ucitajGradove();
        for (Grad g : gradovi) {
            System.out.println(g);
        }

        UN un = new UN();
       zapisiXml(un);
       Drzava d = new Drzava();



     }
}
