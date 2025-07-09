package entity;

import java.util.ArrayList;
import java.util.List;

public class ElencoPrenotazioni {

    private int numeroPrenotazioniTotali;
    private List<Prenotazione> listaPrenotazioni;


    //solita costruzione singleton.
    private static ElencoPrenotazioni instance = null;

    private ElencoPrenotazioni() {
        this.numeroPrenotazioniTotali = 0;
        this.listaPrenotazioni = new ArrayList<>();
    }

    public static synchronized ElencoPrenotazioni getInstance() {
        if (instance == null) {
            instance = new ElencoPrenotazioni();
        }
        return instance;
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

    public void verificaDuplicePrenotazione() {
        
    }

}
