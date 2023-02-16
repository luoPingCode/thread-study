package homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/24 17:28
 */
public class UseExecutors {
    public static void main(String[] args) {
        Runnable taskOne = () -> {
            ThreadUtils.sleep(1000);
            System.out.println(Thread.currentThread().getName()+":taskOne");
        };
        // ExecutorService pools = Executors.newCachedThreadPool();
        // ExecutorService pools = Executors.newSingleThreadExecutor();
        // ExecutorService pools = Executors.newScheduledThreadPool(10);
        ExecutorService pools = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 40; i++) {
            pools.submit(taskOne);
        }
    }
}
