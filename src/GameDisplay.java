import javax.swing.*;
import java.awt.BorderLayout;

public class GameDisplay extends JFrame {
	public GameDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
	}
    // = = = = = TEST CLIENT = = = = = //
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
