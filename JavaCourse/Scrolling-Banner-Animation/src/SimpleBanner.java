import javax.swing.*;
import java.awt.*;

public class SimpleBanner extends JFrame {

    public SimpleBanner() {
        setTitle("Mini Banner");
        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label = new JLabel("Here is the Scrolling message E/Ibrahim");
        label.setBounds(400, 30, 500, 30);
        add(label);

        new Thread(() -> {
            int x = 400;
            while (true) {
                try {
                    x -= 1;
                    if (x < -200) x = 400;
                    int finalX = x;
                    SwingUtilities.invokeLater(() -> label.setLocation(finalX, 30));
                    Thread.sleep(5);
                } catch (Exception e) {}
            }
        }).start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleBanner();
    }
}