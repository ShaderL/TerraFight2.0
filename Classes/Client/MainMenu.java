package Classes.Client;

import Classes.Base.Volume;
import Classes.JavaSwing.*;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;




import static Classes.Base.Defines.*;
import static javax.swing.JLayeredPane.*;

public class MainMenu {
    private static Volume vol = new Volume(15);
    public static Clip clip = null;
    public static int Start() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        JFrame frame = new JFrame("TerraFight v2.0");
        frame.setLocation(40,10);
        frame.setSize(1450,818);
        frame.setResizable(false);
        ImageIcon image = new ImageIcon("./src/Assets/icon.png") ;
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗口关闭时的操作
        frame.setLocationRelativeTo(null);

        clip = AudioSystem.getClip();
        String audioFilePath = "./src/Assets/bmusic2.wav";
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




        JLabel bk = new JLabel();
        ImageIcon icon = new ImageIcon("./src/Assets/bk.png");
        bk.setIcon(icon);
        bk.setSize(icon.getIconWidth(), icon.getIconHeight());

        JLabel version = new JLabel("Version 2.0");
        version.setSize(500,200);
        version.setFont(new Font("SansSerif",Font.PLAIN,40));
        version.setForeground(Color.WHITE);

        JLabel menu1 = new JLabel("单机模式");
        menu1.setSize(500,200);
        menu1.setFont(new Font("黑体",Font.PLAIN,50));
        menu1.setForeground(new Color(130,70,130));

        JLabel title = new JLabel();
        icon = new ImageIcon("./src/Assets/title.png");
        title.setIcon(icon);
        title.setSize(icon.getIconWidth(),icon.getIconHeight());

        JLabel Bar1 = new JLabel();
        icon = new ImageIcon("./src/Assets/MenuBar1.png");
        Bar1.setIcon(icon);
        Bar1.setSize(icon.getIconWidth(),icon.getIconHeight());

        JLabel Bar2 = new JLabel();
        icon = new ImageIcon("./src/Assets/MenuBar2.png");
        Bar2.setIcon(icon);
        Bar2.setSize(icon.getIconWidth(),icon.getIconHeight());

        JLabel Bar3 = new JLabel();
        icon = new ImageIcon("./src/Assets/MenuBar3.png");
        Bar3.setIcon(icon);
        Bar3.setSize(icon.getIconWidth(),icon.getIconHeight());

        //MouseListener adding
        Bar1.addMouseListener(new Button1ML(clip,vol));
        Bar2.addMouseListener(new Button2ML(clip,vol));
        Bar3.addMouseListener(new Button3ML(clip,vol));


        JLayeredPane p = new JLayeredPane();
        p.add(bk,DEFAULT_LAYER);
        p.add(version,PALETTE_LAYER);
        p.add(title,PALETTE_LAYER);
        p.add(Bar1,PALETTE_LAYER);
        p.add(Bar2,PALETTE_LAYER);
        p.add(Bar3,PALETTE_LAYER);



        bk.setLocation(0,0);
        version.setLocation(30,640);
        title.setLocation(200,100);
        Bar1.setLocation(520,270);
        Bar2.setLocation(520,390);
        Bar3.setLocation(520,510);





        frame.add(p);
        p.setVisible(true);
        frame.setVisible(true);
        // frame.pack();

        return DONE;
    };
    public static int Start(JFrame frame,Clip clip,Volume v)throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        vol = v;
        clip.stop();
        frame = new JFrame("TerraFight v2.0");
        frame.setLocation(40,10);
        frame.setSize(1450,818);
        frame.setResizable(false);
        ImageIcon image = new ImageIcon("./src/Assets/icon.png") ;
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗口关闭时的操作
        frame.setLocationRelativeTo(null);

        String audioFilePath = "./src/Assets/bmusic2.wav";
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audioFilePath).getAbsoluteFile());
            clip = AudioSystem.getClip();
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




        JLabel bk = new JLabel();
        ImageIcon icon = new ImageIcon("./src/Assets/bk.png");
        bk.setIcon(icon);
        bk.setSize(icon.getIconWidth(), icon.getIconHeight());

        JLabel version = new JLabel("Version 2.0");
        version.setSize(500,200);
        version.setFont(new Font("SansSerif",Font.PLAIN,40));
        version.setForeground(Color.WHITE);

        JLabel menu1 = new JLabel("单机模式");
        menu1.setSize(500,200);
        menu1.setFont(new Font("黑体",Font.PLAIN,50));
        menu1.setForeground(new Color(130,70,130));

        JLabel title = new JLabel();
        icon = new ImageIcon("./src/Assets/title.png");
        title.setIcon(icon);
        title.setSize(icon.getIconWidth(),icon.getIconHeight());

        JLabel Bar1 = new JLabel();
        icon = new ImageIcon("./src/Assets/MenuBar1.png");
        Bar1.setIcon(icon);
        Bar1.setSize(icon.getIconWidth(),icon.getIconHeight());

        JLabel Bar2 = new JLabel();
        icon = new ImageIcon("./src/Assets/MenuBar2.png");
        Bar2.setIcon(icon);
        Bar2.setSize(icon.getIconWidth(),icon.getIconHeight());

        JLabel Bar3 = new JLabel();
        icon = new ImageIcon("./src/Assets/MenuBar3.png");
        Bar3.setIcon(icon);
        Bar3.setSize(icon.getIconWidth(),icon.getIconHeight());



        JLayeredPane p = new JLayeredPane();
        p.add(bk,DEFAULT_LAYER);
        p.add(version,PALETTE_LAYER);
        p.add(title,PALETTE_LAYER);
        p.add(Bar1,PALETTE_LAYER);
        p.add(Bar2,PALETTE_LAYER);
        p.add(Bar3,PALETTE_LAYER);

        //MouseListener adding
        Bar1.addMouseListener(new Button1ML(clip,vol));
        Bar2.addMouseListener(new Button2ML(clip,vol));
        Bar3.addMouseListener(new Button3ML(clip,vol));

        bk.setLocation(0,0);
        version.setLocation(30,640);
        title.setLocation(200,100);
        Bar1.setLocation(520,270);
        Bar2.setLocation(520,390);
        Bar3.setLocation(520,510);





        frame.add(p);
        p.setVisible(true);
        frame.setVisible(true);
        // frame.pack();

        return DONE;
    }
}
