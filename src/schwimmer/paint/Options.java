package schwimmer.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

public class Options {

	private Stroke stroke;
	private float strokeWidth;
	private Color color;
	
	public Options() {
		strokeWidth = 5;
		stroke = new BasicStroke(5.0f,
                BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND);
		color = Color.BLACK;
	}
	
	public float getStrokeWidth() {
		return strokeWidth;
	}
	public void setStrokeWidth(float strokeWidth) {
		this.strokeWidth = strokeWidth;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Stroke getStroke() {
		return stroke;
	}
	
}
