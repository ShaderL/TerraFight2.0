package Classes.JavaSwing;

import Classes.Career.CareerBase;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class P1KA extends KeyAdapter {

    private CareerBase p;
    private int keyup = 0;
    private int keyright = 0;
    private int keyleft = 0;
    private int keyattack = 0;
    public P1KA(CareerBase p1) {
        p = p1;

    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == 87 && keyup == 0 && p.getM_jumplock() == 0) {//-------------W------------//
            keyup = 1;
            p.jump();
        }else if (key == 65){//--------------A-------------//
            keyleft = 1;
            p.beginMoveleft();
        }else if (key == 68){//-------------D-------------//
            keyright = 1;
            p.beginMoveright();
        }else if (key == 74) {//-------------J-------------//
            keyattack = 1;
            p.beginAttack();
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if (key == 65 && keyleft == 1){//--------------a-------------//
            p.endMoveleft();
            keyleft = 0;
        }else if (key == 68){//-------------d-------------//
            p.endMoveright();
            keyright = 0;
        }else if (key == 74){//-------------j-------------//
            p.endAttack();
            keyattack = 0;
        }else if(keyup == 1 && key == 87){//---------------w-------------//
            keyup = 0;
        }
    }


}
