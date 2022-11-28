import javax.swing.*;
import java.awt.*;

/**
 * Game over screen in the GUI.
 */
public class PanelGameOverLose extends JPanel {
    PanelGameOverLose(){
        JLabel defeatedByTheMinotaurLabel = new JLabel("The Minotaur catches you! GAME OVER!");
        defeatedByTheMinotaurLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        defeatedByTheMinotaurLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(defeatedByTheMinotaurLabel);
    }
}
