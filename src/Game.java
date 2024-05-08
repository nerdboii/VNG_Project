import GameController.MainController;
import GameView.GameOverView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game implements Runnable {
    int lives;
    int countdownTime;
    int delay;
    MainController controller;
    Thread countdownThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                countdown();
            }
        }
    });
    public void countdown() {
        int timeLeft = countdownTime;
        if (this.lives == 0) {
            controller.getView().close();
            GameOverView gameOverView = new GameOverView();
        }
        while (timeLeft >= 0) {
            System.out.println("Time left " + timeLeft + "s");
            controller.updateView("Time " + timeLeft);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeLeft--;
            if (timeLeft == 0) {
                String value = "10";
                controller.updateData("Sub " + value);
                controller.updateView("Treat");
                if (controller.getData().getTreatsLeft() == 0) {
                    System.out.println("The Boss is Hangry!");
                    lives--;
                    controller.updateData("Lives " + lives);
                    controller.updateView("Hangry");
                }
                break;
            }
        }
    }
    public Game() {
        delay = 0;
        lives = 3;
        countdownTime = 5;
        controller = new MainController();
    }

    public Game(int lives, int countDownTime, int delay) {
        this.delay = delay;
        this.lives = lives;
        this.countdownTime = countDownTime;
        controller = new MainController();
    }

    @Override
    public void run() {
        countdownThread.start();
    }
}
