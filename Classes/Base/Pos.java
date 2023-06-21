package Classes.Base;

public class Pos {
    private double x = 0;
    private double y = 0;
    public Pos(){}
    public Pos(double x,double y){
        this.setX(x);
        this.setY(y);
    }
    public Pos(Pos p){
        this.setX(p.getX());
        this.setY(p.getY());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
