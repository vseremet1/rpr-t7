package ba.unsa.rpr.tutorijal7;

public class Grad {


    String naziv;
    int brojStanovnika;
    double [] temperature ;

    public Grad(String naziv, double[] temperature) {
        this.naziv=naziv;
        this.temperature=temperature;
        this.brojStanovnika=0;
    }

    // mora imati konstruktor bez parametara i da svi atributi moraju posjedovati settere i gettere po specifikaciji


    public void Grad ()
    {
        naziv = "";
        brojStanovnika=0;
        temperature=null;

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
}
