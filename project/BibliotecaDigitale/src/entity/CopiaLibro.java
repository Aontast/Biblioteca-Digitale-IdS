package entity;

import java.sql.SQLException;

import database.CopiaLibroDAO;

public class CopiaLibro {

    public enum StatoCopia {
        DISPONIBILE,
        IN_PRESTITO,
        PRENOTATO
    }

    private int ID;
    private StatoCopia stato;
    private Libro libro;

    //Costruttore per recuperare le copie dal database
    public CopiaLibro(int id, String stato, Libro libro) {
        this.ID = id;
        this.stato = StatoCopia.valueOf(stato);
        this.libro = libro;
    }

    public CopiaLibro(Libro libro){
        this.ID = -1; //per indicare che non è ancora stato assegnato dal DB
        this.stato = StatoCopia.DISPONIBILE;
        this.libro = libro;
    }

    public void aggiornaStatoPrenotato() throws ClassNotFoundException, SQLException {
    // 1. Cambia lo stato dell'oggetto in memoria
    this.setStatoPrenotato(); // Metodo che fa this.stato = StatoCopia.PRENOTATO

    // 2. Persisti la modifica chiamando il DAO
    CopiaLibroDAO dao = new CopiaLibroDAO();
    dao.updateStato(this);
}

    @Override
    public String toString(){
        return "CopiaLibro ID: " + this.ID + "\nStato: " + this.stato.toString() + "\nLibro: " + this.libro.getTitolo();
    }

    public int getID() {
        return this.ID;
    }

    public StatoCopia getStato(){
        return this.stato;
    }

    public Libro getLibro(){
        return this.libro;
    }

    public void setStatoPrenotato(){
        this.stato = StatoCopia.PRENOTATO;
    }

    public void setStatoInPrestito(){
        this.stato = StatoCopia.IN_PRESTITO;
    }

    public void setStatoDisponibile(){
        this.stato = StatoCopia.DISPONIBILE;
    }

    public boolean isDisponibile(){
        return this.stato.equals(StatoCopia.DISPONIBILE);
    }

    public boolean isPrenotato(){
        return this.stato.equals(StatoCopia.PRENOTATO);
    }

    public boolean isInPrestito(){
        return this.stato.equals(StatoCopia.IN_PRESTITO);
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
