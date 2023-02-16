package homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/24 17:32
 */
public class UseExecutors01 {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable task = () -> {
            ThreadUtils.sleep(2000);
            System.out.println("----------");
        };
        for (int i = 0; i < 100;i++) {
            executorService.submit(task);
        }
    }
}
