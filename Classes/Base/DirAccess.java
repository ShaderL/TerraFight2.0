package Classes.Base;

public class DirAccess {
    private int up;
    private int down;
    private int left;
    private int right;

    public DirAccess(){};
    public DirAccess(int up,int down,int left,int right){
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
    public int getUp() {
        return up;
    }
    public void setUpp(int up) {
        this.up = up;
    }
    public int getDown() {
        return down;
    }
    public void setDown(int down) {
        this.down = down;
    }
    public int getLeft() {
        return left;
    }
    public void setLeft(int left) {
        this.left = left;
    }
    public int getRight() {
        return right;
    }
    public void setRight(int right) {
        this.right = right;
    }


}
