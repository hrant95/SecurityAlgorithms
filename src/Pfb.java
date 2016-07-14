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

public class Pfb extends JFrame implements ActionListener {
	private JTextField textField = new JTextField("Text", 30);
	private JTextField encryptedField = new JTextField("Encrypted Text", 30);
	private JTextField keyField = new JTextField("0101010", 30);
	// //////////
	private JButton encryptButton = new JButton("Encrypt");

	// private JButton decryptButton = new JButton("Decrypt");

	public Pfb() {
		setLayout(new FlowLayout());
		add(textField);
		add(encryptedField);
		add(keyField);
		add(encryptButton);
		encryptButton.addActionListener(this);
		// /
		// add(decryptButton);
		// decryptButton.addActionListener(this);
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
		// if (e.getSource() == decryptButton) {
		// decrypt();
		// }
	}

	private void encrypt() {
		int key = Integer.parseInt(keyField.getText(), 2);
		System.out.println(key);
		int outputBit = 0;
		int[] bin = bin();
		int x, y, g;
		encryptedField.setText("");
		for (int i = bin.length - 1; i >= 0; i--, x = y = g = 0) {
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

	private void decrypt() {
		String sum = "";
		int k = 0;
		encryptedField.setText(encryptedField.getText() + " ");
		for (int i = 1; i < encryptedField.getText().length(); i++) {
			if (encryptedField.getText().charAt(i) == ' ')
				k++;
		}
		int encryptedText[] = new int[k];
		for (int i = 1, j = 0; i < encryptedField.getText().length(); i++) {

			if (encryptedField.getText().charAt(i) == ' ') {
				encryptedText[j] = Integer.parseInt(sum, 16);
				System.out.println("i = " + i + "j = " + j + encryptedText[j]);
				sum = "";
				j++;
			} else {
				sum += encryptedField.getText().charAt(i);
			}

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
