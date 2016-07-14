import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Homofonik1 extends JFrame implements ActionListener {
	private JLabel labelText = new JLabel("Text: ");
	private JTextField textFieldText = new JTextField(42);
	private JLabel labelEncryptedText = new JLabel("Encrypted text: ");
	private JTextField textFieldEncryptedText = new JTextField(42);
	private JLabel labelDecryptedText = new JLabel("Decrypted text: ");
	private JTextField textFieldDecryptedText = new JTextField(42);
	private JButton buttonEncrypt = new JButton("Encrypt");
	private JButton buttonDecrypt = new JButton("Decrypt");
	
	char[] alphabet = { 'A', 'A', 'B', 'C', 'D', 'E', 'E', 'F', 'G', 'H',
			'I', 'J', 'K', 'L', 'M', 'N', 'N', 'O', 'O', 'P', 'Q', 'R',
			'R', 'S', 'T', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	String[] index = { "01", "07", "14", "21", "04", "23", "27", "20",
			"29", "31", "06", "28", "12", "30", "17", "00", "18", "26",
			"19", "09", "10", "25", "13", "02", "08", "24", "22", "05",
			"16", "15", "11", "03" };
	
	public Homofonik1() {
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
		int x;
		
		
		textFieldEncryptedText.setText("");
		for (int i = 0; i < textFieldText.getText().length(); i++) {
			for (int j = 0; j < alphabet.length; j++) {
				x = (int) (0 + Math.random() * 2);
				if (textFieldText.getText().charAt(i) == alphabet[j]
						&& textFieldText.getText().charAt(i) != 'A'
						&& textFieldText.getText().charAt(i) != 'E'
						&& textFieldText.getText().charAt(i) != 'N'
						&& textFieldText.getText().charAt(i) != 'O'
						&& textFieldText.getText().charAt(i) != 'R'
						&& textFieldText.getText().charAt(i) != 'T') {
					textFieldEncryptedText.setText(textFieldEncryptedText
							.getText() + index[j]);
					break;
				} else {
					// A
					if (textFieldText.getText().charAt(i) == 'A') {
						if (x == 0) {
							textFieldEncryptedText
									.setText(textFieldEncryptedText.getText()
											+ index[0]);
						} else {
							textFieldEncryptedText
									.setText(textFieldEncryptedText.getText()
											+ index[1]);
						}
						break;
					}
					// E
					if (textFieldText.getText().charAt(i) == 'E') {
						if (x == 0) {
							textFieldEncryptedText
									.setText(textFieldEncryptedText.getText()
											+ index[5]);
						} else {
							textFieldEncryptedText
									.setText(textFieldEncryptedText.getText()
											+ index[6]);
						}
						break;
					}
					// N
					if (textFieldText.getText().charAt(i) == 'N') {
						if (x == 0) {
							textFieldEncryptedText
									.setText(textFieldEncryptedText.getText()
											+ index[15]);
						} else {
							textFieldEncryptedText
									.setText(textFieldEncryptedText.getText()
											+ index[16]);
						}
						break;
					}
					// O
					if (textFieldText.getText().charAt(i) == 'O') {
						if (x == 0) {
							textFieldEncryptedText
									.setText(textFieldEncryptedText.getText()
											+ index[17]);
						} else {
							textFieldEncryptedText
									.setText(textFieldEncryptedText.getText()
											+ index[18]);
						}
						break;
					}
					// R
					if (textFieldText.getText().charAt(i) == 'R') {
						if (x == 0) {
							textFieldEncryptedText
									.setText(textFieldEncryptedText.getText()
											+ index[21]);
						} else {
							textFieldEncryptedText
									.setText(textFieldEncryptedText.getText()
											+ index[22]);
						}
						break;
					}
					// T
					if (textFieldText.getText().charAt(i) == 'T') {
						if (x == 0) {
							textFieldEncryptedText
									.setText(textFieldEncryptedText.getText()
											+ index[24]);
						} else {
							textFieldEncryptedText
									.setText(textFieldEncryptedText.getText()
											+ index[25]);
						}
						break;
					}
				}
			}
		}
	}

	public void decrypt() {
		String s, b;
		textFieldDecryptedText.setText("");
		for (int i = 0; i < textFieldEncryptedText.getText().length() - 1; i += 2) {
			s = "" +  textFieldEncryptedText.getText().charAt(i) + textFieldEncryptedText.getText().charAt(i + 1);
			for (int j = 0; j < index.length; j++) {
				
				// A
				if(s == "01" || s == "07"){
					textFieldDecryptedText.setText(textFieldDecryptedText.getText() + "A");
					break;
				}
				// E
				if(s == "23" || s == "27"){
					textFieldDecryptedText.setText(textFieldDecryptedText.getText() + "E");
					break;
				}
				// N
				if(s == "00" || s == "18"){
					textFieldDecryptedText.setText(textFieldDecryptedText.getText() + "N");
					break;
				}
				// O
				if(s == "26" || s == "19"){
					textFieldDecryptedText.setText(textFieldDecryptedText.getText() + "O");
					break;
				}
				// R
				if(s == "25" || s == "13"){
					textFieldDecryptedText.setText(textFieldDecryptedText.getText() + "R");
					break;
				}
				// T
				if(s == "08" || s == "24"){
					textFieldDecryptedText.setText(textFieldDecryptedText.getText() + "T");
					break;
				}
				if(s.equals(index[j])){
					b = "" + alphabet[j];
					textFieldDecryptedText.setText(textFieldDecryptedText.getText() + b);
					break;
				}
			}
		}
	}
}
