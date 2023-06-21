package Classes.Base;

public class Defines {
    public static final int SDAMAGE = 1;//武器伤害
    public static final int BDAMAGE = 5;
    public static final int MDAMAGE = 15;
    public static final int BSPEED = 1;//武器速度
    public static final int MSPEED = 1;
    public static final int SPEEDVALUE = 5;//道具数值
    public static final int SHEILDVALUE = 10;
    public static final int CUREVALUE = 20;

    public static final int FACE_LEFT = 0;     //人物面部朝向
    public static final int FACE_RIGHT = 1;

    public static final int DONE = 1;          //函数运行状态
    public static final int FAILED = 0;

    public static final int heal = 0;          //物品效果类型
    public static final int shield = 1;
    public static final int speedup = 2;
    public static final int speeddown = 3;

    public static final int alive = 1;       //人物生死
    public static final int dead = 0;

    public static final int accessable = 1;    //方向是否通行
    public static final int unaccess = 0;

    public static final int Xdir = 0;
    public static final int Ydir = 1;        //移动块总行动方向，沿X轴方向或沿Y轴方向

    public static final int upleft = 0;       //四角坐标
    public static final int upright = 1;
    public static final int downleft = 2;
    public static final int downright = 3;

    public static final int shooter = 3;     //玩家职业选择
    public static final int mage = 1;
    public static final int worrior = 2;

    public static final int basewid = 100;      //block基础宽度

    public static final int MAXSIZE_INT = 2147483647;

    public static final int BEGIN_FIRE = 1;
    public static final int END_FIRE = 0;

    public static final int upline = 0;
    public static final int downline = 1;
    public static final int leftline = 2;
    public static final int rightline = 3;  //hbox线条方向

    public static final int ud = 0;
    public static final int lr = 1;   //线段水平与垂直

    public static final int COMPENSATE_PARAM = 15; //碰撞补偿参数

    public static final int HIT = 1;
    public static final int MISS = 0; //子弹碰撞返回值

    public static final int player1 = 1;
    public static final int player2 = 2;   //玩家一玩家二

    public static final int deltaT = 15;//帧间隔

    public static final int Wizard = 1;
    public static final int Warrior = 2;
    public static final int Shooter = 3;
    public static final int MagicBall = 1;
    public static final int Sword = 2;
    public static final int Bullet = 3;
    public static final double WizxSpeed = 15;
    public static final double WarxSpeed = 20;
    public static final double ShoxSpeed = 15;
    public static final double jumpSpeed = 1800.0;
    public static final int Warattackspeed = 100;
    public static final int Wizattackspeed = 30;
    public static final int Shoattackspeed = 20;
    public static final int Heart = 1;
    public static final int Shoe = 2;
    public static final int Shield = 3;
    public static final int blockHeight = 100;
    public static final int SHOE_GAP = 600;
    public static final int HEART_GAP = 500;
    public static final int SHIELD_GAP = 450;
}
