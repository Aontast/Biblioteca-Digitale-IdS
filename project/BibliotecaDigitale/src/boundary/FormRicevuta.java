package boundary;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FormRicevuta extends JFrame{

    public FormRicevuta(String cliente, String data, String orario, String servizio, double prezzo) {
        setTitle("Ricevuta Prenotazione");
        setSize(300, 250);
        setLocationRelativeTo(null); // centrare
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // chiudi solo questa finestra

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Cliente: " + cliente));
        panel.add(new JLabel("Data: " + data));
        panel.add(new JLabel("Orario: " + orario));
        panel.add(new JLabel("Servizio: " + servizio));
        panel.add(new JLabel(String.format("Prezzo: € %.2f", prezzo)));

        JButton stampaBtn = new JButton("Stampa ricevuta");
        panel.add(Box.createVerticalStrut(15));
        panel.add(stampaBtn); // puoi collegare una funzione di stampa se vuoi

        add(panel);
    }
    
}
