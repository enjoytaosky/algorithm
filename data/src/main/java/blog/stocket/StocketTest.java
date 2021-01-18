package blog.stocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: taotao
 * @date: 2019/12/19 13:39
 * @description:
 */
public class StocketTest {


    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress("127.0.0.1",8081));
        int idx = 0;
        while (true){
            Socket accept = ss.accept();
            System.out.println("start---");

            new Thread(() ->{
                handle(accept);
            },"线程["+idx+"]").start();
        }
    }
    
    static void handle(Socket socket){
        byte[] bytes = new byte[1024];
        String ss = "server sss [线程：" + Thread.currentThread().getName() + "]";
        try {
            socket.getOutputStream().write(ss.getBytes());
            socket.getOutputStream().flush();
            System.out.println("end---");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
