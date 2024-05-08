package GameController;

import GameView.MainView;
import GameData.MainData;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

import static java.lang.Integer.parseInt;

public class MainController {
    MainView view;
    MainData data;

    public MainView getView() {
        return view;
    }

    public MainData getData() {
        return data;
    }

    public void updateData(String action) {
        String header = action.split(" ", 2)[0], value = action.split(" ", 2)[1];
        int val = parseInt(value);
        switch(header) {
            case "Add":
                data.addTreats(val);
                break;
            case "Sub":
                data.eatTreats(val);
                break;
            case "Lives":
                data.updateLives(val);
                break;
        }
    }

    public void updateView(String command) {
        if (command.equals("Treat")) {
            view.updateTreats(data.getTreatsLeft());
        } else {
            if (command.equals("Hangry")) {
                view.updateLives(data.getLives());
            } else {
                String timeLeft = command.split(" ", 2)[1];
                view.updateTimeLeft(parseInt(timeLeft));
            }
        }
    }

    public MainController() {
        view = new MainView(this);
        data = new MainData(this);
    }
}
