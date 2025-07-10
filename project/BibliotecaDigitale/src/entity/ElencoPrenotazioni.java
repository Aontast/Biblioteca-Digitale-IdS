package entity;

import java.sql.SQLException;
import java.util.Date;

public class ElencoPrenotazioni {

    private static ElencoPrenotazioni instance = null;

    public static synchronized ElencoPrenotazioni getInstance() {
        if (instance == null) {
            instance = new ElencoPrenotazioni();
        }
        return instance;
    }

    public int creaPrenotazioneUtente(Date dataConsegna, double costo, CopiaLibro copiaLibro, UtenteRegistrato utenteRegistrato) throws ClassNotFoundException, SQLException {
        Prenotazione prenotazione = new Prenotazione(dataConsegna, costo, copiaLibro, utenteRegistrato);
        prenotazione.salvaPrenotazione();
        copiaLibro.aggiornaStatoPrenotato();
        return prenotazione.getIDPrenotazione();
    }

    public void elencaPrenotazioniUtente(){

    }

    public void visualizzaCronologiaLibriConsultati(){

    }

    public void visualizzaPrenotazioniComplessive(){

    }

    public void generaReportPrestiti(){

    }

    public void generaReportMensile(){

    }

}
