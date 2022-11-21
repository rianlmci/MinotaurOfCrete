import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class PanelMenuItems extends JPanel {
    public JButton startButton;
    public JButton undoButton;
    public JButton resetButton;
    public JButton titleButton;
    PanelMenuItems() {
        setLayout(new FlowLayout());
        setBorder(new BevelBorder(1));
        setBackground(new Color(255, 255, 255));

        //startButton
        startButton = new JButton("Get Started!");
        startButton.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
        startButton.setForeground(new Color(255, 128, 255));

        //undoButton
        undoButton = new JButton("Undo");
        undoButton.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
        undoButton.setForeground(new Color(255, 128, 255));
        undoButton.setVisible(false);

        //ResetButton
        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
        resetButton.setForeground(new Color(255, 128, 255));
        resetButton.setVisible(false);

        //titleButton
        titleButton = new JButton("Return to Title");
        titleButton.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
        titleButton.setForeground(new Color(255, 128, 255));
        titleButton.setVisible(false);

        //adding all the buttons...
        add(startButton);
        add(undoButton);
        add(resetButton);
        add(titleButton);
    }
}
