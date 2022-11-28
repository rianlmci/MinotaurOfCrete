import javax.swing.*;
import java.awt.*;

/**
 * Game over win screen in the GUI.
 * @author Rianna McIntyre
 * @author Wyatt McCurdy
 */
public class PanelGameOverWin extends JPanel {
    PanelGameOverWin(){
        JLabel beatTheMinotaurLabel = new JLabel("You Beat the Minotaur!");
        beatTheMinotaurLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        beatTheMinotaurLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(beatTheMinotaurLabel);
    }
}
