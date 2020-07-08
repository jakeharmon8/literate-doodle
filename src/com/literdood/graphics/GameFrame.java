package com.literdood.graphics;

import javax.swing.*;

public class GameFrame {
    public static void launchGame() {
        JFrame f = new JFrame("Tower Defense v1.0");
        GamePanel p = new GamePanel();
        f.add(p);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
