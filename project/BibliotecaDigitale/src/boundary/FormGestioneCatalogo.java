package boundary;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FormGestioneCatalogo extends JFrame {
    private JPanel contentPane;
    private Image backgroundImage;

    public FormGestioneCatalogo() {
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
        setTitle("Gestione catalogo libri");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 500);

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JLabel lblTitolo = new JLabel("Gestione catalogo libri", SwingConstants.CENTER);
        lblTitolo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitolo.setForeground(Color.WHITE); // Titolo bianco
        lblTitolo.setBorder(new EmptyBorder(30, 0, 30, 0));
        contentPane.add(lblTitolo, BorderLayout.NORTH);

        JPanel panelBottoni = new JPanel();
        panelBottoni.setOpaque(false); // Solo il pannello è trasparente
        panelBottoni.setLayout(new GridLayout(4, 1, 0, 20));
        panelBottoni.setBorder(new EmptyBorder(40, 80, 40, 80));

        JButton btnAggiungiLibro = new JButton("Aggiungi Libro");
        btnAggiungiLibro.setFont(new Font("Arial", Font.BOLD, 18));
        JButton btnModificaLibro = new JButton("Modifica Libro");
        btnModificaLibro.setFont(new Font("Arial", Font.PLAIN, 18));
        JButton btnEliminaLibro = new JButton("Elimina Libro");
        btnEliminaLibro.setFont(new Font("Arial", Font.PLAIN, 18));
        JButton btnAggiungiCopia = new JButton("Aggiungi Copia");
        btnAggiungiCopia.setFont(new Font("Arial", Font.PLAIN, 18));

        panelBottoni.add(btnAggiungiLibro);
        panelBottoni.add(btnModificaLibro);
        panelBottoni.add(btnEliminaLibro);
        panelBottoni.add(btnAggiungiCopia);

        contentPane.add(panelBottoni, BorderLayout.CENTER);

        btnAggiungiLibro.addActionListener(e -> {
            FormInserimentoLibro form = new FormInserimentoLibro(() -> {
                FormGestioneCatalogo nuovoForm = new FormGestioneCatalogo();
                nuovoForm.setVisible(true);
            });
            form.setVisible(true);
            this.dispose();
        });
        btnModificaLibro.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Funzione non implementata!", "Info", JOptionPane.INFORMATION_MESSAGE);
        });
        btnEliminaLibro.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Funzione non implementata!", "Info", JOptionPane.INFORMATION_MESSAGE);
        });
        btnAggiungiCopia.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Funzione non implementata!", "Info", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FormGestioneCatalogo frame = new FormGestioneCatalogo();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
