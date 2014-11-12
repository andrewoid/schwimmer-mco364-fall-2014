package schwimmer.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseMotionListener {

	private Canvas canvas;

	public DrawListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// The magic happens here!
		
		canvas.setPoint( event.getX(), event.getY() );
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent event) {

	}

}
