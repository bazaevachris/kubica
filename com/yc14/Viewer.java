package com.yc14;

import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {
    private Kub cube;
    public Viewer(Kub c){
        cube = c;
        setSize(800,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void paint(Graphics g1){
        Graphics2D g=(Graphics2D)g1;
        int x = getWidth()/2;
        int y = getHeight()/2;
        g.translate(x, y);
        g.setColor(Color.white);
        g.fillRect(-x, -y, 2*x, 2*x);
        g.setColor(Color.red);
        //cube.draw(g);
        cube.drawPers(g, 500);
    }
}
