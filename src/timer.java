/**
 * Created by sell4_8aha on 11/4/2017.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class timer extends JFrame implements ActionListener {
    // creates minutes and seconds text fields
    private JTextField sec1;
    private JTextField min1;

    //creates minutes and seconds labels
    private JLabel secLab;
    private JLabel minLab;

    //creates timer and sets it to 0
    private int time = 0;
    private Timer count;

    //creates start and stop buttons
    private JButton start;
    private JButton stop;

    public static void main(String[] args) {
        //inits new timer and GUI
        timer frame = new timer();
        frame.setSize(400, 150);
        frame.createGUI();
        frame.setVisible(true);
    }

    //GUI class
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        minLab = new JLabel("Minutes: ");
        window.add(minLab);

        min1 = new JTextField(2);
        window.add(min1);

        secLab = new JLabel("Seconds: ");
        window.add(secLab);

        sec1 = new JTextField(2);
        window.add(sec1);

        //ActionListener adds timer function
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                min1.setText(Integer.toString(time / 60));
                sec1.setText(Integer.toString(time % 60));
                time++;

            }
        };

        count = new Timer(1000, listener);

        start = new JButton("Start Timer");
        window.add(start);
        start.addActionListener(this);

        stop = new JButton("Stop");
        window.add(stop);
        stop.addActionListener(this);
    }

    //button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {

            count.start();

        }
        if(e.getSource() == stop) {
            count.stop();
        }

    }
}