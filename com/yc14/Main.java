package com.yc14;

public class Main {

    public static void main(String[] args) {
        R3Vector a = new R3Vector(1,2,3);
        R3Vector b = new R3Vector(2,3,4);
        a.out();
        (a.sum(a)).out();
        R3Vector.sum(a,b).out();
        R3Vector.scal(a,b).out();

        R3Vector c= R3Vector.vecp(a,b);
        c.out();
        b.mash(10);
        b.out();
        b.rotate(0,0,180);
        b.out();
        Facet f= new Facet(new R3Vector(0,0,0),new R3Vector(1,0,0),new R3Vector(1,1,0),new R3Vector(0,1,0));
        f.print();
        R3Vector d = f.norm();
        d.out();
        Kub k = new Kub();
        k.scale(200);
        k.rotate(45, 30, 90);
        Viewer v= new Viewer(k);

    }

}
