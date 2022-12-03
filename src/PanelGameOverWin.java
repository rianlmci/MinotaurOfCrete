import javax.swing.*;
import java.awt.*;

/**
 * Game over win screen in the GUI.
 * @author Rianna McIntyre
 * @author Wyatt McCurdy
 */
public class PanelGameOverWin extends JPanel {
	private final Color FONT_COLOR = Color.WHITE;
    private final Color BACKGROUND_COLOR = Color.decode("#181A1B");
    
    PanelGameOverWin(){
    	// Font look and feel
        FontGetter fontGetter = new FontGetter();
        Font gameWinFont = fontGetter.getFontByName("VCR_OSD_MONO_1.001.ttf");
        gameWinFont = gameWinFont.deriveFont(Font.BOLD,30);
    	setBackground(BACKGROUND_COLOR);
        setLayout(new BorderLayout(0, 0));
        
        JLabel beatTheMinotaurLabel = new JLabel("You Beat the Minotaur!");
        beatTheMinotaurLabel.setForeground(FONT_COLOR);
        beatTheMinotaurLabel.setFont(gameWinFont);
        beatTheMinotaurLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(beatTheMinotaurLabel);
    }
}
