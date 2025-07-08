package entity;

public class Prenotazione {
    private int IDPrenotazione;
    private int costoComplessivoPrestito;
    private String data; //VERIFICARE SE CAMBIARE IN DATE TRAMITE JAVA.TIME

    public Prenotazione(int IDprenotazione, int costoComplessivoPrestito, String data) {
        this.IDPrenotazione = IDprenotazione;
        this.costoComplessivoPrestito = costoComplessivoPrestito;
        this.data = data;
    }

    public int getIDprenotazione() {
        return IDPrenotazione;
    }

    public void setIDprenotazione(int IDprenotazione) {
        this.IDPrenotazione = IDprenotazione;
    }

    public int getCostoComplessivoPrestito() {
        return costoComplessivoPrestito;
    }

    public void setCostoComplessivoPrestito(int costoComplessivoPrestito) {
        this.costoComplessivoPrestito = costoComplessivoPrestito;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void generaRicevuta(){
        //DA VEDERE
    }

    
}
