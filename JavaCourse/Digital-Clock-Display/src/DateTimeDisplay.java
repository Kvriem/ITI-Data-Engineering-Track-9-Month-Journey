import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeDisplay extends JFrame {

    public DateTimeDisplay() {
        setTitle("Clock");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label);

        new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                try {
                    label.setText(sdf.format(new Date()));
                    Thread.sleep(1000);
                } catch (Exception e) {}
            }
        }).start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new DateTimeDisplay();
    }
}