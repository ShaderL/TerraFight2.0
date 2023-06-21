package Classes.JavaSwing;

import Classes.Base.CareerChoice;
import Classes.Base.Volume;
import Classes.Client.SingleCareerChoose;
import Classes.Client.SingleMode;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CButton extends MouseAdapter {
    private CareerChoice choice;
    public Clip clip = null;
    public Volume vol = null;
    public CButton(CareerChoice c,Clip cl,Volume v){
        choice = c;
        clip = cl;
        vol = v;
    }
    @Override
    public void mouseEntered(MouseEvent e ){
        Object source = e.getSource();

        if (source instanceof JLabel) {
            //强制转换为JLabel类型
            JLabel label = (JLabel) source;
            Point p = new Point();
            //调用JLabel的方法
            ImageIcon icon = new ImageIcon("./src/Assets/BButton.png");
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.getLocation(p);
            label.setLocation(p.x-15,p.y - 15);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
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
                try {
                    SingleMode.Start(frame,choice,clip,vol);
                } catch (LineUnavailableException ex) {
                    throw new RuntimeException(ex);
                }
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
            ImageIcon icon = new ImageIcon("./src/Assets/Button.png");
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.getLocation(p);
            label.setLocation(p.x+15,p.y +15);
        }
    }
}
