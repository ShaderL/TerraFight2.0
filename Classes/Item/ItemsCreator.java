package Classes.Item;

import Classes.Base.Pos;
import Classes.ColliderBox.ColliderBox;
import Classes.Map.MapBase;

import java.util.Random;

import static Classes.Base.Defines.*;

public class ItemsCreator {
    private int m_shoetime = 0;
    private int m_hearttime = 0;
    private int m_shieldtime = 0;
    private int m_shoegap;
    private int m_heartgap;
    private int m_shieldgap;

    public ItemsCreator(int shoegap, int heartgap, int shieldgap) {//shoegap = 900,heartgap = 90,shieldgap = 6000
        m_shoegap = shoegap;
        m_heartgap = heartgap;
        m_shieldgap = shieldgap;
    }

    public ItemBase create(MapBase map,int Type) {
        int posnum;
        Random rand = new Random();

        int time, gap;
        Pos pos1 = new Pos(), uselesspos = new Pos();
        if (Type == Shoe) {
            time = m_shoetime;
            gap = m_shoegap;
            m_shoetime += 3;
        } else if (Type == Shield) {
            time = m_shieldtime;
            gap = m_shieldgap;
            m_shieldtime += 3;
        } else {
            time = m_hearttime;
            gap = m_heartgap;
            m_hearttime += 3;
        }


        uselesspos.setX(0);
        uselesspos.setY(0);

        ColliderBox uncbox = new ColliderBox(uselesspos, 60, 60);           //创建无效item
        ItemBase un = new ItemBase(uselesspos, uncbox, dead, 2, Shoe);

        if (time >= gap) {
            if (Type == Shoe) {
                m_shoetime = 0;
                posnum = rand.nextInt() % 4;
                if (posnum == 0) {
                    pos1.setX(map.Getposas(0).getPos().getX());
                    pos1.setY(map.Getposas(0).getPos().getY());

                    if (map.Getposas(0).getValue() == 1) {
                        ColliderBox shoehbox = new ColliderBox(pos1, 60, 60);
                        ItemBase shoe = new ItemBase(pos1, shoehbox, alive, SPEEDVALUE, Shoe);
                        shoe.setM_posnum(0);
                        map.Changeposvalue(0, 0);
                        return shoe;
                    } else
                        return un;
                } else if (posnum == 1) {
                    pos1.setX(map.Getposas(1).getPos().getX());
                    pos1.setY(map.Getposas(1).getPos().getY());

                    if (map.Getposas(1).getValue() == 1) {
                        ColliderBox shoehbox = new ColliderBox(pos1, 60, 60);
                        ItemBase shoe = new ItemBase(pos1, shoehbox, alive, SPEEDVALUE, Shoe);
                        shoe.setM_posnum(1);
                        map.Changeposvalue(1, 0);
                        return shoe;
                    } else
                        return un;
                } else if (posnum == 2) {
                    pos1.setX(map.Getposas(2).getPos().getX());
                    pos1.setY(map.Getposas(2).getPos().getY());

                    if (map.Getposas(2).getValue() == 1) {
                        ColliderBox shoehbox = new ColliderBox(pos1, 60, 60);
                        ItemBase shoe = new ItemBase(pos1, shoehbox, alive, SPEEDVALUE, Shoe);
                        shoe.setM_posnum(2);
                        map.Changeposvalue(2, 0);
                        return shoe;
                    } else
                        return un;
                } else if (posnum == 3) {
                    pos1.setX(map.Getposas(3).getPos().getX());
                    pos1.setY(map.Getposas(3).getPos().getY());

                    if (map.Getposas(3).getValue() == 1) {
                        ColliderBox shoehbox = new ColliderBox(pos1, 60, 60);
                        ItemBase shoe = new ItemBase(pos1, shoehbox, alive, SPEEDVALUE, Shoe);
                        shoe.setM_posnum(3);
                        map.Changeposvalue(3, 0);
                        return shoe;
                    } else
                        return un;
                } else {
                    return un;
                }
            } else if (Type == Shield) {
                m_shieldtime = 0;
                posnum = rand.nextInt() % 4;
                if (posnum == 0) {
                    pos1.setX(map.Getposas(0).getPos().getX());
                    pos1.setY(map.Getposas(0).getPos().getY());

                    if (map.Getposas(0).getValue() == 1) {
                        ColliderBox shieldcbox = new ColliderBox(pos1, 60, 60);
                        ItemBase shield = new ItemBase(pos1, shieldcbox, alive, SHEILDVALUE, Shield);
                        shield.setM_posnum(0);
                        map.Changeposvalue(0, 0);
                        return shield;
                    } else
                        return un;
                } else if (posnum == 1) {
                    pos1.setX(map.Getposas(1).getPos().getX());
                    pos1.setY(map.Getposas(1).getPos().getY());

                    if (map.Getposas(1).getValue() == 1) {
                        ColliderBox shieldhbox = new ColliderBox(pos1, 60, 60);
                        ItemBase shield = new ItemBase(pos1, shieldhbox, alive, SHEILDVALUE, Shield);
                        shield.setM_posnum(1);
                        map.Changeposvalue(1, 0);
                        return shield;
                    } else
                        return un;
                } else if (posnum == 2) {
                    pos1.setX(map.Getposas(2).getPos().getX());
                    pos1.setY(map.Getposas(2).getPos().getY());

                    if (map.Getposas(2).getValue() == 1) {
                        ColliderBox shieldhbox = new ColliderBox(pos1, 60, 60);
                        ItemBase shield = new ItemBase(pos1, shieldhbox, alive, SHEILDVALUE, Shield);
                        shield.setM_posnum(2);
                        map.Changeposvalue(2, 0);
                        return shield;
                    } else
                        return un;
                } else if (posnum == 3) {
                    pos1.setX(map.Getposas(3).getPos().getX());
                    pos1.setY(map.Getposas(3).getPos().getY());

                    if (map.Getposas(3).getValue() == 1) {
                        ColliderBox shieldhbox = new ColliderBox(pos1, 60, 60);
                        ItemBase shield = new ItemBase(pos1, shieldhbox, alive, SHEILDVALUE, Shield);
                        shield.setM_posnum(3);
                        map.Changeposvalue(3, 0);
                        return shield;
                    } else
                        return un;
                } else {
                    return un;
                }
            } else {
                m_hearttime = 0;
                posnum = rand.nextInt() % 4;
                if (posnum == 0) {
                    pos1.setX(map.Getposas(0).getPos().getX());
                    pos1.setY(map.Getposas(0).getPos().getY());

                    if (map.Getposas(0).getValue() == 1) {
                        ColliderBox heartcbox = new ColliderBox(pos1, 60, 60);
                        ItemBase heart = new ItemBase(pos1, heartcbox, alive, CUREVALUE, Heart);
                        heart.setM_posnum(0);
                        map.Changeposvalue(0, 0);
                        return heart;
                    } else
                        return un;
                } else if (posnum == 1) {
                    pos1.setX(map.Getposas(1).getPos().getX());
                    pos1.setY(map.Getposas(1).getPos().getY());

                    if (map.Getposas(1).getValue() == 1) {
                        ColliderBox hearthbox = new ColliderBox(pos1, 60, 60);
                        ItemBase heart = new ItemBase(pos1, hearthbox, alive, CUREVALUE, Heart);
                        heart.setM_posnum(1);
                        map.Changeposvalue(1, 0);
                        return heart;
                    } else
                        return un;
                } else if (posnum == 2) {
                    pos1.setX(map.Getposas(2).getPos().getX());
                    pos1.setY(map.Getposas(2).getPos().getY());

                    if (map.Getposas(2).getValue() == 1) {
                        ColliderBox hearthbox = new ColliderBox(pos1, 60, 60);
                        ItemBase heart = new ItemBase(pos1, hearthbox, alive, CUREVALUE,Heart );
                        heart.setM_posnum(2);
                        map.Changeposvalue(2, 0);
                        return heart;
                    } else
                        return un;
                } else if (posnum == 3) {
                    pos1.setX(map.Getposas(3).getPos().getX());
                    pos1.setY(map.Getposas(3).getPos().getY());

                    if (map.Getposas(3).getValue() == 1) {
                        ColliderBox hearthbox = new ColliderBox(pos1, 60, 60);
                        ItemBase heart = new ItemBase(pos1, hearthbox, alive, CUREVALUE, Heart);
                        heart.setM_posnum(3);
                        map.Changeposvalue(3, 0);
                        return heart;
                    } else
                        return un;
                } else {
                    return un;
                }
            }
        }
        return un;
    }
    public int getM_shoetime() {
        return m_shoetime;
    }

    public void setM_shoetime(int m_shoetime) {
        this.m_shoetime = m_shoetime;
    }

    public int getM_hearttime() {
        return m_hearttime;
    }

    public void setM_hearttime(int m_hearttime) {
        this.m_hearttime = m_hearttime;
    }

    public int getM_shieldtime() {
        return m_shieldtime;
    }

    public void setM_shieldtime(int m_shieldtime) {
        this.m_shieldtime = m_shieldtime;
    }

    public int getM_shoegap() {
        return m_shoegap;
    }

    public void setM_shoegap(int m_shoegap) {
        this.m_shoegap = m_shoegap;
    }

    public int getM_heartgap() {
        return m_heartgap;
    }

    public void setM_heartgap(int m_heartgap) {
        this.m_heartgap = m_heartgap;
    }

    public int getM_shieldgap() {
        return m_shieldgap;
    }

    public void setM_shieldgap(int m_shieldgap) {
        this.m_shieldgap = m_shieldgap;
    }
}
