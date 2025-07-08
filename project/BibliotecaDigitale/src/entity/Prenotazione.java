package entity;

public class Prenotazione {
    private int IDPrenotazione;
    private float costoPrestito;
    private String dataConsegna; //VERIFICARE SE CAMBIARE IN DATE TRAMITE JAVA.TIME
    private CopiaLibro copiaLibro;
    private UtenteRegistrato utenteRegistrato;

    public Prenotazione(float costoPrestito, String dataConsegna) {
        this.IDPrenotazione = -1; //per indicare che non è ancora stato assegnato dal DB
        this.costoPrestito = costoPrestito;
        this.dataConsegna = dataConsegna;
    }

    public int getIDprenotazione() {
        return IDPrenotazione;
    }

    public void setIDprenotazione(int IDprenotazione) {
        this.IDPrenotazione = IDprenotazione;
    }

    public float getCostoPrestito() {
        return costoPrestito;
    }

    public void setCostoPrestito(float costoPrestito) {
        this.costoPrestito = costoPrestito;
    }

    public String getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(String dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public void generaRicevuta(){
        //DA VEDERE
    }

    
}
