import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class DateTime extends JFrame {

    Thread th;

    public DateTime() {

        setTitle("Current Date Time");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        th = new Thread(new Runnable(){
            public void run() {
                while (true) {
                    try {
                        repaint();
                        Thread.sleep(1000);

                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        });
        th.start();

        setVisible(true);
    }


    public void paint(Graphics g) {
        super.paint(g);
        Date d = new Date();
        g.drawString(d.toString(), 100, 100);
    }

    public static void main(String[] args) {
        new DateTime();
    }
}