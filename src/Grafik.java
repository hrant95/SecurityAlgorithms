import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Grafik extends JFrame {
	private String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int[] masiv;
	private int length;

	public Grafik(int masiv[], int length) {
		this.masiv = masiv;
		this.length = length;
		setSize(300, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(255, 0, 0));
		int x;
		int index = 0;
		for (int y = 50; y < 600; y += 20) {
			x = 40;
			g.drawString(str.charAt(index) + "", 15, y + 12);
			for (int i1 = 0; i1 < masiv[index]; i1++) {
				g.fillRect(x, y, 15, 15);
				x += 10;
			}
			g.drawString(Double.toString((double)masiv[index] / (double)length * 100),
					x + 15, y + 12);
			index++;
		}
		super.paint(g);
	}
}
