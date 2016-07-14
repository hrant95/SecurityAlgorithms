import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ParzPoxarinum extends JFrame implements ActionListener {
	private String key;
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private JPanel textFieldPanel = new JPanel();
	private JLabel textFieldLabel = new JLabel("Text: ");
	private JTextField textField = new JTextField(30);
	// /
	private JPanel encryptedFieldPanel = new JPanel();
	private JLabel encryptedFieldLabel = new JLabel("Encrypted text: ");
	private JTextField encryptedField = new JTextField(25);
	// /
	private JPanel keyFieldPanel = new JPanel();
	private JLabel keyFieldLabel = new JLabel("Key: ");
	private JTextField keyField = new JTextField(20);
	// /
	private JButton encryptButton = new JButton("Encrypt");
	private JButton decryptButton = new JButton("Decrypt");

	public ParzPoxarinum() {
		setLayout(new FlowLayout());
		add(textFieldPanel);
		textFieldPanel.add(textFieldLabel);
		textFieldPanel.add(textField);
		// /
		add(encryptedFieldPanel);
		encryptedFieldPanel.add(encryptedFieldLabel);
		encryptedFieldPanel.add(encryptedField);
		// /
		keyFieldPanel.setPreferredSize(new Dimension(390, 30));
		add(keyFieldPanel);
		keyFieldPanel.add(keyFieldLabel);
		keyFieldPanel.add(keyField);
		// /
		add(encryptButton);
		encryptButton.addActionListener(this);
		//
		add(decryptButton);
		decryptButton.addActionListener(this);
		// /

		setSize(400, 200);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private String key() {
		char[] array = alphabet.toCharArray();
		String sum = "";
		keyField.setText(keyField.getText().toUpperCase());
		keyField.setText((String)keyField.getText().replaceAll("(.)\\1{1,}", "$1"));
		for (int i = 0; i < keyField.getText().length(); i++) {
			for (int j = 0; j < alphabet.length(); j++) {
				if (keyField.getText().charAt(i) == alphabet.charAt(j)) {
					array[j] = ' ';
					break;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			sum += array[i] + "";
		}
		sum = sum.replace(" ", "");
		sum = keyField.getText() + sum;
		return sum;
	}

	private void encrypt() {
		key = key();
		encryptedField.setText("");
		for (int i = 0; i < textField.getText().length(); i++) {
			for (int j = 0; j < alphabet.length(); j++) {
				if(textField.getText().charAt(i) == alphabet.charAt(j)){
					encryptedField.setText(encryptedField.getText() + key.charAt(j));
					break;
				}
			}
		}
	}
	private void decrypt() {
		key = key();
		textField.setText("");
		for (int i = 0; i < encryptedField.getText().length(); i++) {
			for (int j = 0; j < key.length(); j++) {
				if(encryptedField.getText().charAt(i) == key.charAt(j)){
					textField.setText(textField.getText() + alphabet.charAt(j));
					break;
				}
			}
		}
		JOptionPane.showMessageDialog(null, textField.getText());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == encryptButton) {
			textField.setText(textField.getText().toUpperCase());
			encrypt();
		}
		if (e.getSource() == decryptButton) {
			encryptedField.setText(encryptedField.getText().toUpperCase());
			decrypt();
		}
	}

}
