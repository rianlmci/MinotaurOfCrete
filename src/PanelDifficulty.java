import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Title screen in the GUI.
 * @author Rianna McIntyre
 * @author Wyatt McCurdy
 */
public class PanelDifficulty extends JPanel {
    protected JButton easyButton;
    protected JButton mediumButton;
    protected JButton hardButton;
    PanelDifficulty(){
        setLayout(new FlowLayout());
        setBackground(null);
        setBorder(new EmptyBorder(20,0,40,0)); //Pseudo padding for menu items

        JButton easyButton = createMenuButton("Easy");
        JButton mediumButton = createMenuButton("Medium");
        JButton hardButton = createMenuButton("Hard");
        add(easyButton);
        add(mediumButton);
        add(hardButton);
    }
    
    /**
     * Styler for all buttons in the menu.
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
		button.setBorder(new EmptyBorder(10,10,10,10)); //Pseudo-margin for button
        return button;
    }
}
