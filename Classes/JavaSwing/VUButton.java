package Classes.JavaSwing;

import Classes.Base.Volume;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VUButton extends MouseAdapter {
    public Volume vol;
    public Clip clip;
    public JLabel label = null;
    public VUButton(Volume v,Clip c,JLabel l){
        vol = v;
        clip = c;
        label = l;
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();

        if (source instanceof JLabel) {
            //强制转换为JLabel类型
            JLabel label = (JLabel) source;
            Point p = new Point();
            //调用JLabel的方法
            ImageIcon icon = new ImageIcon("./src/Assets/BvolumeUp.png");
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.getLocation(p);
            label.setLocation(p.x-10,p.y -10);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (vol.vol >= 5)
            vol.vol -= 5;
        FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float volume = -1f * vol.vol;
        volumeControl.setValue(volume);
        if (vol.vol == 80)
            label.setText("0");
        else if (vol.vol == 75)
            label.setText("5");
        else if (vol.vol == 70)
            label.setText("10");
        else if (vol.vol == 65)
            label.setText("15");
        else if (vol.vol == 60)
            label.setText("20");
        else if (vol.vol == 55)
            label.setText("25");
        else if (vol.vol == 50)
            label.setText("30");
        else if (vol.vol == 45)
            label.setText("35");
        else if (vol.vol == 40)
            label.setText("40");
        else if (vol.vol == 35)
            label.setText("45");
        else if (vol.vol == 30)
            label.setText("50");
        else if (vol.vol == 25)
            label.setText("55");
        else if (vol.vol == 20)
            label.setText("60");
        else if (vol.vol == 15)
            label.setText("70");
        else if (vol.vol == 10)
            label.setText("80");
        else if (vol.vol == 5)
            label.setText("90");
        else if (vol.vol == 0)
            label.setText("100");
    }
    @Override
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();

        if (source instanceof JLabel) {
            //强制转换为JLabel类型
            JLabel label = (JLabel) source;
            Point p = new Point();
            //调用JLabel的方法
            ImageIcon icon = new ImageIcon("./src/Assets/volumeUp.png");
            label.setIcon(icon);
            label.setSize(icon.getIconWidth(),icon.getIconHeight());
            label.getLocation(p);
            label.setLocation(p.x+10,p.y +10);
        }
    }
}
