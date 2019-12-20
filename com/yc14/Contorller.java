package com.yc14;
import javax.swing.event.*;
import javax.swing.*;
public class Contorller {
    private Kub cube;
    private Viewer viewer;
    private JSlider vSlider;
    public Contorller(Kub cube, Viewer viewer){
        this.cube = cube;
        this.viewer = viewer;
        vSlider = viewer.vSlider;
        vSlider.addChangeListener(e -> {
            int step = vSlider.getValue();
            cube.rotate(step,0,0);
            viewer.repaint();
        });
    }
}
