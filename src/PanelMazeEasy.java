import javax.swing.*;
import java.awt.*;

public class PanelMazeEasy extends JPanel {
    PanelMazeEasy(){
        setLayout(new GridLayout(3,7));
        
        JPanel Panel_Neg_3_1 = new JPanel();
        add(Panel_Neg_3_1);
        Panel_Neg_3_1.setLayout(new BorderLayout(0, 0));
        
        JLabel X_NEG_3_Y_1 = new JLabel("(-3,1)");
        Panel_Neg_3_1.add(X_NEG_3_Y_1, BorderLayout.CENTER);
        X_NEG_3_Y_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_NEG_3_1 = new JButton("Go Here");
        BTN_NEG_3_1.setBorder(null);
        BTN_NEG_3_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Panel_Neg_3_1.add(BTN_NEG_3_1, BorderLayout.SOUTH);
        
        JLabel X_NEG_2_Y_1 = new JLabel("(-2,1)");
        X_NEG_2_Y_1.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_NEG_2_Y_1);
        
        JLabel X_NEG_1_Y_1 = new JLabel("(-1,1)");
        X_NEG_1_Y_1.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_NEG_1_Y_1);
        
        JLabel X_0_Y_1_ACTUAL = new JLabel("(0,1)");
        X_0_Y_1_ACTUAL.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_0_Y_1_ACTUAL);
        
        JLabel X_1_Y_1 = new JLabel("(1,1)");
        X_1_Y_1.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_1_Y_1);
        
        JLabel X_2_Y_1 = new JLabel("(2,1)");
        X_2_Y_1.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_2_Y_1);
        
        JLabel X_3_Y_1 = new JLabel("(3,1)");
        X_3_Y_1.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_3_Y_1);
        
        JLabel X_NEG_3_Y_0 = new JLabel("(-3,0)");
        X_NEG_3_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_NEG_3_Y_0);
        
        JLabel X_NEG_2_Y_0 = new JLabel("(-2,0)");
        X_NEG_2_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_NEG_2_Y_0);
        
        JLabel X_NEG_1_Y_0 = new JLabel("(-1,0)");
        X_NEG_1_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_NEG_1_Y_0);
        
        JLabel X_0_Y_0 = new JLabel("(0,0)");
        X_0_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_0_Y_0);
        
        JLabel X_1_Y_0 = new JLabel("(1,0)");
        X_1_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_1_Y_0);
        
        JLabel X_2_Y_0 = new JLabel("(2,0)");
        X_2_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_2_Y_0);
        
        JLabel X_3_Y_0 = new JLabel("(3,0)");
        X_3_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_3_Y_0);
        
        JLabel X_0_Y_1_12 = new JLabel("(0,1)");
        X_0_Y_1_12.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_0_Y_1_12);
        
        JLabel X_0_Y_1_11 = new JLabel("(0,1)");
        X_0_Y_1_11.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_0_Y_1_11);
        
        JLabel X_0_Y_1_13 = new JLabel("(0,1)");
        X_0_Y_1_13.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_0_Y_1_13);
        
        JLabel X_0_Y_1_15 = new JLabel("(0,1)");
        X_0_Y_1_15.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_0_Y_1_15);
        
        JLabel X_0_Y_1_14 = new JLabel("(0,1)");
        X_0_Y_1_14.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_0_Y_1_14);
        
        JLabel X_0_Y_1_16 = new JLabel("(0,1)");
        X_0_Y_1_16.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_0_Y_1_16);
        
        JLabel X_0_Y_1_17 = new JLabel("(0,1)");
        X_0_Y_1_17.setHorizontalAlignment(SwingConstants.CENTER);
        add(X_0_Y_1_17);
    }
}
