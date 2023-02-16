package homework;

/**
 * @author LuoPing
 * @project IntelliJ IDEA
 * @Package thread-study
 * @Date 2022/12/23 19:44
 */
public class RunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 11; i++) {
            Thread.sleep(1000);
            System.out.println("hi"+i);
            if (i == 5) {
                T3 t3 = new T3();
                Thread thread = new Thread(t3);
                thread.start();
                System.out.println("子线程先开始");
                thread.join();
                thread.setDaemon(true);
                System.out.println("子线程结束，主线程开始");
//                Thread.State
            }
        }
    }
}
class T3 implements Runnable {

    @Override
    public void run() {
        int sum = 0;
        while (true){
            try {
                Thread.sleep(1000);
                sum++;
                System.out.println("hello"+sum +"次");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (sum == 10){
                break;
            }
        }
    }
}
class T4 implements Runnable {

    @Override
    public void run() {
        int sum = 0;
        while (true){
            sum++;
            System.out.println("hi"+sum +"次");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (sum == 5){
                break;
            }
        }
    }
}

