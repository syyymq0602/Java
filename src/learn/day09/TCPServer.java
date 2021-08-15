package learn.day09;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8088);
        System.out.println("启动服务器......");
        Socket socket = server.accept();
        System.out.println("客户端:" + socket.getInetAddress().getLocalHost() + "已连接到服务器");
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //读取客户端发送来的消息
        String mess = br.readLine();
        System.out.println("客户端：" + mess);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(mess + "\n");
        bw.flush();
    }
}
