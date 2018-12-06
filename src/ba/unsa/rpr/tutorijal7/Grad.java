package ba.unsa.rpr.tutorijal7;

import java.util.Arrays;

public class Grad {


    String naziv;
    int brojStanovnika;
    double[] temperature;
    int brojMjerenja;

    public Grad(String naziv, double[] temperature, int brojMjerenja) {
        this.naziv = naziv;
        this.temperature = temperature;
        this.brojStanovnika = 0;
        this.brojMjerenja = brojMjerenja;
    }

    // mora imati konstruktor bez parametara i da svi atributi moraju posjedovati settere i gettere po specifikaciji


    public void Grad() {
        naziv = "";
        brojStanovnika = 0;
        brojMjerenja = 0;
        temperature = null;

    }

    public int getBrojMjerenja() {
        return brojMjerenja;
    }

    public void setBrojMjerenja(int brojMjerenja) {
        this.brojMjerenja = brojMjerenja;
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

    public double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Grad{" +
                "naziv='" + naziv + '\'' +
                ", brojStanovnika=" + brojStanovnika +
                ", temperature=" + Arrays.toString(Arrays.copyOf(temperature, brojMjerenja)) +
                ", brojMjerenja=" + brojMjerenja +
                '}';
    }
}
