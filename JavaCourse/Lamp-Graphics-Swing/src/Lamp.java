import javax.swing.*;
import java.awt.*;

public class Lamp extends JFrame {
    public Lamp() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new DrawLamp());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Lamp();
    }
}

class DrawLamp extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int[] x = {320, 180, 150, 350};
        int[] y = {80, 80, 230, 230};
        g.setColor(Color.WHITE);
        g.fillPolygon(x, y, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(x, y, 4);

        g.setColor(new Color(255, 255, 150));
        g.fillOval(180, 60, 140, 30);
        g.setColor(Color.BLACK);
        g.drawOval(180, 60, 140, 30);

        g.setColor(new Color(255, 255, 150));
        g.fillOval(175, 140, 45, 65);
        g.setColor(Color.BLACK);
        g.drawOval(175, 140, 45, 65);

        g.setColor(new Color(255, 255, 150));
        g.fillOval(230, 110, 65, 100);
        g.setColor(Color.BLACK);
        g.drawOval(230, 110, 65, 100);

        g.setColor(new Color(255, 255, 150));
        g.fillOval(305, 140, 45, 65);
        g.setColor(Color.BLACK);
        g.drawOval(305, 140, 45, 65);

        g.drawLine(250, 230, 240, 320);
        g.drawLine(250, 230, 260, 320);

        g.setColor(Color.WHITE);
        g.fillRect(190, 320, 120, 25);
        g.setColor(Color.BLACK);
        g.drawRect(190, 320, 120, 25);
    }
}