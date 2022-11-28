import javax.swing.*;
import java.awt.*;

/**
 * Game over win screen in the GUI.
 * @author Wyatt McCurdy
 */
public class PanelGameOverLose extends JPanel {
    PanelGameOverLose(){
        JLabel minotaurWinsLabel = new JLabel("The Minotaur Ate You! :{");
        minotaurWinsLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        minotaurWinsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(minotaurWinsLabel);
    }
}
