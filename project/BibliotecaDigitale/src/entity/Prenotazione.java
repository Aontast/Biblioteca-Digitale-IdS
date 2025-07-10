package entity;

import java.sql.SQLException;
import java.util.Date;

import database.PrenotazioneDAO;

public class Prenotazione {
    private int IDPrenotazione;
    private double costoPrestito;
    private Date dataConsegna;
    private CopiaLibro copiaLibro;
    private UtenteRegistrato utenteRegistrato;

    
    public Prenotazione(Date dataConsegna, double costoPrestito, CopiaLibro copiaLibro, UtenteRegistrato utenteRegistrato) {
        this.IDPrenotazione = -1; //per indicare che non è ancora stato assegnato dal DB
        this.costoPrestito = costoPrestito;
        this.dataConsegna = dataConsegna;
        this.copiaLibro = copiaLibro;
        this.utenteRegistrato = utenteRegistrato;
    }

    
    public Prenotazione(int IDPrenotazione, Date dataConsegna, double costoPrestito, CopiaLibro copiaLibro, UtenteRegistrato utenteRegistrato) {
        this.IDPrenotazione = IDPrenotazione;
        this.costoPrestito = costoPrestito;
        this.dataConsegna = dataConsegna;
        this.copiaLibro = copiaLibro;
        this.utenteRegistrato = utenteRegistrato;
    }

    public void salvaPrenotazione() throws SQLException {
        PrenotazioneDAO prenotazioneDAO = new PrenotazioneDAO();
        
        int idPrenotazione = prenotazioneDAO.salvaPrenotazione(this);
        if (idPrenotazione != -1) {
            this.IDPrenotazione = idPrenotazione;
            System.out.println("[salvaPrenotazione] Prenotazione salvata con successo nel database");
        } else {
            System.err.println("[salvaPrenotazione] Prenotazione non salvata nel database");
            throw new SQLException();
        }
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

    public Date getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(Date dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public void generaRicevuta(){
        //DA VEDERE
    }

    
}
