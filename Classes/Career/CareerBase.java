package Classes.Career;

import Classes.Base.DirAccess;
import Classes.Base.Pos;
import Classes.ColliderBox.ColliderBox;
import Classes.Combat.Combat;
import Classes.Map.MapBase;

import javax.swing.*;

import static Classes.Base.Defines.*;


public class CareerBase {
    private int m_life;
    private int m_Health;
    private int m_Shield;
    private Pos m_basepos = new Pos(0,0);
    private Pos m_shootpos = new Pos(0,0);
    private int m_attackspeed;//攻击间隔
    private int m_faceori;
    private ColliderBox m_cbox = new ColliderBox();
    private double m_Xspeed;    //水平速度
    private double m_Yspeed;    //垂直速度
    private double m_jumpspeed;
    private DirAccess m_dir = new DirAccess();    //方向可行性参数
    private int m_jumplock;
    private int m_Ismovingl;
    private int m_Ismovingr;
    private int m_Gunheight = 70;
    private int m_attackstate = END_FIRE;
    private int m_player;//用来判断血条位置
    private double m_attacktime = 0;
    private int m_Type;
    final int m_G = 3000;            //重力加速度


    public int getM_life() {
        return m_life;
    }

    public void setM_life(int m_life) {
        this.m_life = m_life;
    }

    public int getM_Health() {
        return m_Health;
    }

    public void setM_Health(int m_Health) {
        this.m_Health = m_Health;
    }

    public int getM_Shield() {
        return m_Shield;
    }

    public void setM_Shield(int m_Shield) {
        this.m_Shield = m_Shield;
    }

    public Pos getM_basepos() {
        return m_basepos;
    }

    public void setM_basepos(Pos m_basepos) {
        this.m_basepos = m_basepos;
    }

    public Pos getM_shootpos() {
        return m_shootpos;
    }

    public void setM_shootpos(Pos m_shootpos) {
        this.m_shootpos = m_shootpos;
    }

    public int getM_attackspeed() {
        return m_attackspeed;
    }

    public void setM_attackspeed(int m_attackspeed) {
        this.m_attackspeed = m_attackspeed;
    }

    public int getM_faceori() {
        return m_faceori;
    }

    public void setM_faceori(int m_faceori) {
        this.m_faceori = m_faceori;
    }

    public ColliderBox getM_cbox() {
        return m_cbox;
    }

    public void setM_cbox(ColliderBox m_cbox) {
        this.m_cbox = m_cbox;
    }

    public double getM_Xspeed() {
        return m_Xspeed;
    }

    public void setM_Xspeed(double m_Xspeed) {
        this.m_Xspeed = m_Xspeed;
    }

    public double getM_Yspeed() {
        return m_Yspeed;
    }

    public void setM_Yspeed(double m_Yspeed) {
        this.m_Yspeed = m_Yspeed;
    }

    public double getM_jumpspeed() {
        return m_jumpspeed;
    }

    public void setM_jumpspeed(double m_jumpspeed) {
        this.m_jumpspeed = m_jumpspeed;
    }

    public DirAccess getM_dir() {
        return m_dir;
    }

    public void setM_dir(DirAccess m_dir) {
        this.m_dir = m_dir;
    }

    public int getM_jumplock() {
        return m_jumplock;
    }

    public void setM_jumplock(int m_jumplock) {
        this.m_jumplock = m_jumplock;
    }

    public int getM_Ismovingl() {
        return m_Ismovingl;
    }

    public void setM_Ismovingl(int m_Ismovingl) {
        this.m_Ismovingl = m_Ismovingl;
    }

    public int getM_Ismovingr() {
        return m_Ismovingr;
    }

    public void setM_Ismovingr(int m_Ismovingr) {
        this.m_Ismovingr = m_Ismovingr;
    }

    public int getM_Gunheight() {
        return m_Gunheight;
    }

    public void setM_Gunheight(int m_Gunheight) {
        this.m_Gunheight = m_Gunheight;
    }

    public int getM_attackstate() {
        return m_attackstate;
    }

    public void setM_attackstate(int m_attackstate) {
        this.m_attackstate = m_attackstate;
    }

    public int getM_player() {
        return m_player;
    }

    public void setM_player(int m_player) {
        this.m_player = m_player;
    }

    public double getM_attacktime() {
        return m_attacktime;
    }

    public void setM_attacktime(double m_attacktime) {
        this.m_attacktime = m_attacktime;
    }





    public int calDamage(int damage) {
        if (damage - getM_Shield() < 0)
            setM_Shield(0);
        else if (damage - getM_Shield() > 0 && (getM_Health() - (damage - getM_Shield())) >= 0)
            setM_Health(getM_Health() - (damage - getM_Shield()));
        else if (damage - getM_Shield() > 0 && (getM_Health() - (damage - getM_Shield())) < 0) {
            setM_Health(0);
            die();
        }
        return DONE;
    }

    ;

    public int calItemBuff(int type, int value) {
        switch (type) {
            case heal:
                if (getM_Health() + value <= 100)
                    setM_Health(getM_Health() + value);
                else if (getM_Health() + value > 100)
                    setM_Health(100);
                break;

            case shield:
                setM_Shield(getM_Shield() + value);
                break;
            case speedup:               //若为减速，则需传入负数
            case speeddown:
                setM_Xspeed(getM_Xspeed() + value);
                break;
        }
        return DONE;

    }

    ;    //int 返回函数执行情况

    public int beginMoveleft() {

            setM_Ismovingl(1);
            setM_faceori(FACE_LEFT);

        return DONE;
    }
    ;
    public int beginMoveright() {

            setM_Ismovingr(1);
            setM_faceori(FACE_RIGHT);

        return DONE;
    }
    public int endMoveleft() {
        setM_Ismovingl(0);
        return DONE;
    }
    public int endMoveright() {
        setM_Ismovingr(0);
        return DONE;
    }
    public int checkDirAccess(MapBase map) {
        int bnum = map.getBlockNum();
        int flag = 1;
        Pos ULpos, URpos, DRpos, DLpos;
        //上检测
        if (getM_cbox().getPoint(upleft).getY() > 0)  //边框检测
        {
            for (int i = 0; i < bnum; i++) {


                if (map.GetBlock(i).getCbox().checkLBCollision(getM_cbox().getLine(upline))) {
                    getM_dir().setUpp(unaccess);
                    flag = 0;
                   if (m_player == player1) {
                        Pos boxpos = map.GetBlock(i).getCbox().getBasepos();
                   }
                }
            }
            if (flag == 1)
                getM_dir().setUpp(accessable);

        } else
            getM_dir().setUpp(unaccess);
        flag = 1;
        //下检测
        if (getM_cbox().getPoint(downleft).getY() < 700) {
            for (int i = 1; i < bnum; i++)  //从 1 开始，用边框代替地板检测
            {

                if (map.GetBlock(i).getCbox().checkLBCollision(getM_cbox().getLine(downline))) {
                    getM_dir().setDown(unaccess);
                    flag = 0;
//                    if (m_player == player1)
//                        System.out.println("检测到与地图方块"+(i+1)+"碰撞，不可往下走！");
                }
            }
            if (flag == 1) {
                getM_dir().setDown(accessable);
            }

        } else
            getM_dir().setDown(unaccess);
        flag = 1;
        //左检测
        if (getM_cbox().getPoint(upleft).getX() > 0)   //边框检测
        {
            for (int i = 1; i < bnum; i++)                              //地图方块检测
            {

                if (map.GetBlock(i).getCbox().checkLBCollision(getM_cbox().getLine(leftline))) {
                    getM_dir().setLeft(unaccess);
                    flag = 0;
//                    if (m_player == player1)
//                        System.out.println("检测到与地图方块"+(i+1)+"碰撞，不可往左走！");
                }
                if (getM_cbox().getLine(upline).checkLineCollision(map.GetBlock(i).getCbox().getLine(rightline))) {
                    getM_dir().setRight(unaccess);
                    flag = 0;
//                    if (m_player == player1)
//                        System.out.println("检测到与地图方块"+(i+1)+"碰撞，不可往左走！");
                }
                if (getM_cbox().getLine(downline).checkLineCollision(map.GetBlock(i).getCbox().getLine(rightline))) {
                    getM_dir().setRight(unaccess);
                    flag = 0;
//                    if (m_player == player1)
//                        System.out.println("检测到与地图方块"+(i+1)+"碰撞，不可往左走！");
                }
            }
            if (flag == 1) {
                getM_dir().setLeft(accessable);
            }

        } else
            getM_dir().setLeft(unaccess);
        flag = 1;
        //右检测
        if (getM_cbox().getPoint(upright).getX() < 1450)   //边框检测
        {
            for (int i = 1; i < bnum; i++)                              //地图方块检测
            {

                if (map.GetBlock(i).getCbox().checkLBCollision(getM_cbox().getLine(rightline))) {
                    getM_dir().setRight(unaccess);
                    flag = 0;
//                    if (m_player == player1)
//                        System.out.println("检测到与地图方块碰撞，不可往右走！");
                }
                if (getM_cbox().getLine(upline).checkLineCollision(map.GetBlock(i).getCbox().getLine(leftline))) {
                    getM_dir().setRight(unaccess);
                    flag = 0;
//                    if (m_player == player1)
//                        System.out.println("检测到与地图方块碰撞，不可往右走！");
                }
                if (getM_cbox().getLine(downline).checkLineCollision(map.GetBlock(i).getCbox().getLine(leftline))) {
                    getM_dir().setRight(unaccess);
                    flag = 0;
//                    if (m_player == player1)
//                        System.out.println("检测到与地图方块碰撞，不可往右走！");
                }
            }
            if (flag == 1) {
                //if (m_dir.right == unaccess)
                //	m_pblock = 0;
                getM_dir().setRight(accessable);
            }

        } else
            getM_dir().setRight(unaccess);
        flag = 1;

        return DONE;
    }

    ;        //int 返回函数执行情况

    public int jump() {
        if (getM_jumplock() == 0 && getM_dir().getUp() == accessable) {
            setM_Yspeed(-1 * getM_jumpspeed());
            setM_jumplock(1);
        }
        return DONE;
    }

    ;                             //int 返回函数执行情况

    public void updatepos(Pos basepos) {
        getM_shootpos().setX(basepos.getX());
        getM_shootpos().setY(basepos.getY() - getM_Gunheight());
    }

    ;

    public int die() {
        setM_life(dead);
        return DONE;
    }

    ;

    public int beginAttack() {
        setM_attackstate(BEGIN_FIRE);
        return DONE;
    }

    ;

    public int endAttack() {
        setM_attacktime(0);
        setM_attackstate(END_FIRE);
        return DONE;
    }

    ;

    public int paintHealthBar(JLabel bar,JLabel health,int player) {
        ImageIcon icon,icon2 ;
        if (m_Type == Wizard)
        {
            if (player == player1)
                icon = new ImageIcon("./src/Assets/bar_wiz1.png");
            else
                icon = new ImageIcon("./src/Assets/bar_wiz2.png");
        }else if (m_Type == Warrior){
            if (player == player1)
                icon = new ImageIcon("./src/Assets/bar_war1.png");
            else
                icon = new ImageIcon("./src/Assets/bar_war2.png");
        }else{
            if (player == player1)
                icon = new ImageIcon("./src/Assets/bar_sho1.png");
            else
                icon = new ImageIcon("./src/Assets/bar_sho2.png");
        }

        bar.setIcon(icon);
        bar.setSize(icon.getIconWidth(),icon.getIconHeight());

        if (m_Health == 100){
            icon2 = new ImageIcon("./src/Assets/100.png");
        }else if (m_Health<100 && m_Health >= 95){
            icon2 = new ImageIcon("./src/Assets/95.png");
        }else if (m_Health<95 && m_Health >= 90){
            icon2 = new ImageIcon("./src/Assets/90.png");
        }else if (m_Health<90 && m_Health >= 85){
            icon2 = new ImageIcon("./src/Assets/85.png");
        }else if (m_Health<85 && m_Health >= 80){
            icon2 = new ImageIcon("./src/Assets/80.png");
        }else if (m_Health<80 && m_Health >= 75){
            icon2 = new ImageIcon("./src/Assets/75.png");
        }else if (m_Health<75 && m_Health >= 70){
            icon2 = new ImageIcon("./src/Assets/70.png");
        }else if (m_Health<70 && m_Health >= 65) {
            icon2 = new ImageIcon("./src/Assets/65.png");
        }else if (m_Health<65 && m_Health >= 60){
            icon2 = new ImageIcon("./src/Assets/60.png");
        }else if (m_Health<60 && m_Health >= 55){
            icon2 = new ImageIcon("./src/Assets/55.png");
        }else if (m_Health<55 && m_Health >= 50){
            icon2 = new ImageIcon("./src/Assets/50.png");
        }else if (m_Health<50 && m_Health >= 45){
            icon2 = new ImageIcon("./src/Assets/45.png");
        }else if (m_Health<45 && m_Health >= 40){
            icon2 = new ImageIcon("./src/Assets/40.png");
        }else if (m_Health<40 && m_Health >= 35){
            icon2 = new ImageIcon("./src/Assets/35.png");
        }else if (m_Health<35 && m_Health >= 30){
            icon2 = new ImageIcon("./src/Assets/30.png");
        }else if (m_Health<30 && m_Health >= 25){
            icon2 = new ImageIcon("./src/Assets/25.png");
        }else if (m_Health<25 && m_Health >= 20){
            icon2 = new ImageIcon("./src/Assets/20.png");
        }else if (m_Health<20 && m_Health >= 15){
            icon2 = new ImageIcon("./src/Assets/15.png");
        }else if (m_Health<15 && m_Health >= 10){
            icon2 = new ImageIcon("./src/Assets/10.png");
        }else if (m_Health<10 && m_Health > 0){
            icon2 = new ImageIcon("./src/Assets/5.png");
        }else{
            icon2 = new ImageIcon("./src/Assets/0.png");
        }

        health.setIcon(icon2);
        health.setSize(icon.getIconWidth(),icon.getIconHeight());

        int shifting;

        if (player == player1) {
            if (m_Type == Warrior)
                bar.setLocation(45, 30);
            else
                bar.setLocation(50, 30);
            if (m_Type == Shooter)
                health.setLocation(213,22);
            else
                health.setLocation(190,22);
        } else {

            if (m_Type == Shooter)
                bar.setLocation(850, 30);
            else
                bar.setLocation(845, 30);
            shifting = ((100 - m_Health) / 5) * 20;
            health.setLocation(854 + shifting, 22);
        }
        return DONE;
    }

    ;

    public Combat update(MapBase map) {
        if (getM_life() == alive) {
            checkDirAccess(map);
            getM_cbox().updatepos(getM_basepos());
            updatepos(getM_basepos());
            if (getM_Health() <= 0)
                die();
            //落地检测，jumplock置零
            if (getM_jumplock() == 1 && getM_Yspeed() >= 0 && getM_dir().getDown() == unaccess)
                setM_jumplock(0);
            //第一步：移动/坐标更新
            //上下移动/坐标更新
            if (getM_dir().getUp() == accessable) {
                if (getM_dir().getDown() == accessable) {
                    setM_Yspeed(getM_Yspeed() + (m_G * deltaT) / (double) 1000);
                    getM_basepos().setY(getM_basepos().getY() + getM_Yspeed() * deltaT / (double) 1000);
                } else if (getM_dir().getDown() == unaccess) {
                    if (getM_Yspeed() >= 0) {
                        setM_Yspeed(0);
                    } else if (getM_Yspeed() <= 0) {
                        setM_Yspeed(getM_Yspeed() + (m_G * deltaT) / (double) 1000);
                        getM_basepos().setY(getM_basepos().getY() + getM_Yspeed() * deltaT / (double) 1000);
                    }
                }
            } else if (getM_dir().getDown() == accessable && getM_dir().getUp() == unaccess) {
                if (getM_Yspeed() < 0) {
                    setM_Yspeed(0);
                } else if (getM_Yspeed() >= 0) {
                    setM_Yspeed(getM_Yspeed() + (m_G * deltaT) / (double) 1000);
                    getM_basepos().setY(getM_basepos().getY() + getM_Yspeed() * deltaT / (double) 1000);
                }
            }

            //左右移动/坐标更新
            if (getM_dir().getLeft() == accessable && getM_Ismovingl() == 1) {
                getM_basepos().setX(getM_basepos().getX() - (getM_Xspeed() * (double) deltaT) / 50.0);
            }
            if (getM_dir().getRight() == accessable && getM_Ismovingr() == 1) {
                getM_basepos().setX(getM_basepos().getX() + (getM_Xspeed() * (double) deltaT) / 50.0);
            }


            if (m_Type == Wizard) {                //法师攻击更新
                if (getM_attackstate() == BEGIN_FIRE) {

                    setM_attacktime(getM_attacktime() + 3);//suppose every loop add 3
                    int attacktime = (int) getM_attacktime();
                    if (attacktime % getM_attackspeed() == 0) {
                        return new Combat((int) getM_shootpos().getX(), (int) getM_shootpos().getY()+40, getM_faceori(), alive, 20, 20, MDAMAGE, MSPEED, MagicBall);
                    }
                }
                return new Combat((int) getM_shootpos().getX(), (int) getM_shootpos().getY(), getM_faceori(), dead, 20, 20, MDAMAGE, MSPEED, MagicBall);//无效法球

            } else if (m_Type == Warrior) {            //战士攻击更新
                //攻击更新
                if (getM_attackstate() == BEGIN_FIRE) {
                    setM_attacktime(getM_attacktime() + 3);
                    if ((int) getM_attacktime() > getM_attackspeed()) {
                        setM_attacktime(0);
                        return new Combat((int) getM_shootpos().getX(), (int) getM_basepos().getY(), getM_faceori(), alive, 120, 70, SDAMAGE, 0, Sword);
                    }

                }

                return new Combat((int) getM_shootpos().getX(), (int) getM_basepos().getY(), getM_faceori(), dead, 120, 70, SDAMAGE, 0, Sword);//无效剑气


            } else {                           //射手攻击更新

                if (getM_attackstate() == BEGIN_FIRE) {

                    setM_attacktime(getM_attacktime() + 3);
                    if (getM_attacktime() > getM_attackspeed()) {
                        setM_attacktime(0);
                        return new Combat((int) getM_shootpos().getX(), (int) getM_shootpos().getY(), getM_faceori(), alive, 20, 20, BDAMAGE, BSPEED, Bullet);
                    }

                }

                return new Combat((int) getM_shootpos().getX(), (int) getM_shootpos().getY(), getM_faceori(), dead, 20, 20, BDAMAGE, BSPEED, Bullet);//无效子弹
            }
        }else{
            return new Combat((int) getM_shootpos().getX(), (int) getM_shootpos().getY(), getM_faceori(), dead, 20, 20, BDAMAGE, BSPEED, Bullet);//无效子弹
        }
    }
    public CareerBase(Pos basepos, ColliderBox cbox, Pos shootpos, int player, int health, int shield, int faceori,int Type) {
        getM_dir().setRight(accessable);
        getM_dir().setLeft(accessable);
        getM_dir().setUpp(accessable);
        getM_dir().setDown(accessable);
        setM_player(player);

        setM_life(alive);
        setM_jumplock(0);
        setM_Ismovingl(0);
        setM_Ismovingr(0);

        setM_Health(health);
        setM_Shield(shield);

        getM_shootpos().setX(shootpos.getX());
        getM_shootpos().setY(shootpos.getY());

        getM_basepos().setX(basepos.getX());
        getM_basepos().setY(basepos.getY());

        setM_faceori(faceori);
        setM_cbox(cbox);

        if (Type == Warrior) {
            setM_attackspeed(Warattackspeed);
            setM_Xspeed(WarxSpeed);
            setM_jumpspeed(jumpSpeed);
        }else if (Type == Wizard){
            setM_attackspeed(Wizattackspeed);
            setM_Xspeed(WizxSpeed);
            setM_jumpspeed(jumpSpeed);
        }else{
            setM_attackspeed(Shoattackspeed);
            setM_Xspeed(ShoxSpeed);
            setM_jumpspeed(jumpSpeed);
        }

        setM_jumplock(0);
        m_Type = Type;
    }

    ;
    public int paint(JLabel image) {
        ImageIcon icon;
        if (m_Type == Wizard)
        {

            if (m_faceori == FACE_RIGHT)
                icon = new ImageIcon("./src/Assets/Rwizard.png");
            else
                icon = new ImageIcon("./src/Assets/Lwizard.png");


        }else if (m_Type == Warrior){
            if (m_faceori == FACE_RIGHT)
                icon = new ImageIcon("./src/Assets/Rwarrior.png");
            else
                icon = new ImageIcon("./src/Assets/Lwarrior.png");
        }else{
            if (m_faceori == FACE_RIGHT)
                icon = new ImageIcon("./src/Assets/Rshooter.png");
            else
                icon = new ImageIcon("./src/Assets/Lshooter.png");
        }
        image.setIcon(icon);
        image.setSize(icon.getIconWidth(),icon.getIconHeight());

        image.setLocation((int)m_basepos.getX(),(int)m_basepos.getY()-icon.getIconHeight());
        image.setVisible(true);

        return DONE;
    }

    ;                            //int 返回函数执行情况


}