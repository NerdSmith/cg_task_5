package ru.vsu.cs;

import javax.swing.*;

public class MainWindow extends JFrame {
    private DrawPanel drawPanel;

    MainWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1280, 760);

        this.drawPanel = new DrawPanel();




        this.add(drawPanel);
    }
}
