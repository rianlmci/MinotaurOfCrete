import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.BevelBorder;
import java.awt.Font;

public class GameDisplay extends JFrame {
	public GameDisplay() {
		setSize(1000, 700);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
//		panel_1.add(new JLabel();
		panel_1.setBounds(0, 0, 986, 620);
		layeredPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GameDisplay.class.getResource("/resources/Minotaur.png")));
		panel_1.add(lblNewLabel);

//		JLabel lblNewLabel = new JLabel("hi!");
//		panel_1.add(lblNewLabel);
		
//		Label label = new Label();
//		panel_1.add(label);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 986, 620);
		layeredPane.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("You Beat the Minotaur!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel, BorderLayout.SOUTH);

		JButton getStarted = new JButton("Get Started!");
		getStarted.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel_2);
				layeredPane.repaint();
				layeredPane.revalidate();

			}
		});
		getStarted.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		getStarted.setForeground(new Color(255, 128, 255));
		panel.add(getStarted);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameDisplay frame = new GameDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
