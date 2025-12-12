import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonApp extends JFrame {
    int x = 0;
    Button A;
    Button B;

    public ButtonApp() {
        setTitle("Counter Application");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        A = new Button("++");
        B = new Button("--");

        A.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                x++;
                repaint();
            }
        });
        add(A);

        B.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                x--;
                repaint();
            }
        });
        add(B);

        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Counter's value is " + x, 100, 100);
    }

    public static void main(String[] args) {
        new ButtonApp();
    }
}