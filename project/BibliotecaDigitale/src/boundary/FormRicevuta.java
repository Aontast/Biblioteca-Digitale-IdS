package boundary;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FormRicevuta extends JFrame{
    private Image backgroundImage;

    public FormRicevuta(int IDPrenotazione, String titolo, long ISBN, String email, String data, double prezzo) {

        try {
            backgroundImage = new ImageIcon(getClass().getResource("/resources/backgroundRicevuta.jpg")).getImage();
			// Ridimensiona l'immagine per adattarla alla finestra
			backgroundImage = backgroundImage.getScaledInstance(
				Toolkit.getDefaultToolkit().getScreenSize().width, 
				Toolkit.getDefaultToolkit().getScreenSize().height, 
				Image.SCALE_SMOOTH
			);
        } catch (Exception e) {
            System.out.println("Errore caricamento immagine: " + e.getMessage());
        }

        setTitle("Ricevuta Prenotazione");
        setSize(600, 500);
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
