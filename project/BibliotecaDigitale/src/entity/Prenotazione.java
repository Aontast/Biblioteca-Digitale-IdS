package entity;

public class Prenotazione {
    private int IDPrenotazione;
    private double costoPrestito;
    private String dataConsegna; //VERIFICARE SE CAMBIARE IN DATE TRAMITE JAVA.TIME
    private CopiaLibro copiaLibro;
    private UtenteRegistrato utenteRegistrato;

    public Prenotazione(String dataConsegna, double costoPrestito, CopiaLibro copiaLibro, UtenteRegistrato utenteRegistrato) {
        this.IDPrenotazione = -1; //per indicare che non è ancora stato assegnato dal DB
        this.costoPrestito = costoPrestito;
        this.dataConsegna = dataConsegna;
        this.copiaLibro = copiaLibro;
        this.utenteRegistrato = utenteRegistrato;
    }

    public Prenotazione(int IDPrenotazione, String dataConsegna, double costoPrestito, CopiaLibro copiaLibro, UtenteRegistrato utenteRegistrato) {
        this.IDPrenotazione = IDPrenotazione;
        this.costoPrestito = costoPrestito;
        this.dataConsegna = dataConsegna;
        this.copiaLibro = copiaLibro;
        this.utenteRegistrato = utenteRegistrato;
    }

    public CopiaLibro getCopiaLibro() {
        return copiaLibro;
    }

    public UtenteRegistrato getUtenteRegistrato() {
        return utenteRegistrato;
    }

    public int getIDPrenotazione() {
        return IDPrenotazione;
    }

    public void setIDPrenotazione(int IDPrenotazione) {
        this.IDPrenotazione = IDPrenotazione;
    }

    public double getCostoPrestito() {
        return costoPrestito;
    }

    public void setCostoPrestito(double costoPrestito) {
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
