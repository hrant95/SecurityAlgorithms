import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Hash extends JFrame implements ActionListener {
	private JTextField textField = new JTextField("Text", 30);
	private JTextField hashedTextField = new JTextField("Hashed text", 30);

	private JButton hashingButton = new JButton("Hashing");

	public Hash() {
		setLayout(new FlowLayout());
		add(textField);
		add(hashingButton);
		add(hashedTextField);
		hashingButton.addActionListener(this);
		setSize(400, 150);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private long[] bin() {
		long bin[] = new long[textField.getText().length()];
		for (int i = 0; i < textField.getText().length(); i++) {
			bin[i] = (long) textField.getText().charAt(i);
		}
		return bin;
	}

	private void Hashing() {
		hashedTextField.setText("");
		long text[] = bin();
		String str;
		long temp = 0;
		for (int i = 0; i < text.length; i++) {
			temp = text[i];
			str = Long.toBinaryString(text[i]);
			for (int j = str.length(); j < 40; j++) {
				text[i] = text[i] << 1;
			}
			temp = (long) Math.pow(temp, Math.sqrt(temp % 10));
			text [i] = text[i] ^ temp;
		}
		long hash = text[0];
		for (int i = 1; i < text.length; i++) {
			hash = hash ^ text[i] ^ (long)Math.sqrt(text[i]);
		}
		str = Long.toHexString(hash);
		hashedTextField.setText(hashedTextField.getText() + str);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == hashingButton) {
			Hashing();
		}
	}
}
