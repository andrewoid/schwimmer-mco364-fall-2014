package schwimmer.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface DrawListener 
	extends MouseListener, MouseMotionListener {

	/**
	 * This method is meant to be called by the Canvas class.
	 * If the DrawListener has any kind of preview before mouseReleased() then
	 * it should be drawn here.
	 * The Graphics2D object should be from paintComponent()
	 */
	void drawPreview(Graphics2D g);
	
	
}
