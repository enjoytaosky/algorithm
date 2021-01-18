package pool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: taotao
 * @date: 2020/12/7 10:08
 * @description:
 */
public class ThreadPoolCallableDemon {

    public static final int CORE_POOL_SIZE = 5;

    public static final int MAX_POOL_SIZE  = 10;

    public static final int QUEUE_SIZE = 100;

    public static final Long ALIVE_TIME = 1L;


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, ALIVE_TIME,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_SIZE),
                new ThreadPoolExecutor.CallerRunsPolicy());
        MyCallableDemon myCallableDemon = new MyCallableDemon();
        List<Future<String>> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> future = threadPoolExecutor.submit(myCallableDemon);
            strings.add(future);
        }
        for (Future<String> string : strings) {
            try {
                String s = string.get();
                System.out.println(new Date() + "::" + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPoolExecutor.shutdown();

    }
}
