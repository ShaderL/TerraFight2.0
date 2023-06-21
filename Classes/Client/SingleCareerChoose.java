package Classes.Client;

import Classes.JavaSwing.MyLayeredPane;

import javax.sound.sampled.Clip;
import javax.swing.*;
import Classes.Base.*;
import Classes.Career.*;
import Classes.ColliderBox.*;
import Classes.Combat.*;
import Classes.Item.*;
import Classes.Map.*;
import Classes.JavaSwing.*;
import Classes.Online.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import static Classes.Base.Defines.*;
import static javax.swing.JLayeredPane.*;

import javax.swing.*;

public class SingleCareerChoose {
    public static CareerChoice choice = new CareerChoice(1,1);
    public static Clip clip;
    public static Volume vol = null;
    public static void Run(JFrame frame,Clip c,Volume v){
        clip = c;
        vol = v;
        JLabel bk = new JLabel();
        JLabel p1 = new JLabel();
        JLabel p2 = new JLabel();
        JLabel button = new JLabel();

        ImageIcon bkimg = new ImageIcon("./src/Assets/ChooseBK.png");
        ImageIcon buttonimg = new ImageIcon("./src/Assets/Button.png");

        if (choice.p1chocie == Wizard) {
            ImageIcon p1img = new ImageIcon("./src/Assets/SWiz.png");
            p1.setIcon(p1img);
            p1.setSize(p1img.getIconWidth(),p1img.getIconHeight());
        } else if (choice.p1chocie == Shooter) {
            ImageIcon p1img = new ImageIcon("./src/Assets/SSho.png");
            p1.setIcon(p1img);
            p1.setSize(p1img.getIconWidth(),p1img.getIconHeight());
        } else {
            ImageIcon p1img = new ImageIcon("./src/Assets/SWar.png");
            p1.setIcon(p1img);
            p1.setSize(p1img.getIconWidth(),p1img.getIconHeight());
        }

        if (choice.p2chocie == Wizard) {
            ImageIcon p2img = new ImageIcon("./src/Assets/SWiz.png");
            p2.setIcon(p2img);
            p2.setSize(p2img.getIconWidth(),p2img.getIconHeight());
        } else if (choice.p2chocie == Shooter) {
            ImageIcon p2img = new ImageIcon("./src/Assets/SSho.png");
            p2.setIcon(p2img);
            p2.setSize(p2img.getIconWidth(),p2img.getIconHeight());
        } else {
            ImageIcon p2img = new ImageIcon("./src/Assets/SWar.png");
            p2.setIcon(p2img);
            p2.setSize(p2img.getIconWidth(),p2img.getIconHeight());
        }

        bk.setIcon(bkimg);
        bk.setSize(bkimg.getIconWidth(), bkimg.getIconHeight());
        button.setIcon(buttonimg);
        button.setSize(buttonimg.getIconWidth(),buttonimg.getIconHeight());


        int x1,y1,x2,y2;
        if (choice.p1chocie == Warrior) {
            x1 = 220;
            y1 = 230;
        }else if (choice.p1chocie == Shooter){
            x1 = 250;
            y1 = 235;
        }else {
            x1 = 315;
            y1 = 235;
        }

        if (choice.p2chocie == Warrior) {
            x2 = 780;
            y2 = 230;
        }else if (choice.p2chocie == Shooter){
            x2 = 840;
            y2 = 235;
        }else{
            x2 = 875;
            y2 = 235;
        }

        p1.addMouseListener(new P1C(choice,x1,y1));
        p2.addMouseListener(new P2C(choice,x2,y2));
        button.addMouseListener(new CButton(choice,clip,vol));

        MyLayeredPane p = new MyLayeredPane();
        p.setVisible(true);
        p.add(bk,DEFAULT_LAYER);
        p.add(button,PALETTE_LAYER);
        p.add(p1,PALETTE_LAYER);
        p.add(p2,PALETTE_LAYER);


        bk.setLocation(0,0);
        bk.setVisible(true);
        button.setLocation(580,500);
        button.setVisible(true);
        if (choice.p1chocie == Warrior)
            p1.setLocation(150,230);
        else
            p1.setLocation(315,235);

        if (choice.p2chocie == Warrior)
            p2.setLocation(780,230);
        else
            p2.setLocation(875,235);

        frame.add(p);
        frame.setVisible(true);

        //SingleMode.Start(frame,choice);//要放到鼠标响应里

    }


}
