import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameDisplay extends JFrame {

	//Display Containers
	private static JPanel outerContainer = new JPanel(new BorderLayout());
	private static CardLayout cardDeck = new CardLayout();
	private static JPanel gameContent = new JPanel(cardDeck);

	//Game Screens
	private static PanelMenuItems panelMenuItems = new PanelMenuItems();
	private static PanelTitle panelTitle = new PanelTitle();
	private static PanelGameOverWin panelGameOverWin= new PanelGameOverWin();

	public GameDisplay() {
		setSize(1000, 700);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//adds each card and their aliases to the game content panel
		gameContent.add(panelTitle, "Title");
		gameContent.add(panelGameOverWin, "Win");
		getContentPane().add(panelMenuItems, BorderLayout.SOUTH);
		setButtonLogic();
		outerContainer.add(gameContent,SwingConstants.CENTER);
		add(outerContainer);
		setVisible(true);
	}

	public void setButtonLogic(){
		//Start Button
		panelMenuItems.startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardDeck.show(gameContent,"Win");
				panelMenuItems.startButton.setVisible(false);
				panelMenuItems.titleButton.setVisible(true);

			}
		});

		//(Return to) Title Button
		panelMenuItems.titleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardDeck.show(gameContent,"Title");
				panelMenuItems.startButton.setVisible(true);
				panelMenuItems.titleButton.setVisible(false);
			}
		});
	}
	// = = = = = TEST CLIENT = = = = = //
	public static void main(String[] args) {

	}
}
