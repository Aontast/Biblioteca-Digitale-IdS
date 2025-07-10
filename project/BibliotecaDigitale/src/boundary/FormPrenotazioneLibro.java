package boundary;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DTO.LibroDTO;
import control.ControllerCatalogo;
import control.ControllerPrenotazione;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormPrenotazioneLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMatteo;
	private JTextField txtBottari;
	private JTextField txtMatteoingswcom;
	private JPasswordField txtPassword;
	private JButton btnNewButton;
	private JButton btnMenu;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JLabel lblImmagineProfilo;
	private JButton btnNewButton_5;
	private JLabel lblNewLabel_4;
	private Image backgroundImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrenotazioneLibro frame = new FormPrenotazioneLibro();
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
	public FormPrenotazioneLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 489);
		
		// Carica l'immagine di background
        try {
            backgroundImage = new ImageIcon(getClass().getResource("/resources/login_background.jpg")).getImage();
			// Ridimensiona l'immagine per adattarla alla finestra
			backgroundImage = backgroundImage.getScaledInstance(
				Toolkit.getDefaultToolkit().getScreenSize().width, 
				Toolkit.getDefaultToolkit().getScreenSize().height, 
				Image.SCALE_SMOOTH
			);
        } catch (Exception e) {
            System.out.println("Errore caricamento immagine: " + e.getMessage());
        }
		
        try {
            Image icon = new ImageIcon(getClass().getResource("/resources/iconaApp.jpg")).getImage();
            setIconImage(icon);
        } catch (Exception e) {
            System.out.println("Errore caricamento icona: " + e.getMessage());
        }
        
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
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setBounds(38, 40, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cognome");
		lblNewLabel_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_1.setBounds(38, 100, 98, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(new Color(192, 192, 192));
		lblNewLabel_2.setBounds(38, 160, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		txtMatteo = new JTextField();
		txtMatteo.setForeground(SystemColor.menu);
		txtMatteo.setBackground(SystemColor.activeCaptionText);
		txtMatteo.setEditable(false);
		txtMatteo.setText("Matteo");
		txtMatteo.setBounds(38, 57, 151, 25);
		contentPane.add(txtMatteo);
		txtMatteo.setColumns(10);
		
		txtBottari = new JTextField();
		txtBottari.setForeground(SystemColor.menu);
		txtBottari.setBackground(SystemColor.activeCaptionText);
		txtBottari.setEditable(false);
		txtBottari.setText("Bottari");
		txtBottari.setBounds(38, 117, 151, 25);
		contentPane.add(txtBottari);
		txtBottari.setColumns(10);
		
		txtMatteoingswcom = new JTextField();
		txtMatteoingswcom.setForeground(SystemColor.menu);
		txtMatteoingswcom.setBackground(SystemColor.activeCaptionText);
		txtMatteoingswcom.setEditable(false);
		txtMatteoingswcom.setText("matteo@ingSW.it");
		txtMatteoingswcom.setBounds(38, 177, 151, 25);
		contentPane.add(txtMatteoingswcom);
		txtMatteoingswcom.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(SystemColor.menu);
		txtPassword.setBackground(SystemColor.activeCaptionText);
		txtPassword.setEditable(false);
		txtPassword.setToolTipText("");
		txtPassword.setBounds(38, 237, 151, 25);
		txtPassword.setEchoChar('•');
		contentPane.add(txtPassword);
		txtPassword.setText("Swing_12");
		
		
		JButton btnMostraPassword = new JButton("👁");
		btnMostraPassword.setBackground(Color.LIGHT_GRAY);
		btnMostraPassword.setBounds(199, 237, 70, 25);
		contentPane.add(btnMostraPassword);
		btnMostraPassword.addActionListener(new ActionListener() {
		    private boolean visibile = false;

		    public void actionPerformed(ActionEvent e) {
		        if (visibile) {
		            txtPassword.setEchoChar('•');  // Oscura password
		            btnMostraPassword.setText("👁");
		        } else {
		            txtPassword.setEchoChar((char) 0);  // Mostra password
		            btnMostraPassword.setText("🚫");
		        }
		        visibile = !visibile;
		    }
		});
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setForeground(new Color(192, 192, 192));
		lblNewLabel_3.setBounds(38, 220, 98, 13);
		contentPane.add(lblNewLabel_3);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setOpaque(false);
		panelMenu.setVisible(false);
		panelMenu.setBounds(396, 221, 224, 188);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		btnNewButton_1 = new JButton("Elenco Libri Prenotati");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(10, 10, 204, 21);
		panelMenu.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Cronologia Prenotazioni");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_2.setBounds(10, 60, 204, 21);
		panelMenu.add(btnNewButton_2);

		JPanel panelRingraziamento = new JPanel();
		panelRingraziamento.setBackground(new Color(0, 0, 0, 215)); // semi-trasparente
		panelRingraziamento.setVisible(false);  // nascosto all'avvio
		panelRingraziamento.setBounds(10, 10, 600, 430);  // stesse dimensioni del pannello prenotazione
		panelRingraziamento.setLayout(null);

		// Titolo principale
		JLabel lblGrazie = new JLabel("* Grazie per la Prenotazione! *");
		lblGrazie.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblGrazie.setForeground(new Color(255, 215, 0)); // Oro
		lblGrazie.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrazie.setBounds(50, 80, 500, 40);
		panelRingraziamento.add(lblGrazie);

		// Messaggio di attenzione
		JLabel lblAttenzione = new JLabel("!!! ATTENZIONE !!!");
		lblAttenzione.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblAttenzione.setForeground(new Color(255, 69, 0)); // Rosso arancione
		lblAttenzione.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttenzione.setBounds(50, 150, 500, 30);
		panelRingraziamento.add(lblAttenzione);

		// Primo messaggio informativo
		JLabel lblInfo1 = new JLabel("Non perdere la ricevuta!");
		lblInfo1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblInfo1.setForeground(Color.WHITE);
		lblInfo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo1.setBounds(50, 190, 500, 25);
		panelRingraziamento.add(lblInfo1);

		// Secondo messaggio informativo
		JLabel lblInfo2 = new JLabel("Sarà necessaria per il ritiro del libro");
		lblInfo2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblInfo2.setForeground(new Color(192, 192, 192));
		lblInfo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo2.setBounds(50, 220, 500, 25);
		panelRingraziamento.add(lblInfo2);

		// Messaggio aggiuntivo
		JLabel lblInfo3 = new JLabel("--- Conserva la ricevuta stampata o digitale ---");
		lblInfo3.setFont(new Font("Segoe UI", Font.ITALIC, 16));
		lblInfo3.setForeground(new Color(144, 238, 144)); // Verde chiaro
		lblInfo3.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo3.setBounds(50, 260, 500, 25);
		panelRingraziamento.add(lblInfo3);

		// Pulsante per tornare al menu
		JButton btnTornaMenu = new JButton(">> Torna al Menu Principale");
		btnTornaMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnTornaMenu.setBackground(new Color(70, 130, 180)); // Steel Blue
		btnTornaMenu.setForeground(Color.WHITE);
		btnTornaMenu.setBounds(175, 320, 250, 40);

		btnTornaMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Chiudi la finestra corrente
				dispose();

				// Riavvia il main per creare una nuova istanza
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormPrenotazioneLibro nuovaFrame = new FormPrenotazioneLibro();
							nuovaFrame.setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
			}
		});

		panelRingraziamento.add(btnTornaMenu);
		contentPane.add(panelRingraziamento);


		JPanel panelPrenotazione = new JPanel();
		panelPrenotazione.setBackground(new Color(0, 0, 0, 215)); // semi-trasparente
		panelPrenotazione.setVisible(false);  // all'avvio nascosto
		panelPrenotazione.setBounds(10, 10, 600, 430);  // sovrapposto a contentPane
		panelPrenotazione.setLayout(null);
		
		btnNewButton_3 = new JButton("Effettua Prenotazione");
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(false);       // nasconde tutto il contentPane e i bottoni del content pane
				lblNewLabel.setVisible(false);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_2.setVisible(false);
				txtMatteo.setVisible(false);
				txtBottari.setVisible(false);
				txtMatteoingswcom.setVisible(false);
				txtPassword.setVisible(false);
				btnMostraPassword.setVisible(false);
				lblNewLabel_3.setVisible(false);
				lblImmagineProfilo.setVisible(false); 
				btnNewButton_5.setVisible(false); 
				btnNewButton.setVisible(false); 
				btnMenu.setVisible(false);
				
				
		        panelPrenotazione.setVisible(true);  // mostra solo la prenotazione
			}
		});
		
		btnNewButton_3.setBounds(10, 110, 204, 21);
		panelMenu.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Gestisci Prenotazioni");
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_4.setBounds(10, 160, 204, 21);
		panelMenu.add(btnNewButton_4);
		
		lblImmagineProfilo = new JLabel();
		lblImmagineProfilo.setBounds(417, 25, 172, 109);
		
		try {
			ImageIcon iconaOriginale = new ImageIcon(getClass().getResource("/resources/profilo.png"));
			
			Image immagineRidimensionata = iconaOriginale.getImage().getScaledInstance(
				lblImmagineProfilo.getWidth(), 
				lblImmagineProfilo.getHeight(), 
				Image.SCALE_SMOOTH
			);
			
			// Imposta l'icona ridimensionata
			lblImmagineProfilo.setIcon(new ImageIcon(immagineRidimensionata));
			
		} catch (Exception ex) {
			// Se l'immagine non può essere caricata, mostra un testo di fallback
			lblImmagineProfilo.setText("Foto Profilo");
			lblImmagineProfilo.setHorizontalAlignment(JLabel.CENTER);
			lblImmagineProfilo.setVerticalAlignment(JLabel.CENTER);
			System.err.println("Errore nel caricamento dell'immagine: " + ex.getMessage());
		}
		
		contentPane.add(lblImmagineProfilo);
		
		btnMenu = new JButton("☰☰☰ Menu a tendina ☰☰☰");
		btnMenu.setBackground(Color.LIGHT_GRAY);
		btnMenu.setBounds(406, 419, 204, 21);
		contentPane.add(btnMenu);
		
		btnNewButton = new JButton("✎ Modifica i dati personali ✎");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(38, 293, 229, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_5 = new JButton("✎ Modifica immagine profilo✎");
		btnNewButton_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_5.setBounds(396, 144, 224, 21);
		contentPane.add(btnNewButton_5);
		btnMenu.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        panelMenu.setVisible(!panelMenu.isVisible());
		    }
		});
		
		ControllerCatalogo controllerC = ControllerCatalogo.getInstance();
		List<LibroDTO> libri = controllerC.mostraLibriDisponibili();
		
		ButtonGroup gruppoLibri = new ButtonGroup();

		int y = 20;
		JLabel labelIstruzioni = new JLabel("Seleziona un libro disponibile:");
		labelIstruzioni.setBackground(Color.LIGHT_GRAY);
		labelIstruzioni.setForeground(Color.LIGHT_GRAY);
		labelIstruzioni.setBounds(10, y, 300, 20);
		panelPrenotazione.add(labelIstruzioni);
		y += 30;

		JRadioButton[] radioButtons = new JRadioButton[libri.size()];

		for (int i = 0; i < libri.size(); i++) {
		    radioButtons[i] = new JRadioButton(libri.get(i).toString());
		    radioButtons[i].setBounds(10, y, 500, 20);
		    panelPrenotazione.add(radioButtons[i]);
		    gruppoLibri.add(radioButtons[i]);
		    y += 30;
		}
		
		JLabel lblData = new JLabel("Data prevista restituzione:");
		lblData.setBackground(Color.LIGHT_GRAY);
		lblData.setForeground(Color.LIGHT_GRAY);
		lblData.setBounds(10, y + 10, 200, 20);
		panelPrenotazione.add(lblData);

		JTextField txtData = new JTextField();
		txtData.setBounds(200, y + 10, 150, 20);
		panelPrenotazione.add(txtData);
		txtData.setColumns(10);

		JButton btnConferma = new JButton("Conferma prenotazione");
		btnConferma.setBackground(Color.LIGHT_GRAY);

		btnConferma.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
				String dataRest = txtData.getText();
				Date inputDate;

				// Trova l'indice del radio selezionato
				int selectedIndex = -1;
				for (int i = 0; i < radioButtons.length; i++) {
					if (radioButtons[i].isSelected()) {
						selectedIndex = i;
						break;
					}
				}

				// Validazione: libro e data
				if (selectedIndex == -1 || dataRest.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Seleziona un libro e inserisci la data di restituzione.", "Errore campi vuoti", JOptionPane.ERROR_MESSAGE);
					return;
				}

				LibroDTO libroSelezionato = libri.get(selectedIndex);

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

				// inizio creazione prenotazione
				int idPrenotazione = (int)(Math.random() * 100000);
				
				//Calcolo del costo totale tramite controller
				String email = txtMatteoingswcom.getText();
				double costoTotale = controllerPren.calcolaPrezzo(inputDate);

				try {
					controllerPren.prenotaLibroDisponibile(libroSelezionato, costoTotale, inputDate, email);
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Il server non è riuscito a cambiare lo stao della copia, riprovare.", "Errore nella prenotazione", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				FormRicevuta ricevutaFrame = new FormRicevuta(
						idPrenotazione,
						libroSelezionato.getTitolo(),
						libroSelezionato.getCodiceISBN(),
						email,
						dataRest,
						costoTotale
				);
				ricevutaFrame.setVisible(true);

				// Cambia pannello -> Pannello di ringraziamento
				panelPrenotazione.setVisible(false);
				panelRingraziamento.setVisible(true);
			}
		});
		
		btnConferma.setBounds(460, y + 50, 100, 25);
		panelPrenotazione.add(btnConferma);
		
		contentPane.add(panelPrenotazione);
		
		lblNewLabel_4 = new JLabel("📚Catalogo Libri Disponibili📖");
		lblNewLabel_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setBounds(209, 0, 158, 35);
		panelPrenotazione.add(lblNewLabel_4);
	}
}