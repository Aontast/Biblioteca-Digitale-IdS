package boundary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.LibroDTO;
import control.ControllerCatalogo;
import control.ControllerPrenotazione;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Graphics2D;

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
                    // Overlay bianco trasparente per migliorare la leggibilità
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 0.70f));
                    g2d.setColor(new Color(255,255,255,230));
                    g2d.fillRoundRect(15, 15, getWidth() - 30, getHeight() - 30, 40, 40);
                    g2d.dispose();
                }
            }
        };
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Cambia font e colori delle label e dei campi
		Font labelFont = new Font("Segoe UI", Font.BOLD, 16);
		Font fieldFont = new Font("Segoe UI", Font.PLAIN, 15);
		Color labelColor = new Color(44, 62, 80);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(labelFont);
		lblNewLabel.setForeground(labelColor);
		lblNewLabel.setBounds(38, 40, 80, 18);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cognome");
		lblNewLabel_1.setFont(labelFont);
		lblNewLabel_1.setForeground(labelColor);
		lblNewLabel_1.setBounds(38, 100, 98, 18);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(labelFont);
		lblNewLabel_2.setForeground(labelColor);
		lblNewLabel_2.setBounds(38, 160, 80, 18);
		contentPane.add(lblNewLabel_2);

		txtMatteo = new JTextField();
		txtMatteo.setFont(fieldFont);
		txtMatteo.setForeground(new Color(52, 73, 94));
		txtMatteo.setBackground(new Color(236, 240, 241));
		txtMatteo.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));
		txtMatteo.setEditable(false);
		txtMatteo.setText("Matteo");
		txtMatteo.setBounds(38, 57, 151, 28);
		contentPane.add(txtMatteo);

		txtBottari = new JTextField();
		txtBottari.setFont(fieldFont);
		txtBottari.setForeground(new Color(52, 73, 94));
		txtBottari.setBackground(new Color(236, 240, 241));
		txtBottari.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));
		txtBottari.setEditable(false);
		txtBottari.setText("Bottari");
		txtBottari.setBounds(38, 117, 151, 28);
		contentPane.add(txtBottari);

		txtMatteoingswcom = new JTextField();
		txtMatteoingswcom.setFont(fieldFont);
		txtMatteoingswcom.setForeground(new Color(52, 73, 94));
		txtMatteoingswcom.setBackground(new Color(236, 240, 241));
		txtMatteoingswcom.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));
		txtMatteoingswcom.setEditable(false);
		txtMatteoingswcom.setText("matteo@ingSW.it");
		txtMatteoingswcom.setBounds(38, 177, 151, 28);
		contentPane.add(txtMatteoingswcom);

		txtPassword = new JPasswordField();
		txtPassword.setFont(fieldFont);
		txtPassword.setForeground(new Color(52, 73, 94));
		txtPassword.setBackground(new Color(236, 240, 241));
		txtPassword.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));
		txtPassword.setEditable(false);
		txtPassword.setToolTipText("");
		txtPassword.setBounds(38, 237, 151, 28);
		txtPassword.setEchoChar('•');
		contentPane.add(txtPassword);
		txtPassword.setText("Swing_1");

		JButton btnMostraPassword = new JButton("👁");
		btnMostraPassword.setBackground(new Color(52, 152, 219));
		btnMostraPassword.setForeground(Color.WHITE);
		btnMostraPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnMostraPassword.setBounds(199, 237, 70, 28);
		contentPane.add(btnMostraPassword);
		btnMostraPassword.addActionListener(new ActionListener() {
		    private boolean visibile = false;
		    public void actionPerformed(ActionEvent e) {
		        if (visibile) {
		            txtPassword.setEchoChar('•');
		            btnMostraPassword.setText("👁");
		        } else {
		            txtPassword.setEchoChar((char) 0);
		            btnMostraPassword.setText("🚫");
		        }
		        visibile = !visibile;
		    }
		});

		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(labelFont);
		lblNewLabel_3.setForeground(labelColor);
		lblNewLabel_3.setBounds(38, 220, 98, 18);
		contentPane.add(lblNewLabel_3);

		JPanel panelMenu = new JPanel();
		panelMenu.setOpaque(false);
		panelMenu.setVisible(false);
		panelMenu.setBounds(396, 221, 224, 188);
		panelMenu.setLayout(null);
		contentPane.add(panelMenu);

		btnNewButton_1 = new JButton("Elenco Libri Prenotati");
		btnNewButton_1.setBackground(new Color(46, 204, 113));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_1.setBounds(10, 10, 204, 28);
		panelMenu.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		btnNewButton_2 = new JButton("Cronologia Prenotazioni");
		btnNewButton_2.setBackground(new Color(241, 196, 15));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_2.setBounds(10, 60, 204, 28);
		panelMenu.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		btnNewButton_3 = new JButton("Effettua Prenotazione");
		btnNewButton_3.setBackground(new Color(52, 152, 219));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_3.setBounds(10, 110, 204, 28);
		panelMenu.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMenu.setVisible(false);
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
		        panelPrenotazione.setVisible(true);
			}
		});

		btnNewButton_4 = new JButton("Gestisci Prenotazioni");
		btnNewButton_4.setBackground(new Color(231, 76, 60));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_4.setBounds(10, 160, 204, 28);
		panelMenu.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		lblImmagineProfilo = new JLabel();
		lblImmagineProfilo.setBounds(417, 25, 172, 109);
		try {
			ImageIcon iconaOriginale = new ImageIcon(getClass().getResource("/resources/profilo.png"));
			Image immagineRidimensionata = iconaOriginale.getImage().getScaledInstance(
				lblImmagineProfilo.getWidth(), 
				lblImmagineProfilo.getHeight(), 
				Image.SCALE_SMOOTH
			);
			lblImmagineProfilo.setIcon(new ImageIcon(immagineRidimensionata));
		} catch (Exception ex) {
			lblImmagineProfilo.setText("Foto Profilo");
			lblImmagineProfilo.setHorizontalAlignment(JLabel.CENTER);
			lblImmagineProfilo.setVerticalAlignment(JLabel.CENTER);
			System.err.println("Errore nel caricamento dell'immagine: " + ex.getMessage());
		}
		contentPane.add(lblImmagineProfilo);

		btnMenu = new JButton("☰☰☰ Menu a tendina ☰☰☰");
		btnMenu.setBackground(new Color(52, 73, 94));
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnMenu.setBounds(406, 419, 204, 28);
		contentPane.add(btnMenu);
		btnMenu.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        panelMenu.setVisible(!panelMenu.isVisible());
		    }
		});

		btnNewButton = new JButton("✎ Modifica i dati personali ✎");
		btnNewButton.setBackground(new Color(155, 89, 182));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBounds(38, 293, 229, 28);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		btnNewButton_5 = new JButton("✎ Modifica immagine profilo✎");
		btnNewButton_5.setBackground(new Color(26, 188, 156));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton_5.setBounds(396, 144, 224, 28);
		contentPane.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Funzione ancora non disponibile!", "Work In Progress", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		ControllerCatalogo controllerC = new ControllerCatalogo();
		List<LibroDTO> libri = controllerC.mostraLibriDisponibili();

		ButtonGroup gruppoLibri = new ButtonGroup();

		int y = 20;
		JLabel labelIstruzioni = new JLabel("Seleziona un libro disponibile:");
		labelIstruzioni.setFont(new Font("Segoe UI", Font.BOLD, 16));
		labelIstruzioni.setForeground(new Color(41, 128, 185));
		labelIstruzioni.setBounds(10, y, 350, 22);
		panelPrenotazione.add(labelIstruzioni);
		y += 34;

		JRadioButton[] radioButtons = new JRadioButton[libri.size()];

		for (int i = 0; i < libri.size(); i++) {
		    radioButtons[i] = new JRadioButton(libri.get(i).toString());
		    radioButtons[i].setFont(new Font("Segoe UI", Font.PLAIN, 15));
		    radioButtons[i].setForeground(new Color(52, 73, 94));
		    radioButtons[i].setBackground(new Color(255,255,255,0));
		    radioButtons[i].setBounds(10, y, 500, 24);
		    panelPrenotazione.add(radioButtons[i]);
		    gruppoLibri.add(radioButtons[i]);
		    y += 28;
		}

		JLabel lblData = new JLabel("Data prevista restituzione:");
		lblData.setFont(labelFont);
		lblData.setForeground(new Color(41, 128, 185));
		lblData.setBounds(10, y + 10, 250, 22);
		panelPrenotazione.add(lblData);

		JTextField txtData = new JTextField();
		txtData.setFont(fieldFont);
		txtData.setForeground(new Color(52, 73, 94));
		txtData.setBackground(new Color(236, 240, 241));
		txtData.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 1));
		txtData.setBounds(220, y + 10, 150, 28);
		panelPrenotazione.add(txtData);
		txtData.setColumns(10);

		JButton btnConferma = new JButton("Conferma prenotazione");
		btnConferma.setBackground(new Color(52, 152, 219));
		btnConferma.setForeground(Color.WHITE);
		btnConferma.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnConferma.setBounds(420, y + 50, 170, 32);
		panelPrenotazione.add(btnConferma);

		// Migliora estetica panelPrenotazione
		panelPrenotazione.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(new Color(41, 128, 185), 2, true),
			BorderFactory.createEmptyBorder(18, 18, 18, 18)
		));
		panelPrenotazione.setBackground(new Color(255,255,255,220));

		contentPane.add(panelPrenotazione);

		lblNewLabel_4 = new JLabel("📚 Catalogo Libri Disponibili 📖");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_4.setForeground(new Color(41, 128, 185));
		lblNewLabel_4.setBounds(180, 0, 300, 35);
		panelPrenotazione.add(lblNewLabel_4);
	}
}