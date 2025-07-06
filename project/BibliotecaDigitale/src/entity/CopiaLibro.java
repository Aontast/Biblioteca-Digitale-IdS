package entity;

public class CopiaLibro {

    private static int counter = 0;

    public enum StatoCopia {
        DISPONIBILE,
        INPRESTITO,
        PRENOTATO
    }

    private int ID;
    private StatoCopia stato;
    private Libro libro;

    public CopiaLibro(Libro libro){
        this.ID = counter++;
        this.stato = StatoCopia.DISPONIBILE;
        this.libro = libro;
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
        this.stato = StatoCopia.INPRESTITO;
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
        return this.stato.equals(StatoCopia.INPRESTITO);
    }
}
