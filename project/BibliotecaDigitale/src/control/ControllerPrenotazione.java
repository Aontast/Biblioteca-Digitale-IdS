package control;

import DTO.ClienteDTO;
import DTO.LibroDTO;
import entity.*;

import java.sql.SQLException;
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

    public int prenotaLibroDisponibile(LibroDTO libroDTO, ClienteDTO clienteDTO, double costo, Date dataConsegna) throws ClassNotFoundException, SQLException {

        Libro libro = new Libro(
                libroDTO.getCodiceISBN(),
                libroDTO.getTitolo(),
                libroDTO.getAutore(),
                libroDTO.getAnnoDiPubblicazione(),
                libroDTO.getGenere(),
                libroDTO.getDescrizione()
        );
        
        List<CopiaLibro> listaCopieDisp = libro.getCopieDisponibili();
        CopiaLibro copiaLibro = listaCopieDisp.get(0);

        UtenteRegistrato cliente = new Cliente(
                clienteDTO.getNome(),
                clienteDTO.getCognome(),
                clienteDTO.getEmail(),
                clienteDTO.getPassword()
        );

        ElencoPrenotazioni elencoPrenotazioni = ElencoPrenotazioni.getInstance();
        int idPrenotazione = elencoPrenotazioni.creaPrenotazioneUtente(dataConsegna, costo, copiaLibro, cliente);

        System.out.println("[prenotaLibroDisponibile] Prenotazione effettuata con successo per il libro: " + libro.getTitolo());
        return idPrenotazione;
    }
}