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

public class Caesar extends JFrame implements ActionListener {
	private char alphabet[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z' };
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

	public Caesar() {
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

	private void decrypt() {
		String sum = "";
		if (errors())
			for (int i = 0; i < encryptedField.getText().length(); i++) {
				for (int j = 0; j < alphabet.length; j++) {
					if (encryptedField.getText().charAt(i) == alphabet[j]) {
						sum += alphabet[(j
								- Integer.parseInt(keyField.getText()) + alphabet.length)
								% alphabet.length];
						break;
					}

				}
			}
		textField.setText(sum);
		JOptionPane.showMessageDialog(null, sum);
	}

	private void encrypt() {
		String sum = "";
		if (errors())
			for (int i = 0; i < textField.getText().length(); i++) {
				for (int j = 0; j < alphabet.length; j++) {
					if (textField.getText().charAt(i) == alphabet[j]) {
						sum += alphabet[(Integer.parseInt(keyField.getText()) + j)
								% alphabet.length];
						break;
					}

				}
			}
		encryptedField.setText(sum);
	}

	private boolean errors() {
		try {
			Integer.parseInt(keyField.getText());
			return true;
		} catch (java.lang.NumberFormatException e1) {
			JOptionPane.showMessageDialog(null,
					"Key դաշտում պետք է թիվ նեռմուծեք։");
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		textField.setText(textField.getText().toUpperCase());

		if (e.getSource() == encryptButton) {
			encrypt();
		}
		if (e.getSource() == decryptButton) {
			decrypt();
		}
	}

}
