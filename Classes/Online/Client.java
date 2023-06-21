package Classes.Online;

import Classes.Base.Volume;
import Classes.JavaSwing.MyLayeredPane;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import Classes.Base.Volume;
import Classes.JavaSwing.*;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;




import static Classes.Base.Defines.*;
import static javax.swing.JLayeredPane.*;


public class Client {
    //定义服务器的IP地址
    public static String SERVER_IP = "127.0.0.1";
    //定义服务器的端口号
    public static int SERVER_PORT = 8888;
    //定义缓冲区大小
    public static int BUFFER_SIZE = 102400;
    public static Clip clip;
    public static Volume vol;

    public static void Start(JFrame frame, Clip c, Volume v) {
         clip = c;
         vol = v;
         JLabel bk = new JLabel();


         ImageIcon bkimg = new ImageIcon("./src/Assets/MBK.png");

         bk.setIcon(bkimg);
         bk.setSize(bkimg.getIconWidth(),bkimg.getIconHeight());

         MyLayeredPane p = new MyLayeredPane();

         frame.add(p);
         p.setVisible(true);
         p.add(bk,DEFAULT_LAYER);



         frame.setVisible(true);



        //-----------------------服务器连接部分------------------------//
        boolean flag = true;
        String username = "Shader_L";
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入服务器ip：");
//        SERVER_IP = sc.next();
//        System.out.println("请输入服务器端口号：");
//        SERVER_PORT = sc.nextInt();

        try {
            //TCP连接确认
            {            //创建一个Socket对象，连接到指定的服务器和端口
                Socket socket = new Socket(SERVER_IP, SERVER_PORT);
                System.out.println("客户端已连接到服务器");
                //获取输出流，向服务器发送数据
                OutputStream out = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(out, true);
                pw.println("用户名：" + username);
                //获取输入流，读取服务器发送的数据
                InputStream in = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line = br.readLine();
                System.out.println("服务器：" + line);
                //关闭TCP连接
                socket.close();
                System.out.println("已确认和服务器建立连接，TCP连接已关闭,即将进行udp通信...");
            }


            //创建一个DatagramSocket对象
            DatagramSocket datagramSocket = new DatagramSocket();
            System.out.println("客户端已切换到UDP模式");
            //创建一个字节数组，用于接收和发送数据
            byte[] buffer = new byte[BUFFER_SIZE];


            int cnt = 0;

            while(flag){            //将要发送的数据转换为字节数组

                //--------------------数据接收--------------------//
                String data = "按键操作：w、j";
                buffer = data.getBytes();
                //创建一个DatagramPacket对象，用于向服务器发送数据报
                DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(SERVER_IP), SERVER_PORT);
                //调用send方法，向服务器发送数据报
                datagramSocket.send(sendPacket);
                System.out.println("客户端已向服务器发送消息");



                //----------------服务器数据处理运算----------------------//

                cnt++;
                if (cnt == 10)
                    flag = false;




                //---------------------数据发送--------------------//
                //创建一个DatagramPacket对象，用于接收服务器发送的数据报
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                //调用receive方法，接收服务器发送的数据报
                datagramSocket.receive(receivePacket);
                //获取数据报中的数据
                data = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("服务器：" + data);


            }
            //关闭UDP连接
            datagramSocket.close();
            System.out.println("UDP连接已关闭");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}