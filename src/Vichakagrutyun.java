import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Vichakagrutyun extends JFrame implements ActionListener {
	private JTextField textField = new JTextField(25);
	private JButton okButton = new JButton("Ok");
	private String alp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public int masiv[] = new int[alp.length()];

	public Vichakagrutyun() {

		setLayout(new FlowLayout());
		add(textField);
		add(okButton);
		okButton.addActionListener(this);
		setSize(400, 100);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void function() {
		String text = textField.getText().toString();
		text = text.toUpperCase();
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < alp.length(); j++) {
				if (text.charAt(i) == alp.charAt(j)) {
					masiv[j]++;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == okButton) {
			function();
			new Grafik(masiv, textField.getText().toString().length());
		}
	}

}
