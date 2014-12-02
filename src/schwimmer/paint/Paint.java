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
		
		Options options = new Options();
		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);
		
		//DrawListener listener = new PencilListener(canvas);
		DrawListener listener = new RectListener(canvas, options);

		canvas.addMouseListener(listener);
		canvas.addMouseMotionListener(listener);
		canvas.setDrawListener(listener);
		
	}

	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.setVisible(true);
	}

}
