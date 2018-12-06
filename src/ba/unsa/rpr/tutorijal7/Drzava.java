package ba.unsa.rpr.tutorijal7;

import java.io.Serializable;

public class Drzava implements Serializable {

    String naziv;
    int brojStanovnika;
    double povrsina;
    String jedinicaZaPovrsinu;
    Grad glavniGrad;



    public Drzava() {
        naziv = "";
        brojStanovnika=0;
        povrsina=0;
        jedinicaZaPovrsinu="";
        glavniGrad=null;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina = povrsina;
    }

    public String getJedinicaZaPovrsinu() {
        return jedinicaZaPovrsinu;
    }

    public void setJedinicaZaPovrsinu(String jedinicaZaPovrsinu) {
        this.jedinicaZaPovrsinu = jedinicaZaPovrsinu;
    }

    public Grad getGlavniGrad() {
        return glavniGrad;
    }

    public void setGlavniGrad(Grad glavniGrad) {
        this.glavniGrad = glavniGrad;
    }
}
