package Classes.JavaSwing;

import Classes.Base.Volume;
import Classes.Client.MainMenu;
import Classes.Client.SingleCareerChoose;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ReButton extends MouseAdapter {
    public Clip clip = null;
    public Volume vol = null;
    public ReButton(Clip c,Volume v){
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
            ImageIcon icon = new ImageIcon("./src/Assets/BReturnBar.png");
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.getLocation(p);
            label.setLocation(p.x-15,p.y -5);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
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
                frame.setVisible(false);
                frame.remove(pane);
                try {
                    MainMenu.Start(frame, clip, vol);
                } catch (UnsupportedAudioFileException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
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
            ImageIcon icon = new ImageIcon("./src/Assets/ReturnBar.png");
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.getLocation(p);
            label.setLocation(p.x+15,p.y +5);
        }
    }

}
