package Classes.Map;

import Classes.Base.Pos;
import Classes.ColliderBox.ColliderBox;

import javax.swing.*;

import static Classes.Base.Defines.*;

public class Block {
    private Pos m_basepos = new Pos(0, 0);

    public Pos getBasepos() {
        return m_basepos;
    }

    public void setBasepos(Pos m_basepos) {
        this.m_basepos = m_basepos;
    }

    public ColliderBox getCbox() {
        return m_cbox;
    }

    public void setCbox(ColliderBox m_cbox) {
        this.m_cbox = m_cbox;
    }

    public int getLife() {
        return m_life;
    }

    public void setLife(int m_life) {
        this.m_life = m_life;
    }

    public int getWidth() {
        return m_width;
    }

    public void setWidth(int m_width) {
        this.m_width = m_width;
    }

    private ColliderBox m_cbox = new ColliderBox();
    private int m_life;
    private int m_width;
    public static int m_height = blockHeight;


    public Block(Pos basepos, ColliderBox hbox, int width) {
        setBasepos(basepos);
        setCbox(hbox);
        setLife(alive);
        setWidth(width);

    }

    ;

    int draw(JFrame frame) {
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("./src/Assets/Block1.png");
        label.setIcon(icon);
        label.setSize(icon.getIconWidth(), icon.getIconHeight());
        JLayeredPane p = frame.getLayeredPane();
        int num = m_width / basewid;



        for (int i = 1; i <= num; i++) {
            JLabel l = new JLabel();
            l = createBackup(label);
            p.add(l);
            l.setLocation((int) m_basepos.getX() + basewid * (i - 1), (int) m_basepos.getY());
        }


        label.setVisible(true);
        m_cbox.DrawCbox(p);
        return DONE;
    }

    ;

    int Delete() {
        this.m_life = 0;
        return DONE;
    }

    ;

    int Update() {
        return DONE;
    }

    ;


    private static JLabel createBackup(JLabel originalLabel) {
        JLabel backupLabel = new JLabel();
        ImageIcon icon = new ImageIcon("./src/Assets/Block1.png");
        // 复制原始JLabel对象的属性到备份JLabel对象
        backupLabel.setIcon(icon);
        backupLabel.setSize(icon.getIconWidth(), icon.getIconHeight());


        return backupLabel;
    }
}