

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Playfair extends JFrame implements ActionListener {

	private JTextArea textAreaText = new JTextArea(15, 30);
	private JTextArea textAreaEncryptedText = new JTextArea(15, 30);
	private JTextArea textAreaDecryptedText = new JTextArea(15, 30);
	private JTextField textFiledKey = new JTextField(40);
	private JLabel labelForKey = new JLabel("Key");
	private JButton buttonEncrypt = new JButton("Encrypt");
	private JButton buttonDecrypt = new JButton("Decrypt");

	Playfair() {
		setLayout(new FlowLayout());
		add(textAreaText);
		add(textAreaEncryptedText);
		add(textAreaDecryptedText);
		add(labelForKey);
		add(textFiledKey);

		add(buttonEncrypt);
		add(buttonDecrypt);
		buttonEncrypt.addActionListener(this);
		buttonDecrypt.addActionListener(this);
		setSize(1030, 350);
		setMinimumSize(new Dimension(1030, 350));
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == buttonEncrypt) {
			textAreaText.setText(textAreaText.getText().toUpperCase());
			textFiledKey.setText(textFiledKey.getText().toUpperCase());
			encrypte();
		}
		if (e.getSource() == buttonDecrypt) {
			decrypt();
		}
	}

	private String key() {
		String alph = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		String key = textFiledKey.getText();
		key = key.replace(" ", "");
		key = key.toUpperCase();
		key = key.replace("J", "");
		
		char[] keyArray = key.toCharArray();
		for (int i = 0; i < keyArray.length; i++) {
			for (int j = i + 1; j < keyArray.length; j++) {
				if(keyArray[i] == keyArray[j]){
					keyArray[j] = ' ';					
				}
			}
		}
		String sum = " ";
		for (int i = 0; i < keyArray.length; i++) {
			sum += keyArray[i];
		}
		sum = sum.replace(" ", "");
		char[] array = sum.toCharArray();
		
		String a;
		for (char c : array) {
			
			for (int i = 0; i < alph.length(); i++) {
				if (c == alph.charAt(i)) {
					a = "" + c;
					alph = alph.replace(a, "");
					a = "";
				}
			}
		}
		key = sum + alph;
		
		return key;
	}

	private void encrypte() {

		int index = 0;
		char matrix[][] = new char[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matrix[i][j] = key().charAt(index);
				index++;
			}
		}
		// ////////////////////////////
		String text = textAreaText.getText();
		text = text.replace(" ", "");
		text = text.toUpperCase();
		text = text.replace("J", "I");
		// /////////////////////
		if (text.length() % 2 != 0)
			text += " ";
		char[] textArray = text.toCharArray();
		String textSum = "";
		for (int i = 0; i < textArray.length - 1; i += 2) {
			if (textArray[i] == textArray[i + 1]) {
				textSum = textSum + textArray[i] + "Z" + textArray[i + 1];
			} else {
				textSum = textSum + textArray[i] + textArray[i + 1];
			}
		}
		textSum = textSum.replace(" ", "");
		if (textSum.length() % 2 != 0) {
			textSum += "Z";
		}
		char[] array = textSum.toCharArray();
		// //////////////////////////////////////

		for (int i = 0; i < array.length - 1; i += 2) {

			int I1 = 0, J1 = 0;
			int I2 = 0, J2 = 0;
			;
			for (int j = 0; j < 5; j++) {
				for (int j2 = 0; j2 < 5; j2++) {
					if (array[i] == matrix[j][j2]) {
						I1 = j;
						J1 = j2;
						break;
					}
				}

			}
			// ///
			for (int j = 0; j < 5; j++) {

				for (int j2 = 0; j2 < 5; j2++) {
					if (array[i + 1] == matrix[j][j2]) {
						I2 = j;
						J2 = j2;
						break;
					}
				}
			}

			if (I1 != I2 && J1 != J2) {
				array[i] = matrix[I1][J2];
				array[i + 1] = matrix[I2][J1];
			}
			// ///////////////////
			if (I1 == I2) {
				if (J1 == 4) {
					array[i] = matrix[I1][0];
				} else {
					array[i] = matrix[I1][J1 + 1];
				}
				if (J2 == 4) {
					array[i + 1] = matrix[I2][0];
				} else {
					array[i + 1] = matrix[I2][J2 + 1];
				}
			}
		}
		String sum = "";
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		textAreaEncryptedText.setText(sum);
	}

	private void decrypt() {
		int index = 0;
		char matrix[][] = new char[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				matrix[i][j] = key().charAt(index);
				System.out.print(matrix[i][j] + " ");
				index++;
			}System.out.println();
		}
		// ////////////////////////
		char[] array = textAreaEncryptedText.getText().toCharArray();
		for (int i = 0; i < array.length - 1; i += 2) {

			int I1 = 0, J1 = 0;
			int I2 = 0, J2 = 0;
			;
			for (int j = 0; j < 5; j++) {
				for (int j2 = 0; j2 < 5; j2++) {
					if (array[i] == matrix[j][j2]) {
						I1 = j;
						J1 = j2;
						break;
					}
				}

			}
			// ///
			for (int j = 0; j < 5; j++) {

				for (int j2 = 0; j2 < 5; j2++) {
					if (array[i + 1] == matrix[j][j2]) {
						I2 = j;
						J2 = j2;
						break;
					}
				}
			}

			if (I1 != I2 && J1 != J2) {
				array[i] = matrix[I1][J2];
				array[i + 1] = matrix[I2][J1];
			}
			// ///////////////////
			if (I1 == I2) {
				if(J1 == 0)
				{
					array[i] = matrix[I1][4];
				} else {
					array[i] = matrix[I1][J1 - 1];
				}
				if(J2 == 0)
				{
					array[i + 1] = matrix[I2][4];
				} else {
					array[i + 1] = matrix[I2][J2 - 1];
				}
				
			}
			
		}
		String sum = "";
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		textAreaDecryptedText.setText(sum);
	}

}
