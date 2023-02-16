package homework;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/23 19:28
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        new ThreadTest().start();
        while (true) {
            System.out.println(Thread.currentThread().getName()+"---1");
            Thread.sleep(1000);
        }
    }
}
class ThreadTest extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName()+"---2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}