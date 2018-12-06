package ba.unsa.rpr.tutorijal7;

import java.io.Serializable;
import java.util.ArrayList;

public class UN implements Serializable {

    ArrayList<ba.unsa.rpr.tutorijal7.Drzava> drzave = new ArrayList<>();


    // mora imati konstruktor bez parametara i da svi atributi moraju posjedovati settere i gettere po specifikaciji

    public UN ()
    {
        drzave=null;
    }

    public ArrayList<Drzava> getDrzave() {
        return drzave;
    }

    public void setDrzave(ArrayList<Drzava> drzave) {
        this.drzave = drzave;
    }
}
