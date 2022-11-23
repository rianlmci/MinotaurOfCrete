import javax.swing.*;
import java.awt.*;

/**
 * Game over win screen in the GUI.
 * @author Wyatt McCurdy
 */
public class PanelGameOverLose extends JPanel {
    PanelGameOverLose(){
        //setBounds(0, 0, 986, 620);

        JLabel minotaurWins = new JLabel("The Minotaur Ate You! :{");
        minotaurWins.setFont(new Font("Tahoma", Font.BOLD, 20));
        minotaurWins.setHorizontalAlignment(SwingConstants.CENTER);
        add(minotaurWins);
    }
}
