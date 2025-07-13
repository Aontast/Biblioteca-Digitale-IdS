package boundary;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormProfiloUtente extends JFrame {

    private JPanel contentPane;
    private JTextField txtMatteo;
    private JTextField txtBottari;
    private JTextField txtMatteoingswcom;
    private JPasswordField txtPassword;
	private Image backgroundImage;
	private JPanel panelRingraziamento;

    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProfiloUtente frame = new FormProfiloUtente();
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
	public FormProfiloUtente() {
		
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

		// Inizializza i componenti dell'interfaccia utente
		initializeUserInterface();
		
		// Crea il pannello di ringraziamento
		panelRingraziamento = createPanelRingraziamento();
		contentPane.add(panelRingraziamento);
	}
	
	private void initializeUserInterface() {

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
		txtMatteo.setForeground(Color.BLACK);
		txtMatteo.setBackground(Color.LIGHT_GRAY);
		txtMatteo.setEditable(false);
		txtMatteo.setText("Matteo");
		txtMatteo.setBounds(38, 57, 151, 25);
		contentPane.add(txtMatteo);
		txtMatteo.setColumns(10);

		txtBottari = new JTextField();
		txtBottari.setForeground(Color.BLACK);
		txtBottari.setBackground(Color.LIGHT_GRAY);
		txtBottari.setEditable(false);
		txtBottari.setText("Bottari");
		txtBottari.setBounds(38, 117, 151, 25);
		contentPane.add(txtBottari);
		txtBottari.setColumns(10);

		txtMatteoingswcom = new JTextField();
		txtMatteoingswcom.setForeground(Color.BLACK);
		txtMatteoingswcom.setBackground(Color.LIGHT_GRAY);
		txtMatteoingswcom.setEditable(false);
		txtMatteoingswcom.setText("matteo@ingSW.it");
		txtMatteoingswcom.setBounds(38, 177, 151, 25);
		contentPane.add(txtMatteoingswcom);
		txtMatteoingswcom.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setBackground(Color.LIGHT_GRAY);
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

		JButton btnNewButton_1 = new JButton("Elenco Libri Prenotati");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(10, 10, 204, 21);
		panelMenu.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cronologia Prenotazioni");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_2.setBounds(10, 60, 204, 21);
		panelMenu.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Effettua Prenotazione");
        btnNewButton_3.setBackground(Color.LIGHT_GRAY);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                effettuaPrenotazione(txtMatteoingswcom.getText());
            }
        });
        btnNewButton_3.setBounds(10, 110, 204, 21);
        panelMenu.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Gestisci Prenotazioni");
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_4.setBounds(10, 160, 204, 21);
		panelMenu.add(btnNewButton_4);

		JButton btnMenu = new JButton("☰☰☰ Menu a tendina ☰☰☰");
		btnMenu.setBackground(Color.LIGHT_GRAY);
		btnMenu.setBounds(406, 419, 204, 21);
		contentPane.add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(!panelMenu.isVisible());
			}
		});

		JLabel lblImmagineProfilo = new JLabel();
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

		JButton btnNewButton = new JButton("✎ Modifica i dati personali ✎");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(38, 293, 229, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_5 = new JButton("✎ Modifica immagine profilo✎");
		btnNewButton_5.setBackground(Color.LIGHT_GRAY);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_5.setBounds(396, 144, 224, 21);
		contentPane.add(btnNewButton_5);
	}

	 private JPanel createPanelRingraziamento() {
        JPanel panelRingraziamento = new JPanel();
        panelRingraziamento.setBackground(new Color(0, 0, 0, 215));
        panelRingraziamento.setVisible(false);
        panelRingraziamento.setBounds(10, 10, 600, 430);
        panelRingraziamento.setLayout(null);

        JLabel lblGrazie = new JLabel("* Grazie per la Prenotazione! *");
        lblGrazie.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblGrazie.setForeground(new Color(255, 215, 0));
        lblGrazie.setHorizontalAlignment(SwingConstants.CENTER);
        lblGrazie.setBounds(50, 80, 500, 40);
        panelRingraziamento.add(lblGrazie);

        JLabel lblAttenzione = new JLabel("!!! ATTENZIONE !!!");
        lblAttenzione.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblAttenzione.setForeground(new Color(255, 69, 0));
        lblAttenzione.setHorizontalAlignment(SwingConstants.CENTER);
        lblAttenzione.setBounds(50, 150, 500, 30);
        panelRingraziamento.add(lblAttenzione);

        JLabel lblInfo1 = new JLabel("Non perdere la ricevuta!");
        lblInfo1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblInfo1.setForeground(Color.WHITE);
        lblInfo1.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo1.setBounds(50, 190, 500, 25);
        panelRingraziamento.add(lblInfo1);

        JLabel lblInfo2 = new JLabel("Sarà necessaria per il ritiro del libro");
        lblInfo2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblInfo2.setForeground(new Color(192, 192, 192));
        lblInfo2.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo2.setBounds(50, 220, 500, 25);
        panelRingraziamento.add(lblInfo2);

        JLabel lblInfo3 = new JLabel("--- Conserva la ricevuta stampata o digitale ---");
        lblInfo3.setFont(new Font("Segoe UI", Font.ITALIC, 16));
        lblInfo3.setForeground(new Color(144, 238, 144));
        lblInfo3.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo3.setBounds(50, 260, 500, 25);
        panelRingraziamento.add(lblInfo3);

        JButton btnTornaMenu = new JButton(">> Torna al Menu Principale");
        btnTornaMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btnTornaMenu.setBackground(new Color(70, 130, 180));
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
                            FormProfiloUtente nuovaFrame = new FormProfiloUtente();
                            nuovaFrame.setVisible(true);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }
        });

        panelRingraziamento.add(btnTornaMenu);
        return panelRingraziamento;
    }

    private void effettuaPrenotazione(String emailUtente) {

		PrenotazioneLibro panelPrenotazione = new PrenotazioneLibro(emailUtente,  panelRingraziamento);
		contentPane.add(panelPrenotazione);

		Component[] components = contentPane.getComponents();
        for (Component comp : components) {
            if (comp != panelPrenotazione) {
                comp.setVisible(false);
            }
		}
		panelRingraziamento.setVisible(false);
        panelPrenotazione.setVisible(true);
    }
}