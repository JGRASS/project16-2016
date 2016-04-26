package forme;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class DodatProizvod extends JDialog {

	private final JPanel contentPanel = new JPanel();
	

	/**
	 * Create the dialog.
	 */
	public DodatProizvod() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DodatProizvod.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
		setBounds(100, 100, 302, 123);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblProizvodJeDodat = new JLabel("Proizvod je dodat/izmenjen.");
			lblProizvodJeDodat.setIcon(new ImageIcon(DodatProizvod.class.getResource("/javax/swing/plaf/metal/icons/ocean/info.png")));
			lblProizvodJeDodat.setFont(new Font("Tahoma", Font.PLAIN, 15));
			contentPanel.add(lblProizvodJeDodat);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
