package schwimmer.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class RectListener implements DrawListener {

	private Options options;
	private Canvas canvas;
	private boolean pressed;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public RectListener(Canvas canvas, Options options) {
		this.canvas = canvas;
		this.options = options;
		pressed = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressed = true;
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
		drawPreview(g);
		
		pressed = false;
		canvas.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void drawPreview(Graphics2D g) {
		if ( !pressed ) {
			return;
		}
		
		int minX = Math.min(x1, x2);
		int minY = Math.min(y1, y2);
		int width = Math.abs(x2 - x1);
		int height = Math.abs(y2 - y1);

		g.setColor(options.getColor());
		g.setStroke(options.getStroke());
		g.drawRect(minX, minY, width, height);
		
	}

}
