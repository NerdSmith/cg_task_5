package ru.vsu.cs;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final JPanel sidePanel;
    private final JButton restartBtn;
    private final JSlider decayRateSlider;
    private final JPanel decayRatePanel;
    private final JPanel keepingFireRatePanel;
    private final JSlider keepingFireSlider;
    private JPanel panelMain;
    private DrawPanel drawPanel;

    MainWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1650, 940);

        this.panelMain = new JPanel();
        this.panelMain.setLayout(new BoxLayout(this.panelMain, BoxLayout.X_AXIS));

        this.drawPanel = new DrawPanel();
        this.sidePanel = new JPanel();
        this.sidePanel.setLayout(new BoxLayout(this.sidePanel, BoxLayout.Y_AXIS));

        this.restartBtn = new JButton("Restart");
        this.restartBtn.addActionListener((e) -> {
            this.drawPanel.restartBonfire();
        });


        this.decayRatePanel = new JPanel();
        this.decayRatePanel.setLayout(new BoxLayout(this.decayRatePanel, BoxLayout.Y_AXIS));

        this.decayRateSlider = new JSlider(JSlider.VERTICAL);
        this.decayRateSlider.setMinimum(101);
        this.decayRateSlider.setMaximum(200);
        this.decayRateSlider.addChangeListener((e) -> {
            this.drawPanel.setDecayRate(this.decayRateSlider.getValue() / 100f);
        });
        this.decayRatePanel.setMaximumSize(new Dimension(100,200));

        decayRatePanel.add(decayRateSlider);
        decayRatePanel.add(new Label("Decay rate"));

        this.keepingFireRatePanel = new JPanel();
        this.keepingFireRatePanel.setLayout(new BoxLayout(this.keepingFireRatePanel, BoxLayout.Y_AXIS));

        this.keepingFireSlider = new JSlider(JSlider.VERTICAL);
        this.keepingFireSlider.setMinimum(0);
        this.keepingFireSlider.setMaximum(100);
        this.keepingFireSlider.addChangeListener((e) -> {
            this.drawPanel.setKeepFireRate(this.keepingFireSlider.getValue() / 100f);
        });
        this.keepingFireRatePanel.setMaximumSize(new Dimension(100,200));

        keepingFireRatePanel.add(keepingFireSlider);
        keepingFireRatePanel.add(new Label("Keeping fire rate"));



        this.sidePanel.add(restartBtn);
        this.sidePanel.add(decayRatePanel);
        this.sidePanel.add(keepingFireRatePanel);

        this.panelMain.add(drawPanel);
        this.panelMain.add(sidePanel);

        this.getContentPane().add(this.panelMain, BorderLayout.CENTER);
    }
}
