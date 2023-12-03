import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CarRaceApp extends JFrame {
    private JLabel car1Label;
    private JLabel car2Label;
    public JButton startButton;

    public CarRaceApp() {
        setTitle("Car Race");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        car1Label = new JLabel("Car 1 - Position: 0");
        car2Label = new JLabel("Car 2 - Position: 0");

        startButton = new JButton("Start Race");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startRace();
            }
        });

        add(car1Label);
        add(car2Label);
        add(startButton);

        pack();
        setLocationRelativeTo(null);
    }
    public void updateCarPosition(String carName, int position) {
        if (carName.equals("Car 1")) {
            car1Label.setText(carName + " - Position: " + position);
        } else if (carName.equals("Car 2")) {
            car2Label.setText(carName + " - Position: " + position);
        }
    }
    public void startRace() {
        startButton.setEnabled(false);

        Car car1 = new Car("Car 1", this);
        Car car2 = new Car("Car 2", this);

        car1.start();
        car2.start();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CarRaceApp app = new CarRaceApp();
                app.setVisible(true);
            }
        });
    }
}
