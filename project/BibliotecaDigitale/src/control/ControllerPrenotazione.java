package control;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ControllerPrenotazione {

    private static ControllerPrenotazione instance = null;

    private ControllerPrenotazione(){
        super();
    }

    public static synchronized ControllerPrenotazione getInstance() {
        if (instance == null) {
            instance = new ControllerPrenotazione();
        }
        return instance;
    }

    public boolean futureDateCheck(Date check){
        Date today = new Date();
        return check.after(today);
    }

    public double calcolaPrezzo(Date previstaRestituzione){
        double prezzo = 0.25;
        Date oggi = new Date();

        long diffInMillisecondi = previstaRestituzione.getTime() - oggi.getTime();
        long giorni = TimeUnit.MILLISECONDS.toDays(diffInMillisecondi);

        double costoTotale = giorni * prezzo;
        return costoTotale;
    }

    public void prenotaLibroDisponibile(){

    }
}