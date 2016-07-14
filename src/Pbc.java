import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.plaf.DesktopPaneUI;

public class Pbc extends JFrame implements ActionListener {
	private JTextField textField = new JTextField("Text", 30);
	private JTextField encryptedField = new JTextField("Encrypted Text", 30);
	private JTextField keyField = new JTextField("0101010", 30);
	// //////////
	private JButton encryptButton = new JButton("Encrypt");

	public Pbc() {
		setLayout(new FlowLayout());
		add(textField);
		add(encryptedField);
		add(keyField);
		add(encryptButton);
		encryptButton.addActionListener(this);
		setSize(400, 200);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == encryptButton) {
			if (keyField.getText().length() == 7) {
				keyField.setText(keyField.getText().replace(" ", ""));
				encrypt();
			}

		}
	}

	private void encrypt() {
		int key = Integer.parseInt(keyField.getText(), 2);
		System.out.println(key);
		int outputBit = 0;
		int[] bin = bin();
		int x, y, g;
		encryptedField.setText("");
		for (int i = 0; i < bin.length; i++, x = y = g = 0) {
			x = (outputBit ^ bin[i]);
			outputBit = x;
			System.out.println("x " + Integer.toBinaryString(x) + " " + x);
			y = (x ^ key);
			System.out.println("y " + Integer.toBinaryString(x) + " " + y);
			g = (y ^ 64);
			System.out.println("g " + Integer.toBinaryString(x) + " " + g);
			if (g < y) {
				y = (y << 1 ^ 128) ^ 1;
			} else {
				y = (y << 1);
			}
			System.out.println("y " + Integer.toBinaryString(x) + " " + y);
			encryptedField.setText(encryptedField.getText() + " "

			+ Integer.toHexString(y));
		}

	}

	private int[] bin() {
		textField.setText(textField.getText().toUpperCase());
		int bin[] = new int[textField.getText().length()];
		for (int i = 0; i < textField.getText().length(); i++) {
			bin[i] = (int) textField.getText().charAt(i);
		}
		return bin;
	}

}
