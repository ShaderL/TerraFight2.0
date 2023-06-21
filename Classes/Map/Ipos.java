package Classes.Map;

import Classes.Base.Pos;

public class Ipos {
    public Pos getPos() {
        return m_pos;
    }

    public void setPos(Pos m_pos) {
        this.m_pos = m_pos;
    }

    public int getValue() {
        return m_value;
    }

    public void setValue(int m_value) {
        this.m_value = m_value;
    }

    private Pos m_pos;
    private int m_value;
    public  Ipos(){};
    public  Ipos(Pos pos,int value){
        m_pos.setY(pos.getY());
        m_pos.setX(pos.getX());
        m_value = value;
    }
}
