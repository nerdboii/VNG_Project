package GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GameController.MainController;

import static java.lang.Integer.parseInt;

public class MainView extends JFrame {
    private MainController controller;
    private JPanel panel;
    private JButton button;
    private JLabel treatsLabel, timeLabel, livesLabel;
    private JTextField textField;

    public MainView(MainController controller) {
        this.controller = controller;
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    public MainController getController() {
        return controller;
    }

    public void initComponents() {
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        treatsLabel = new JLabel("Treats in plate: 0");
        timeLabel = new JLabel("Time till The Boss arrive: 0s");
        livesLabel = new JLabel("Lives remaining: 3");
        treatsLabel.setBounds(10, 0, 300, 50);
        timeLabel.setBounds(350, 0, 300, 50);
        livesLabel.setBounds(10, 100, 300, 50);
        panel.add(treatsLabel);
        panel.add(timeLabel);
        panel.add(livesLabel);

        textField = new JTextField("Type something...");
        textField.setBounds(10, 200, 300, 50);
        panel.add(textField);

        button = new JButton("Click me!");
        button.setBounds(10, 300, 100, 50);
        button.addActionListener(new Action());
        panel.add(button);

        this.setVisible(true);
    }

    public void updateTreats(int treats) {
        treatsLabel.setText("Treats in plate: " + treats);
    }

    public void updateTimeLeft(int second) {
        timeLabel.setText("Time till The Boss arrive: " + second + "s");
    }

    public void updateLives(int lives) {
        livesLabel.setText("Lives remaining: " + lives);
    }

    public class Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                String extraTreats = textField.getText();
                controller.updateData("Add " + extraTreats);
                controller.updateView("Treat");
            }
        }
    }

    public void close() {
        this.setVisible(false);
    }

}
