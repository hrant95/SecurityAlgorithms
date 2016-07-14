import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Homofonik2 extends JFrame implements ActionListener {
	private JLabel labelText = new JLabel("Text: ");
	private JTextField textFieldText = new JTextField(42);
	private JLabel labelEncryptedText = new JLabel("Encrypted text: ");
	private JTextField textFieldEncryptedText = new JTextField(42);
	private JLabel labelDecryptedText = new JLabel("Decrypted text: ");
	private JTextField textFieldDecryptedText = new JTextField(42);
	private JButton buttonEncrypt = new JButton("Encrypt");
	private JButton buttonDecrypt = new JButton("Decrypt");

	char[] alphabet = { 'A', 'Ä', 'B', 'C', 'D', 'E', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'Ö', 'P', 'Q', 'R', 'S', 'ß', 'T',
			'U', 'Ü', 'V', 'W', 'X', 'Y', 'Z' };
	String index = "ABCDIFGHIJKLMNOPQRSTUVWXYZ";

	public Homofonik2() {
		setLayout(new FlowLayout());
		add(labelText);
		add(textFieldText);
		add(labelEncryptedText);
		add(textFieldEncryptedText);
		add(labelDecryptedText);
		add(textFieldDecryptedText);
		add(buttonEncrypt);
		add(buttonDecrypt);
		buttonEncrypt.addActionListener(this);
		buttonDecrypt.addActionListener(this);
		setSize(500, 220);
		setLocationRelativeTo(null); // center
		setResizable(false); // fixed size
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		textFieldText.setText(textFieldText.getText().toUpperCase());
		if (e.getSource() == buttonEncrypt) {
			encrypt();

		}
		if (e.getSource() == buttonDecrypt) {
			decrypt();
		}
	}

	public void encrypt() {
		textFieldEncryptedText.setText("");
		int rand;

		String text = textFieldText.getText().toString();
		text = text.toUpperCase();
		for (int i = 0; i < text.length(); i++) {
			rand = (int) (0 + Math.random() * 2);
			System.out.println(rand);
			switch (text.charAt(i)) {
			case 'A':
				if (rand == 1)
					textFieldEncryptedText.setText(textFieldEncryptedText
							.getText() + "A");
				else
					textFieldEncryptedText.setText(textFieldEncryptedText
							.getText() + "Ä");
				break;
			case 'O':
				if (rand == 1)
					textFieldEncryptedText.setText(textFieldEncryptedText
							.getText() + "O");
				else
					textFieldEncryptedText.setText(textFieldEncryptedText
							.getText() + "Ö");
				break;
			case 'S':
				if (rand == 1)
					textFieldEncryptedText.setText(textFieldEncryptedText
							.getText() + "S");
				else
					textFieldEncryptedText.setText(textFieldEncryptedText
							.getText() + "ß");
				break;
			case 'U':
				if (rand == 1)
					textFieldEncryptedText.setText(textFieldEncryptedText
							.getText() + "U");
				else
					textFieldEncryptedText.setText(textFieldEncryptedText
							.getText() + "Ü");
				break;
			default:
				textFieldEncryptedText.setText(textFieldEncryptedText.getText()
						+ text.charAt(i));
				break;
			}

		}

	}

	public void decrypt() {
		textFieldDecryptedText.setText("");

		String text = textFieldEncryptedText.getText().toString();
		text = text.toUpperCase();
		for (int i = 0; i < text.length(); i++) {
			switch (text.charAt(i)) {
			case 'A':
			case 'Ä':
				textFieldDecryptedText.setText(textFieldDecryptedText.getText()
						+ "A");
				break;
			case 'Ö':
			case 'O':
				textFieldDecryptedText.setText(textFieldDecryptedText.getText()
						+ "O");
				break;
			case 'ß':
			case 'S':
				textFieldDecryptedText.setText(textFieldDecryptedText.getText()
						+ "S");
				break;
			case 'Ü':
			case 'U':
				textFieldDecryptedText.setText(textFieldDecryptedText.getText()
						+ "U");
				break;
			default:
				textFieldDecryptedText.setText(textFieldDecryptedText.getText()
						+ text.charAt(i));
				break;
			}

		}
	}

}
