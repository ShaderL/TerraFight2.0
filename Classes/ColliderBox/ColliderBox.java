package Classes.ColliderBox;

import Classes.Base.Line;
import Classes.Base.Pos;

import javax.swing.*;

import static Classes.Base.Defines.*;

public class ColliderBox {


    public Pos getUpLeft() {
        return m_UpLeft;
    }

    public Pos getDownRight() {
        return m_DownRight;
    }

    public Pos getUpRight() {
        return m_UpRight;
    }

    public Pos getDownLeft() {
        return m_DownLeft;
    }

    public Pos getBasepos() {
        return m_Basepos;
    }

    public double getLength() {
        return m_length;
    }

    public double getWidth() {
        return m_width;
    }

    public void setUpLeft(Pos m_UpLeft) {
        this.m_UpLeft = m_UpLeft;
    }

    public void setDownRight(Pos m_DownRight) {
        this.m_DownRight = m_DownRight;
    }

    public void setUpRight(Pos m_UpRight) {
        this.m_UpRight = m_UpRight;
    }

    public void setDownLeft(Pos m_DownLeft) {
        this.m_DownLeft = m_DownLeft;
    }

    public void setBasepos(Pos m_Basepos) {
        this.m_Basepos = m_Basepos;
    }

    public void setLength(double m_length) {
        this.m_length = m_length;
    }

    public void setWidth(double m_width) {
        this.m_width = m_width;
    }

    private Pos m_UpLeft = new Pos(0,0);         //左上右下坐标
    private Pos m_DownRight = new Pos(0,0);
    private Pos m_UpRight = new Pos(0,0);        //剩余两个坐标通过构造函数计算而得
    private Pos m_DownLeft = new Pos(0,0);
    private Pos m_Basepos = new Pos(0,0);        //以左下角为基础坐标
    private double m_length;         //长度宽度
    private double m_width;

    public ColliderBox(){;}
    public ColliderBox(Pos upleftpos, Pos downrightpos){
        m_length = downrightpos.getY() - upleftpos.getY();
        m_width = downrightpos.getX() - upleftpos.getX();

        m_UpLeft.setX(upleftpos.getX());
        m_UpLeft.setY(upleftpos.getY());

        m_DownRight.setX(downrightpos.getX());
        m_DownRight.setY(downrightpos.getY());

        m_Basepos.setX(upleftpos.getX());
        m_Basepos.setY(downrightpos.getY());

        m_UpRight.setX( downrightpos.getX());
        m_UpRight.setY(upleftpos.getY());

        m_DownLeft.setX(upleftpos.getX());
        m_DownLeft.setY(downrightpos.getY());
    };
    public ColliderBox(Pos basepos, int length, int width){
        m_length = length;
        m_width = width;

        m_Basepos.setX(basepos.getX());
        m_Basepos.setY(basepos.getY());

        m_UpLeft.setX(basepos.getX());
        m_UpLeft.setY(basepos.getY() - length) ;

        m_DownRight.setX(basepos.getX() + width);
        m_DownRight.setY(basepos.getY());

        m_DownLeft.setX(basepos.getX());
        m_DownLeft.setY(basepos.getY());

        m_UpRight.setX(basepos.getX() + width);
        m_UpRight.setY(basepos.getY() - length);
    };
    public ColliderBox(ColliderBox cb){
        Pos initpos = new Pos(0,0);

        m_length = 0;
        m_width = 0;

        m_Basepos.setX(initpos.getX());
        m_Basepos.setY(initpos.getY());

        m_UpLeft.setX(initpos.getX());
        m_UpLeft.setY(initpos.getY());

        m_UpRight.setX(initpos.getX());
        m_UpRight.setY(initpos.getY());

        m_DownLeft.setX(initpos.getX());
        m_DownLeft.setY(initpos.getY());

        m_DownRight.setX(initpos.getX());
        m_DownRight.setY(initpos.getY());
    };

    public int updatepos(Pos basepos){
        m_Basepos.setX(basepos.getX());
        m_Basepos.setY(basepos.getY());

        m_UpLeft.setX(m_Basepos.getX());
        m_UpLeft.setY( m_Basepos.getY() - m_length);

        m_UpRight.setX(m_Basepos.getX() + m_width);
        m_UpRight.setY( m_Basepos.getY() - m_length);

        m_DownLeft.setX(m_Basepos.getX());
        m_DownLeft.setY( m_Basepos.getY());

        m_DownRight.setX(m_Basepos.getX() + m_width);
        m_DownRight.setY(m_Basepos.getY());

        return DONE;
    };
    public int assignment(Pos upleftpos, Pos downrightpos){
        m_length = downrightpos.getY() - upleftpos.getY();
        m_width = downrightpos.getX() - upleftpos.getX();

        m_UpLeft.setX(upleftpos.getX());
        m_UpLeft.setY(upleftpos.getY());

        m_DownRight.setX(downrightpos.getX());
        m_DownRight.setY(downrightpos.getY());

        m_Basepos.setX(upleftpos.getX());
        m_Basepos.setY(downrightpos.getY());

        m_UpRight.setX(downrightpos.getX());
        m_UpRight.setY(upleftpos.getY());

        m_DownLeft.setX(upleftpos.getX());
        m_DownLeft.setY(downrightpos.getY());

        return DONE;
    };   //赋值函数
    public int assignment(Pos basepos, int length, int width){
        m_length = length;
        m_width = width;

        m_Basepos.setX(basepos.getX());
        m_Basepos.setY(basepos.getY());

        m_UpLeft.setX(basepos.getX());
        m_UpLeft.setY(basepos.getY() + length);

        m_DownRight.setX(basepos.getX() + width);
        m_DownRight.setY(basepos.getY());

        m_DownLeft.setX(basepos.getX());
        m_DownLeft.setY(basepos.getY());

        m_UpRight.setX(basepos.getX() + width);
        m_UpRight.setY(basepos.getY() + length);

        return DONE;
    };
    public boolean checkPBCollision(Pos targetpos){
        if (targetpos.getX() >= m_UpLeft.getX() && targetpos.getX() <=m_UpRight.getX())
        {
            if (targetpos.getY() >= m_UpLeft.getY() && targetpos.getY() <= m_DownLeft.getY())
                return true;
            else
                return false;
        }
        else
            return false;
    };                   //检查点箱碰撞
    public boolean checkLBCollision(Line l1){
        if      (l1.checkLineCollision(getLine(upline)) ||
                l1.checkLineCollision(getLine(downline)) ||
                l1.checkLineCollision(getLine(leftline)) ||
                l1.checkLineCollision(getLine(rightline)))
            return true;
        else
        {
            if (checkPBCollision(l1.getPos1()) ||
                    checkPBCollision(l1.getPos2()))
                return true;
            else
                return false;
        }
    };                         //检查线箱碰撞
    public boolean checkBoxCollision(ColliderBox targethbox){
        if       (checkLBCollision(targethbox.getLine(upline)) ||
                checkLBCollision(targethbox.getLine(downline)) ||
                checkLBCollision(targethbox.getLine(leftline)) ||
                checkLBCollision(targethbox.getLine(rightline)))
            return true;
        else if (targethbox.checkLBCollision(getLine(upline)) ||
                targethbox.checkLBCollision(getLine(downline)) ||
                targethbox.checkLBCollision(getLine(leftline)) ||
                targethbox.checkLBCollision(getLine(rightline)))
            return true;
        else
            return false;
    };              //检查箱箱碰撞
    public Pos getPoint(int point){
        if (point == upleft)
            return m_UpLeft;
        else if (point == upright)
            return m_UpRight;
        else if (point == downleft)
            return m_DownLeft;
        else
            return m_DownRight;

    };
    public  Line getLine(int line){
        Line line1 = new Line(new Pos(0,0),new Pos(0,0));
        if (line == upline)
        {
            line1.setPos1(m_UpLeft);
            line1.setPos2(m_UpRight);
            return line1;
        }
        else if (line == downline)
        {
            line1.setPos1(m_DownLeft);
            line1.setPos2(m_DownRight);
            return line1;
        }
        else if (line == leftline)
        {
            line1.setPos1(m_UpLeft);
            line1.setPos2(m_DownLeft);
            return line1;
        }
        else if (line == rightline)
        {
            line1.setPos1(m_UpRight);
            line1.setPos2(m_DownRight);
            return line1;
        }
        return line1;
    };
    public void DrawCbox(JLayeredPane p){
//        Graphics g = frame.getLayeredPane().getGraphics();
//        frame.paintComponents(g);
//        g.drawLine((int)m_UpLeft.getX(),(int)m_UpLeft.getY(),(int)m_UpRight.getX(),(int)m_UpRight.getY());
//        g.drawLine((int) m_UpLeft.getX(), (int) m_UpLeft.getY(), (int) m_DownLeft.getX(), (int) m_DownLeft.getY());
//        g.drawLine((int) m_UpRight.getX(), (int) m_UpRight.getY(), (int) m_DownRight.getX(), (int) m_DownRight.getY());
//        g.drawLine((int) m_DownLeft.getX(), (int) m_DownLeft.getY(), (int) m_DownRight.getX(), (int) m_DownRight.getY());


        }




}
