package boundary;

import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FormRicevuta extends JFrame {
    private Image backgroundImage;

    public FormRicevuta(int IDPrenotazione, String titolo, long ISBN, String email, String data, double prezzo) {

        try {
            backgroundImage = new ImageIcon(getClass().getResource("/resources/backgroundRicevuta.jpg")).getImage();
            backgroundImage = backgroundImage.getScaledInstance(
                600, 500, // dimensioni fisse per la finestra
                Image.SCALE_SMOOTH
            );
        } catch (Exception e) {
            System.out.println("Errore caricamento immagine: " + e.getMessage());
        }

        setTitle("Ricevuta Prenotazione");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Pannello con background personalizzato
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        // Titolo grande e centrato
        JLabel titoloLabel = new JLabel(" Ricevuta Prenotazione ");
        titoloLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titoloLabel.setForeground(new Color(30, 30, 30));
        titoloLabel.setAlignmentX(CENTER_ALIGNMENT);
        titoloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titoloLabel);

        panel.add(Box.createVerticalStrut(30));

        // Font per le info
        Font infoFont = new Font("Segoe UI", Font.PLAIN, 20);
        Color infoColor = new Color(40, 40, 40);

        JLabel idLabel = new JLabel("Identificativo prenotazione: " + IDPrenotazione);
        idLabel.setFont(infoFont);
        idLabel.setForeground(infoColor);
        idLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(idLabel);

        panel.add(Box.createVerticalStrut(18));

        JLabel titoloLibroLabel = new JLabel("Titolo: " + titolo);
        titoloLibroLabel.setFont(infoFont);
        titoloLibroLabel.setForeground(infoColor);
        titoloLibroLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(titoloLibroLabel);

        panel.add(Box.createVerticalStrut(18));

        JLabel isbnLabel = new JLabel("Codice ISBN: " + ISBN);
        isbnLabel.setFont(infoFont);
        isbnLabel.setForeground(infoColor);
        isbnLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(isbnLabel);

        panel.add(Box.createVerticalStrut(18));

        JLabel emailLabel = new JLabel("Email utente: " + email);
        emailLabel.setFont(infoFont);
        emailLabel.setForeground(infoColor);
        emailLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(emailLabel);

        panel.add(Box.createVerticalStrut(18));

        JLabel dataLabel = new JLabel("Data: " + data);
        dataLabel.setFont(infoFont);
        dataLabel.setForeground(infoColor);
        dataLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(dataLabel);

        panel.add(Box.createVerticalStrut(18));

        JLabel prezzoLabel = new JLabel(String.format("Prezzo: € %.2f", prezzo));
        prezzoLabel.setFont(infoFont.deriveFont(Font.BOLD));
        prezzoLabel.setForeground(new Color(0, 102, 51));
        prezzoLabel.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(prezzoLabel);

        panel.add(Box.createVerticalStrut(35));

        JButton stampaBtn = new JButton("Stampa ricevuta");
        stampaBtn.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        stampaBtn.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(stampaBtn);

        add(panel);
    }
}
