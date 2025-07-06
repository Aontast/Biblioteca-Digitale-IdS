package entity;

import java.util.List;

public class main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", 1954, "Fantasy", 1234567890, "molto bello");

        libro1.aggiungiCopia();
        List<CopiaLibro> lista = libro1.getListaCopie();

        CopiaLibro copia = lista.get(0);
        System.out.println("copia.getStato() = " + copia.getStato());

        copia.setStatoInPrestito();
        System.out.println("copia.getStato() = " + copia.getStato());

        

    }
}
