package Classes.JavaSwing;

import Classes.Career.CareerBase;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class P2KA extends KeyAdapter {

    private CareerBase p;
    private int keyup = 0;
    private int keyleft = 0;
    private int keyright = 0;
    private int keyattack = 0;
    public P2KA(CareerBase p2) {
        p = p2;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == 38 && keyup == 0&& p.getM_jumplock() == 0) {//-------------↑------------//
            keyup = 1;
            p.jump();
        }else if (key == 37 ){//--------------←-------------//
            keyleft = 1;
            p.beginMoveleft();
        }else if (key == 39 ){//-------------→-------------//
            keyright = 1;
            p.beginMoveright();
        }else if (key == KeyEvent.VK_NUMPAD1 ) {//------------ 1-------------//
            p.beginAttack();
            keyattack = 1;
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if (key == 37 && keyleft == 1){//--------------←-------------//
            p.endMoveleft();
            keyleft = 0;
        }else if (key == 39 && keyright == 1){//-------------→-------------//
            p.endMoveright();
            keyright = 0;
        }else if (key == KeyEvent.VK_NUMPAD1 && keyattack == 1){//-------------1-------------//
            p.endAttack();
            keyattack = 0;
        }else if (key == 38 && keyup == 1 ) {//----------------------↑------------------//
            keyup = 0;
        }
    }

}
