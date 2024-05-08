package GameView;

import javax.swing.*;

public class GameOverView extends JFrame {
    private JPanel panel;
    private JLabel label;

    public GameOverView() {
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    void initComponents() {
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        label = new JLabel("You have let The Boss down!");
        label.setBounds(10, 100, 300, 50);
        panel.add(label);

        this.setVisible(true);
    }
}
