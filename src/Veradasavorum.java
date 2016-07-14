import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Veradasavorum extends JFrame implements ActionListener {

	private JLabel labelText = new JLabel("Text:");
	private JTextField textFieldText = new JTextField(30);
	// //////
	private JLabel labelEncryptedText = new JLabel("Encrypted text:");
	private JTextField textFieldEncryptedText = new JTextField(25);
	// /////
	private JLabel labelDecryptedText = new JLabel("Decrypted text:");
	private JTextField textFieldDecryptedText = new JTextField(25);
	// /////
	private JLabel labelKey = new JLabel("Key num:");
	private JTextField textFieldKey = new JTextField(31);
	// /////
	private JButton buttonEncrypt = new JButton("Encrypt");
	// /////
	private JButton buttonDecrypt = new JButton("Decrypt");
	////////
	public Veradasavorum() {

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
		if (e.getSource() == buttonEncrypt) {
			encrypt(textFieldText, textFieldKey);
		}
		if (e.getSource() == buttonDecrypt) {
			decrypt(textFieldEncryptedText,textFieldKey);
		}	
	}
	private void encrypt(JTextField t,JTextField k){
		t.setText(t.getText().replace(" ", ""));
		t.setText(t.getText().toUpperCase());
		k.setText(k.getText().replace(" ", ""));
		int key = Integer.parseInt(k.getText());
		String text = t.getText(), sum = "";
		if((text.length() % key) < key){
			for (int i = 0; i < text.length() + (text.length() % key); i++) {
				if(i > text.length()){
					text += "Z";
				}
			}
		}
		System.out.println(text + text.length());
		//matrix[][] = new String[k.getText().length()][5];
		int index = 0;
		String matrix[][] = new String[text.length() / key][key];
		////////// matrix - initialization
		for (int i = 0; i < text.length() / key; i++) {
			for (int j = 0; j < key; j++) {
				matrix[i][j] = text.charAt(index) + "";
				System.out.print(matrix[i][j]);
				index++;
			}System.out.println();
		}System.out.println();
		textFieldEncryptedText.setText("");
		///////////// encrypt
		for (int i = 0; i < key; i++) {
			for (int j = 0; j < text.length() / key; j++) {
				textFieldEncryptedText.setText(textFieldEncryptedText.getText() + matrix[j][i]);
				index++;
			}
		}
	}
	
	private void decrypt(JTextField t,JTextField k){
		String text = t.getText();
		k.setText(k.getText().replace(" ", ""));
		text = text.replace(" ", "");
		int key = Integer.parseInt(k.getText());
		int index = 0;
		String matrix[][] = new String[key][text.length() / key];
		System.out.println();
		////////// matrix - initialization
		for (int i = 0; i < key; i++) {
			for (int j = 0; j < text.length() / key; j++) {
				matrix[i][j] = text.charAt(index) + "";
				System.out.print(matrix[i][j]);
				index++;
			}System.out.println();
		}
		////// decrypt
		textFieldDecryptedText.setText("");
		for (int i = 0; i < text.length() / key; i++) {
			for (int j = 0; j < key; j++) {
				textFieldDecryptedText.setText(textFieldDecryptedText.getText() + matrix[j][i]);
			}
		}
		
		System.out.println();
		
	}
	}
