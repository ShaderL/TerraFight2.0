package Classes.Online;

import Classes.Base.Volume;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.*;
import java.net.*;
public class Server {
    //定义服务器端口号
    public static int SERVER_PORT = 8888;
    //定义缓冲区大小
    public static int BUFFER_SIZE = 102400;
    public static Clip clip;
    public static Volume vol;

    public static void Start(JFrame frame, Clip c, Volume v) {
        clip = c;
        vol = v;
















        //------------------------服务器创建部分---------------------------//
        try {
            boolean flag = true;
            //创建一个ServerSocket对象，监听指定的端口
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("服务器启动，等待客户端连接...");
            //调用accept方法，等待客户端的连接请求
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接，IP地址为：" + socket.getInetAddress());
            //获取输入流，读取客户端发送的数据
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = br.readLine();
            System.out.println("客户端：" + line);
            //获取输出流，向客户端发送数据
            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(out, true);
            pw.println("服务器已收到你的消息");
            //关闭TCP连接
            socket.close();
            serverSocket.close();
            System.out.println("已确认连接成功，TCP连接已关闭，即将开始udp通信");



            //创建一个DatagramSocket对象，绑定到指定的端口
            DatagramSocket datagramSocket = new DatagramSocket(SERVER_PORT);
            System.out.println("服务器已切换到UDP模式");
            //创建一个字节数组，用于接收和发送数据
            byte[] buffer = new byte[BUFFER_SIZE];
            //创建一个DatagramPacket对象，用于接收客户端发送的数据报
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

            int cnt = 0;

            while(flag){            //调用receive方法，接收客户端发送的数据报
                datagramSocket.receive(receivePacket);
                //获取数据报中的数据
                String data = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("客户端：" + data);
                //获取数据报中的源地址和源端口
                InetAddress address = receivePacket.getAddress();
                int port = receivePacket.getPort();
                //创建一个DatagramPacket对象，用于向客户端发送数据报
                buffer = "玩家1血量：100".getBytes();
                DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, address, port);
                //调用send方法，向客户端发送数据报
                datagramSocket.send(sendPacket);
                System.out.println("服务器已回复客户端");

                cnt++;
                if (cnt == 10)
                    flag = false;
            }
            //关闭UDP连接
            datagramSocket.close();
            System.out.println("UDP连接已关闭");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}