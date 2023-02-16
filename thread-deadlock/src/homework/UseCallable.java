package homework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/23 19:56
 */
public class UseCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(1);
        //保存一个将来的返回值
        FutureTask<String> futureTask = new FutureTask<>(new Task());
        new Thread(futureTask).start();
        System.out.println(3);
        System.out.println(4);
        String result = futureTask.get();
        System.out.println(5);
        System.out.println(result);
        System.out.println(6);
    }

    static class Task implements Callable<String> {

        public String call() throws Exception {
            while (true) {
                Thread.sleep(1000);
                return Thread.currentThread().getName() + "---2";
            }

        }
    }
}
