package schwimmer.paint;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Paint extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Paint() {
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Paint");
		setLocationRelativeTo(null);
		
		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);
		
		DrawListener listener = new DrawListener(canvas);
		
		canvas.addMouseMotionListener(listener);
		
	}

	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.setVisible(true);
	}

}
