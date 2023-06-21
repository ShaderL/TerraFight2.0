package Classes.Client;

import Classes.Base.Volume;
import Classes.JavaSwing.ClientButton;
import Classes.JavaSwing.ServerButton;

import javax.sound.sampled.Clip;
import javax.swing.*;

import static Classes.Base.Defines.*;
import static javax.swing.JLayeredPane.DEFAULT_LAYER;
import static javax.swing.JLayeredPane.PALETTE_LAYER;

public class MultipleMode {
    public static final int SERVER = 1;
    public static final int CLIENT = 0;
    public static Clip clip = null;
    public static Volume vol = null;
    public static int Start(JFrame frame, Clip c, Volume v){
        clip = c;
        vol = v;


        JLabel bk = new JLabel();
        JLabel sbutton = new JLabel();
        JLabel cbutton = new JLabel();

        ImageIcon icon = new ImageIcon("./src/Assets/MBK.png");
        ImageIcon sicon = new ImageIcon("./src/Assets/Server.png");
        ImageIcon cicon = new ImageIcon("./src/Assets/Client.png");


        sbutton.setIcon(sicon);
        sbutton.setSize(sicon.getIconWidth(),sicon.getIconHeight());
        cbutton.setIcon(cicon);
        cbutton.setSize(cicon.getIconWidth(),cicon.getIconHeight());
        bk.setIcon(icon);
        bk.setSize(icon.getIconWidth(), icon.getIconHeight());

        JLayeredPane p = new JLayeredPane();
        p.add(bk,DEFAULT_LAYER);
        p.add(sbutton,PALETTE_LAYER);
        p.add(cbutton,PALETTE_LAYER);


        bk.setLocation(0,0);
        sbutton.setLocation(470,200);
        cbutton.setLocation(470,400);

        sbutton.addMouseListener(new ServerButton(clip,vol));
        cbutton.addMouseListener(new ClientButton(clip,vol));

        frame.add(p);
        p.setVisible(true);
        frame.setVisible(true);




        int choose = 1;
        if (choose == SERVER)
            ;
        else if (choose == CLIENT)
            ;

        return DONE;
    }
}
