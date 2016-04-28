package forme;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class GUIGlavniProgram extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldSifra;
	private JTextField textFieldNaziv;
	private JTextField textFieldCena;


	/**
	 * Create the frame.
	 */
	public GUIGlavniProgram() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GUIGlavniProgram.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		setTitle("Prodavnica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JScrollPane scrollPaneTabela = new JScrollPane();
		contentPane.add(scrollPaneTabela, BorderLayout.CENTER);
		
		Model model = Kontroler.kreirajModel();
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int red = table.getSelectedRow();
				textFieldSifra.setText(model.getValueAt(red, 0).toString());
				textFieldNaziv.setText(model.getValueAt(red, 1).toString());
				textFieldCena.setText(model.getValueAt(red, 2).toString());
			}
		});
		model.fireTableDataChanged();
		scrollPaneTabela.setViewportView(table);
		
		
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons, BorderLayout.SOUTH);
		
		
		model.fireTableDataChanged();
		
		JButton btnDodajProizvod = new JButton("Dodaj/Izmeni/Obrisi");
		btnDodajProizvod.setIcon(new ImageIcon(GUIGlavniProgram.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		panelButtons.add(btnDodajProizvod);
		
		JButton btnIzlaz = new JButton("Izlaz");
		btnIzlaz.setIcon(new ImageIcon(GUIGlavniProgram.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroler.potvrdaIzlaza();
			}
		});
		panelButtons.add(btnIzlaz);
		
		JPanel panelEast = new JPanel();
		panelEast.setVisible(false);
		panelEast.setBorder(new TitledBorder(null, "Unos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelEast, BorderLayout.EAST);
		GridBagLayout gbl_panelEast = new GridBagLayout();
		gbl_panelEast.columnWidths = new int[]{50, 88, 0};
		gbl_panelEast.rowHeights = new int[]{41, 22, 22, 22, 38, 25, 0, 25, 0, 0, 0};
		gbl_panelEast.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelEast.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelEast.setLayout(gbl_panelEast);
		
		JLabel lblSifra = new JLabel("Sifra:");
		GridBagConstraints gbc_lblSifra = new GridBagConstraints();
		gbc_lblSifra.insets = new Insets(0, 0, 5, 5);
		gbc_lblSifra.gridx = 0;
		gbc_lblSifra.gridy = 1;
		panelEast.add(lblSifra, gbc_lblSifra);
		
		textFieldSifra = new JTextField();
		GridBagConstraints gbc_textFieldSifra = new GridBagConstraints();
		gbc_textFieldSifra.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldSifra.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSifra.gridx = 1;
		gbc_textFieldSifra.gridy = 1;
		panelEast.add(textFieldSifra, gbc_textFieldSifra);
		textFieldSifra.setColumns(10);
		
		JLabel lblNaziv = new JLabel("Naziv:");
		GridBagConstraints gbc_lblNaziv = new GridBagConstraints();
		gbc_lblNaziv.insets = new Insets(0, 0, 5, 5);
		gbc_lblNaziv.gridx = 0;
		gbc_lblNaziv.gridy = 2;
		panelEast.add(lblNaziv, gbc_lblNaziv);
		
		textFieldNaziv = new JTextField();
		GridBagConstraints gbc_textFieldNaziv = new GridBagConstraints();
		gbc_textFieldNaziv.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldNaziv.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldNaziv.gridx = 1;
		gbc_textFieldNaziv.gridy = 2;
		panelEast.add(textFieldNaziv, gbc_textFieldNaziv);
		textFieldNaziv.setColumns(10);
		
		JLabel lblCena = new JLabel("Cena:");
		GridBagConstraints gbc_lblCena = new GridBagConstraints();
		gbc_lblCena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCena.gridx = 0;
		gbc_lblCena.gridy = 3;
		panelEast.add(lblCena, gbc_lblCena);
		
		textFieldCena = new JTextField();
		GridBagConstraints gbc_txtCena = new GridBagConstraints();
		gbc_txtCena.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtCena.insets = new Insets(0, 0, 5, 0);
		gbc_txtCena.gridx = 1;
		gbc_txtCena.gridy = 3;
		panelEast.add(textFieldCena, gbc_txtCena);
		textFieldCena.setColumns(10);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setIcon(new ImageIcon(GUIGlavniProgram.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEast.setVisible(false);
			}
		});
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.setIcon(new ImageIcon(GUIGlavniProgram.class.getResource("/com/sun/javafx/scene/web/skin/Cut_16x16_JFX.png")));
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Kontroler.dugmeObrisi(table, panelEast, model, textFieldSifra.getText(), textFieldNaziv.getText(), textFieldCena.getText());				
			}
		});
		
		JButton btnOk = new JButton("OK");
		btnOk.setIcon(new ImageIcon(GUIGlavniProgram.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kontroler.dugmeOK(table, panelEast, model, textFieldSifra.getText(), textFieldNaziv.getText(), textFieldCena.getText());
			}
		});
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.anchor = GridBagConstraints.NORTH;
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 6;
		panelEast.add(btnOk, gbc_btnOk);
		GridBagConstraints gbc_btnObrisi = new GridBagConstraints();
		gbc_btnObrisi.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnObrisi.insets = new Insets(0, 0, 5, 0);
		gbc_btnObrisi.gridx = 1;
		gbc_btnObrisi.gridy = 7;
		panelEast.add(btnObrisi, gbc_btnObrisi);
		GridBagConstraints gbc_btnOdustani = new GridBagConstraints();
		gbc_btnOdustani.anchor = GridBagConstraints.NORTH;
		gbc_btnOdustani.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOdustani.gridx = 1;
		gbc_btnOdustani.gridy = 9;
		panelEast.add(btnOdustani, gbc_btnOdustani);
		
		
		btnDodajProizvod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				panelEast.setVisible(true);				
			}
		});
		
	}
	
	

}
