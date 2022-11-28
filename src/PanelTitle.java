import javax.swing.*;
import java.awt.*;

/**
 * Title screen in the GUI.
 * @author Rianna McIntyre
 * @author Wyatt McCurdy
 */
public class PanelTitle extends JPanel {

    //Look and feel:
    private final Color BACKGROUND_COLOR = Color.decode("#181A1B"); //hex code decoder, a charcoal color.

    PanelTitle(){
        setLayout(new GridLayout()); //this centers the art vertically for some reason? It's what I want, so.
        setBackground(BACKGROUND_COLOR);
        JLabel minotaurArtLabel = new JLabel();
        minotaurArtLabel.setHorizontalAlignment(SwingConstants.CENTER);
        minotaurArtLabel.setIcon(new ImageIcon(GameDisplay.class.getResource("/resources/Minotaur.png")));
        add(minotaurArtLabel);
    }
}
