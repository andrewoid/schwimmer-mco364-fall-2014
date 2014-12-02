package schwimmer.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	private static final long serialVersionUID = 1L;

	private BufferedImage image;
	private DrawListener listener;

	public Canvas() {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, 0, 0, null);
		
		listener.drawPreview((Graphics2D)g);
		
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setDrawListener(DrawListener listener) {
		this.listener = listener;
	}

}





