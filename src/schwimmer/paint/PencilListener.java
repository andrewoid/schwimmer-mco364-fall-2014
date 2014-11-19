package schwimmer.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PencilListener implements MouseListener, MouseMotionListener {

	private Canvas canvas;
	private int previousX;
	private int previousY;

	public PencilListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// The magic happens here!
		
		Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
		g.setColor(Color.BLACK);
		g.drawLine(event.getX(), event.getY(), previousX, previousY);
		previousX = event.getX();
		previousY = event.getY();
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent event) {

	}

	@Override
	public void mouseClicked(MouseEvent event) {
	}

	@Override
	public void mouseEntered(MouseEvent event) {
		
	}

	@Override
	public void mouseExited(MouseEvent event) {
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		previousX = event.getX();
		previousY = event.getY();
		
		Graphics2D g = (Graphics2D) canvas.getImage().getGraphics();
		g.setColor(Color.BLACK);
        g.fillRect(previousX, previousY, 1, 1);
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		
	}

}
