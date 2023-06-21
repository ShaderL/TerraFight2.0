package Classes.Combat;

import Classes.Base.Pos;
import Classes.ColliderBox.ColliderBox;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Classes.Base.Defines.*;
import static Classes.Base.Defines.MISS;
import static javax.swing.JLayeredPane.MODAL_LAYER;

public class Combat {
    private Pos m_basepos = new Pos(0,0);      //发射坐标
    private int m_width;
    private int m_length;
    private ColliderBox m_cbox;       //攻击范围
    private int m_damage;
    private double m_speed;         //弹道速度
    private int m_life = alive;
    private int m_face;

    private int m_time = 0;
    private int m_Type;
    public JLabel label = new JLabel();
    public Combat(int x,int y, int face, int life, int length, int width, int damage, double speed,int Type){
        if (Type != Sword){
            m_basepos.setX(x);
            m_basepos.setY(y);
            m_length = length;
            m_width = width;
            ColliderBox hbox = new ColliderBox(m_basepos, length, width);
            m_cbox = hbox;
            m_damage = damage;
            m_speed = speed;
            m_face = face;
            m_life = life;
            m_Type = Type;
        }else{
            if (face == FACE_RIGHT)
            {
                m_basepos.setX(x + 50);
                m_basepos.setY(y);
            }
            else if (face == FACE_LEFT)
            {
                m_basepos.setX(x - 50);
                m_basepos.setY(y);
            }
            m_length = length;
            m_width = width;
            ColliderBox hbox= new ColliderBox(m_basepos, length, width);
            m_cbox = hbox;
            m_damage = damage;
            m_life = life;

            m_time = 0;
        }

    }
    public int update(ColliderBox plhbox,Pos shotpos,int face) {
        if (m_life == dead){
            label.setVisible(false);
            label.setLocation(100000,100000);
        }
        if (m_Type == Bullet) {
            m_cbox.updatepos(m_basepos);
            if (m_life == alive) {
                if (m_face == FACE_RIGHT)
                    m_basepos.setX(m_basepos.getX() + m_speed * 30);
                else if (m_face == FACE_LEFT)
                    m_basepos.setX(m_basepos.getX() - m_speed * 30);

                if (plhbox.checkPBCollision(m_cbox.getPoint(downleft))) {
                    m_life = dead;
                    return HIT;
                }
                if (m_cbox.getPoint(upright).getX() >= 1450 || m_cbox.getPoint(upleft).getX() <= 0) {
                    m_life = dead;
                }

                return MISS;
            } else
                return MISS;
        }
        else if (m_Type == MagicBall){
            m_cbox.updatepos(m_basepos);
            if (m_life == alive)
            {
                if (m_cbox.checkBoxCollision(plhbox))
                {
                    m_life = dead;
                    return HIT;
                }
                if (m_cbox.getPoint(upleft).getX() >= 1450 || m_cbox.getPoint(upright).getX() <= 0)
                {
                    m_life = dead;
                }
                if (m_life == alive)
                {
                    if (m_face == FACE_RIGHT)
                        m_basepos.setX(m_basepos.getX() + m_speed * deltaT);
                    else if (m_face == FACE_LEFT)
                        m_basepos.setX(m_basepos.getX() - m_speed * deltaT);
                }
                return MISS;
            }
            else
                return MISS;
        }else{
            m_basepos = shotpos;
            m_cbox.updatepos(shotpos);//update positions

            m_face = face;//update face direction
            m_time += 3;
            if (m_time >= 30)
            {
                m_life = dead;
            }


            if (m_cbox.checkBoxCollision(plhbox))//return hb hit
                return HIT;
            else
                return MISS;
        }
    };
    public Pos getM_basepos() {
        return m_basepos;
    }

    public void setM_basepos(Pos m_basepos) {
        this.m_basepos = m_basepos;
    }

    public int getM_width() {
        return m_width;
    }

    public void setM_width(int m_width) {
        this.m_width = m_width;
    }

    public int getM_length() {
        return m_length;
    }

    public void setM_length(int m_length) {
        this.m_length = m_length;
    }

    public ColliderBox getM_cbox() {
        return m_cbox;
    }

    public void setM_cbox(ColliderBox m_cbox) {
        this.m_cbox = m_cbox;
    }

    public int getM_damage() {
        return m_damage;
    }

    public void setM_damage(int m_damage) {
        this.m_damage = m_damage;
    }

    public double getM_speed() {
        return m_speed;
    }

    public void setM_speed(double m_speed) {
        this.m_speed = m_speed;
    }

    public int getM_life() {
        return m_life;
    }

    public void setM_life(int m_life) {
        this.m_life = m_life;
    }

    public int getM_face() {
        return m_face;
    }

    public void setM_face(int m_face) {
        this.m_face = m_face;
    }
    public int paint(){
        ImageIcon icon;

        if (m_Type == MagicBall) {
            icon = new ImageIcon("./src/Assets/MagicBall.png");
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());


            label.setLocation((int)m_basepos.getX(),(int)m_basepos.getY()-icon.getIconHeight());
            label.setVisible(true);

//            BufferedImage bulletImg = null;
//            try {
//                bulletImg = ImageIO.read(new File("./src/Assets/MagicBall.png"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Graphics2D g2d = (Graphics2D) g;
//            g2d.drawImage(bulletImg, (int)m_basepos.getX(),(int)m_basepos.getY(), null);


        }else if (m_Type == Bullet) {
            icon = new ImageIcon("./src/Assets/Bullet.png");
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.setLocation((int)m_basepos.getX(),(int)m_basepos.getY());
            label.setVisible(true);


        }else{

            if (m_face == FACE_RIGHT) {
                icon = new ImageIcon("./src/Assets/Rsword.png");
                label.setIcon(icon);
                label.setSize(icon.getIconWidth(),icon.getIconHeight());
                label.setLocation((int)m_basepos.getX() + 100,(int)m_basepos.getY()-30);
                label.setVisible(true);
            }else{
                icon = new ImageIcon("./src/Assets/Lsword.png");
                label.setIcon(icon);
                label.setSize(icon.getIconWidth(),icon.getIconHeight());
                label.setLocation((int)m_basepos.getX() - 40,(int)m_basepos.getY()-30);
                label.setVisible(true);
            }




        }
        return DONE;
    };
}
