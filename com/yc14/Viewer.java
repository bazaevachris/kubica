package com.yc14;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {
    public Kub cube;
    public Container pane;
    public JPanel renderPanel;
    public JSlider vSlider;

    public Viewer(Kub c){
        cube = c;
        setSize(800,800);
        pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        renderPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g1){
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
        };
        pane.add(renderPanel, BorderLayout.CENTER);
        vSlider = new JSlider(SwingConstants.VERTICAL,-50,50,0);
        pane.add(vSlider, BorderLayout.EAST);
        /*vSlider.addChangeListener(e -> {
            int step = vSlider.getValue();
            cube.rotate(step,0,0);
            pane.repaint();
        });*/
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
   /* @Override
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
    }*/
}
