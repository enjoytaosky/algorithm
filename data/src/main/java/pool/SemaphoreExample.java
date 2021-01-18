package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author: taotao
 * @date: 2020/12/7 14:29
 * @description:
 */
public class SemaphoreExample {

    private static final int threadCount = 550;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(300);
        final Semaphore semaphore = new Semaphore(4);
        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire(4);
                    //
                    test(threadnum);
                    semaphore.release(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        System.out.println("finish");
    }


    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadnum:" + threadnum);
        Thread.sleep(1000);
    }
}
