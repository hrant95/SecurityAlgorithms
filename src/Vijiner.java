import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Vijiner extends JFrame implements ActionListener {
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private char[] alphabetArray = alphabet.toCharArray();
	private JLabel labelText = new JLabel("Text:");
	private JTextField textFieldText = new JTextField(30);
	// //////
	private JLabel labelEncryptedText = new JLabel("Encrypted text:");
	private JTextField textFieldEncryptedText = new JTextField(25);
	// /////
	private JLabel labelDecryptedText = new JLabel("Decrypted text:");
	private JTextField textFieldDecryptedText = new JTextField(25);
	// /////
	private JLabel labelKey = new JLabel("Key:");
	private JTextField textFieldKey = new JTextField(31);
	// /////
	private JButton buttonEncrypt = new JButton("Encrypt");
	// /////
	private JButton buttonDecrypt = new JButton("Decrypt");

	public Vijiner() {

		setLayout(new FlowLayout());
		add(labelText);
		add(textFieldText);
		// ////
		add(labelEncryptedText);
		add(textFieldEncryptedText);
		// ////
		add(labelDecryptedText);
		add(textFieldDecryptedText);
		// ////
		add(labelKey);
		add(textFieldKey);
		// ////
		add(buttonEncrypt);
		buttonEncrypt.addActionListener(this);
		// ////
		add(buttonDecrypt);
		buttonDecrypt.addActionListener(this);
		setResizable(false);
		setSize(400, 200);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == buttonEncrypt) {
			encrypt(textFieldText, textFieldKey);
		}
		if (e.getSource() == buttonDecrypt) {
			//decrypt(textFieldEncryptedText, textFieldKey);
		}
	}

	private void encrypt(JTextField text, JTextField k) {
		text.setText(text.getText().replace(" ", ""));
		text.setText(text.getText().toUpperCase());
		String s1 = "";
		int index = 0;
		for (int i = 0; i < text.getText().length(); i++) {
			if (index == k.getText().length()) {
				index = 0;
			}
			s1 += k.getText().charAt(index);
			index++;
		}
		s1 = s1.toUpperCase();
		k.setText(k.getText().toUpperCase());
		textFieldEncryptedText.setText("");
		int textIndex = 0, kIndex = 0;
		// /////////
		for (int i = 0; i < text.getText().length(); i++) {
			for (int j = 0; j < alphabetArray.length; j++) {
				if (text.getText().charAt(i) == alphabetArray[j]) {
					textIndex = j;
					break;
				}
			}
			for (int j = 0; j < alphabetArray.length; j++) {
				if (s1.charAt(i) == alphabetArray[j]) {
					kIndex = j;
					break;
				}
			}

			textFieldEncryptedText.setText(textFieldEncryptedText.getText()
					+ alphabetArray[(kIndex + textIndex) % 26]);
		}
	}
	
	private void decrypt(JTextField eText, JTextField k){
		
		String s1 = "";
		int index = 0;
		for (int i = 0; i < eText.getText().length(); i++) {
			if (index == k.getText().length()) {
				index = 0;
			}
			s1 += k.getText().charAt(index);
			index++;
		}
		s1 = s1.toUpperCase();
		k.setText(k.getText().toUpperCase());
		int eTextIndex = 0, kIndex = 0; 
		////////////
		textFieldDecryptedText.setText("");
		for (int i = 0; i < alphabetArray.length; i++) {
			for (int j = 0; j < eText.getText().length(); j++) {
				if(eText.getText().charAt(i) == alphabetArray[j]){
					eTextIndex = j;
					System.out.println(j);
					break;
				}
			}
			for (int j = 0; j < s1.length(); j++) {
				if(s1.charAt(i) == alphabetArray[j]){
					kIndex = j;
					System.out.println(j);
					break;
				}
			}
			
			textFieldDecryptedText.setText(textFieldDecryptedText.getText() + alphabetArray[(eTextIndex - kIndex + 26) % 26]);
		}
	}
}
