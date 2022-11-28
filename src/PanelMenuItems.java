import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        setLayout(new FlowLayout());
        setBackground(null);
        setBorder(new EmptyBorder(20,0,40,0)); //Pseudo padding for menu items

        //startButton
        startButton = createMenuButton("Get Started!");

        //undoButton
        undoButton = createMenuButton("Undo");
        undoButton.setVisible(false);

        //ResetButton
        resetButton = createMenuButton("Reset");
        resetButton.setVisible(false);

        //titleButton
        titleButton = createMenuButton("Return to Title");
        titleButton.setVisible(false);

        //adding all the buttons...
        add(startButton);
        add(undoButton);
        add(resetButton);
        add(titleButton);
    }

    /**
     * Helper method that styles all buttons in the menu.
     * @param menuButtonText
     * @return a button that's styled for the game menu.
     */
    private JButton createMenuButton(String menuButtonText) {
        //look and feel of buttons:
        FontGetter fontGetter = new FontGetter();
        Font buttonFont = fontGetter.getFontByName("VCR_OSD_MONO_1.001.ttf");
        buttonFont = buttonFont.deriveFont(Font.PLAIN,25);
        Color fontColor = Color.WHITE;
        //Color fontColor = new Color(255, 128, 255); //magenta
        Color backgroundColor = Color.DARK_GRAY;

        //sets the style of the buttons
        JButton button = new JButton(menuButtonText);
        button.setFocusable(false);
        button.setFont(buttonFont);
        button.setForeground(fontColor);
        button.setBackground(backgroundColor);
		button.setFocusable(false);
		button.setBorder(new EmptyBorder(10,10,10,10));
        return button;
    }
}
