package boundary;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FormRicevuta extends JFrame{

    public FormRicevuta(String IDPrenotazione, String titolo, String ISBN, String email, String data, double prezzo) {
        setTitle("Ricevuta Prenotazione");
        setSize(300, 250);
        setLocationRelativeTo(null); // centrare
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // chiudi solo questa finestra

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Identificativo prenotazione: " + IDPrenotazione));
        panel.add(new JLabel("Titolo: " + titolo));
        panel.add(new JLabel("Codice ISBN: " + ISBN));
        panel.add(new JLabel("Email utente: " + email));
        panel.add(new JLabel("Data: " + data));
        panel.add(new JLabel(String.format("Prezzo: € %.2f", prezzo)));

        JButton stampaBtn = new JButton("Stampa ricevuta");
        panel.add(Box.createVerticalStrut(15));
        panel.add(stampaBtn); // puoi collegare una funzione di stampa se vuoi

        add(panel);
    }
    
}
