package entity;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ElencoPrenotazioni {

    private static ElencoPrenotazioni instance = null;
    private List<Prenotazione> elencoPrenotazioni;

    public static synchronized ElencoPrenotazioni getInstance() {
        if (instance == null) {
            instance = new ElencoPrenotazioni();
        }
        return instance;
    }

    public int creaPrenotazioneUtente(Date dataConsegna, double costo, Libro libro, String emailUtente) throws ClassNotFoundException, SQLException {
        CopiaLibro copiaLibro = libro.getCopiaDisponibile();
        Prenotazione prenotazione = new Prenotazione(dataConsegna, costo, copiaLibro.getID(), emailUtente);
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
