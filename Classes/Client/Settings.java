package Classes.Client;

import Classes.Base.Volume;
import Classes.JavaSwing.ReButton;
import Classes.JavaSwing.VDButton;
import Classes.JavaSwing.VUButton;

import javax.sound.sampled.Clip;
import javax.swing.*;

import java.awt.*;

import static Classes.Base.Defines.DONE;
import static javax.swing.JLayeredPane.DEFAULT_LAYER;
import static javax.swing.JLayeredPane.PALETTE_LAYER;

public class Settings {
    private static Clip clip = null;
    public static Volume vol = null;
    public static int Start(JFrame frame, Clip c,Volume v){
        clip = c;
        vol = v;
        JLabel bk = new JLabel();
        JLabel volumeUp = new JLabel();
        JLabel volumeDown = new JLabel();
        JLabel ret = new JLabel();
        
        JLabel num = new JLabel();
        if (vol.vol == 80)
            num.setText("0");
        else if (vol.vol == 75)
            num.setText("5");
        else if (vol.vol == 70)
            num.setText("10");
        else if (vol.vol == 65)
            num.setText("15");
        else if (vol.vol == 60)
            num.setText("20");
        else if (vol.vol == 55)
            num.setText("25");
        else if (vol.vol == 50)
            num.setText("30");
        else if (vol.vol == 45)
            num.setText("35");
        else if (vol.vol == 40)
            num.setText("40");
        else if (vol.vol == 35)
            num.setText("45");
        else if (vol.vol == 30)
            num.setText("50");
        else if (vol.vol == 25)
            num.setText("55");
        else if (vol.vol == 20)
            num.setText("60");
        else if (vol.vol == 15)
            num.setText("70");
        else if (vol.vol == 10)
            num.setText("80");
        else if (vol.vol == 5)
            num.setText("90");
        else if (vol.vol == 0)
            num.setText("100");
        num.setSize(120,70);
        num.setFont(new Font("黑体",Font.PLAIN,70));
        num.setForeground(new Color(0,0,0));

        ImageIcon vuicon = new ImageIcon("./src/Assets/volumeUp.png");
        ImageIcon icon = new ImageIcon("./src/Assets/SettingsBK.png");
        ImageIcon vdicon = new ImageIcon("./src/Assets/volumeDown.png");
        ImageIcon ricon = new ImageIcon("./src/Assets/ReturnBar.png");

        volumeDown.setIcon(vdicon);
        volumeDown.setSize(vdicon.getIconWidth(),vdicon.getIconHeight());
        volumeUp.setIcon(vuicon);
        volumeUp.setSize(vuicon.getIconWidth(), vuicon.getIconHeight());
        bk.setIcon(icon);
        bk.setSize(icon.getIconWidth(), icon.getIconHeight());
        ret.setIcon(ricon);
        ret.setSize(ricon.getIconWidth(),ricon.getIconHeight());


        JLayeredPane p = new JLayeredPane();
        p.add(bk,DEFAULT_LAYER);
        p.add(volumeUp,PALETTE_LAYER);
        p.add(volumeDown,PALETTE_LAYER);
        p.add(num,PALETTE_LAYER);
        p.add(ret,PALETTE_LAYER);

        num.setLocation(490,120);

        volumeUp.setLocation(650,120);
        volumeDown.setLocation(350,140);
        bk.setLocation(0,0);
        ret.setLocation(520,590);

        volumeDown.addMouseListener(new VDButton(vol,clip,num));
        volumeUp.addMouseListener(new VUButton(vol,clip,num));
        ret.addMouseListener(new ReButton(clip,vol));

        frame.add(p);
        p.setVisible(true);
        frame.setVisible(true);




        return DONE;
    }
}
