package ba.unsa.rpr.tutorijal7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {



    public static UN ucitajXml(ArrayList<Grad> g) throws IOException, SAXException, ParserConfigurationException {


        UN un = new UN();
        ArrayList<Drzava> d = new ArrayList<>();


        Document xmldoc = null;

        DocumentBuilder docReader
                = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        xmldoc = docReader.parse(new File("C:\\Users\\Korisnik\\IdeaProjects\\rpr-t75554433434\\drzave.xml"));


        Element korijen = xmldoc.getDocumentElement();
        Drzava jednaDrzava = new Drzava();
        ArrayList<Grad> gradovi = new ArrayList<>();
        gradovi = ucitajGradove();

        NodeList drzave = korijen.getChildNodes();// sve države
        NodeList nodeList = xmldoc.getElementsByTagName("drzava");

        for (int i = 0; i < drzave.getLength(); i++) {  // djeca.getLength() je 2
            Node drzava = drzave.item(i);  // uzima jednu državu
            if (drzava instanceof Element) {
                jednaDrzava = upisiElement((Element) drzava, gradovi);
                d.add(jednaDrzava);
            }
        }

        un.setDrzave(d);
        return un;
    }

    public static Drzava upisiElement(Element drzava, ArrayList<Grad> gradovi) {


        Drzava d = new Drzava();

        NodeList elementiDrzave = drzava.getChildNodes();

        String nazivDrzave = elementiDrzave.item(0).getTextContent();
        d.setNaziv(nazivDrzave);


        Node glavniGrad = elementiDrzave.item(1).getFirstChild();
        String imeGlavnogGrada = glavniGrad.getTextContent();

        gradovi = ucitajGradove(); // učitava gradove iz mjerenja

        for (Grad grad : gradovi) {
            double[] temp;
            temp = grad.getTemperature();
            Grad gr = new Grad(grad.getNaziv(), temp, grad.getBrojMjerenja());

            if (imeGlavnogGrada.equals(grad.getNaziv()))
                d.setGlavniGrad(gr);
        }

        Node elementPovrsina = elementiDrzave.item(2);
        d.setJedinicaZaPovrsinu(elementPovrsina.getTextContent());

        Node elementpovrsina = elementiDrzave.item(2).getFirstChild();
        String povrsina = elementpovrsina.getTextContent();
        d.setPovrsina(Double.parseDouble(povrsina));


        return d;
    }


    public static void zapisiXml(UN un) {

        XMLEncoder izlaz = null;
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
                broj = 0;
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

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        ArrayList<Grad> gradovi;
        gradovi = ucitajGradove();
        for (Grad g : gradovi) {
            System.out.println(g);
        }

        UN un = new UN();
        zapisiXml(un);
        Drzava d = new Drzava();

       // un = ucitajXml(gradovi);


    }
}
