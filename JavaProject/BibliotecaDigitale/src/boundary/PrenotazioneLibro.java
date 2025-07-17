package boundary;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.*;

import DTO.LibroDTO;
import control.ControllerCatalogo;
import control.ControllerPrenotazione;

public class PrenotazioneLibro extends JPanel {
    
    private JTextField txtData;
    private JRadioButton[] radioButtons;
    private List<LibroDTO> libri;
    private String emailUtente;
    private JPanel panelRingraziamento;
    
    public PrenotazioneLibro(String emailUtente, JPanel panelRingraziamento) {
        this.emailUtente = emailUtente;
        this.panelRingraziamento = panelRingraziamento;
        
        setBackground(new Color(0, 0, 0, 100)); // semi-trasparente
        setVisible(false);  // all'avvio nascosto
        setBounds(10, 10, 600, 430);  // sovrapposto a contentPane
        setLayout(null);
        
        initializeComponents();
    }
    
    private void initializeComponents() {
        // Recupera i libri disponibili
        ControllerCatalogo controllerC = ControllerCatalogo.getInstance();
        libri = controllerC.mostraLibriDisponibili();

        ButtonGroup gruppoLibri = new ButtonGroup();
        int y = 20;
        
        // Etichetta del catalogo
        JLabel lblNewLabel_4 = new JLabel("📚Catalogo Libri Disponibili📖");
        lblNewLabel_4.setBackground(Color.LIGHT_GRAY);
        lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
        lblNewLabel_4.setBounds(209, 0, 165, 35);
        add(lblNewLabel_4);
        
        // Istruzioni
        JLabel labelIstruzioni = new JLabel("Seleziona un libro disponibile:");
        labelIstruzioni.setBackground(Color.WHITE);
        labelIstruzioni.setForeground(Color.LIGHT_GRAY);
        labelIstruzioni.setBounds(10, y, 300, 20);
        add(labelIstruzioni);
        y += 30;
        
        // Radio buttons per i libri
        radioButtons = new JRadioButton[libri.size()];
        for (int i = 0; i < libri.size(); i++) {
            radioButtons[i] = new JRadioButton(libri.get(i).toString());
            radioButtons[i].setBounds(10, y, 500, 20);
            radioButtons[i].setForeground(Color.BLACK);
            radioButtons[i].setBackground(Color.LIGHT_GRAY);
            add(radioButtons[i]);
            gruppoLibri.add(radioButtons[i]);
            y += 35;
        }
        
        // Label per la data
        JLabel lblData = new JLabel("Data prevista restituzione:");
        lblData.setBackground(Color.LIGHT_GRAY);
        lblData.setForeground(Color.LIGHT_GRAY);
        lblData.setBounds(10, y + 10, 200, 20);
        add(lblData);
        
        // Campo di testo per la data
        txtData = new JTextField();
        txtData.setBounds(200, y + 10, 150, 20);
        add(txtData);
        txtData.setColumns(10);
        
        // Pulsante di conferma
        JButton btnConferma = new JButton("Conferma prenotazione");
        btnConferma.setBackground(Color.LIGHT_GRAY);
        btnConferma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confermaPrenotazione();
            }
        });
        btnConferma.setBounds(410, y + 50, 180, 25);
        add(btnConferma);
    }
    
    private void confermaPrenotazione() {
        
        // Trova l'indice del radio selezionato
        int selectedIndex = -1;
        for (int i = 0; i < radioButtons.length; i++) {
            if (radioButtons[i].isSelected()) {
                selectedIndex = i;
                break;
            }
        }
        
        // Validazione: libro e data
        String dataRest = txtData.getText();
        Date inputDate;

        if (selectedIndex == -1 || dataRest.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleziona un libro e inserisci la data di restituzione.", "Errore campi vuoti", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validazione formato data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            inputDate = sdf.parse(dataRest);
        } catch (ParseException e1) {
            JOptionPane.showMessageDialog(null, "Per favore inserire una data del tipo DD/MM/YYYY valida.","Errore formato data", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ControllerPrenotazione controllerPren = ControllerPrenotazione.getInstance();
        
        // Validazione data futura
        if(!controllerPren.futureDateCheck(inputDate)) {
            JOptionPane.showMessageDialog(null, "Per favore inserire una data futura.", "Errore data passata", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Inizio creazione prenotazione
        int idPrenotazione;
        // Recupera isbn libro selezionato
        LibroDTO libroSelezionato = libri.get(selectedIndex);
        
        double costoTotale = controllerPren.calcolaPrezzo(inputDate);
        
        try {
            idPrenotazione = controllerPren.prenotaLibroDisponibile(libroSelezionato, emailUtente, costoTotale, inputDate);
        } catch (ClassNotFoundException | SQLException e1) {
            JOptionPane.showMessageDialog(null, "Il server non è riuscito a cambiare lo stato della copia, riprovare.", "Errore nella prenotazione", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Crea e mostra la ricevuta
        RicevutaPrenotazione ricevutaFrame = new RicevutaPrenotazione(
                idPrenotazione,
                libroSelezionato.getTitolo(),
                libroSelezionato.getCodiceISBN(),
                emailUtente,
                dataRest,
                costoTotale
        );
        ricevutaFrame.setVisible(true);
        setVisible(false);
        panelRingraziamento.setVisible(true);
    }
}
