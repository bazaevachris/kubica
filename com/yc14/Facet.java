package com.yc14;

import java.awt.*;
import java.awt.geom.Path2D;

public class Facet {
    private R3Vector[] vertex;
     Color c;
    public Facet(R3Vector v1,R3Vector v2,R3Vector v3,R3Vector v4) {
        vertex = new R3Vector[4];
        vertex[0] = v1;
        vertex[1] = v2;
        vertex[2] = v3;
        vertex[3] = v4;
        //vertex[4] = vertex[0];
    }
    public void print(){
        for (int i=0; i<3;i++){
            vertex[i].print();
            System.out.print("---");
            vertex[i+1].out();

        }
        vertex[3].print();
        System.out.print("---");
        vertex[0].out();
    }
    public R3Vector norm()
    {
        R3Vector a = R3Vector.perevod(vertex[0], vertex[1]);
        R3Vector b = R3Vector.perevod(vertex[0], vertex[3]);
        return R3Vector.vecp(a,b);
    }
    public void scale(double k){
        for (int i=0; i<vertex.length; i++){
            vertex[i].mash(k);
        }
    }
public void trans(double dx, double dy, double dz){
    for (int i=0; i<vertex.length; i++){
        vertex[i].move(dx,dy,dz);
    }
}
public void rotate(double dx, double dy, double dz){
    for (int i=0; i<vertex.length; i++){
        vertex[i].rotate(dx,dy,dz);
    }
}

    public void draw(Graphics2D g) {
        Path2D path = new Path2D.Double();
        path.moveTo(vertex[0].getX(), vertex[0].getY());
        path.lineTo(vertex[1].getX(), vertex[1].getY());
        path.lineTo(vertex[2].getX(), vertex[2].getY());
        path.lineTo(vertex[3].getX(), vertex[3].getY());
        path.lineTo(vertex[0].getX(), vertex[0].getY());
        path.closePath();
        g.draw(path);
    }
    public void drawPers(Graphics2D g, double k) {
        Path2D path = new Path2D.Double();
        double t[] = new double[4];
        t[0]= -k/(vertex[0].getZ()-k);
        t[1]= -k/(vertex[1].getZ()-k);
        t[2]= -k/(vertex[2].getZ()-k);
        t[3]= -k/(vertex[3].getZ()-k);
        R3Vector vertex1[] = new R3Vector[4];
        vertex1 [0]= new R3Vector(vertex[0].getX()*t[0], vertex[0].getY()*t[0],vertex[0].getZ()*t[0]);
        vertex1 [1]= new R3Vector(vertex[1].getX()*t[1], vertex[1].getY()*t[1],vertex[1].getZ()*t[1]);
        vertex1 [2]= new R3Vector(vertex[2].getX()*t[2], vertex[2].getY()*t[2],vertex[2].getZ()*t[2]);
        vertex1 [3]= new R3Vector(vertex[3].getX()*t[3], vertex[3].getY()*t[3],vertex[3].getZ()*t[3]);
        path.moveTo(vertex1[0].getX(), vertex1[0].getY());
        path.lineTo(vertex1[1].getX(), vertex1[1].getY());
        path.lineTo(vertex1[2].getX(), vertex1[2].getY());
        path.lineTo(vertex1[3].getX(), vertex1[3].getY());
        path.lineTo(vertex1[0].getX(), vertex1[0].getY());
        path.closePath();
        Facet facet1 = new Facet(vertex1[0],vertex1[1],vertex1[2],vertex1[3]);

        if (facet1.light()){
            g.setColor(c);
            g.fill(path);
        }
    }
    public boolean light(){
        if (norm().getZ()<0){
            return true;
        }else return false;
    }
    public void setColor(Color c){
        this.c = c;

    }
}
