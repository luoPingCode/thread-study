package homework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/23 22:07
 */
public class UseCallable1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //单线程计算
        long start = System.currentTimeMillis();
        long res = 0L;
        for (int i = 0; i < 1000000000; i++) {
            res += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("---单线程计算时间" + (end - start));
        System.out.println(res);
        //多线程计算
        start = System.currentTimeMillis();
        FutureTask[] futureTasks = new FutureTask[10];
        res = 0L;
        for (int i = 0; i < 10; i++) {
            FutureTask<Long> futureTask = new FutureTask<>(new Task(i*100000000,(i+1)*100000000));
            new Thread(futureTask).start();
            futureTasks[i] = futureTask;
        }
        for (int i = 0; i < futureTasks.length; i++) {
            long sum = (long) futureTasks[i].get();
            res += sum;
        }
        end = System.currentTimeMillis();
        System.out.println("---多线程计算时间" + (end - start));
        System.out.println(res);
    }

    static class Task implements Callable<Long> {

        private int from;
        private int to;
        public Task(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() throws Exception {
            long sum = 0L;
            for (int i = from; i < to; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
