import javax.swing.*;
import java.awt.*;

/**
 * Game over screen in the GUI.
 */
public class PanelGameOverWin extends JPanel {
    PanelGameOverWin(){
        setBounds(0, 0, 986, 620);

        JLabel beatTheMinotaurLabel = new JLabel("You Beat the Minotaur!");
        beatTheMinotaurLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        beatTheMinotaurLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
