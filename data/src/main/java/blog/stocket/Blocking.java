package blog.stocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author: taotao
 * @date: 2019/12/19 14:08
 * @description:
 */
public class Blocking {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress("127.0.0.1",8081));
        System.out.println("NIO service started ...");
        ss.configureBlocking(false);
        int idx = 0;
        while (true){
            SocketChannel accept = ss.accept();
            new Thread(() -> {
                handle(accept);
            },"线程["+idx+"]" ).start();
        }
    }

    static void handle(SocketChannel socketChannel){
        try {
            socketChannel.configureBlocking(false);
            ByteBuffer bf = ByteBuffer.allocate(1024);
            socketChannel.read(bf);
            System.out.println("请求：" + new String(bf.array()));
            String  resp  = "服务器相应";
            bf.get(resp.getBytes());
            socketChannel.write(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
