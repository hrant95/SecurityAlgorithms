import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Algorithms extends JFrame implements ActionListener {
	private JPanel combokBoxPanel = new JPanel();
	private String[] combokBoxComponents = { "Select encryption algorithm",
			"Caesar", "Parz Poxarinum", "Playfair", "Homofonik1", "Homofonik2",
			"Vijiner", "Veradasavorum","Vichakagrutyun","Hash", "Cbc", "Pbc", "Cfb", "Pfb", "DiffieHellman" };
	private JComboBox combokBox = new JComboBox(combokBoxComponents);
	private JButton nextButton = new JButton("Next");
	private JButton closeButton = new JButton("Close");
	private ImageIcon icon = new ImageIcon("src/encrypt.png");

	public Algorithms() {
		setLayout(new FlowLayout());
		combokBoxPanel.setPreferredSize(new Dimension(280, 70));
		add(combokBoxPanel);
		combokBoxPanel.add(combokBox);
		combokBox.setPreferredSize(new Dimension(280, 25));
		// /
		add(nextButton);
		nextButton.addActionListener(this);
		nextButton.setIcon(new ImageIcon("src/next.png"));
		nextButton.setPreferredSize(new Dimension(83, 40));
		// /
		closeButton.setIcon(new ImageIcon("src/close.png"));
		closeButton.setPreferredSize(new Dimension(83, 40));
		add(closeButton);
		closeButton.addActionListener(this);
		// /
		setIconImage(icon.getImage());
		setSize(350, 180);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void nxetButtonMetod() {
		switch ((String) combokBox.getSelectedItem()) {
		case "Select encryption algorithm":
			JOptionPane.showMessageDialog(null, "Ցանկից ընտրեք ալգորիթմը։");
			break;
		case "Caesar":
			new Caesar();
			break;
		case "Parz Poxarinum":
			new ParzPoxarinum();
			break;
		case "Vijiner":
			new Vijiner();
			break;
		case "Homofonik1":
			new Homofonik1();
			break;
		case "Homofonik2":
			new Homofonik2();
			break;
		case "Playfair":
			new Playfair();
			break;
		case "Veradasavorum":
			new Veradasavorum();
			break;
		case "Vichakagrutyun":
			new Vichakagrutyun();
			break;
		case "Hash":
			new Hash();
			break;
		case "Cbc":
			new Cbc();
			break;
		case "Pbc":
			new Pbc();
			break;
		case "Cfb":
			new Cfb();
			break;
		case "Pfb":
			new Pfb();
			break;
		case "DiffieHellman":
			new DiffieHellman();
			break;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == nextButton) {
			nxetButtonMetod();
		}
		if (e.getSource() == closeButton) {
			System.exit(0);
		}
	}

}
