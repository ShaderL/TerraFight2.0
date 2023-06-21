package Classes.Item;

import Classes.Base.Pos;
import Classes.ColliderBox.ColliderBox;
import Classes.Map.MapBase;

import javax.swing.*;
import java.lang.reflect.Type;

import static Classes.Base.Defines.*;

public class ItemBase{

    private Pos m_basepos = new Pos();
    private ColliderBox m_cbox;
    private int m_life = alive;
    private int m_value = dead;
    private int m_posnum = 0;
    public JLabel label = new JLabel();
    public int getM_Type() {
        if (m_Type == Heart)
            return heal;
        else if (m_Type == Shield)
            return shield;
        else
            return speedup;
    }

    public void setM_Type(int m_Type) {
        this.m_Type = m_Type;
    }

    private int m_Type = 0;
    public void paint(){
        ImageIcon icon;

        if (m_Type == Heart) {
            icon = new ImageIcon("./src/Assets/CureHeart.png");
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.setLocation((int)m_basepos.getX(),(int)m_basepos.getY()-icon.getIconHeight());
            label.setVisible(true);


        }else if (m_Type == Shoe) {
            icon = new ImageIcon("./src/Assets/SpeedShoes.png");
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.setLocation((int)m_basepos.getX(),(int)m_basepos.getY()-icon.getIconHeight());
            label.setVisible(true);
        }else{
            icon = new ImageIcon("./src/Assets/Shield.png");
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.setLocation((int)m_basepos.getX(),(int)m_basepos.getY()-icon.getIconHeight());
            label.setVisible(true);


        }

    };
    public int update(ColliderBox plcbox, MapBase map){
        if (getM_cbox().checkBoxCollision(plcbox) && getM_life() == alive) {
            setM_life(dead);
            map.Changeposvalue(m_posnum, 1);
            return HIT;
        }
        return MISS;
    };

    public ItemBase(Pos basepos, ColliderBox cbox, int life, int value,int Type){
        getM_basepos().setX(basepos.getX());
        getM_basepos().setY(basepos.getY());

        setM_cbox(cbox);
        setM_value(value);

        setM_life(life);
        m_Type = Type;
    };


    public Pos getM_basepos() {
        return m_basepos;
    }

    public void setM_basepos(Pos m_basepos) {
        this.m_basepos = m_basepos;
    }

    public ColliderBox getM_cbox() {
        return m_cbox;
    }

    public void setM_cbox(ColliderBox m_cbox) {
        this.m_cbox = m_cbox;
    }

    public int getM_life() {
        return m_life;
    }

    public void setM_life(int m_life) {
        this.m_life = m_life;
    }

    public int getM_value() {
        return m_value;
    }

    public void setM_value(int m_value) {
        this.m_value = m_value;
    }

    public int getM_posnum() {
        return m_posnum;
    }

    public void setM_posnum(int m_posnum) {
        this.m_posnum = m_posnum;
    }
}
