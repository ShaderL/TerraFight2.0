package Classes.JavaSwing;


import Classes.Base.Volume;
import Classes.Client.MultipleMode;
import Classes.Client.Settings;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Button2ML extends MouseAdapter {
    public Clip clip = null;
    public Volume vol = null;
    public Button2ML(Clip c,Volume v){
        clip = c;
        vol = v;
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();

        if (source instanceof JLabel) {
            //强制转换为JLabel类型
            JLabel label = (JLabel) source;
            Point p = new Point();
            //调用JLabel的方法
            ImageIcon icon = new ImageIcon("./src/Assets/BMenuBar2.png");
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.getLocation(p);
            label.setLocation(p.x-15,p.y -5);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        System.out.println("Pressed!");
        if (source instanceof JLabel) {
            //强制转换为JLabel类型
            JLabel label = (JLabel) source;
            Container container = label.getTopLevelAncestor();
            Container pane = label.getParent();
            //判断是否是JFrame类型
            if (container instanceof JFrame) {
                //强制转换为JFrame类型

                JFrame frame = (JFrame) container;
                frame.remove(pane);
                MultipleMode.Start(frame,clip,vol);

            }

        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();

        if (source instanceof JLabel) {
            //强制转换为JLabel类型
            JLabel label = (JLabel) source;
            Point p = new Point();
            //调用JLabel的方法
            ImageIcon icon = new ImageIcon("./src/Assets/MenuBar2.png");
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.getLocation(p);
            label.setLocation(p.x+15,p.y +5);
        }
    }

}