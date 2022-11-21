import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Easy difficulty maze screen in the GUI.
 */
public class PanelMazeEasy extends JPanel {
    PanelMazeEasy(){
        setLayout(new GridLayout(3,7));
        
        JPanel Panel_Neg_3_1 = new JPanel();
        add(Panel_Neg_3_1);
        Panel_Neg_3_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_NEG_3_1 = new JButton("1");
        BTN_NEG_3_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });

        BTN_NEG_3_1.setBorder(null);
        BTN_NEG_3_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        Panel_Neg_3_1.add(BTN_NEG_3_1, BorderLayout.CENTER);
        
        JPanel Panel_Neg_2_1 = new JPanel();
        add(Panel_Neg_2_1);
        Panel_Neg_2_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_NEG_2_1 = new JButton("-");
        BTN_NEG_2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        BTN_NEG_2_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_NEG_2_1.setBorder(null);
        Panel_Neg_2_1.add(BTN_NEG_2_1);
        
        JPanel Panel_Neg_1_1 = new JPanel();
        add(Panel_Neg_1_1);
        Panel_Neg_1_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_NEG_1_1 = new JButton("0");
        BTN_NEG_1_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_NEG_1_1.setBorder(null);
        Panel_Neg_1_1.add(BTN_NEG_1_1, BorderLayout.CENTER);
        
        JPanel Panel_0_1 = new JPanel();
        add(Panel_0_1);
        Panel_0_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_0_1 = new JButton("");
        BTN_0_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        BTN_0_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_0_1.setBorder(null);
        Panel_0_1.add(BTN_0_1, BorderLayout.CENTER);
        
        JPanel Panel_1_1 = new JPanel();
        add(Panel_1_1);
        Panel_1_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_1_1 = new JButton("7");
        BTN_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        BTN_1_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_1_1.setBorder(null);
        Panel_1_1.add(BTN_1_1);
        
        JPanel Panel_2_1 = new JPanel();
        add(Panel_2_1);
        Panel_2_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_2_1 = new JButton("-");
        BTN_2_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_2_1.setBorder(null);
        Panel_2_1.add(BTN_2_1, BorderLayout.CENTER);
        
        JPanel Panel_3_1 = new JPanel();
        add(Panel_3_1);
        Panel_3_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_3_1 = new JButton("6");
        BTN_3_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_3_1.setBorder(null);
        Panel_3_1.add(BTN_3_1, BorderLayout.CENTER);
        
        JPanel Panel_Neg_3_0 = new JPanel();
        add(Panel_Neg_3_0);
        Panel_Neg_3_0.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_NEG_3_0 = new JButton("|");
        BTN_NEG_3_0.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        BTN_NEG_3_0.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_NEG_3_0.setBorder(null);
        Panel_Neg_3_0.add(BTN_NEG_3_0);
        
        JPanel Panel_Neg_2_0 = new JPanel();
        add(Panel_Neg_2_0);
        Panel_Neg_2_0.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_NEG_2_0 = new JButton("");
        BTN_NEG_2_0.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_NEG_2_0.setBorder(null);
        Panel_Neg_2_0.add(BTN_NEG_2_0);
        
        JPanel Panel_Neg_1_0 = new JPanel();
        add(Panel_Neg_1_0);
        Panel_Neg_1_0.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_NEG_1_0 = new JButton("|");
        BTN_NEG_1_0.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_NEG_1_0.setBorder(null);
        Panel_Neg_1_0.add(BTN_NEG_1_0);
        
        JPanel Panel_0_0 = new JPanel();
        add(Panel_0_0);
        Panel_0_0.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_0_0 = new JButton("/");
        BTN_0_0.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_0_0.setBorder(null);
        Panel_0_0.add(BTN_0_0, BorderLayout.CENTER);
        
        JPanel Panel_1_0 = new JPanel();
        add(Panel_1_0);
        Panel_1_0.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_1_0 = new JButton("|");
        BTN_1_0.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_1_0.setBorder(null);
        Panel_1_0.add(BTN_1_0, BorderLayout.CENTER);
        
        JPanel Panel_2_0 = new JPanel();
        add(Panel_2_0);
        Panel_2_0.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_2_0 = new JButton("/");
        BTN_2_0.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_2_0.setBorder(null);
        Panel_2_0.add(BTN_2_0, BorderLayout.CENTER);
        
        JPanel Panel_3_0 = new JPanel();
        add(Panel_3_0);
        Panel_3_0.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_3_0 = new JButton("|");
        BTN_3_0.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_3_0.setBorder(null);
        Panel_3_0.add(BTN_3_0, BorderLayout.CENTER);
        
        JPanel Panel_Neg_3_Neg_1 = new JPanel();
        add(Panel_Neg_3_Neg_1);
        Panel_Neg_3_Neg_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_NEG_3_NEG_1 = new JButton("2");
        BTN_NEG_3_NEG_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_NEG_3_NEG_1.setBorder(null);
        Panel_Neg_3_Neg_1.add(BTN_NEG_3_NEG_1, BorderLayout.CENTER);
        
        JPanel Panel_Neg_2_Neg_1 = new JPanel();
        add(Panel_Neg_2_Neg_1);
        Panel_Neg_2_Neg_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_NEG_2_NEG_1 = new JButton("");
        BTN_NEG_2_NEG_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_NEG_2_NEG_1.setBorder(null);
        Panel_Neg_2_Neg_1.add(BTN_NEG_2_NEG_1);
        
        JPanel Panel_Neg_1_Neg_1 = new JPanel();
        add(Panel_Neg_1_Neg_1);
        Panel_Neg_1_Neg_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_NEG_1_NEG_1 = new JButton("3");
        BTN_NEG_1_NEG_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_NEG_1_NEG_1.setBorder(null);
        Panel_Neg_1_Neg_1.add(BTN_NEG_1_NEG_1, BorderLayout.CENTER);
        
        JPanel Panel_0_Neg_1 = new JPanel();
        add(Panel_0_Neg_1);
        Panel_0_Neg_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_0_NEG_1 = new JButton("-");
        BTN_0_NEG_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_0_NEG_1.setBorder(null);
        Panel_0_Neg_1.add(BTN_0_NEG_1, BorderLayout.CENTER);
        
        JPanel Panel_1_Neg_1 = new JPanel();
        add(Panel_1_Neg_1);
        Panel_1_Neg_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_1_NEG_1 = new JButton("4");
        BTN_1_NEG_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_1_NEG_1.setBorder(null);
        Panel_1_Neg_1.add(BTN_1_NEG_1, BorderLayout.CENTER);
        
        JPanel Panel_2_Neg_1 = new JPanel();
        add(Panel_2_Neg_1);
        Panel_2_Neg_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_2_NEG_1 = new JButton("");
        BTN_2_NEG_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_2_NEG_1.setBorder(null);
        Panel_2_Neg_1.add(BTN_2_NEG_1, BorderLayout.CENTER);
        
        JPanel Panel_3_Neg_1 = new JPanel();
        add(Panel_3_Neg_1);
        Panel_3_Neg_1.setLayout(new BorderLayout(0, 0));
        
        JButton BTN_3_NEG_1 = new JButton("5");
        BTN_3_NEG_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
        BTN_3_NEG_1.setBorder(null);
        Panel_3_Neg_1.add(BTN_3_NEG_1, BorderLayout.CENTER);
    }
}
