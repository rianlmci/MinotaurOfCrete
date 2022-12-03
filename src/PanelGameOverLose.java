import javax.swing.*;
import java.awt.*;

/**
 * Game over win screen in the GUI.
 * @author Wyatt McCurdy
 */
public class PanelGameOverLose extends JPanel {
	private final Color FONT_COLOR = Color.WHITE;
    private final Color BACKGROUND_COLOR = Color.decode("#181A1B");
    
    PanelGameOverLose(){
        FontGetter fontGetter = new FontGetter();
        Font gameOverFont = fontGetter.getFontByName("VCR_OSD_MONO_1.001.ttf");
        gameOverFont = gameOverFont.deriveFont(Font.BOLD,30);
    	setBackground(BACKGROUND_COLOR);
        setLayout(new BorderLayout(0, 0));
        JLabel minotaurWinsLabel = new JLabel("The Minotaur Ate You! :{");
        minotaurWinsLabel.setForeground(FONT_COLOR);
        minotaurWinsLabel.setFont(gameOverFont);
        minotaurWinsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(minotaurWinsLabel);
    }
}
