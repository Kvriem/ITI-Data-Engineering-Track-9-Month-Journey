import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawLine extends JFrame {

    private int x1, y1, x2, y2;
    private boolean drawing = false;

    public DrawLine() {

        setTitle("DrawLine");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Listen for mouse press + drag
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
                drawing = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                drawing = false;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                repaint();
            }
        });

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLUE);
        g.drawLine(x1, y1, x2, y2);
    }

    public static void main(String[] args) {
        new DrawLine();
    }
}
