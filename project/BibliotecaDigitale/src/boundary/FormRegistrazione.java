package boundary;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import control.ControllerRegistrazione;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class FormRegistrazione extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final JPanel panelHome = new JPanel();
    private final JPanel panelRegister = new JPanel();
    private JPasswordField passwordField;
    private JTextField txtNome;
    private JTextField txtCognome;
    private JTextField txtEmail;
    private Image backgroundImage;
    private JButton btnRegistrati; // Riferimento al pulsante

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormRegistrazione frame = new FormRegistrazione();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FormRegistrazione() {
        // Carica l'immagine di background
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/resources/background.jpg")).getImage();
        } catch (Exception e) {
            System.out.println("Errore caricamento immagine: " + e.getMessage());
        }

        try {
            Image icon = new ImageIcon(getClass().getResource("/resources/iconaApp.jpg")).getImage();
            setIconImage(icon);
        } catch (Exception e) {
            System.out.println("Errore caricamento icona: " + e.getMessage());
        }
        
        panelHome.setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 700);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // PANNELLO HOME - centrato
        panelHome.setBounds(10, 10, 664, 641);
        contentPane.add(panelHome);
        panelHome.setLayout(null);
        panelHome.setOpaque(false);
        panelRegister.setOpaque(false);

        // HOME PAGE - centrata
        JLabel HomePage = new JLabel("Home Page");
        HomePage.setBounds(232, 100, 200, 60);
        HomePage.setFont(new Font("Arial", Font.BOLD, 24));
        HomePage.setHorizontalAlignment(JLabel.CENTER);
        panelHome.add(HomePage);

        // PULSANTE ACCEDI - centrato
        JButton Accedi = new JButton("Accedi");
        Accedi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        Accedi.setBounds(257, 180, 150, 40);
        Accedi.setFont(new Font("Arial", Font.PLAIN, 16));
        panelHome.add(Accedi);

        // PULSANTE REGISTRATI - centrato
        JButton Registrati = new JButton("Registrati");
        Registrati.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelHome.setVisible(false);
                panelRegister.setVisible(true);
            }
        });
        Registrati.setBounds(257, 240, 150, 40);
        Registrati.setFont(new Font("Arial", Font.PLAIN, 16));
        panelHome.add(Registrati);

        // ICONA CASA - centrata
        JLabel lblNewLabel_2 = new JLabel("🏠");
        lblNewLabel_2.setBounds(307, 60, 50, 31);
        lblNewLabel_2.setHorizontalAlignment(JLabel.CENTER);
        panelHome.add(lblNewLabel_2);

        // PANNELLO REGISTRAZIONE - centrato
        panelRegister.setBounds(10, 10, 664, 641);
        contentPane.add(panelRegister);
        panelRegister.setVisible(false);
        panelRegister.setLayout(null);
        panelHome.setOpaque(false);
        panelRegister.setOpaque(false);

        // TITOLO REGISTRAZIONE - centrato
        JLabel lblNewLabel = new JLabel("<html>Inserisci i dati nei <br> campi di testo indicati:</html>");
        lblNewLabel.setBounds(132, 50, 400, 30);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
        lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
        panelRegister.add(lblNewLabel);

        // CAMPO NOME - centrato
        txtNome = new JTextField();
        txtNome.setBounds(232, 100, 200, 30);
        txtNome.setFont(new Font("Arial", Font.PLAIN, 14));
        txtNome.setHorizontalAlignment(JTextField.CENTER);
        panelRegister.add(txtNome);
        txtNome.setColumns(10);
        setupPlaceholder(txtNome, "Nome");
        setupRealTimeValidation(txtNome, "nome");

        // CAMPO COGNOME - centrato
        txtCognome = new JTextField();
        txtCognome.setBounds(232, 160, 200, 30);
        txtCognome.setFont(new Font("Arial", Font.PLAIN, 14));
        txtCognome.setHorizontalAlignment(JTextField.CENTER);
        panelRegister.add(txtCognome);
        txtCognome.setColumns(10);
        setupPlaceholder(txtCognome, "Cognome");
        setupRealTimeValidation(txtCognome, "cognome");

        // CAMPO EMAIL - centrato
        txtEmail = new JTextField();
        txtEmail.setBounds(232, 220, 200, 30);
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 14));
        txtEmail.setHorizontalAlignment(JTextField.CENTER);
        panelRegister.add(txtEmail);
        txtEmail.setColumns(10);
        setupPlaceholder(txtEmail, "Email");
        setupRealTimeValidation(txtEmail, "email");

        // CAMPO PASSWORD - centrato
        passwordField = new JPasswordField();
        passwordField.setBounds(232, 280, 200, 30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        panelRegister.add(passwordField);
        setupPasswordPlaceholder(passwordField, "Password");
        setupRealTimeValidationPassword(passwordField);

        // TOOLTIP NOME - posizionato a destra del campo
        JLabel lblNewLabel_1_1 = new JLabel("🛈");
        lblNewLabel_1_1.setToolTipText("<html>Il nome deve:<br>• Contenere al più 50 caratteri<br>• Avere la prima lettera maiuscola<br>• Contenere solo caratteri<br>• Contenere almeno un carattere</html>");
        lblNewLabel_1_1.setBounds(440, 100, 30, 30);
        panelRegister.add(lblNewLabel_1_1);

        // TOOLTIP COGNOME - posizionato a destra del campo
        JLabel lblNewLabel_1 = new JLabel("🛈");
        lblNewLabel_1.setToolTipText("<html>Il cognome deve:<br>• Contenere al più 50 caratteri<br>• Contenere solo caratteri e apostrofi<br>• Contenere almeno un carattere</html>");
        lblNewLabel_1.setBounds(440, 160, 30, 30);
        panelRegister.add(lblNewLabel_1);

        // TOOLTIP EMAIL - posizionato a destra del campo
        JLabel lblNewLabel_1_2 = new JLabel("🛈");
        lblNewLabel_1_2.setToolTipText("<html>L'email deve:<br>• Contenere al più 255 caratteri alfanumerici<br>• Contenere obbligatoriamente il simbolo \"@\"<br>• Non essere associata ad un profilo già esistente</html>");
        lblNewLabel_1_2.setBounds(440, 220, 30, 30);
        panelRegister.add(lblNewLabel_1_2);

        // TOOLTIP PASSWORD - posizionato a destra del campo
        JLabel lblNewLabel_1_3 = new JLabel("🛈");
        lblNewLabel_1_3.setToolTipText("<html>La password deve:<br>• Contenere almeno 8 caratteri<br>• Contenere almeno un carattere maiuscolo<br>• Contenere almeno un carattere minuscolo<br>• Contenere almeno un carattere speciale<br>• Contenere almeno un numero</html>");
        lblNewLabel_1_3.setBounds(440, 280, 30, 30);
        panelRegister.add(lblNewLabel_1_3);

        // PULSANTE CONFERMA - centrato
        btnRegistrati = new JButton("Conferma dati");
        btnRegistrati.setBounds(257, 350, 150, 40);
        btnRegistrati.setFont(new Font("Arial", Font.BOLD, 16));
        panelRegister.add(btnRegistrati);

        btnRegistrati.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeInserito = txtNome.getText();
                String cognomeInserito = txtCognome.getText();
                String emailInserita = txtEmail.getText();
                String passwordInserita = new String(passwordField.getPassword());

                // Evita i placeholder
                if (nomeInserito.equals("Nome")) {
                    nomeInserito = "";
                }

                if (cognomeInserito.equals("Cognome")) {
                    cognomeInserito = "";
                }

                if (emailInserita.equals("Email")) {
                    emailInserita = "";
                }

                if (passwordInserita.equals("Password")){
                    passwordInserita = "";
                }

                // 1. Controllo del Nome
                if (!isNomeValido(nomeInserito)) {
                    JOptionPane.showMessageDialog(null,
                            "Il nome inserito non è valido.\nPer favore, controlla e riprova.",
                            "Errore nel Nome",
                            JOptionPane.ERROR_MESSAGE);
                    return;

                    // 2. Controllo del Cognome
                } else if (!isCognomeValido(cognomeInserito)) {
                    JOptionPane.showMessageDialog(null,
                            "Il cognome inserito non è valido.\nPer favore, controlla e riprova.",
                            "Errore nel Cognome",
                            JOptionPane.ERROR_MESSAGE);
                    return;

                    // 3. Controllo dell'Email
                } else if (!isEmailValida(emailInserita)) {
                    JOptionPane.showMessageDialog(null,
                            "L'email inserita ha un formato non corretto.\nPer favore, riprova.",
                            "Errore nell'Email",
                            JOptionPane.ERROR_MESSAGE);
                    return;

                    // 4. Controllo della Password
                } else if (!isPasswordValida(passwordInserita)) {
                    JOptionPane.showMessageDialog(null,
                            "La password non soddisfa i requisiti di sicurezza.\nPer favore, riprova.",
                            "Errore nella Password",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Se tutto va bene
                try {
                    ControllerRegistrazione controller = ControllerRegistrazione.getInstance();
                    controller.registraUtente(nomeInserito, cognomeInserito, emailInserita, passwordInserita);
                    JOptionPane.showMessageDialog(null,
                        "Registrazione completata con successo!",
                        "Successo",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                } catch (SQLIntegrityConstraintViolationException ex) {  //errore se gia esistente
                    JOptionPane.showMessageDialog(null,
                        "L’email inserita è già stata utilizzata! ",
                        "Errore registrazione",
                        JOptionPane.ERROR_MESSAGE
                    );
                }catch (SQLException ex) {     //errore generico
                    JOptionPane.showMessageDialog(null,
                        "Si è verificato un errore durante la registrazione: " + ex.getMessage(),
                        "Errore",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
                panelRegister.setVisible(false);
                panelHome.setVisible(true);
            }
        });

        // PULSANTE INDIETRO - centrato
        JButton btnNewButton = new JButton("Vai indietro");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelRegister.setVisible(false);
                panelHome.setVisible(true);
            }
        });
        btnNewButton.setBounds(257, 420, 150, 40);
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
        panelRegister.add(btnNewButton);
    }

    /**
     * Metodo per aggiungere validazione in tempo reale ai JTextField
     */
    private void setupRealTimeValidation(JTextField textField, String tipo) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateField();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateField();
            }

            private void validateField() {
                String content = textField.getText();
                boolean isValid = false;

                // Controlla se non è un placeholder
                if (!content.equals("Nome") && !content.equals("Cognome") && !content.equals("Email")) {
                    switch (tipo) {
                        case "nome":
                            isValid = isNomeValido(content);
                            break;
                        case "cognome":
                            isValid = isCognomeValido(content);
                            break;
                        case "email":
                            isValid = isEmailValida(content);
                            break;
                    }
                }

                // Cambia il colore del bordo
                if (isValid) {
                    textField.setBorder(new LineBorder(Color.GREEN, 2));
                } else {
                    textField.setBorder(new LineBorder(Color.RED, 2));
                }
            }
        });
    }

    /**
     * Metodo per aggiungere validazione in tempo reale al JPasswordField
     */
    private void setupRealTimeValidationPassword(JPasswordField passwordField) {
        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateField();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateField();
            }

            private void validateField() {
                String content = String.valueOf(passwordField.getPassword());
                boolean isValid = false;

                // Controlla se non è un placeholder
                if (!content.equals("Password")) {
                    isValid = isPasswordValida(content);
                }

                // Cambia il colore del bordo
                if (isValid) {
                    passwordField.setBorder(new LineBorder(Color.GREEN, 2));
                } else {
                    passwordField.setBorder(new LineBorder(Color.RED, 2));
                }
            }
        });
    }

    private boolean isCognomeValido(String cognome) {
        // 1. Controllo null e lunghezza
        if (cognome == null || cognome.length() < 1 || cognome.length() > 50) {
            return false;
        }

        // 2. Controllo caratteri ammessi: lettere, spazio o apostrofo
        for (int i = 0; i < cognome.length(); i++) {
            char c = cognome.charAt(i);
            if (!Character.isLetter(c) && c != ' ' && c != '\'') {
                return false;
            }
        }

        return true;
    }

    private boolean isNomeValido(String nome) {
        // 1. Controllo null e lunghezza
        if (nome == null || nome.length() < 1 || nome.length() > 50) {
            return false;
        }

        // 2. Controllo se il primo carattere è maiuscolo
        char primo = nome.charAt(0);
        if (!Character.isUpperCase(primo)) {
            return false;
        }

        // 3. Controllo se tutti i caratteri sono lettere
        for (int i = 0; i < nome.length(); i++) {
            if (!Character.isLetter(nome.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean isEmailValida(String email) {
        // 1. Controllo null e lunghezza
        if (email == null || email.length() < 1 || email.length() > 255) {
            return false;
        }

        // 2. Controllo che ci sia esattamente una @
        int atCount = 0;
        for (char c : email.toCharArray()) {
            if (c == '@') {
                atCount++;
            }
        }

        return atCount == 1;
    }

    private boolean isPasswordValida(String password){
        // 1. Controllo null e lunghezza
        if (password == null || password.length() < 8) {
            return false;
        }

        // 2. Flag per i vincoli
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecial = true; // qualunque altro carattere
            }
        }

        // 3. Deve soddisfare tutti i requisiti
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    /**
     * Metodo per aggiungere placeholder ai JTextField
     */
    private void setupPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });
    }

    /**
     * Metodo per aggiungere placeholder ai JPasswordField
     */
    private void setupPasswordPlaceholder(JPasswordField passwordField, String placeholder) {
        passwordField.setText(placeholder);
        passwordField.setForeground(Color.GRAY);
        passwordField.setEchoChar((char) 0); // Mostra il testo del placeholder

        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals(placeholder)) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                    passwordField.setEchoChar('•'); // Attiva la mascheratura
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getPassword().length == 0) {
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setText(placeholder);
                    passwordField.setEchoChar((char) 0); // Mostra il testo del placeholder
                }
            }
        });
    }
}