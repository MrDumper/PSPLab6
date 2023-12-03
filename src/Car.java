import javax.swing.*;
import java.util.Random;

class Car extends Thread {
    private String name;
    private int position;
    private CarRaceApp app;

    public Car(String name, CarRaceApp app) {
        this.name = name;
        this.position = 0;
        this.app = app;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (position < 100) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int distance = random.nextInt(10);
            position += distance;

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    app.updateCarPosition(name, position);
                }
            });
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                app.updateCarPosition(name, position);
                app.startButton.setEnabled(true);
            }
        });
    }
}