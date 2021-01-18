package pool;

import java.util.Date;

/**
 * @author: taotao
 * @date: 2020/12/4 10:16
 * @description:
 */
public class MyRunnableDemon implements Runnable{
    private String commode;


    public MyRunnableDemon(String commode) {
        this.commode = commode;
    }

    @Override
    public String toString() {
        return "MyRunnableDemon{" +
                "commode='" + commode + '\'' +
                '}';
    }


    private void sleep(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "start at = " + new Date());
        sleep();
        System.out.println(Thread.currentThread().getName() + "start at = " + new Date());

    }
}
