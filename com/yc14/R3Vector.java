package com.yc14;

public class R3Vector {
    private double x,y,z;
    public R3Vector(double x, double y, double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public R3Vector(){

    }
    public void out(){
        System.out.println("("+x+", "+y+", "+z+")");
    }
    public void print(){
        System.out.print("("+x+", "+y+", "+z+")");
    }
    public R3Vector sum (R3Vector a){
        return new R3Vector(x+a.x, y+a.y, z+a.z);
    }
    public static  R3Vector sum( R3Vector a, R3Vector b){
        return new R3Vector(a.x+b.x, a.y+b.y, a.z+b.z);
    }
    public static  R3Vector scal( R3Vector a, R3Vector b){
        return new R3Vector(a.x*b.x, a.y*b.y, a.z*b.z);
    }
    public static  R3Vector vecp( R3Vector a, R3Vector b){
        return new R3Vector(a.y*b.z-a.z*b.y,a.z*b.x-a.x*b.z,a.x*b.y-a.y*b.x);
    }
    public void mash(double b)
    {
        x = x*b;
        y = y*b;
        z = z*b;
    }
    public void rotateZ(double u) {
        double x1, y1;
        x1 = x * Math.cos((u * Math.PI) /180 ) + y * Math.sin((u *Math.PI ) / 180);
        y1 = y * Math.cos((u * Math.PI) / 180) - x * Math.sin((u * Math.PI) /180 );
        x=x1; y=y1;
    }
    public void rotateX(double u) {
        double z1, y1;
        y1 = y * Math.cos((u * Math.PI) /180 ) + z * Math.sin((u * Math.PI) / 180);
        z1 = z * Math.cos((u * Math.PI) / 180) -y * Math.sin((u *Math.PI ) / 180);
        z=z1; y=y1;
    }
    public void rotateY(double u) {
        double z1, x1;
        x1 = x * Math.cos((u *Math.PI ) / 180) + z * Math.sin((u *Math.PI ) /180 );
        z1 = z * Math.cos((u * Math.PI ) /180) - x * Math.sin((u * Math.PI) / 180);
        x=x1; z=z1;
    }
    public void rotate(double A, double B, double C)
    {
        rotateX(A);
        rotateY(B);
        rotateZ(C);
    }
    public static R3Vector perevod(R3Vector a, R3Vector b){
       return new R3Vector(b.x-a.x, b.y-a.y, b.z-a.z);
    }
    public  void moveX(double dx){
        x+=dx;
    }
    public  void moveY(double dy){
        y+=dy;
    }
    public  void moveZ(double dz){
        z+=dz;
    }
    public void  move(double dx,double dy,double dz){
        moveX(dx);
        moveY(dy);
        moveZ(dz);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
