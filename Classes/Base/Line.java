package Classes.Base;

import static Classes.Base.Defines.*;


public class Line {
    private Pos pos1 = new Pos(0,0);
    private Pos pos2 = new Pos(0,0);
    public  Line(){;}
    public  Line(Pos p1, Pos p2){
        pos1.setX(p1.getX());
        pos1.setY(p1.getY());
        pos2.setX(p2.getX());
        pos2.setY(p2.getY());
    }
    public Line(Line l){
        this.setPos1(l.getPos1());
        this.setPos2(l.getPos2());
    }
    public Pos getPos1() {
        return pos1;
    }
    public Pos getPos2() {
        return pos2;
    }
    public void setPos1(Pos pos1) {
        this.pos1.setX(pos1.getX());
        this.pos1.setY(pos1.getY());
    }
    public void setPos2(Pos pos2) {
        this.pos2.setX(pos2.getX());
        this.pos2.setY(pos2.getY());
    }
    public int checkLineDir(){
        if (pos1.getX() == pos2.getX())
            return ud;
        else if (pos1.getY() == pos2.getY())
            return lr;
        else
            return -1;
    }
    public boolean checkPLCollision(Pos p1){//检查点线碰撞
        if (this.checkLineDir() == lr)
        {
            double minx, maxx;
            if (this.pos1.getX() > this.pos2.getX())
            {
                maxx = this.pos1.getX();
                minx = this.pos2.getX();
            }
            else
            {
                maxx = this.pos2.getX();
                minx = this.pos1.getX();
            }
            if (p1.getX() > minx + COMPENSATE_PARAM && p1.getX() < maxx - COMPENSATE_PARAM && p1.getY() >= this.pos1.getY() - COMPENSATE_PARAM && p1.getY() <= this.pos1.getY() + COMPENSATE_PARAM)//应该加入补偿参数
                return true;
            else
                return false;
        }
        else if (this.checkLineDir() == ud)
        {
            {
                double miny, maxy;
                if (this.pos1.getY() > this.pos2.getY())
                {
                    maxy = this.pos1.getY();
                    miny = this.pos2.getY();
                }
                else
                {
                    maxy = this.pos2.getY();
                    miny = this.pos1.getY();
                }
                if (p1.getY() > miny + COMPENSATE_PARAM && p1.getY() < maxy - COMPENSATE_PARAM && p1.getX() >= this.pos1.getX() - COMPENSATE_PARAM && p1.getX() <= this.pos1.getX() + COMPENSATE_PARAM)//应该加入补偿参数
                    return true;
                else
                    return false;
            }
        }
        else
            return false;//!!!!!!!!暂时不能判断斜线的碰撞!!!!!!!!!!!!!!
    }
    public boolean checkLineCollision(Line l2)      //检查线线碰撞
    {
        int l1dir, l2dir;
        double miny, maxy;
        double minx, maxx;
        l1dir = this.checkLineDir();
        l2dir = l2.checkLineDir();
        if (l1dir == lr && l2dir == lr)
        {
            if (this.checkPLCollision(l2.pos1) || this.checkPLCollision(l2.pos2)) {          //待重做，需加上补偿参数

                return true;
            }
            else if ( l2.checkPLCollision(this.pos1) ||  l2.checkPLCollision(this.pos2)) {

                return true;
            }
            else
                return false;
        }
        else if (l1dir == ud && l2dir == ud)
        {
            if (this.checkPLCollision( l2.pos1) || this.checkPLCollision( l2.pos2)) {

                return true;
            }
            else if ( l2.checkPLCollision(this.pos1) ||  l2.checkPLCollision(this.pos2)) {

                return true;
            }
            else
                return false;
        }
        else if (l1dir == lr && l2dir == ud)
        {

            if ( l2.pos1.getY() >  l2.pos2.getY())
            {
                maxy =  l2.pos1.getY();
                miny =  l2.pos2.getY();
            }
            else
            {
                maxy =  l2.pos2.getY();
                miny =  l2.pos1.getY();
            }
            if (this.pos1.getY() > miny + COMPENSATE_PARAM && this.pos1.getY() < maxy - COMPENSATE_PARAM)
            {
                if (this.pos1.getX() > this.pos2.getX())
                {
                    maxx = this.pos1.getX();
                    minx = this.pos2.getX();
                }
                else
                {
                    maxx = this.pos2.getX();
                    minx = this.pos1.getX();
                }
                if ( l2.pos1.getX() > minx + COMPENSATE_PARAM &&  l2.pos1.getX() < maxx - COMPENSATE_PARAM) {

                    return true;
                }
                else
                    return false;
            }
            else
                return false;
        }
        else if (l1dir == ud && l2dir == lr)
        {

            if (this.pos1.getY() > this.pos2.getY())
            {
                maxy =  this.pos1.getY();
                miny =  this.pos2.getY();
            }
            else
            {
                maxy =  this.pos2.getY();
                miny =  this.pos1.getY();
            }
            if ( l2.pos1.getY() > miny + COMPENSATE_PARAM &&  l2.pos1.getY() < maxy - COMPENSATE_PARAM)
            {
                if ( l2.pos1.getX() >  l2.pos2.getX())
                {
                    maxx =  l2.pos1.getX();
                    minx =  l2.pos2.getX();
                }
                else
                {
                    maxx =  l2.pos2.getX();
                    minx =  l2.pos1.getX();
                }
                if (this.pos1.getX() > minx + COMPENSATE_PARAM  && this.pos1.getX() < maxx - COMPENSATE_PARAM) {

                    return true;

                }
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false;
    }
}
