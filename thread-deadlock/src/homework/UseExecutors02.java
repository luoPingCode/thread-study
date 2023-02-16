package homework;

import java.util.concurrent.*;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/24 17:32
 */
public class UseExecutors02 {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = new ThreadPoolExecutor(5, 10,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(40),
                new MyThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 50; i++) {
            ThreadUtils.sleep(1000);
            executorService.submit(() -> System.out.println(Thread.currentThread().getName() + " - test"));
        }
    }
}
