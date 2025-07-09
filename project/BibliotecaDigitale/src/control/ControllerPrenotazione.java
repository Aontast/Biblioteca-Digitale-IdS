package control;

import DTO.LibroDTO;
import database.LibroDAO;
import entity.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;
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

    public void prenotaLibroDisponibile(LibroDTO libroDTO, double costo, Date dataConsegna, String email) {

        Libro libro = new Libro(
                libroDTO.getCodiceISBN(),
                libroDTO.getTitolo(),
                libroDTO.getAutore(),
                libroDTO.getAnnoDiPubblicazione(),
                libroDTO.getGenere(),
                libroDTO.getDescrizione()
        );
        List<CopiaLibro> listaCopieDisp = libro.getCopieDisponibili();

        CopiaLibro copiaLibro = listaCopieDisp.getFirst();

        Prenotazione prenotazione = new Prenotazione(dataConsegna, costo, copiaLibro.getID(), email);
        prenotazione.salvaPrenotazione();
    }
}