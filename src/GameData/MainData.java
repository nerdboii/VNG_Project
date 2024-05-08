package GameData;

import GameController.MainController;

public class MainData {
    private MainController controller;
    protected int treatsLeft;
    protected int countdownTime;
    protected int lives;

    public MainData(MainController controller) {
        this.controller = controller;
        treatsLeft = 0;
        countdownTime = 5;
        lives = 3;
    }

    public MainController getController() {
        return controller;
    }

    public int getTreatsLeft() {
        return treatsLeft;
    }

    public void setTreatsLeft(int treatsLeft) {
        this.treatsLeft = treatsLeft;
    }

    public void addTreats(int value) {
        treatsLeft += value;
    }

    public void eatTreats(int value) {
        if (treatsLeft <= value) treatsLeft = 0;
        else treatsLeft -= value;
    }

    public int getCountdownTime() {
        return countdownTime;
    }

    public void setCountdownTime(int nextFeedTime) {
        this.countdownTime = nextFeedTime;
    }

    public void updateLives(int lives) {
        this.lives = lives;
    }
    public int getLives() {
        return lives;
    }
}
