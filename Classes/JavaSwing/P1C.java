package Classes.JavaSwing;

import Classes.Base.CareerChoice;
import Classes.Client.SingleCareerChoose;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static Classes.Base.Defines.*;

public class P1C extends MouseAdapter {
    private CareerChoice choice;
    private int X;
    private int Y;
    public P1C(CareerChoice c,int x,int y){
        choice = c;
        X = x;
        Y = y;
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        ImageIcon icon = null;
        if (source instanceof JLabel) {
            //强制转换为JLabel类型
            JLabel label = (JLabel) source;
            if (choice.p1chocie == Wizard){
                icon = new ImageIcon("./src/Assets/BWiz.png");
            }else if (choice.p1chocie == Warrior){
                icon = new ImageIcon("./src/Assets/BWar.png");
            }else if (choice.p1chocie == Shooter){
                icon = new ImageIcon("./src/Assets/BSho.png");
            }
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.setLocation(X-15,Y-12);

        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source instanceof JLabel) {
            //强制转换为JLabel类型
            JLabel label = (JLabel) source;

            if (choice.p1chocie < 3)
                choice.p1chocie++;
            else
                choice.p1chocie = 1;
            ImageIcon icon = null;
            if (choice.p1chocie == Wizard){
                X = 315;
                Y = 235;
                icon = new ImageIcon("./src/Assets/BWiz.png");
            }else if (choice.p1chocie == Warrior){
                X = 220;
                Y = 230;
                icon = new ImageIcon("./src/Assets/BWar.png");
            }else if (choice.p1chocie == Shooter){
                X = 250;
                Y = 235;
                icon = new ImageIcon("./src/Assets/BSho.png");
            }
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.setLocation(X,Y);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();

        if (source instanceof JLabel) {
            //强制转换为JLabel类型
            JLabel label = (JLabel) source;
            ImageIcon icon = null;
            if (choice.p1chocie == Wizard){
                icon = new ImageIcon("./src/Assets/SWiz.png");
            }else if (choice.p1chocie == Warrior){
                icon = new ImageIcon("./src/Assets/SWar.png");
            }else{
                icon = new ImageIcon("./src/Assets/SSho.png");
            }
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.setLocation(X,Y);

        }
    }
}
