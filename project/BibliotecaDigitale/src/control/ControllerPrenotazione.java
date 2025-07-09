package control;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ControllerPrenotazione {

    public static boolean futureDateCheck(Date check){
        Date today = new Date();
        return check.after(today);
    }

    public static double calcolaPrezzo(Date previstaRestituzione){
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