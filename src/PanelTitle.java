import javax.swing.*;

/**
 * Title screen in the GUI.
 */
public class PanelTitle extends JPanel {
    PanelTitle(){
        //setBounds(0, 0, 986, 620);
        JLabel minotaurArtLabel = new JLabel();
        minotaurArtLabel.setIcon(new ImageIcon(GameDisplay.class.getResource("/resources/Minotaur2.png")));
        add(minotaurArtLabel);
    }
}
