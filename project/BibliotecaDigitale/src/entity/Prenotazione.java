package entity;

public class Prenotazione {
    private int IDprenotazione;
    private int costoComplessivoPrestito;
    private String data; //VERIFICARE SE CAMBIARE IN DATE TRAMITE JAVA.TIME

    public Prenotazione(int IDprenotazione, int costoComplessivoPrestito, String data) {
        this.IDprenotazione = IDprenotazione;
        this.costoComplessivoPrestito = costoComplessivoPrestito;
        this.data = data;
    }

    public int getIDprenotazione() {
        return IDprenotazione;
    }

    public void setIDprenotazione(int IDprenotazione) {
        this.IDprenotazione = IDprenotazione;
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
