package Classes.Client;
import javax.sound.sampled.*;
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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import static Classes.Base.Defines.*;
import static javax.swing.JLayeredPane.*;

public class SingleMode {
    public static CareerChoice choice;
    public static int lock = 0;
    public static boolean flag = true;
    public static Clip clip;
    public static Volume vol = null;
    public static int Start(JFrame frame, CareerChoice c, Clip cl,Volume vol) throws LineUnavailableException {
        clip = cl;
        choice = c;
        lock  = 0;

        clip.stop();
        //---------------------------战斗音乐播放--------------------------//
        clip = AudioSystem.getClip();
        String audioFilePath = "./src/Assets/bmusic.wav";
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audioFilePath).getAbsoluteFile());

            clip.open(audioInputStream);
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float volume = -1f * vol.vol;
            volumeControl.setValue(volume);

            clip.start();


            // 设置循环播放
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            //clip.stop();
            //clip.close();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e ) {
            e.printStackTrace();
        }

        ArrayList<Combat> p1list = new ArrayList<Combat>();
        ArrayList<Combat> p2list = new ArrayList<Combat>();
       //当我在这里改动p1list或p2list时，MyLayeredPane里面的list也会跟着改变，因为他们指向同一个list
        MyLayeredPane p = new MyLayeredPane();

        JLabel bk = new JLabel();
        ImageIcon icon = new ImageIcon("./src/Assets/GameMap.png");
        bk.setIcon(icon);
        bk.setSize(icon.getIconWidth(), icon.getIconHeight());


        p.add(bk, DEFAULT_LAYER);
        bk.setLocation(0, 0);

        frame.add(p);
        p.setVisible(true);
        frame.setVisible(true);



        //-------------------------游戏逻辑------------------------//

        //基础数据
        Pos p1basepos = new Pos();
        Pos p2basepos = new Pos();
        Pos p1shootpos = new Pos();
        Pos p2shootpos = new Pos();

        int x = 100, y = 100;
        int plength = 100, pwidth = 100;

        p1basepos.setX(300);
        p1basepos.setY(650);

        p2basepos.setX(1000);
        p2basepos.setY(650);


        p1shootpos.setX(p1basepos.getX() + 50);
        p1shootpos.setY(p1basepos.getY() - 70);

        p2shootpos.setX(p2basepos.getX() + 50);
        p2shootpos.setY(p2basepos.getY() - 70);


        //组件创建
        ColliderBox p1cbox = new ColliderBox(p1basepos, plength, pwidth);
        ColliderBox p2cbox = new ColliderBox(p2basepos, plength, pwidth);

        ItemsCreator itcreator = new ItemsCreator(SHOE_GAP, HEART_GAP, SHIELD_GAP);//shoegap heartgap shieldgap 请保持3的倍数

        MapBase map1 = new MapBase();

        JLabel p1label = new JLabel();
        JLabel p2label = new JLabel();

        JLabel p1bar = new JLabel();
        JLabel p2bar = new JLabel();
        JLabel p1health = new JLabel();
        JLabel p2health = new JLabel();




        p.add(p1label,PALETTE_LAYER);
        p.add(p2label,PALETTE_LAYER);
        p.add(p1bar,MODAL_LAYER);
        p.add(p2bar,MODAL_LAYER);
        p.add(p1health,POPUP_LAYER);
        p.add(p2health,POPUP_LAYER);



        //玩家实例创建
        final CareerBase[] p1 = {new CareerBase(p1basepos, p1cbox, p1shootpos, player1, 100, 0, FACE_RIGHT, choice.p1chocie)};
        final CareerBase[] p2 = {new CareerBase(p2basepos, p2cbox, p2shootpos, player2, 100, 0, FACE_LEFT, choice.p2chocie)};


        ArrayList<ItemBase> Itemlist = new ArrayList<ItemBase>();


        /////////////////////////////按键系统/////////////////////////////
        frame.addKeyListener(new P1KA(p1[0]));
        frame.addKeyListener(new P2KA(p2[0]));

               //30ms一帧
            ////////////////////////////////////////////总循环//////////////////////////////////////////////////////////////
        Timer timer = null;
        timer = new Timer(1, new ActionListener() {
            ////////////////////////////////////////////总循环//////////////////////////////////////////////////////////////
            @Override
            public void actionPerformed(ActionEvent e) {

                // 在这里执行计时器触发时要执行的操作
                //循环内部：



            //////////////////////////////////////对象更新/////////////////////////////////////
            Combat c1 = p1[0].update(map1);
            Combat c2 = p2[0].update(map1);
            if (c1.getM_life() != dead) {
                p1list.add(c1);
                p.add(c1.label,PALETTE_LAYER);
            }
            if (c2.getM_life() != dead) {
                p2list.add(c2);
                p.add(c2.label,PALETTE_LAYER);
            }

            ItemBase it1 = itcreator.create(map1, Heart);
            ItemBase it2 = itcreator.create(map1, Shoe);
            ItemBase it3 = itcreator.create(map1, Shield);

            if (it1.getM_life() == alive) {
                Itemlist.add(it1);
                p.add(it1.label,PALETTE_LAYER);

            }
            if (it2.getM_life() == alive) {
                Itemlist.add(it2);
                p.add(it2.label,PALETTE_LAYER);

            }
            if (it3.getM_life() == alive) {
                Itemlist.add(it3);
                p.add(it3.label,PALETTE_LAYER);

            }

            map1.update();

            for (Combat o : p1list) {
                if (o.update(p2[0].getM_cbox(), p1[0].getM_shootpos(), p1[0].getM_faceori()) != MISS) {//传入的攻击坐标和面部朝向是战士自己的而不是对手的
                    p2[0].calDamage(o.getM_damage());
                }
            }
            for (Combat o : p2list) {
                if (o.update(p1[0].getM_cbox(), p2[0].getM_shootpos(), p2[0].getM_faceori()) != MISS) {
                    p1[0].calDamage(o.getM_damage());
                }
            }

            for (ItemBase o : Itemlist) {
                if (o.getM_life() == alive && o.update(p1[0].getM_cbox(), map1) != MISS) {
                    p1[0].calItemBuff(o.getM_Type(), o.getM_value());
                    o.setM_life(dead);
                }
                if (o.getM_life() == alive && o.update(p2[0].getM_cbox(), map1) != MISS) {
                    p2[0].calItemBuff(o.getM_Type(), o.getM_value());
                    o.setM_life(dead);
                }
            }

            //已生效物品剔除
            for (Iterator<Combat> it = p1list.iterator();it.hasNext();) {
                Combat c = it.next();
                if (c.getM_life() == dead) {
                    c.label.setVisible(false);
                    it.remove();
                }
            }
                for (Iterator<Combat> it = p2list.iterator();it.hasNext();) {
                    Combat c = it.next();
                    if (c.getM_life() == dead) {
                        c.label.setVisible(false);
                        it.remove();
                    }
                }
                for (Iterator<ItemBase> it = Itemlist.iterator();it.hasNext();) {
                    ItemBase c = it.next();
                    if (c.getM_life() == dead) {
                        c.label.setVisible(false);
                        it.remove();
                    }
                }

            ////////////////////////////对象绘制////////////////////////////////
           p1[0].paint(p1label);
           p1[0].paintHealthBar(p1bar,p1health,player1);
           p2[0].paint(p2label);
           p2[0].paintHealthBar(p2bar,p2health,player2);

           for (Combat o : p1list) {
               o.paint();
           }
           for (Combat o : p2list) {
               o.paint();
           }
           for (ItemBase o : Itemlist) {

               o.paint();

           }

           if (p1[0].getM_life() == dead && lock == 0){
                   JOptionPane.showMessageDialog(frame,"玩家2胜利！","游戏结束",2);
               frame.remove(p);
               lock = 1;
               frame.setVisible(false);
               p1[0].setM_life(100);
               p1[0] = null;
               try {
                   MainMenu.Start(frame,clip,vol);
               } catch (UnsupportedAudioFileException ex) {
                   throw new RuntimeException(ex);
               } catch (IOException ex) {
                   throw new RuntimeException(ex);
               } catch (LineUnavailableException ex) {
                   throw new RuntimeException(ex);
               }
           }else if (p2[0].getM_life() == dead && lock == 0){
               lock = 1;
                    JOptionPane.showMessageDialog(frame,"玩家1胜利！","游戏结束",2);
               frame.remove(p);
               frame.setVisible(false);
               p2[0]=null;
               try {
                   MainMenu.Start(frame,clip,vol);
               } catch (UnsupportedAudioFileException ex) {
                   throw new RuntimeException(ex);
               } catch (IOException ex) {
                   throw new RuntimeException(ex);
               } catch (LineUnavailableException ex) {
                   throw new RuntimeException(ex);
               }
           }




            }
        });
        timer.start();

        p.setVisible(true);
        frame.setVisible(true);
        return DONE;
    }

}
