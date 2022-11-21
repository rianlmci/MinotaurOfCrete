import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        
        JPanel Panel_Neg_2_1 = new JPanel();
        add(Panel_Neg_2_1);
        
        JLabel X_NEG_2_Y_1 = new JLabel("(-2,1)");
        Panel_Neg_2_1.add(X_NEG_2_Y_1);
        X_NEG_2_Y_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_NEG_2_1 = new JButton("Go Here");
        Panel_Neg_2_1.add(BTN_NEG_2_1);
        
        JPanel Panel_Neg_1_1 = new JPanel();
        add(Panel_Neg_1_1);
        
        JLabel X_NEG_1_Y_1 = new JLabel("(-1,1)");
        Panel_Neg_1_1.add(X_NEG_1_Y_1);
        X_NEG_1_Y_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_NEG_1_1 = new JButton("Go Here");
        Panel_Neg_1_1.add(BTN_NEG_1_1);
        
        JPanel Panel_0_1 = new JPanel();
        add(Panel_0_1);
        
        JLabel X_0_Y_1_ACTUAL = new JLabel("(0,1)");
        Panel_0_1.add(X_0_Y_1_ACTUAL);
        X_0_Y_1_ACTUAL.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_0_1 = new JButton("Go Here");
        Panel_0_1.add(BTN_0_1);
        
        JPanel Panel_1_1 = new JPanel();
        add(Panel_1_1);
        
        JLabel X_1_Y_1 = new JLabel("(1,1)");
        Panel_1_1.add(X_1_Y_1);
        X_1_Y_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_1_1 = new JButton("Go Here");
        Panel_1_1.add(BTN_1_1);
        
        JPanel Panel_2_1 = new JPanel();
        add(Panel_2_1);
        
        JLabel X_2_Y_1 = new JLabel("(2,1)");
        Panel_2_1.add(X_2_Y_1);
        X_2_Y_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_2_1 = new JButton("Go Here");
        Panel_2_1.add(BTN_2_1);
        
        JPanel Panel_3_1 = new JPanel();
        add(Panel_3_1);
        
        JLabel X_3_Y_1 = new JLabel("(3,1)");
        Panel_3_1.add(X_3_Y_1);
        X_3_Y_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_3_1 = new JButton("Go Here");
        Panel_3_1.add(BTN_3_1);
        
        JPanel Panel_Neg_3_0 = new JPanel();
        add(Panel_Neg_3_0);
        
        JLabel X_NEG_3_Y_0 = new JLabel("(-3,0)");
        Panel_Neg_3_0.add(X_NEG_3_Y_0);
        X_NEG_3_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_NEG_3_0 = new JButton("Go Here");
        Panel_Neg_3_0.add(BTN_NEG_3_0);
        
        JPanel Panel_Neg_2_0 = new JPanel();
        add(Panel_Neg_2_0);
        
        JLabel X_NEG_2_Y_0 = new JLabel("(-2,0)");
        Panel_Neg_2_0.add(X_NEG_2_Y_0);
        X_NEG_2_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_NEG_2_0 = new JButton("Go Here");
        Panel_Neg_2_0.add(BTN_NEG_2_0);
        
        JPanel Panel_Neg_1_0 = new JPanel();
        add(Panel_Neg_1_0);
        
        JLabel X_NEG_1_Y_0 = new JLabel("(-1,0)");
        Panel_Neg_1_0.add(X_NEG_1_Y_0);
        X_NEG_1_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_NEG_1_0 = new JButton("Go Here");
        Panel_Neg_1_0.add(BTN_NEG_1_0);
        
        JPanel Panel_0_0 = new JPanel();
        add(Panel_0_0);
        
        JLabel X_0_Y_0 = new JLabel("(0,0)");
        Panel_0_0.add(X_0_Y_0);
        X_0_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_0_0 = new JButton("Go Here");
        Panel_0_0.add(BTN_0_0);
        
        JPanel Panel_1_0 = new JPanel();
        add(Panel_1_0);
        
        JLabel X_1_Y_0 = new JLabel("(1,0)");
        Panel_1_0.add(X_1_Y_0);
        X_1_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_1_0 = new JButton("Go Here");
        Panel_1_0.add(BTN_1_0);
        
        JPanel Panel_2_0 = new JPanel();
        add(Panel_2_0);
        
        JLabel X_2_Y_0 = new JLabel("(2,0)");
        Panel_2_0.add(X_2_Y_0);
        X_2_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_2_0 = new JButton("Go Here");
        Panel_2_0.add(BTN_2_0);
        
        JPanel Panel_3_0 = new JPanel();
        add(Panel_3_0);
        
        JLabel X_3_Y_0 = new JLabel("(3,0)");
        Panel_3_0.add(X_3_Y_0);
        X_3_Y_0.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_3_0 = new JButton("Go Here");
        Panel_3_0.add(BTN_3_0);
        
        JPanel Panel_Neg_3_Neg_1 = new JPanel();
        add(Panel_Neg_3_Neg_1);
        
        JLabel X_NEG_3_Y_NEG_1 = new JLabel("(-3,-1)");
        Panel_Neg_3_Neg_1.add(X_NEG_3_Y_NEG_1);
        X_NEG_3_Y_NEG_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_NEG_3_NEG_1 = new JButton("Go Here");
        Panel_Neg_3_Neg_1.add(BTN_NEG_3_NEG_1);
        
        JPanel Panel_Neg_2_Neg_1 = new JPanel();
        add(Panel_Neg_2_Neg_1);
        
        JLabel X_NEG_2_Y_NEG_1 = new JLabel("(-2,-1)");
        Panel_Neg_2_Neg_1.add(X_NEG_2_Y_NEG_1);
        X_NEG_2_Y_NEG_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_NEG_2_NEG_1 = new JButton("Go Here");
        Panel_Neg_2_Neg_1.add(BTN_NEG_2_NEG_1);
        
        JPanel Panel_Neg_1_Neg_1 = new JPanel();
        add(Panel_Neg_1_Neg_1);
        
        JLabel X_NEG_1_Y_NEG_1 = new JLabel("(-1,-1)");
        Panel_Neg_1_Neg_1.add(X_NEG_1_Y_NEG_1);
        X_NEG_1_Y_NEG_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_NEG_1_NEG_1 = new JButton("Go Here");
        Panel_Neg_1_Neg_1.add(BTN_NEG_1_NEG_1);
        
        JPanel Panel_0_Neg_1 = new JPanel();
        add(Panel_0_Neg_1);
        
        JLabel X_0_Y_NEG_1 = new JLabel("(0,-1)");
        Panel_0_Neg_1.add(X_0_Y_NEG_1);
        X_0_Y_NEG_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_0_NEG_1 = new JButton("Go Here");
        Panel_0_Neg_1.add(BTN_0_NEG_1);
        
        JPanel Panel_1_Neg_1 = new JPanel();
        add(Panel_1_Neg_1);
        
        JLabel X_1_Y_NEG_1 = new JLabel("(1,-1)");
        Panel_1_Neg_1.add(X_1_Y_NEG_1);
        X_1_Y_NEG_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_1_NEG_1 = new JButton("Go Here");
        Panel_1_Neg_1.add(BTN_1_NEG_1);
        
        JPanel Panel_2_Neg_1 = new JPanel();
        add(Panel_2_Neg_1);
        
        JLabel X_2_Y_NEG_1 = new JLabel("(2,-1)");
        Panel_2_Neg_1.add(X_2_Y_NEG_1);
        X_2_Y_NEG_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_2_NEG_1 = new JButton("Go Here");
        Panel_2_Neg_1.add(BTN_2_NEG_1);
        
        JPanel Panel_3_Neg_1 = new JPanel();
        add(Panel_3_Neg_1);
        
        JLabel X_3_Y_NEG_1 = new JLabel("(3,-1)");
        Panel_3_Neg_1.add(X_3_Y_NEG_1);
        X_3_Y_NEG_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton BTN_3_NEG_1 = new JButton("Go Here");
        Panel_3_Neg_1.add(BTN_3_NEG_1);
    }
}
