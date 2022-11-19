import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class GameDisplay2 {

	private JFrame frame;
	private JTextField txtYouWin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameDisplay2 window = new GameDisplay2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameDisplay2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 945, 605);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		txtYouWin = new JTextField();
		txtYouWin.setText("You win!");
		panel.add(txtYouWin);
		txtYouWin.setColumns(10);
	}

}
