package main;
import java.awt.*;
import java.awt.event.*;
import java.time.Duration;
import java.time.Instant;
import javax.swing.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class TimeLimit implements ActionListener {
    JFrame frame = new JFrame();
    JButton tenMin = new JButton("10min");
    JButton thirtyMin = new JButton("30min");
    JButton sixtyMin = new JButton("60min");
    JButton resetB = new JButton("Reset");
    JButton pauseB = new JButton("Pause");
    JButton backB = new JButton("Back");
    JLabel timeLabel = new JLabel();
    int milliSeconds = 0;
    int seconds = 0;
    int minutes = 0;
    boolean started = false;
    String milliSecondsStr = String.format("%02d", milliSeconds);
    String secondsStr = String.format("%02d", seconds);
    String minutesStr = String.format("%02d", minutes);
    /** 1000000 nanoseconds passed in (to represent each millisecond passed) */
    Timer timer = new Timer(1000000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //StopWatch watch = new StopWatch();
            Instant start = Instant.now();
            Instant finish = Instant.now();
            long elapsedTime = Duration.between(finish, start).toMinutes();
            minutes %= 60;
            seconds %= 60;
            milliSeconds %= 100;
        }
    });
    TimeLimit() {
        timeLabel.setText(minutesStr + ":" + secondsStr + ":" + milliSecondsStr);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Oxygen", Font.PLAIN, 25));
        timeLabel.setBorder(BorderFactory.createBevelBorder(2));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        tenMin.setBounds(20, 200, 100, 50);
        tenMin.setFont(new Font("Oxygen", Font.PLAIN, 20));
        tenMin.setFocusable(false);
        tenMin.addActionListener(this);
        //tenMin.

        thirtyMin.setBounds(135, 200, 100, 50);
        thirtyMin.setFont(new Font("Oxygen", Font.PLAIN, 20));
        thirtyMin.setFocusable(false);
        thirtyMin.addActionListener(this);

        sixtyMin.setBounds(250, 200, 100, 50);
        sixtyMin.setFont(new Font("Oxygen", Font.PLAIN, 20));
        sixtyMin.setFocusable(false);
        sixtyMin.addActionListener(this);

        backB.setBounds(400, 500, 80, 30);
        backB.setFont(new Font("Oxygen", Font.PLAIN, 20));
        backB.setFocusable(false);
        backB.addActionListener(this);

        frame.add(tenMin);
        frame.add(thirtyMin);
        frame.add(sixtyMin);
        frame.add(backB);
        frame.add(resetB);
        frame.add(pauseB);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String timerRequest = e.getActionCommand();
        //if timerRequest == tenMin {
            //start();
        //}
    }
    void start() {

    }

    void stop() {

    }

    void reset() {
        timer.stop();
        minutes = 0;
        seconds = 0;
        milliSeconds = 0;
        minutesStr = String.format("02d", minutes);
        secondsStr = String.format("02d", seconds);
        milliSecondsStr = String.format("02d", milliSeconds);
        timeLabel.setText(minutesStr + ":" + secondsStr + ":" + milliSecondsStr);
    }
    void back() {

    }
}
