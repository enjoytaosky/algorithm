package pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: taotao
 * @date: 2020/12/4 10:33
 * @description:
 */
public class ThreadPoolExecutorDemo {

    public static final int CORE_POOL_SIZE = 5;

    public static final int MAX_POOL_SIZE  = 10;

    public static final int QUEUE_SIZE = 100;

    public static final Long ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_SIZE),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 10; i++) {
            MyRunnableDemon myRunnableDemon = new MyRunnableDemon("" + i);
            threadPoolExecutor.execute(myRunnableDemon);
        }
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()){
           // System.out.println("wait ------");
        }
        System.out.println("Finished all");

    }
}
