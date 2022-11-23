import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * The bottom panel which contains all the menu buttons
 * for the game.
 * @author Rianna McIntyre
 * @author Wyatt McCurdy
 */
public class PanelMenuItems extends JPanel {
    protected JButton startButton;
    protected JButton undoButton;
    protected JButton resetButton;
    protected JButton titleButton;
    PanelMenuItems() {
        Font buttonFont = new Font("Yu Gothic", Font.PLAIN, 12);
        Color buttonColor = new Color(255, 128, 255);
        setLayout(new FlowLayout());
        setBorder(new BevelBorder(1));
        setBackground(new Color(255, 255, 255));

        //startButton
        startButton = new JButton("Get Started!");
        startButton.setFont(buttonFont);
        startButton.setForeground(buttonColor);

        //undoButton
        undoButton = new JButton("Undo");
        undoButton.setFont(buttonFont);
        undoButton.setForeground(buttonColor);
        undoButton.setVisible(false);

        //ResetButton
        resetButton = new JButton("Reset");
        resetButton.setFont(buttonFont);
        resetButton.setForeground(buttonColor);
        resetButton.setVisible(false);

        //titleButton
        titleButton = new JButton("Return to Title");
        titleButton.setFont(buttonFont);
        titleButton.setForeground(buttonColor);
        titleButton.setVisible(false);

        //adding all the buttons...
        add(startButton);
        add(undoButton);
        add(resetButton);
        add(titleButton);
    }
}
