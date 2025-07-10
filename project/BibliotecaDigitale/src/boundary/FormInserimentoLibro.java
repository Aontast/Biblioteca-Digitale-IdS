package boundary;

import control.ControllerCatalogo;
import java.awt.*;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class FormInserimentoLibro extends JFrame {

    private JPanel contentPane;
    private JTextField txtTitolo;
    private JTextField txtAutore;
    private JFormattedTextField txtAnno;
    private JTextField txtGenere;
    private JTextField txtISBN;
    private JTextArea txtDescrizione;

    private Runnable onCancel;

    private Image backgroundImage;

    public FormInserimentoLibro(Runnable onCancel) {
        this();
        this.onCancel = onCancel;
    }

    public FormInserimentoLibro() {
        // --- CARICAMENTO IMMAGINE DI SFONDO ---
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/resources/BackGroundGestioneCatalogo.jpg")).getImage();
            backgroundImage = backgroundImage.getScaledInstance(
                Toolkit.getDefaultToolkit().getScreenSize().width, 
                Toolkit.getDefaultToolkit().getScreenSize().height, 
                Image.SCALE_SMOOTH
            );
        } catch (Exception e) {
            System.out.println("Errore caricamento immagine: " + e.getMessage());
        }
        // --- CARICAMENTO ICONA ---
        try {
            Image icon = new ImageIcon(getClass().getResource("/resources/iconaApp.jpg")).getImage();
            setIconImage(icon);
        } catch (Exception e) {
            System.out.println("Errore caricamento icona: " + e.getMessage());
        }
        setTitle("Inserimento Nuovo Libro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 650);

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitoloPagina = new JLabel("Inserimento nuovo libro", SwingConstants.CENTER);
        lblTitoloPagina.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitoloPagina.setForeground(Color.WHITE);
        lblTitoloPagina.setBounds(0, 10, 700, 40);
        contentPane.add(lblTitoloPagina);

        int yStart = 70; // Spazio extra sotto il titolo
        int yStep = 50;

        JLabel lblTitolo = new JLabel("Titolo:");
        lblTitolo.setFont(new Font("Arial", Font.BOLD, 14));
        lblTitolo.setForeground(Color.WHITE);
        lblTitolo.setBounds(100, yStart, 100, 30);
        contentPane.add(lblTitolo);

        txtTitolo = new JTextField();
        txtTitolo.setBounds(220, yStart, 350, 30);
        contentPane.add(txtTitolo);
        setupRealTimeValidation(txtTitolo, "titolo");

        JLabel infoTitolo = new JLabel("🛈");
        infoTitolo.setForeground(Color.WHITE);
        infoTitolo.setToolTipText("<html>Il titolo deve:<br>• Contenere da 1 a 50 caratteri<br>• Non contenere caratteri speciali</html>");
        infoTitolo.setBounds(580, yStart, 30, 30);
        contentPane.add(infoTitolo);

        JLabel lblAutore = new JLabel("Autore:");
        lblAutore.setFont(new Font("Arial", Font.BOLD, 14));
        lblAutore.setForeground(Color.WHITE);
        lblAutore.setBounds(100, yStart + yStep, 100, 30);
        contentPane.add(lblAutore);

        txtAutore = new JTextField();
        txtAutore.setBounds(220, yStart + yStep, 350, 30);
        contentPane.add(txtAutore);
        setupRealTimeValidation(txtAutore, "autore");

        JLabel infoAutore = new JLabel("🛈");
        infoAutore.setForeground(Color.WHITE);
        infoAutore.setToolTipText("<html>L'autore deve:<br>• Contenere da 1 a 50 caratteri<br>• Solo lettere e apostrofi</html>");
        infoAutore.setBounds(580, yStart + yStep, 30, 30);
        contentPane.add(infoAutore);

        JLabel lblAnno = new JLabel("<html>Anno di<br>Pubblicazione:</html>");
        lblAnno.setFont(new Font("Arial", Font.BOLD, 14));
        lblAnno.setForeground(Color.WHITE);
        lblAnno.setBounds(100, yStart + 2 * yStep - 10, 150, 40); // Spostato più in alto
        contentPane.add(lblAnno);

        // Campo anno come data (solo anno)
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        txtAnno = new JFormattedTextField(yearFormat);
        txtAnno.setValue(null); // Nessun valore di default
        txtAnno.setBounds(220, yStart + 2 * yStep, 100, 30); // Allineato con gli altri campi
        contentPane.add(txtAnno);
        setupRealTimeValidation(txtAnno, "anno");

        JLabel infoAnno = new JLabel("🛈");
        infoAnno.setForeground(Color.WHITE);
        infoAnno.setToolTipText("<html>L'anno deve:<br>• Essere numerico <br>• Essere maggiore o uguale a 0</html>");
        infoAnno.setBounds(340, yStart + 2 * yStep, 30, 30);
        contentPane.add(infoAnno);

        JLabel lblGenere = new JLabel("Genere:");
        lblGenere.setFont(new Font("Arial", Font.BOLD, 14));
        lblGenere.setForeground(Color.WHITE);
        lblGenere.setBounds(100, yStart + 3 * yStep, 100, 30);
        contentPane.add(lblGenere);

        txtGenere = new JTextField();
        txtGenere.setBounds(220, yStart + 3 * yStep, 200, 30);
        contentPane.add(txtGenere);
        setupRealTimeValidation(txtGenere, "genere");

        JLabel infoGenere = new JLabel("🛈");
        infoGenere.setForeground(Color.WHITE);
        infoGenere.setToolTipText("<html>Il genere deve:<br>• Contenere al massimo 50 caratteri<br>• Nessun carattere speciale</html>");
        infoGenere.setBounds(440, yStart + 3 * yStep, 30, 30);
        contentPane.add(infoGenere);

        JLabel lblISBN = new JLabel("ISBN:");
        lblISBN.setFont(new Font("Arial", Font.BOLD, 14));
        lblISBN.setForeground(Color.WHITE);
        lblISBN.setBounds(100, yStart + 4 * yStep, 100, 30);
        contentPane.add(lblISBN);

        txtISBN = new JTextField();
        txtISBN.setBounds(220, yStart + 4 * yStep, 200, 30);
        contentPane.add(txtISBN);
        setupRealTimeValidation(txtISBN, "isbn");

        JLabel infoISBN = new JLabel("🛈");
        infoISBN.setForeground(Color.WHITE);
        infoISBN.setToolTipText("<html>L'ISBN deve:<br>• Contenere solo cifre<br>• Essere lungo esattamente 13 caratteri</html>");
        infoISBN.setBounds(440, yStart + 4 * yStep, 30, 30);
        contentPane.add(infoISBN);

        JLabel lblDescrizione = new JLabel("Descrizione:");
        lblDescrizione.setFont(new Font("Arial", Font.BOLD, 14));
        lblDescrizione.setForeground(Color.WHITE);
        lblDescrizione.setBounds(100, yStart + 5 * yStep, 100, 30);
        contentPane.add(lblDescrizione);

        txtDescrizione = new JTextArea();
        txtDescrizione.setLineWrap(true);
        txtDescrizione.setWrapStyleWord(true);
        txtDescrizione.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(txtDescrizione);
        scrollPane.setBounds(220, yStart + 5 * yStep, 350, 150); // Casella più grande
        contentPane.add(scrollPane);
        setupRealTimeValidationArea(txtDescrizione);

        JLabel infoDescrizione = new JLabel("🛈");
        infoDescrizione.setForeground(Color.WHITE);
        infoDescrizione.setToolTipText("<html>La descrizione deve:<br>• Contenere al massimo 500 caratteri</html>");
        infoDescrizione.setBounds(580, yStart + 5 * yStep, 30, 30);
        contentPane.add(infoDescrizione);

        JButton btnConferma = new JButton("Conferma");
        btnConferma.setFont(new Font("Arial", Font.BOLD, 16));
        btnConferma.setBounds(220, yStart + 5 * yStep + 180, 150, 40);
        contentPane.add(btnConferma);

        JButton btnAnnulla = new JButton("Annulla");
        btnAnnulla.setFont(new Font("Arial", Font.PLAIN, 14));
        btnAnnulla.setBounds(400, yStart + 5 * yStep + 180, 150, 40);
        contentPane.add(btnAnnulla);

        btnAnnulla.addActionListener(e -> {
            dispose();
            if (onCancel != null) onCancel.run();
        });
        btnConferma.addActionListener(e -> {
            String titolo = txtTitolo.getText().trim();
            String autore = txtAutore.getText().trim();
            String anno = txtAnno.getText().trim();
            String genere = txtGenere.getText().trim();
            String isbn = txtISBN.getText().trim();
            String descrizione = txtDescrizione.getText().trim();

            // TITOLO
            if (titolo.length() < 1) {
                JOptionPane.showMessageDialog(this, "Il titolo non può essere vuoto.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (titolo.length() > 50) {
                JOptionPane.showMessageDialog(this, "Il titolo non può superare i 50 caratteri.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!titolo.matches("[a-zA-Z0-9àèéìòù' ]+")) {
                JOptionPane.showMessageDialog(this, "Il titolo contiene caratteri speciali non ammessi.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // AUTORE
            if (autore.length() < 1) {
                JOptionPane.showMessageDialog(this, "Il campo autore non può essere vuoto.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (autore.length() > 50) {
                JOptionPane.showMessageDialog(this, "Il campo autore non può superare i 50 caratteri.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!autore.matches("[a-zA-Zàèéìòù' ]+")) {
                JOptionPane.showMessageDialog(this, "Il campo autore può contenere solo lettere e apostrofi.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // ANNO DI PUBBLICAZIONE
            if (!anno.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "L'anno di pubblicazione deve essere un numero intero positivo.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int annoInt = Integer.parseInt(anno);
            if (annoInt < 0) {
                JOptionPane.showMessageDialog(this, "L'anno di pubblicazione non può essere negativo.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // GENERE
            if (genere.length() > 50) {
                JOptionPane.showMessageDialog(this, "Il genere non può superare i 50 caratteri.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!genere.matches("[a-zA-Z0-9àèéìòù' ]*")) {
                JOptionPane.showMessageDialog(this, "Il genere contiene caratteri speciali non ammessi.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // ISBN
            if (!isbn.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Il codice ISBN deve contenere solo cifre.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (isbn.length() != 13) {
                JOptionPane.showMessageDialog(this, "Il codice ISBN deve essere di 13 cifre.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // DESCRIZIONE
            if (descrizione.length() > 500) {
                JOptionPane.showMessageDialog(this, "La descrizione non può superare i 500 caratteri.", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tutti i dati sono validi
            ControllerCatalogo controllerC = ControllerCatalogo.getInstance();

            try {
                controllerC.aggiungiLibro(Long.parseLong(isbn), titolo, autore, annoInt, genere, descrizione);
                JOptionPane.showMessageDialog(this, "Libro inserito con successo!", "Successo", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new FormGestioneCatalogo().setVisible(true);
            } catch (SQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(this, "Errore durante l'inserimento del libro: " + ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
            }catch (SQLException ex){  //errore generico
                JOptionPane.showMessageDialog(null,
                        "Si è verificato un errore durante la registrazione: " + ex.getMessage(),
                        "Errore",
                        JOptionPane.ERROR_MESSAGE
                    );
            }
            
        });
    }

    // --- VALIDAZIONE IN TEMPO REALE ---
    private void setupRealTimeValidation(JTextField textField, String tipo) {
        textField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { validateField(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { validateField(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { validateField(); }
            private void validateField() {
                String content = textField.getText();
                boolean isValid = false;
                // Mostra rosso anche se vuoto
                switch (tipo) {
                    case "titolo":
                        isValid = isTitoloValido(content);
                        break;
                    case "autore":
                        isValid = isAutoreValido(content);
                        break;
                    case "anno":
                        isValid = isAnnoValido(content);
                        break;
                    case "genere":
                        isValid = isGenereValido(content);
                        break;
                    case "isbn":
                        isValid = isISBNValido(content);
                        break;
                }
                // Se il campo è vuoto, comunque rosso
                if (content.isEmpty() || !isValid) {
                    textField.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    textField.setBorder(new LineBorder(Color.GREEN, 2));
                }
            }
        });
    }
    private void setupRealTimeValidationArea(JTextArea textArea) {
        textArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) { validateField(); }
            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) { validateField(); }
            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) { validateField(); }
            private void validateField() {
                String content = textArea.getText();
                boolean isValid = isDescrizioneValida(content);
                if (content.isEmpty() || !isValid) {
                    textArea.setBorder(new LineBorder(Color.RED, 2));
                } else {
                    textArea.setBorder(new LineBorder(Color.GREEN, 2));
                }
            }
        });
    }
    // --- FUNZIONI DI VALIDAZIONE PER OGNI CAMPO ---
    private boolean isTitoloValido(String titolo) {
        return titolo.length() >= 1 && titolo.length() <= 50 && titolo.matches("[a-zA-Z0-9àèéìòù' ]+");
    }
    private boolean isAutoreValido(String autore) {
        return autore.length() >= 1 && autore.length() <= 50 && autore.matches("[a-zA-Zàèéìòù' ]+");
    }
    private boolean isAnnoValido(String anno) {
        return anno.matches("\\d+") && Integer.parseInt(anno) >= 0;
    }
    private boolean isGenereValido(String genere) {
        return genere.length() <= 50 && genere.matches("[a-zA-Z0-9àèéìòù' ]*");
    }
    private boolean isISBNValido(String isbn) {
        return isbn.matches("\\d+") && isbn.length() == 13;
    }
    private boolean isDescrizioneValida(String descrizione) {
        return descrizione.length() <= 500;
    }
}
