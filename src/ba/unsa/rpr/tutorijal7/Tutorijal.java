package ba.unsa.rpr.tutorijal7;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {


    public static Drzava ucitajXml (ArrayList<Grad> g) throws FileNotFoundException {
 





    }

    public static void zapisiXmlDrzave (Drzava d) {

        XMLEncoder izlaz= null;
        try {
            izlaz = new XMLEncoder(new FileOutputStream("drzave.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        izlaz.writeObject(d);
        izlaz.close();
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
       zapisiXmlDrzave(d);


     }
}
