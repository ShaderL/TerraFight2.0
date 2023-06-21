package Classes.Map;

import Classes.Base.Pos;
import Classes.ColliderBox.ColliderBox;

import javax.swing.*;
import java.util.Vector;

import static Classes.Base.Defines.DONE;

public class MapBase{
    private Vector<Ipos> m_ItemPoslist = new Vector<Ipos>();
    private Vector<Block> m_Blocklist = new Vector<Block>();
    private int m_BlockNum;

    public int getBlockNum() {
        return m_BlockNum;
    }

    public void setBlockNum(int blockNum) {
        m_BlockNum = blockNum;
    }

    public int draw(JFrame frame) {


        JLayeredPane p = frame.getLayeredPane();

//        for (Block o:m_Blocklist)
//        {
//
//            o.draw(frame);
//        }

        return DONE;
    }

    public int update() {
        for (Block b : m_Blocklist) {
            b.Update();
        }
        return DONE;
    }

    public Block GetBlock(int num) {
        return m_Blocklist.get(num);
    }

    public Ipos Getposas(int i) {
        return m_ItemPoslist.get(i);
    }

    public void Changeposvalue(int i, int value) {
        m_ItemPoslist.get(i).setValue(value);
    }

    public MapBase(){
        Pos posground = new Pos(), posflyblock1 = new Pos(), posflyblock2 = new Pos();
        ColliderBox hboxg = new ColliderBox(), hboxf1 = new ColliderBox(), hboxf2 = new ColliderBox();
        Ipos itpos1 = new Ipos(), itpos2 = new Ipos(), itpos3 = new Ipos(), itpos4 = new Ipos();

        m_BlockNum = 3;

        posground.setX(0);                            //三个方块的基础坐标（基础坐标就是方块的左下角坐标）
        posground.setY(700);                          //地板方块
        posflyblock1.setX(200);                      //浮空方块1
        posflyblock1.setY(300);
        posflyblock2.setX(920);                       //浮空方块2
        posflyblock2.setY(300);

  //道具可生成坐标点
        itpos1.setPos(new Pos(280,250));
        itpos1.setValue(1);

        itpos2.setPos(new Pos(1050,280));
        itpos2.setValue(1);

        itpos3.setPos(new Pos(640,650));
        itpos3.setValue(1);

        itpos4.setPos(new Pos(650,300));
        itpos4.setValue(1);


        hboxg.assignment(posground, 100, 1500);      //三个方块的碰撞箱，括号里的内容是（基础坐标，高度，宽度）
        hboxf1.assignment(posflyblock1, 100, 300);
        hboxf2.assignment(posflyblock2, 100, 300);


        Block groundblock = new Block(posground, hboxg, 1500);     //创建三个方块对应的Block对象，括号里参数分别为（贴图路径，基础坐标，碰撞箱，block总长度）
        Block Flyingblock = new Block(posflyblock1, hboxf1, 300);
        Block Flyingblock2 = new Block(posflyblock2, hboxf2, 300);

        m_Blocklist.add(groundblock);            //往MapBase类里的vector<Block>容器里插入元素
        m_Blocklist.add(Flyingblock);
        m_Blocklist.add(Flyingblock2);

        m_ItemPoslist.add(itpos1);
        m_ItemPoslist.add(itpos2);
        m_ItemPoslist.add(itpos3);
        m_ItemPoslist.add(itpos4);
    }
}
