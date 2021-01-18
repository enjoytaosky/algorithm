package pool;

import java.util.concurrent.Callable;

/**
 * @author: taotao
 * @date: 2020/12/7 10:07
 * @description:
 */
public class MyCallableDemon implements Callable<String> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}
