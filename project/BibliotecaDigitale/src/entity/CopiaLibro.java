package entity;

public class CopiaLibro {
    private static int counter = 0;

    private int ID;
    private String stato;
    private Libro libro;

    public CopiaLibro(Libro libro){
        this.ID = counter++;
        this.stato = "Disponibile";
        this.libro = libro;

        this.libro.incrementaDisponibilitaCopie();
    }

    @Override
    public String toString(){
        return "CopiaLibro ID: " + this.ID + "\nStato: " + this.stato + "\nLibro: " + this.libro.getTitolo();
    }

    public int getID() {
        return this.ID;
    }

    public String getStato(){
        return this.stato;
    }

    public Libro getLibro(){
        return this.libro;
    }

    public void setStatoPrenotato(){
        this.stato = "Prenotato";
        this.libro.decrementaDisponibilitaCopie();
    }

    public void setStatoInPrestito(){
        this.stato = "In prestito";
    }

    public void setStatoDisponibile(){
        this.stato = "Disponibile";
    }

    /* 
    public boolean checkStato() {
        String statoUpper = this.stato.toUpperCase();
    
        if (statoUpper.equals("PRENOTATO") || 
            statoUpper.equals("IN PRESTITO") || 
            statoUpper.equals("DISPONIBILE")) {
            return true;
        }
    
        return false;
    } */

    public boolean isDisponibile(){
        return this.stato.equals("Disponibile");
    }

    public boolean isPrenotato(){
        return this.stato.equals("Prenotato");
    }

    public boolean isInPrestito(){
        return this.stato.equals("In prestito");
    }
}
