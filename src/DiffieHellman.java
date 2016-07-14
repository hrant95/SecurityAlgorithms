import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DiffieHellman extends JFrame implements ActionListener {

	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	// //
	private JTextField nfield = new JTextField(25);
	private JTextField gfield = new JTextField( 25);

	private JTextField x1field = new JTextField(22);
	private JTextField x2field = new JTextField(22);

	private JPanel centerPanel = new JPanel();
	private JButton changeButton = new JButton();

	private int y1, y2;
	
	private JTextArea K1Area = new JTextArea(5, 22);
	private JTextArea K2Area = new JTextArea(5, 22);

	// private JButton
	public DiffieHellman() {
		setLayout(new BorderLayout());
		panel1.setLayout(new FlowLayout());
		panel1.setPreferredSize(new Dimension(300, 190));
		panel1.setBackground(new Color(0, 204, 153));
		add(panel1, BorderLayout.WEST);
		// /
		panel1.add(new JLabel("N:"));
		panel1.add(nfield);
		panel1.add(new JLabel("X[1]:"));
		panel1.add(x1field);
		panel1.add(K1Area);
		panel2.setPreferredSize(new Dimension(300, 190));

		panel2.setBackground(new Color(175, 238, 238));
		panel2.setLayout(new FlowLayout());
		add(panel2, BorderLayout.EAST);
		panel2.add(new JLabel("G:"));
		panel2.add(gfield);
		panel2.add(new JLabel("X[2]:"));
		panel2.add(x2field);
		panel2.add(K2Area);
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		centerPanel.setPreferredSize(new Dimension(290, 190));
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.add(changeButton);
		changeButton.setIcon(new ImageIcon("src/refresh.png"));
		changeButton.setPreferredSize(new Dimension(128, 128));
		changeButton.addActionListener(this);
		setResizable(false);
		setSize(800, 185);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == changeButton) {
			
			int N, G;
			N = Integer.parseInt(nfield.getText());
			G = Integer.parseInt(gfield.getText());

			int x1 = Integer.parseInt(x1field.getText());
			y1 = (int) (Math.pow(G, x1)) % N;

			int x2 = Integer.parseInt(x2field.getText());
			y2 = (int) (Math.pow(G, x2)) % N;
			
			K1Area.setText(Integer.toString((int) (Math.pow(y2, x1) % N)));
			K2Area.setText(Integer.toString((int) (Math.pow(y1, x2) % N)));
		}
	}

}
