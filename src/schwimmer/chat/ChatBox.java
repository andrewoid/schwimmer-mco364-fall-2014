package schwimmer.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatBox extends JFrame implements ActionListener {

	private JTextArea area;
	private JTextField field;
	private JButton button;
	private Socket socket;

	public ChatBox(String title) {
		
		setSize(800,600);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		area = new JTextArea();
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		field = new JTextField();
		button = new JButton("SEND");
		panel.add(field);
		panel.add(button);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(area), BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		button.addActionListener(this);
		
	}

	public JTextArea getArea() {
		return area;
	}

	public JTextField getField() {
		return field;
	}

	public JButton getButton() {
		return button;
	}
	
	public void append( String text ) {
		area.append(text);
		area.append("\n");
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	public void send(String s) throws IOException {
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.println(s);
		out.flush();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			send(getField().getText());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
